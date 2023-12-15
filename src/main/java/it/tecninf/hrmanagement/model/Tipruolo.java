package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipruolo database table.
 * 
 */
@Entity
@NamedQuery(name="Tipruolo.findAll", query="SELECT t FROM Tipruolo t")
public class Tipruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipruolo")
	private int idTipruolo;

	@Column(name="tipologia_ruolo")
	private String tipologiaRuolo;

	public Tipruolo() {
	}

	public int getIdTipruolo() {
		return this.idTipruolo;
	}

	public void setIdTipruolo(int idTipruolo) {
		this.idTipruolo = idTipruolo;
	}

	public String getTipologiaRuolo() {
		return this.tipologiaRuolo;
	}

	public void setTipologiaRuolo(String tipologiaRuolo) {
		this.tipologiaRuolo = tipologiaRuolo;
	}
}