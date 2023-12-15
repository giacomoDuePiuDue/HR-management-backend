package it.tecninf.hrmanagement.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
@NamedQuery(name="Tipskill.findAll", query="SELECT t FROM Tipskill t")
public class Tipskill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipskill")
	private int idTipskill;

	@Column(name="tipologia_skill")
	private String tipologiaSkill;
	
	@ManyToMany(mappedBy="skills")//,cascade = CascadeType.ALL)
	private Set<Dipendente> dipendenti = new HashSet<>();


	public Tipskill() {
	}

	public int getIdTipskill() {
		return this.idTipskill;
	}

	public void setIdTipskill(int idTipskill) {
		this.idTipskill = idTipskill;
	}

	public String getTipologiaSkill() {
		return this.tipologiaSkill;
	}

	public void setTipologiaSkill(String tipologiaSkill) {
		this.tipologiaSkill = tipologiaSkill;
	}
}