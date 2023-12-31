package it.tecninf.hrmanagement.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.tecninf.hrmanagement.exception.RecourceAlreadyPresenteException;
import it.tecninf.hrmanagement.exception.ResourceNotFoundException;
import it.tecninf.hrmanagement.model.Competenze;
import it.tecninf.hrmanagement.model.Curriculum;
import it.tecninf.hrmanagement.model.Dipendente;
import it.tecninf.hrmanagement.model.Tipskill;
import it.tecninf.hrmanagement.repository.CompetenzeRepository;
import it.tecninf.hrmanagement.repository.CurriculumRepository;
import it.tecninf.hrmanagement.repository.DipendenteRepository;
import it.tecninf.hrmanagement.repository.TipskillRepository;

@Service
public class TipskillService {
	
	@Autowired
	private TipskillRepository tipskillRepository;
	@Autowired
	private CompetenzeRepository competenzeRepository;
	@Autowired
	private CurriculumRepository curriculumRepository;
	@Autowired
	private DipendenteRepository dipendenteRepository;
	@Autowired
	private DipendenteService dipendeteService;
	
	public List<Tipskill> listaSkill() {
		return (List<Tipskill>) tipskillRepository.listaSkill();
	}
	
	public void cancellaSkill(int id_tip_skill) {
		tipskillRepository.cancellaSkill(id_tip_skill);
	}
	
	public void aggiungiSkill(Tipskill tipskill) {
		tipskillRepository.save(tipskill);
	}
	
	
	

	//------------aggiunta------------
	public List<Tipskill> getTipskillsByEmployeeIDCvID(int dipendenteID,int cvID)
	{
		if(!curriculumRepository.existsById(cvID))
		{
			throw new ResourceNotFoundException("Curriculum row","id", cvID);
		}
		if(!dipendenteRepository.existsById(dipendenteID))
		{
			throw new ResourceNotFoundException("Dipendente row","id", dipendenteID);
		}
		return (List<Tipskill>) tipskillRepository.getTipskillsByEmployeeIDCvID(dipendenteID,cvID);
	}
	//------------esecizio 3------------esecizio 5------------
	public void esercizio_3_addSkillsFromIDCV_2(int id_curriculum,Set<Integer> idSkills)
	{
		if(!curriculumRepository.existsById(id_curriculum))
		{
			throw new ResourceNotFoundException("Curriculum row","id", id_curriculum);
		}
		if(idSkills.isEmpty())//se c'è un id mancante nel set parte un'ecceione per uest .orElse(null) non serve
		{
			throw new ResourceNotFoundException("TipSkill rows");
	    }
		
		Curriculum curriculum=curriculumRepository.findById(id_curriculum).get();
	    Dipendente dipendente=curriculum.getDipendente();//non mi serve controllare se è nullo perchè inserisco il cv in base ad un dipendente esistente
	    
	    //ho dovuto commentare questa parte perchè non posso associare una tipskill su cv diversi
	    /*for(Integer i:idSkills)
	    {
	    	if(dipendente.getSkills().contains(tipskillRepository.findById(i).get()))
	    	{
	    		throw new RecourceAlreadyPresenteException("TipSkill rows");
	    	}
	    }*/
	    
	    for(Integer i:idSkills)
	    {
	    	Tipskill t= tipskillRepository.findById(i).get();
		    Competenze comodo = new Competenze();
	        comodo.setIdTipskill(t.getIdTipskill());
	        comodo.setIdDipendente(dipendente.getIdDipendente());
	        comodo.setIdCurriculum(id_curriculum);
	        competenzeRepository.save(comodo);
	    }
	    
	    
	    //il codice, che segue, funiona
	    /*Set<Tipskill> ti=new HashSet<Tipskill>();
	    for(Integer i:idSkills) ti.add(tipskillRepository.findById(i).get());
	    //if(Collections.disjoint(dipendente.getSkills(),ti))
	    if(dipendente.getSkills().stream().anyMatch(ti::contains))
	    {
	    	//System.out.println("\n\n##################################\n\n\n########################################\n\n");
			throw new RecourceAlreadyPresenteException("Skill gia presenti","");
	    }
	    for(Tipskill t:ti)
	    {
		    Competenze comodo = new Competenze();
	        comodo.setIdTipskill(t.getIdTipskill());
	        comodo.setIdDipendente(dipendente.getIdDipendente());
	        comodo.setIdCurriculum(id_curriculum);
	        competenzeRepository.save(comodo);
	    }*/
	}
	
	public String esercizio_3_addSkillsFromIDCV(int id_curriculum,Set<Tipskill> skills)
	{	
		boolean flag=false;
		for(Tipskill skill:skills)
		{
			if(skill!=null)
			{
				flag=true;
				break;
			}
		}
		if(!curriculumRepository.existsById(id_curriculum))
		{
			return "\nID missing\n";
		}
		if(!flag)
		{
	        return "\nSkills missing\n";
	    }
		Curriculum curriculum=curriculumRepository.findById(id_curriculum).get();
	    Dipendente dipendente=curriculum.getDipendente();//non mi serve controllare se è nullo perchè inserisco il cv in base ad un dipendente esistente
		for(Tipskill skill:skills)
	    {
			/*if(dipendente.getSkills().contains(skill)) //non entra mai qui dentro, perchè? perche il set<dipendente> dipednenti è diverso?
			{
				return "\nSkill already present\n";
			}*/
			for(Tipskill t:dipendente.getSkills())
			{
				//if(skill.equals(t)) //neanche questo funziona
				//if(skill.getIdTipskill()==(t.getIdTipskill())
				if(skill.getTipologiaSkill().equalsIgnoreCase(t.getTipologiaSkill()))
				{
					return "\nSkill already present\n";
				}
			}
			Competenze comodo = new Competenze();
	        comodo.setIdTipskill(skill.getIdTipskill());
	        comodo.setIdDipendente(dipendente.getIdDipendente());
	        comodo.setIdCurriculum(id_curriculum);
	        competenzeRepository.save(comodo);
	    }
	    return "\nSkills updated\n";
	}
	
	public void aggiungiSkillToCV(int idCurriculum,Set<Integer> tpskill) throws Exception {
	    Curriculum c = curriculumRepository.findById(idCurriculum).orElse(null);

	    if (c != null) {
	        Dipendente d = c.getDipendente();
	        Set<Tipskill> skill = d.getSkills();
	      
	      
	        
	        if (d != null) {
	            for (Integer s : tpskill) {
	                Tipskill t = tipskillRepository.findById(s).orElse(null);

	                if (t != null) {
	                    if (skill.contains(t)) {
	                        throw new IOException("Questa skill: " + t.getTipologiaSkill() + " è già presente");
	                    } else {
	                    	 List<Competenze> listcompente = (List<Competenze>) competenzeRepository.findAll();
	              	       int index= listcompente.get(listcompente.size()-1).getIdCompetenze();
	                        Competenze competenza = new Competenze();
	                        competenza.setIdCompetenze(index+1);
	                        competenza.setIdTipskill(t.getIdTipskill());
	                        competenza.setIdDipendente(d.getIdDipendente());
	                        competenza.setIdCurriculum(idCurriculum);
	                        System.out.println(competenza);
	                        competenzeRepository.save(competenza);
	                    }
	                } else {
	                    throw new IOException("TipSkill non trovato per l'id " + s);
	                }
	            }
	        } else {
	            throw new IOException("Nessun dipendente trovato per il curriculum con ID " + idCurriculum);
	        }
	    } else {
	        throw new IOException("Nessun curriculum trovato per l'ID " + idCurriculum);
	    }	
	}   
}
