package it.tecninf.hrmanagement.dto;

import java.util.Date;
import java.util.Set;

import it.tecninf.hrmanagement.model.Tipskill;

public class DipendenteDto {

	private int idDipendente;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private Set<Tipskill> skill;
	
	public DipendenteDto() {
		super();
	}
	public DipendenteDto(int id,String nome, String cognome, Set<Tipskill> skill,Date date) {
		
		this.idDipendente = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = date;
		this.skill = skill;
	}
	public String getNome() {
		return nome;
	}
	public int getIdDipendente() {
		return idDipendente;
	}
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
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
