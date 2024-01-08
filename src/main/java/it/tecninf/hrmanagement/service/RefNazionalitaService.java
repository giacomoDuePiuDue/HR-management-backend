package it.tecninf.hrmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tecninf.hrmanagement.exception.RecourceAlreadyPresenteException;
import it.tecninf.hrmanagement.model.RefNazionalita;
import it.tecninf.hrmanagement.repository.RefNazionalitaRepository;

@Service
public class RefNazionalitaService {
	
	@Autowired
	private RefNazionalitaRepository refnazionalitaRepository;
	
	public List<RefNazionalita> listaNazionalita() {
		return (List<RefNazionalita>) refnazionalitaRepository.listaNazionalita();
	}
	
	public void addNat(String nazionalita) {
		List<RefNazionalita> list = refnazionalitaRepository.listaNazionalita();
		if(list.stream().anyMatch(item -> item.getNazionalita().toLowerCase().equals(nazionalita.toLowerCase()))) {
			System.out.println(list.stream().anyMatch(item -> item.getNazionalita().toLowerCase().equals(nazionalita.toLowerCase())));
//			throw new  RecourceAlreadyPresenteException(nazionalita +" gia presente");
		}else{
			
			RefNazionalita n = new RefNazionalita();
			
			n.setNazionalita(nazionalita);
			System.out.println(n);
			 refnazionalitaRepository.save(n);
			 System.out.println(n);
			
			 
		}
		
	}
}

