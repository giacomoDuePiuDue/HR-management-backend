package it.tecninf.hrmanagement.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.tecninf.hrmanagement.model.Curriculum;
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
		
		
		//------------aggiunta------------
		@Query(value = "SELECT * "
				+ "FROM hrmanagement.tipskill "
				+ "INNER JOIN hrmanagement.competenze ON hrmanagement.tipskill.id_tipskill = hrmanagement.competenze.id_tipskill "
				+ "INNER JOIN hrmanagement.curriculum ON hrmanagement.curriculum.id_curriculum = hrmanagement.competenze.id_curriculum "
				+ "WHERE hrmanagement.competenze.id_dipendente=? AND "
				+ "hrmanagement.curriculum.id_curriculum =? ;", nativeQuery = true)
		public List<Tipskill> getTipskillsByEmployeeIDCvID(int dipendenteID,int cvID);
}