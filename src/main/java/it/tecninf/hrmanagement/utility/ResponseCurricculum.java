package it.tecninf.hrmanagement.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.tecninf.hrmanagement.model.Curriculum;

public class ResponseCurricculum {
	private String nome;
	private String cognome;
	
	


	private Set<Curriculum>  curriculum = new HashSet<Curriculum>();
	

	public ResponseCurricculum() {
		super();
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Set<Curriculum> getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Set<Curriculum> curriculum) {
		this.curriculum = curriculum;
	}




	


	

}
