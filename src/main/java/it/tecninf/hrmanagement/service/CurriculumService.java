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
	public void esercizio_3_addCVsFromIDDipendente(int id_dipendente,Set<MultipartFile> files) throws Exception
	{
		//System.out.println("\n---------------\n"+files.isEmpty()+"\n---------------\n");
		boolean flag=false;
		for(MultipartFile file:files)
		{
			//System.out.println("\n---------------\n"+file.getSize()+"\n---------------\n");
			if(file.getSize()>0)
			{
				flag=true;
				break;
			}
		}		
		
		if(!dipRepository.existsById(id_dipendente))
		{
			throw new ResourceNotFoundException("Nessun utente trovato", id_dipendente);
			//return "\nID missing\n";
		}
		if(!flag)
		{
			throw new ResourceNotFoundException("Nessun curriculum trovato", id_dipendente);
	        //return "\nCVs missing\n";
	    }
		Dipendente dipendente=dipRepository.findById(id_dipendente).get();
		byte[] originalBytes=null;
		//Nota: a dipendente fissato devo far variare le righe di curriculum
		for(MultipartFile file:files)
		{
			try//NOTA: il controllo dell'eccezione sorge per richiamare .getBytes()!
			{
				originalBytes = Base64.getEncoder().encode(file.getBytes());
			}
			catch (Exception e)	{
				System.out.println(e.getMessage()+"\n"+e.getCause());				
			}
				
			Curriculum comodo = new Curriculum();//istanziarlo qui dentro significa che crea una nuova riga volante con un id nuovo?
			comodo.setCurriculum(originalBytes);
			comodo.setDipendente(dipendente);
				
			/*if(dipendente.getCurriculum().contains(comodo))//credo che se non entra qui è per l'id diverso...ho tolto il try/catch per essere sicuro che non interferisse
			{
				return "\nCVs already present\n";
			}*/
			
			for(Curriculum c:dipendente.getCurriculum())
			{
				if(Arrays.equals(c.getCurriculum(),comodo.getCurriculum())&&c.getDipendente().equals(comodo.getDipendente()))
				{
					throw new RecourceAlreadyPresenteException("il Cv è gia stato caricato ",file.getOriginalFilename());
					//return "\nCVs already present\n";
				}
			}
			repository.save(comodo);//non vado a fare dipednete.getCurriculum().add(comodo)?
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
					System.out.println(d.getCurriculum().add(saveCv));

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
