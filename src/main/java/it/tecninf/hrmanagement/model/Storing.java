package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the storing database table.
 * 
 */
@Entity
@NamedQuery(name="Storing.findAll", query="SELECT s FROM Storing s")
public class Storing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_storing")
	private int idStoring;

	private String anno;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine")
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio")
	private Date dataInizio;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inserimento")
	private Date dataInserimento;

	private String mese;

	//uni-directional many-to-one association to Dipendente
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_dipendente")
	private Dipendente dipendente;

	public Storing() {
	}

	public int getIdStoring() {
		return this.idStoring;
	}

	public void setIdStoring(int idStoring) {
		this.idStoring = idStoring;
	}

	public String getAnno() {
		return this.anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getMese() {
		return this.mese;
	}

	public void setMese(String mese) {
		this.mese = mese;
	}

	public Dipendente getDipendente() {
		return this.dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
}