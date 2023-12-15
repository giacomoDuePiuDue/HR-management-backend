package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@NamedQuery(name="Competenze.findAll", query="SELECT c FROM Competenze c")
public class Competenze implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//lho aggiunto
	@Column(name="id_competenze")
	private int idCompetenze;

	@Column(name="id_dipendente")
	private int idDipendente;

	@Column(name="id_tipskill")
	private int idTipskill;
	
	@Column(name="id_curriculum")
	private int idCurriculum;

	@ManyToMany(mappedBy="skills",cascade = CascadeType.ALL)
	private Set<Dipendente> dipendenti = new HashSet<Dipendente>();
	
	



	public Competenze() {
	}

	public int getIdCompetenze() {
		return this.idCompetenze;
	}

	public void setIdCompetenze(int idCompetenze) {
		this.idCompetenze = idCompetenze;
	}

	public int getIdDipendente() {
		return this.idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}
	
	public int getIdCurriculum() {
		return idCurriculum;
	}

	public void setIdCurriculum(int idCurriculum) {
		this.idCurriculum = idCurriculum;
	}
	

	public int getIdTipskill() {
		return idTipskill;
	}

	public void setIdTipskill(int idTipskill) {
		this.idTipskill = idTipskill;
	}


	public void setDipendenti(Set<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}


}