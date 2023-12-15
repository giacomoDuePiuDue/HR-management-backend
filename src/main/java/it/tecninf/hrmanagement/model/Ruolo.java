package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@NamedQuery(name="Ruolo.findAll", query="SELECT r FROM Ruolo r")
public class Ruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ruolo")
	private int idRuolo;

	private String mansione;

	private String profilo;

	private String ruolo;


	@ManyToOne
	@JoinColumn(name="id_dipendente")
	private Dipendente dipendente;

	public Ruolo() {
	}

	public int getIdRuolo() {
		return this.idRuolo;
	}

	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getMansione() {
		return this.mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public String getProfilo() {
		return this.profilo;
	}

	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}

	public String getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Dipendente getDipendente() {
		return this.dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
}