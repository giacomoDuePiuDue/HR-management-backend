package it.tecninf.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.tecninf.hrmanagement.model.Storing;

public interface StoringRepository  extends CrudRepository<Storing, Integer>{
	
	@Query(value ="SELECT * FROM hrmanagement.storing;" ,nativeQuery=true )
	public List<Storing> getStoring();
	
	
}
