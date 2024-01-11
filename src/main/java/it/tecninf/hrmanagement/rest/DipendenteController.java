package it.tecninf.hrmanagement.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.LockModeType;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.tecninf.hrmanagement.dto.DipendenteDto;
import it.tecninf.hrmanagement.model.Curriculum;
import it.tecninf.hrmanagement.model.Dipendente;
import it.tecninf.hrmanagement.model.Tipskill;
import it.tecninf.hrmanagement.service.CompetenzeService;
import it.tecninf.hrmanagement.service.CurriculumService;
import it.tecninf.hrmanagement.service.DipendenteService;
import it.tecninf.hrmanagement.service.TipskillService;
import it.tecninf.hrmanagement.utility.BaseResponseDipendente;
import it.tecninf.hrmanagement.utility.ResponseCurricculum;
import it.tecninf.hrmanagement.utility.Utility;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("dipendente")
public class DipendenteController {

	@Autowired
	private DipendenteService dipendenteService;

	@Autowired
	private CurriculumService curriculumService;
	
	@Autowired
	private CompetenzeService competenzeService;
		
	@Autowired
	private Utility utility;

	@GetMapping("/diplist")
	public List<Dipendente> listaDipendenti() {
		return dipendenteService.listaDipendenti();
	}
	@GetMapping("/diplistpage")
	public Page<Dipendente> listaDipendentiPage(Pageable pageable){
		return dipendenteService.listaDipendentiPageable(pageable);
	}
	@GetMapping("/filterListName")
	public Page<Dipendente> filterByNomeAndCognome(Pageable pageable,@RequestParam String nomeCognome){
		return dipendenteService.filterByNomeAndCognome(pageable, nomeCognome);
	}
	@GetMapping("/dipoldlist")
	public List<Dipendente> listaDipendentiVecchi() {
		return (List<Dipendente>) dipendenteService.listaDipendentiVecchi();
	}

	@GetMapping("/getByID")
	public Dipendente getByID(@RequestParam int id) {
		return dipendenteService.getByID(id).get();
	}

	@GetMapping("/getSkill")
	public List<Dipendente> getSkillFilter(@RequestParam String skill) {
		return (List<Dipendente>) dipendenteService.getSkillFilter(skill);
	}
		
	@Transactional
	@Modifying
	@PostMapping("/aggiungiDipendente")
	public int AggiungiDipendente(@RequestBody Dipendente dipendente) {
		int result;
		try {
			// double x =1/0;
			dipendenteService.addDipendente(dipendente.getMatricola(), dipendente.getNome(), dipendente.getCognome(),
					dipendente.getDataDiNascita(), dipendente.getIndirizzo(), dipendente.getCitta(),
					dipendente.getRefNazionalita().getIdRefNazionalita(), dipendente.getRowExist());

			int lastInsertID = dipendenteService.lastIdDipendente();
			String matricola = dipendente.getNome().substring(0, 3).toUpperCase()
					+ dipendente.getCognome().substring(0, 3).toUpperCase() + String.valueOf(lastInsertID);
			dipendente.setMatricola(matricola);
			dipendenteService.updateDipendente(dipendente.getMatricola(), dipendente.getNome(), dipendente.getCognome(),
					dipendente.getDataDiNascita(), dipendente.getIndirizzo(), dipendente.getCitta(),
					dipendente.getRefNazionalita().getIdRefNazionalita(), lastInsertID);

			result = lastInsertID;
		} catch (Exception e) {
			result = 0;
			System.out.println("---------------->" + e.toString());
			System.out.println("Error---" + e.toString());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exception", e);
		}

		return result;
		
//		int lastDip = dipendenteService.lastIdDipendente();
//		Dipendente dip = dipendenteService.getByID(lastDip).get();
//		Set<Curriculum> cur=dip.getCurriculum();
//		for(Curriculum c : cur ) {
//			c.setIdCurriculum(lastDip);
//		}
//		dip.setCurriculum(cur);
//		dipendenteService.addDipendente(dip);
	}
	
	
	
	

	@PatchMapping("/modificaDipendente")
	public void modificaDipendente(@RequestBody Dipendente dipendente) {
		System.out.println("Modifica del dipendente!");
		dipendenteService.updateDipendente(dipendente.getMatricola(), dipendente.getNome(), dipendente.getCognome(),
				dipendente.getDataDiNascita(), dipendente.getIndirizzo(), dipendente.getCitta(), 
				dipendente.getRefNazionalita().getIdRefNazionalita(), dipendente.getIdDipendente());
	}

	/*@Transactional
	@Modifying
	@DeleteMapping("/deleteDipendente")
	public void cancellaDipendente(@RequestParam int dipendente_id) {
		System.out.println("Cancellazione del dipendente!");
		dipendenteService.deleteByIdDip(dipendente_id);
	}*/
	
	
	
	
	//------------esecizio 1------------
	@GetMapping("/dipendentiPerDataDiNascitaECompetenze")
	public List<DipendenteDto> dipendentiPerDataDiNascitaECompetenze(@RequestParam String dataInizio,@RequestParam String dataFine,@RequestParam Set<String> skill)
	{
		System.out.println(dataInizio + dataFine +skill + "----------------------------------------");
		return (List<DipendenteDto>) dipendenteService.dipendentiPerDataDiNascitaECompetenze(dataInizio,dataFine,skill);
	}
	//------------esecizio 3------------
	/*@Transactional
	@Modifying
	@PostMapping("/esercizio_3")
	public int esercizio_3(@RequestBody Dipendente dipendente)
	{
		int result=this.AggiungiDipendente(dipendente);
		curriculumService.esercizio_3_addCVsFromID(dipendente.getIdDipendente(),dipendente.getCurriculum());
		tipskillService.esercizio_3_addSkillsFromID(dipendente.getIdDipendente(),dipendente.getSkills());
		return result;
	}*/
	//------------esecizio 4------------
	@Transactional
	@Modifying
	@DeleteMapping("/esercizio_4")
	public void esercizio_4(@RequestParam("id") int dipendente_id) throws Exception
	{
		dipendenteService.esercizio_4(dipendente_id);
		
	}
}