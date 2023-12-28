package it.tecninf.hrmanagement.rest;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.tecninf.hrmanagement.model.Tipskill;
import it.tecninf.hrmanagement.service.TipskillService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("tipskill")
public class TipskillController {

	@Autowired
	private TipskillService tipskillService;
		
	@GetMapping("/listaskill")
	public List<Tipskill> listaSkill() {

		return (List<Tipskill>) tipskillService.listaSkill();
	}	
	
	@DeleteMapping("/cancellaskill")
	public void cancellaSkill(@RequestParam int id_tipskill) {		
		tipskillService.cancellaSkill(id_tipskill);
	}
	
	@PostMapping("/aggiungiskill")
	public void aggiungiSkill(@RequestBody Tipskill tipskill) {
		tipskillService.aggiungiSkill(tipskill);
	}
	
	
	
	//------------aggiunta------------
	@GetMapping("/getTipskillsByEmployeeIDCvID")
	public List<Tipskill> getTipskillsByEmployeeIDCvID(@RequestParam int dipendenteId,@RequestParam int cvId)
	{
		return (List<Tipskill>) tipskillService.getTipskillsByEmployeeIDCvID(dipendenteId,cvId);
	}
	//------------esecizio 3------------esecizio 5------------
	//partire da le informaioni di un dipendente gi salavto nel db, poi all'inserimento di un curriculum e 
	//e poi per le skill...è di netto più efficace
	@Transactional
	@Modifying
	@PostMapping("/esercizio_3/addSkillsFromIDCV_2/{id_curriculum}")
	public void esercizio_3_addSkillsFromIDCV_2(@PathVariable int id_curriculum,@RequestParam Set<Integer> idTipskill) throws Exception
	{
		tipskillService.esercizio_3_addSkillsFromIDCV_2(id_curriculum,idTipskill);
	}
	@Transactional
	@Modifying
	@PostMapping("/esercizio_3/addSkillsFromIDCV/{id_curriculum}")
	public String esercizio_3_addSkillsFromIDCV(@PathVariable int id_curriculum,@RequestBody Set<Tipskill> tipskill)
	{
		return tipskillService.esercizio_3_addSkillsFromIDCV(id_curriculum,tipskill);
	}
	@Transactional
	@Modifying
	@PostMapping("/addSkillToDip")
	public void addSkillToDip(@RequestParam int idCv,@RequestParam Set<Integer> tpskill) throws Exception {
		tipskillService.aggiungiSkillToCV(idCv, tpskill);
	}
}
