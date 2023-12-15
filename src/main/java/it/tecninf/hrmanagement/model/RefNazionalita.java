package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="ref_nazionalita")
@NamedQuery(name="RefNazionalita.findAll", query="SELECT r FROM RefNazionalita r")
public class RefNazionalita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ref_nazionalita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRefNazionalita;

	private String nazionalita;

	public RefNazionalita() {
	}

	public int getIdRefNazionalita() {
		return this.idRefNazionalita;
	}

	public void setIdRefNazionalita(int idRefNazionalita) {
		this.idRefNazionalita = idRefNazionalita;
	}

	public String getNazionalita() {
		return this.nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
}