package it.tecninf.hrmanagement.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.tecninf.hrmanagement.model.Curriculum;
import it.tecninf.hrmanagement.model.Dipendente;
import it.tecninf.hrmanagement.model.Tipskill;

public interface CurriculumRepository extends CrudRepository<Curriculum,Integer>{
	//------------esecizio 2------------
	@Query(value = "SELECT * "
			+ "FROM hrmanagement.competenze "
			+ "INNER JOIN hrmanagement.curriculum ON hrmanagement.curriculum.id_curriculum = hrmanagement.competenze.id_curriculum "
			+ "INNER JOIN hrmanagement.dipendente ON hrmanagement.dipendente.id_dipendente = hrmanagement.competenze.id_dipendente "
			+ "INNER JOIN hrmanagement.tipskill on hrmanagement.tipskill.id_tipskill = hrmanagement.competenze.id_tipskill "
			+ "WHERE BINARY tipskill.tipologia_skill IN(:skills) "
			+ "ORDER BY dipendente.cognome ASC;", nativeQuery = true)
	public List<Curriculum> curriculumPerCompetenze(Set<String> skills);
}