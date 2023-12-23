package it.tecninf.hrmanagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import it.tecninf.hrmanagement.service.CompetenzeService;
import it.tecninf.hrmanagement.utility.Chart;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("competenze")
public class CompetenzeController {
	@Autowired
	private CompetenzeService compService;

	@Transactional
	@GetMapping("/data")
	public List<Chart> getChartData() {
		List<Integer> vals = compService.getChartVals();
		List<String> names = compService.getChartNames();
		List<Chart> data = new ArrayList<Chart>();
		
		for(int i=0;i<vals.size();i++) {
			data.add(new Chart(names.get(i),vals.get(i)));
		}
				
		return data;
	}
	
	//------------aggiunta------------
	@DeleteMapping("/deleteByIdDipendenteIdCompetenza")
	public void deleteByIdDipendenteIdCompetenza(@RequestParam int dipendenteId,@RequestParam int tipskillId) {
		compService.deleteByIdDipendenteIdCompetenza(dipendenteId,tipskillId);
	}
	
	

}
