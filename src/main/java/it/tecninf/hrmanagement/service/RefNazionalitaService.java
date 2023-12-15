package it.tecninf.hrmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tecninf.hrmanagement.model.RefNazionalita;
import it.tecninf.hrmanagement.repository.RefNazionalitaRepository;

@Service
public class RefNazionalitaService {
	
	@Autowired
	private RefNazionalitaRepository refnazionalitaRepository;
	
	public List<RefNazionalita> listaNazionalita() {
		return (List<RefNazionalita>) refnazionalitaRepository.listaNazionalita();
	}
}
