package it.tecninf.hrmanagement.model;
//prova
import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Entity
@NamedQuery(name="Dipendente.findAll", query="SELECT d FROM Dipendente d")
public class Dipendente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_dipendente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDipendente;

	private String citta;

	private String cognome;

	@Temporal(TemporalType.DATE)
	@Column(name="data_di_nascita")
	private Date dataDiNascita;

	private String indirizzo;

	private String matricola;

	private String nome;

	
	@Column(name="row_exist")
	private int rowExist;
	
	@ManyToMany(fetch = FetchType.EAGER)//,cascade = CascadeType.ALL)
	@JoinTable(name = "competenze",
	joinColumns = {@JoinColumn(name="id_dipendente")},
	inverseJoinColumns= {@JoinColumn(name="id_tipskill")})
	private Set<Tipskill> skills = new HashSet<>();
	

	@ManyToOne
	@JoinColumn(name="id_ref_nazionalita")
	private RefNazionalita refNazionalita;
	
	@OneToMany(mappedBy="dipendente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Curriculum> curriculum = new HashSet<Curriculum>(); 
	


	public Dipendente() {
	}

	public int getIdDipendente() {
		return this.idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return this.dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getMatricola() {
		return this.matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRowExist() {
		return this.rowExist;
	}

	public void setRowExist(int rowExist) {
		this.rowExist = rowExist;
	}

	public RefNazionalita getRefNazionalita() {
		return this.refNazionalita;
	}

	public void setRefNazionalita(RefNazionalita refNazionalita) {
		this.refNazionalita = refNazionalita;
	}

	public Set<Tipskill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Tipskill> skills) {
		this.skills = skills;
	}

	public Set<Curriculum> getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Set<Curriculum> curriculum) {
		this.curriculum = curriculum;
	}
}