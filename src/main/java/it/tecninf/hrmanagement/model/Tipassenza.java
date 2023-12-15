package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipassenza database table.
 * 
 */
@Entity
@NamedQuery(name="Tipassenza.findAll", query="SELECT t FROM Tipassenza t")
public class Tipassenza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipassenza")
	private int idTipassenza;

	@Column(name="tipologia_assenza")
	private String tipologiaAssenza;

	public Tipassenza() {
	}

	public int getIdTipassenza() {
		return this.idTipassenza;
	}

	public void setIdTipassenza(int idTipassenza) {
		this.idTipassenza = idTipassenza;
	}

	public String getTipologiaAssenza() {
		return this.tipologiaAssenza;
	}

	public void setTipologiaAssenza(String tipologiaAssenza) {
		this.tipologiaAssenza = tipologiaAssenza;
	}
}