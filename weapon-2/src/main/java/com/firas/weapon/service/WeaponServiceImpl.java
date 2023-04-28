package com.firas.weapon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.firas.weapon.entities.Class;
import com.firas.weapon.entities.Weapon;
import com.firas.weapon.repos.WeaponRepository;
@Service
public class WeaponServiceImpl  implements WeaponService {

	@Autowired
	WeaponRepository weaponRepository;
	@Override
	public Weapon saveWeapon(Weapon p) {
	return weaponRepository.save(p);
	}
	@Override
	public Weapon updateWeapon(Weapon p) {
	return weaponRepository.save(p);
	}
	@Override
	public void deleteWeapon(Weapon p) {
		weaponRepository.delete(p);
	}
	 @Override
	public void deleteWeaponById(Long id) {
		 weaponRepository.deleteById(id);
	}
	@Override
	public Weapon getWeapon(Long id) {
	return weaponRepository.findById(id).get();
	}
	@Override
	public List<Weapon> getAllWeapon() {
	return weaponRepository.findAll();
	}
	@Override
	public Page<Weapon> getAllWeaponParPage(int page, int size) {
	return weaponRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Weapon> findByNomWp(String nom) {
		return weaponRepository.findByNomWp(nom);		
	}
	@Override
	public List<Weapon> findByNomWpContains(String nom) {
		return weaponRepository.findByNomWpContains(nom);

	}
	@Override
	public List<Weapon> findByNomPrix(String nom, Double prix) {
		return weaponRepository.findByNomPrix(nom, prix);

	}
	@Override
	public List<Weapon> findByClass(Class classe) {
		return weaponRepository.findByClass(classe);

	}
	@Override
	public List<Weapon> findByClasseIdClass(Long id) {
		return weaponRepository.findByClasseIdClass(id);
	}
	@Override
	public List<Weapon> findByOrderByNomWpAsc() {
		return weaponRepository.findByOrderByNomWpAsc();

	}
	@Override
	public List<Weapon> trierWeaponNomsPrix() {
		return weaponRepository.trierWeaponNomsPrix();

	}

}
