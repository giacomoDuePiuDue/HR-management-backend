package it.tecninf.hrmanagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import it.tecninf.hrmanagement.model.Dipendente;
import it.tecninf.hrmanagement.model.Storing;
import it.tecninf.hrmanagement.service.DipendenteService;
import it.tecninf.hrmanagement.service.StoringService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("storing")
public class StoringController {
	
	@Autowired
	private StoringService storingService;
	
	@GetMapping("/getStoring")
	public List<Storing> getStoring() {
		return (List<Storing>) storingService.getStoring();
	}
	
	
}
