package com.firas.weapon.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.firas.weapon.entities.Weapon;
import com.firas.weapon.entities.Class;

public interface WeaponService {
	Weapon saveWeapon(Weapon w);
	Weapon updateWeapon(Weapon w);
	void deleteWeapon(Weapon w);
	 void deleteWeaponById(Long id);
	 Weapon getWeapon(Long id);
	List<Weapon> getAllWeapon();
	Page<Weapon> getAllWeaponParPage(int page, int size);

	
	List<Weapon> findByNomWp(String nom);
	List<Weapon> findByNomWpContains(String nom);
	List<Weapon> findByNomPrix (String nom, Double prix);
	List<Weapon> findByClass (Class classe);
	List<Weapon> findByClasseIdClass(Long id);
	List<Weapon> findByOrderByNomWpAsc();
	List<Weapon> trierWeaponNomsPrix();


}
