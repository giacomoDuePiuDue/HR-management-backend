package it.tecninf.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.tecninf.hrmanagement.model.Tipskill;

	public interface TipskillRepository extends CrudRepository<Tipskill, Integer >{ 	
		
		@Modifying
	    @Transactional
		@Query(
			   value = "SELECT * FROM hrmanagement.tipskill", 
			   nativeQuery = true)
		List<Tipskill> listaSkill();
		
		@Modifying
		@Transactional
		@Query(
			   value = "DELETE FROM hrmanagement.tipskill WHERE id_tipskill=?",
			   nativeQuery = true)
		public void cancellaSkill(int id_tip_skill);
}