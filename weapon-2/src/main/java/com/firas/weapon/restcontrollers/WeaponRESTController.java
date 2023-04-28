package com.firas.weapon.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firas.weapon.entities.Weapon;
import com.firas.weapon.service.WeaponService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class WeaponRESTController {
	@Autowired
	WeaponService weaponService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Weapon> getAllWeapon() {
	return weaponService.getAllWeapon();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Weapon getweaponById(@PathVariable("id") Long id) {
	return weaponService.getWeapon(id);
	 }

	@RequestMapping(method = RequestMethod.POST)
	public Weapon createWeapon(@RequestBody Weapon weapon) {
	return weaponService.saveWeapon(weapon);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Weapon updateWeapon(@RequestBody Weapon weapon) {
	return weaponService.updateWeapon(weapon);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteWeapon(@PathVariable("id") Long id)
	{
		weaponService.deleteWeaponById(id);
	}
	@RequestMapping(value="/wpclass/{idClass}",method = RequestMethod.GET)
	public List<Weapon> getWeaponsByCatId(@PathVariable("idClass") Long idClass) {
	return weaponService.findByClasseIdClass(idClass);
	}

	

}
