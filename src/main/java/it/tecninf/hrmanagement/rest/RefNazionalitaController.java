package it.tecninf.hrmanagement.rest;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.tecninf.hrmanagement.model.RefNazionalita;
import it.tecninf.hrmanagement.service.RefNazionalitaService;

@CrossOrigin(origins = "*")
	@RestController
	@RequestMapping("refnazionalita")
	public class RefNazionalitaController {

		@Autowired
		private RefNazionalitaService refnazionalitaService;
			
		
		@GetMapping("/listanazionalita")
		public List <RefNazionalita> listaNazionalita() {
			return (List<RefNazionalita>) refnazionalitaService.listaNazionalita();
		}
		
		@PostMapping("/aggiungi/{nazionalita}")
		public void add(@PathVariable String nazionalita) {
			 refnazionalitaService.addNat(nazionalita);
		}
}