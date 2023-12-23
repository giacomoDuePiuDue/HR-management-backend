package it.tecninf.hrmanagement.repository;

import org.hibernate.type.BigIntegerType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.transaction.Transactional;

import it.tecninf.hrmanagement.model.Competenze;
import it.tecninf.hrmanagement.utility.Chart;


public interface CompetenzeRepository extends CrudRepository<Competenze,Integer>{

	@Query(value = "SELECT COUNT(*) as quantity FROM hrmanagement.competenze GROUP BY skill;", nativeQuery = true)
	public List<Integer> getChartVals();
	
	@Query(value = "SELECT skill as quantity FROM hrmanagement.competenze GROUP BY skill;", nativeQuery = true)
	public List<String> getChartNames();

	//------------aggiunta------------
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "FROM hrmanagement.competenze "
			+ "WHERE hrmanagement.competenze.id_dipendente=:dipendenteId AND "
			+ "hrmanagement.competenze.id_tipskill=:tipskillId ;", nativeQuery = true)
	public int deleteByIdDipendenteIdCompetenza(int dipendenteId,int tipskillId);
	
	@Query(value = "SELECT COUNT(*) "
			+ "FROM hrmanagement.competenze "
			+ "WHERE hrmanagement.competenze.id_dipendente=:dipendenteId AND "
			+ "hrmanagement.competenze.id_tipskill=:tipskillId ;", nativeQuery = true)
	public int existByIdDipendenteIdCompetenza(int dipendenteId,int tipskillId);

}
