package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@NamedQuery(name="Curriculum.findAll", query="SELECT c FROM Curriculum c")
public class Curriculum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_curriculum")
	private int idCurriculum;

	@Lob
	private byte[] curriculum;
	
	@Transient
	private String pdfText ;

	@ManyToOne
	@JoinColumn(name="id_dipendente")
	private Dipendente dipendente;
	

	public Curriculum() {
	}

	

	public int getIdCurriculum() {
		return idCurriculum;
	}



	public void setIdCurriculum(int idCurriculum) {
		this.idCurriculum = idCurriculum;
	}



	public String getPdfText() {
		return this.pdfText;
	}

	public void setPdfText(String pdfText) {
		this.pdfText = pdfText;
	}
	
	
	public byte[] getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(byte[] curriculum) {
		this.curriculum = curriculum;
	}

	
	@JsonIgnore
	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idCurriculum);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curriculum other = (Curriculum) obj;
		return idCurriculum == other.idCurriculum;
	}
	

	


	
	



}