package it.tecninf.hrmanagement.utility;

import java.util.HashSet;
import java.util.Set;

import it.tecninf.hrmanagement.model.Tipskill;

public class BaseResponseDipendente {
	private String nome;
	private String cognome;
	private Set<Tipskill> skills = new HashSet<>();
	
	public BaseResponseDipendente() {
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

	public Set<Tipskill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Tipskill> skills) {
		this.skills = skills;
	}

	
	
	
}
