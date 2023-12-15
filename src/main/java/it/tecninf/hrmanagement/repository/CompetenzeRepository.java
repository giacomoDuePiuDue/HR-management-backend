package it.tecninf.hrmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import javax.transaction.Transactional;

import it.tecninf.hrmanagement.model.Competenze;
import it.tecninf.hrmanagement.utility.Chart;


public interface CompetenzeRepository extends CrudRepository<Competenze,Integer>{

	@Query(value = "SELECT COUNT(*) as quantity FROM hrmanagement.competenze GROUP BY skill;", nativeQuery = true)
	public List<Integer> getChartVals();
	
	@Query(value = "SELECT skill as quantity FROM hrmanagement.competenze GROUP BY skill;", nativeQuery = true)
	public List<String> getChartNames();
	
	
}
