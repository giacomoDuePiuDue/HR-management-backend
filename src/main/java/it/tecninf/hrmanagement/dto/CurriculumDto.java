package it.tecninf.hrmanagement.dto;

import java.util.HashSet;
import java.util.Set;

import it.tecninf.hrmanagement.model.Curriculum;

public class CurriculumDto {

	private String nome;
	private String cognome;
	private Set<Curriculum> curriculum = new HashSet<Curriculum>();
	
	public CurriculumDto() {
		super();
	}
	public CurriculumDto(String nome, String cognome, Set<Curriculum> curriculum) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.curriculum = curriculum;
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
