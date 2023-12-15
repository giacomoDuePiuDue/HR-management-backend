package it.tecninf.hrmanagement.dto;

import java.util.Set;

import it.tecninf.hrmanagement.model.Tipskill;

public class DipendenteDto {

	private String nome;
	private String cognome;
	private Set<Tipskill> skill;
	
	public DipendenteDto() {
		super();
	}
	public DipendenteDto(String nome, String cognome, Set<Tipskill> skill) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.skill = skill;
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
	public Set<Tipskill> getSkill() {
		return skill;
	}
	public void setSkill(Set<Tipskill> skill) {
		this.skill = skill;
	}
	
	
	
}
