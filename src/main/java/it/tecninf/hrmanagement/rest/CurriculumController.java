package it.tecninf.hrmanagement.rest;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import it.tecninf.hrmanagement.dto.CurriculumDto;
import it.tecninf.hrmanagement.dto.DipendenteDto;
import it.tecninf.hrmanagement.model.Curriculum;
import it.tecninf.hrmanagement.service.CurriculumService;
import it.tecninf.hrmanagement.service.DipendenteService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("curriculum")
public class CurriculumController {
	@Autowired
	CurriculumService curriculumService;
	
	@Autowired
	private DipendenteService dipendenteService;


	@GetMapping("/findall")
	public List<Curriculum> findall() {
		List<Curriculum> lista1 = curriculumService.findall();
		return lista1;
	}
	
	
	
	
	//------------esecizio 2------------
	@GetMapping("/curriculumPerCompetenze")
	public List<CurriculumDto> curriculumPerCompetenze(@RequestParam Set<String> skills)
	{
		return (List<CurriculumDto>) curriculumService.curriculumPerCompetenze(skills);
	}
	//------------esecizio 3------------
	@PostMapping("/esercizio_3/addCVsFromIDDipendente/{id_dipendente}")
	public String esercizio_3_addCVsFromIDDipendente(@PathVariable int id_dipendente,@RequestParam("files") Set<MultipartFile> curriculumFile)
	{
		return curriculumService.esercizio_3_addCVsFromIDDipendente(id_dipendente,curriculumFile);
	}
	
	@PostMapping("/addCV/{id_dipendente}")
	public void addCvDipendente(@PathVariable int id_dipendente,@RequestParam("cv")Set<MultipartFile> cv) throws Exception {
		curriculumService.addCurriculum(id_dipendente, cv);		
	}
}