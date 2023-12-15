package it.tecninf.hrmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import it.tecninf.hrmanagement.repository.CompetenzeRepository;
import it.tecninf.hrmanagement.utility.Chart;

@Service
public class CompetenzeService {

	@Autowired
	private CompetenzeRepository competenzeRepo;
	
	public List<Integer> getChartVals() {
		return competenzeRepo.getChartVals();
	}
	
	public List<String> getChartNames() {
		return competenzeRepo.getChartNames();
	}
	
}
