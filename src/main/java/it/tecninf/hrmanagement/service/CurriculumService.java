package it.tecninf.hrmanagement.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.tecninf.hrmanagement.dto.DipendenteDto;
import it.tecninf.hrmanagement.exception.RecourceAlreadyPresenteException;
import it.tecninf.hrmanagement.exception.ResourceNotFoundException;
import it.tecninf.hrmanagement.model.Curriculum;
import it.tecninf.hrmanagement.model.Dipendente;
import it.tecninf.hrmanagement.repository.CurriculumRepository;
import it.tecninf.hrmanagement.repository.DipendenteRepository;
import it.tecninf.hrmanagement.dto.CurriculumDto;

@Service
public class CurriculumService {
	@Autowired
	private CurriculumRepository repository;
	
	@Autowired
	private DipendenteRepository dipRepository;
	

	public List<Curriculum> findall(){
		List<Curriculum> lista = (List<Curriculum>)repository.findAll();
		
		for(Curriculum c : lista) {
			byte[] base = c.getCurriculum();
			String text = Base64.getEncoder().encodeToString(base);
			Base64.Decoder decoder = Base64.getDecoder();  
			String result  = new String(decoder.decode(text));
			c.setPdfText(result);
		}
		return (List<Curriculum>)repository.findAll();
	}

	
	public void addCurriculums(Set<Curriculum> curriculum) {
		repository.saveAll(curriculum);
	}
	
	
	
	//------------aggiunta------------
	public void deleteCVsFromID(int id_cv)
	{
		if(!repository.existsById(id_cv))
		{
			throw new ResourceNotFoundException("Nessun cv trovato", id_cv);
		}
		repository.deleteById(id_cv);
	}
	public void updateBlobCvFromID(int idCv,MultipartFile file) throws IOException
	{
		if(!repository.existsById(idCv))
		{
			throw new ResourceNotFoundException("Nessun cv trovato", idCv);
		}
		Curriculum cv=repository.findById(idCv).get();
		/*byte[] originalBytes=null;
		try//NOTA: il controllo dell'eccezione sorge per richiamare .getBytes()!
		{
			originalBytes = Base64.getEncoder().encode(file.getBytes());
		}
		catch (Exception e)	{
			System.out.println(e.getMessage()+"\n"+e.getCause());				
		}
		System.out.println("\n\n-------------------------------------------------\n"+originalBytes+"\n"+file.getBytes()+"\n-----------------------------------------------\n\n");
		cv.setCurriculum(originalBytes);*/
		
		//IMPORTANTE: non so perchè la request mi manda un messaggio già codificato in base 64, inoltre per ottenere un buon comportamento del backend
		//è consigliabile usare solo file .txt, perchè evidentemente c'è un meccanismo diverso per leggere i pdf, che contengono anche codice xml di dipendenze
		cv.setCurriculum(file.getBytes());//non so perchè ma la request cos impostata sopra mi codifica in base64 una volta in più il contenuto del file
		repository.save(cv); // Salva l'oggetto Curriculum modificato nel database senza realizzare una nuova riga, ma modificando quella esistente
	}
	private String base64ToString(byte[] base64Data)
	{
	    if(isPdfFile(base64Data)) {
	        try {
				String text = Base64.getEncoder().encodeToString(base64Data);
				Base64.Decoder decoder = Base64.getDecoder();  
				String pdfContent  = new String(decoder.decode(text));
	            return pdfContent;
	        } catch (IllegalArgumentException e) {
	            throw new IllegalArgumentException("Contenuto base64 non valido per il PDF", e);
	        }
	    }
	    // Codifica il file di testo
        String encodedText = Base64.getEncoder().encodeToString(base64Data);
        return encodedText;
	}
	private static boolean isPdfFile(byte[] data) {
	    // Controllo se il file inizia con la sequenza di byte "%PDF"
	    byte[] pdfSignature = "%PDF".getBytes();
	    for (int i = 0; i < pdfSignature.length; i++) {
	        if (data[i] != pdfSignature[i]) {
	            return false;
	        }
	    }
	    return true;
	}	
	//------------esecizio 2------------
	public List<CurriculumDto> curriculumPerCompetenze(Set<String> skills)
	{
		List<Curriculum> curriculum=repository.curriculumPerCompetenze(skills);
		List<CurriculumDto> curriculumDto=new ArrayList<CurriculumDto>();
		for(Curriculum c:curriculum)
		{			
			CurriculumDto comodo=new CurriculumDto();
			byte[] base = c.getCurriculum();
			String text = Base64.getEncoder().encodeToString(base);
			Base64.Decoder decoder = Base64.getDecoder();			
			String result  = new String(decoder.decode(text));
			c.setPdfText(result);
			
			//curriculumDto.add(new CurriculumDto(c.getDipendente().getNome(),c.getDipendente().getCognome(),c.getCurriculum()));
			
			comodo.getCurriculum().add(c);			
			comodo.setNome(c.getDipendente().getNome());
			comodo.setCognome(c.getDipendente().getCognome());
		
			curriculumDto.add(comodo);
		}
		return curriculumDto;
	}
	//------------esecizio 3------------
	public void esercizio_3_addCVsFromIDDipendente(int id_dipendente,Set<MultipartFile> files) throws IOException
	{
		boolean flag=false;
		for(MultipartFile file:files)
		{
			if(file.getSize()>0)
			{
				flag=true;
				break;
			}
		}		
		if(!dipRepository.existsById(id_dipendente))
		{
			throw new ResourceNotFoundException("Dipendente", id_dipendente);
			//return "\nID missing\n";
		}
		if(!flag)
		{
			throw new ResourceNotFoundException("CVs");
	        //return "\nCVs missing\n";
	    }
		Dipendente dipendente=dipRepository.findById(id_dipendente).get();
		//Nota: a dipendente fissato devo far variare le righe di curriculum
		for(MultipartFile file:files)
		{
			if(file.getSize()>0)
			{
				/*byte[] originalBytes=null;
				try//NOTA: il controllo dell'eccezione sorge per richiamare .getBytes()!
				{
					originalBytes = Base64.getEncoder().encode(file.getBytes());
				}
				catch (Exception e)	{
					System.out.println(e.getMessage()+"\n"+e.getCause());				
				}
	
				Curriculum comodo = new Curriculum();
				comodo.setCurriculum(originalBytes);//comodo.setCurriculum(file.getBytes());
				comodo.setDipendente(dipendente);*/
				
				//IMPORTANTE: non so perchè la request mi manda un messaggio già codificato in base 64, inoltre per ottenere un buon comportamento del backend
				//è consigliabile usare solo file .txt, perchè evidentemente c'è un meccanismo diverso per leggere i pdf, che contengono anche codice xml di dipendenze
				Curriculum comodo = new Curriculum();
				byte[] blob=file.getBytes();
				comodo.setCurriculum(blob);
				//comodo.setPdfText(this.base64ToString(blob));
				comodo.setDipendente(dipendente);
					
				/*if(dipendente.getCurriculum().contains(comodo))//credo che se non entra qui è per l'id diverso...ho tolto il try/catch per essere sicuro che non interferisse
				{
					return "\nCVs already present\n";
				}*/
				
				for(Curriculum c:dipendente.getCurriculum())
				{
					if(Arrays.equals(c.getCurriculum(),comodo.getCurriculum())&&c.getDipendente().equals(comodo.getDipendente()))
					{
						//System.out.println("\n\n-------------------------------------------------\nCV duplicati\n-----------------------------------------------\n\n");
						throw new RecourceAlreadyPresenteException("Curriculum rows",file.getOriginalFilename());
						//return "\nCVs already present\n";
					}
				}
				repository.save(comodo);//non vado a fare dipednete.getCurriculum().add(comodo)?
			}
		}
		//return "\nCVs updated\n";
	}
	
	public void addCurriculum(int idDipendente, Set<MultipartFile> c) throws Exception {

		try {
			Dipendente d = dipRepository.findById(idDipendente).get();
			if (d != null && c != null) {
				for (MultipartFile file : c) {

					byte[] originalBytes = Base64.getEncoder().encode(file.getBytes());

					Curriculum saveCv = new Curriculum();
					saveCv.setCurriculum(originalBytes);
					saveCv.setDipendente(d);
					//System.out.println(d.getCurriculum().add(saveCv));

					// se il cv è gia presente lancia un'eccezione e non lo salva
					if (!d.getCurriculum().add(repository.save(saveCv)))
					{
						throw new RecourceAlreadyPresenteException("il Cv è gia stato caricato ",
								file.getOriginalFilename());

					}

				}
			}

		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Nessun utente trovato", e.getMessage(), idDipendente);

		} catch (RecourceAlreadyPresenteException e) {
			throw e;
		}

	}
}
