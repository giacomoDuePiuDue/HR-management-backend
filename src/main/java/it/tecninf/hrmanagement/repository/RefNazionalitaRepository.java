package it.tecninf.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.tecninf.hrmanagement.model.RefNazionalita;

public interface RefNazionalitaRepository extends CrudRepository <RefNazionalita, Integer > { 	
	
	@Query(
		    value = "SELECT * from hrmanagement.ref_nazionalita",
			nativeQuery = true)
	public List<RefNazionalita> listaNazionalita();
}
