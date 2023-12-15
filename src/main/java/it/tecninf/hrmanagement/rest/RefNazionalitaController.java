package it.tecninf.hrmanagement.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.tecninf.hrmanagement.model.RefNazionalita;
import it.tecninf.hrmanagement.service.RefNazionalitaService;

@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("refnazionalita")
	public class RefNazionalitaController {

		@Autowired
		private RefNazionalitaService refnazionalitaService;
			
		
		@GetMapping("/listanazionalita")
		public List <RefNazionalita> listaNazionalita() {
			return (List<RefNazionalita>) refnazionalitaService.listaNazionalita();
		}
}