package com.firas.weapon.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Weapon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idWp;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomWp;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixWp;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Class classe;
	public Weapon() {
		super();
	}
	public Class getClasse() {
		return classe;
	}
	public void setClasse(Class classe) {
		this.classe = classe;
	}
	public Weapon(Long idWp, String nomWp, Double prixWp, Date dateCreation,Class classe) {
		super();
		this.idWp = idWp;
		this.nomWp = nomWp;
		this.prixWp = prixWp;
		this.dateCreation = dateCreation;
		this.classe=classe;
	}
	public Long getIdWp() {
		return idWp;
	}
	public void setIdWp(Long idWp) {
		this.idWp = idWp;
	}
	public String getNomWp() {
		return nomWp;
	}
	public void setNomWp(String nomWp) {
		this.nomWp = nomWp;
	}
	public Double getPrixWp() {
		return prixWp;
	}
	public void setPrixWp(Double prixWp) {
		this.prixWp = prixWp;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Weapon [idWp=" + idWp + ", nomWp=" + nomWp + ", prixWp=" + prixWp + ", dateCreation=" + dateCreation
				+ "]";
	}
	
	
	
	
	}
	
	

