package com.firas.weapon.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Class {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClass;
	private String nomClass;
	private String descriptionClass;
	@JsonIgnore
	@OneToMany(mappedBy = "classe")
	private List<Weapon> weapons;

	public Class() {
		super();
	}

	public Class(String nomClass, String descriptionClass, List<Weapon> weapons) {
		super();
		this.nomClass = nomClass;
		this.descriptionClass = descriptionClass;
		this.weapons = weapons;
	}

	public Long getIdClass() {
		return idClass;
	}

	public void setIdClass(Long idClass) {
		this.idClass = idClass;
	}

	public String getNomClass() {
		return nomClass;
	}

	public void setNomClass(String nomClass) {
		this.nomClass = nomClass;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public String getDescriptionClass() {
		return descriptionClass;
	}

	public void setDescriptionClass(String descriptionClass) {
		this.descriptionClass = descriptionClass;
	}


}
