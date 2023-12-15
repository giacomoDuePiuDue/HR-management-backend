package it.tecninf.hrmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import it.tecninf.hrmanagement.repository.DipendenteRepository;
import it.tecninf.hrmanagement.repository.StoringRepository;
import it.tecninf.hrmanagement.model.Storing;

@Service
public class StoringService {

	@Autowired
	private StoringRepository storingRepository;
	
	public List<Storing> getStoring() {
		return storingRepository.getStoring();
	}
	
}
