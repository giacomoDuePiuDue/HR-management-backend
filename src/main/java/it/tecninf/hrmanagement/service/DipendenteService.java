package it.tecninf.hrmanagement.service;


import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import it.tecninf.hrmanagement.dto.DipendenteDto;
import it.tecninf.hrmanagement.exception.ResourceNotFoundException;
import it.tecninf.hrmanagement.model.Curriculum;
import it.tecninf.hrmanagement.model.Dipendente;
import it.tecninf.hrmanagement.model.Tipskill;
import it.tecninf.hrmanagement.repository.CompetenzeRepository;
import it.tecninf.hrmanagement.repository.CurriculumRepository;
import it.tecninf.hrmanagement.repository.DipendenteRepository;
import it.tecninf.hrmanagement.utility.ResponseCurricculum;

@Service
public class DipendenteService {

	private static final Date Date = null;
	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@Autowired
	private CurriculumRepository curriculumRepository;
	
	@Autowired
	private CompetenzeRepository competenzeRepository;

	public List<Dipendente> listaDipendenti() {
		return (List<Dipendente>) dipendenteRepository.findAllEmp();
	}

	public Page<Dipendente> listaDipendentiPageable(Pageable pageable){
		return  dipendenteRepository.findAll(pageable);
	}
	public List<Dipendente> listaDipendentiVecchi() {
		return (List<Dipendente>) dipendenteRepository.findAllOldEmp();

	}

	public Optional<Dipendente> getByID(int id) {
		return dipendenteRepository.findById(id);
	}

	

	public List<Dipendente> getSkillFilter(String skill) {
		return (List<Dipendente>) dipendenteRepository.getSkillFilter(skill);
	}

	public int lastIdDipendente() {
		return (int) dipendenteRepository.lastIdDipendente();
	}

	public void addDipendente(String matricola, String nome, String cognome, Date data_di_nascita, String indirizzo,
			String citta, int id_ref_nazionalita, int row_exist) {
		dipendenteRepository.addDipendente(matricola, nome, cognome, data_di_nascita, indirizzo, citta,
				id_ref_nazionalita, row_exist);
	}

	public  Set<Tipskill> getSkillByDip (int idDip) {
		Dipendente dip = dipendenteRepository.getSkillFilterByIdDip(idDip);
		return  dip.getSkills();
	}	

	public void updateDipendente(String matricola, String nome, String cognome, Date data_di_nascita, String indirizzo,
			String citta, int id_ref_nazionalita, int id_dipendente) {

		dipendenteRepository.updateDipendente(matricola, nome, cognome, data_di_nascita, indirizzo, citta,
				id_ref_nazionalita, id_dipendente);
	}

	/*public void deleteByIdDip(int id_dipendente) {
		dipendenteRepository.deleteByIdDip(id_dipendente);
	}*/
	
	
	public Page<Dipendente> listaDipendentiPageable(Pageable pageable){
		return  dipendenteRepository.findAll(pageable);
	}
	
	//------------esecizio 1------------
	public List<DipendenteDto> dipendentiPerDataDiNascitaECompetenze(String dataInizio,String dataFine,Set<String> skill)
	{
		List<Dipendente> dipendenti=dipendenteRepository.dipendentiPerDataDiNascitaECompetenze(dataInizio,dataFine,skill);
		List<DipendenteDto> dipendentiDto=new ArrayList<DipendenteDto>();
		for(Dipendente dipendente:dipendenti)
		{
			dipendentiDto.add(new DipendenteDto(dipendente.getNome(),dipendente.getCognome(),dipendente.getSkills()));
		}
		return dipendentiDto;
	}
	//------------esecizio 4------------
	public void esercizio_4(int dipendente_id) throws Exception
	{
		if(!dipendenteRepository.existsById(dipendente_id))
		{
			throw new ResourceNotFoundException("Dipendente", dipendente_id);
			//return "\nID missing\n";
		}
		dipendenteRepository.deleteById(dipendente_id);
		//return "\nSuccessfully eraise\n";
	}
}
