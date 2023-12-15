package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipmansione database table.
 * 
 */
@Entity
@NamedQuery(name="Tipmansione.findAll", query="SELECT t FROM Tipmansione t")
public class Tipmansione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipmansione")
	private int idTipmansione;

	@Column(name="tipologia_mansione")
	private String tipologiaMansione;

	public Tipmansione() {
	}

	public int getIdTipmansione() {
		return this.idTipmansione;
	}

	public void setIdTipmansione(int idTipmansione) {
		this.idTipmansione = idTipmansione;
	}

	public String getTipologiaMansione() {
		return this.tipologiaMansione;
	}

	public void setTipologiaMansione(String tipologiaMansione) {
		this.tipologiaMansione = tipologiaMansione;
	}
}