package com.firas.weapon.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.firas.weapon.entities.Weapon;
import com.firas.weapon.service.WeaponService;

@Controller
public class WeaponController {
	@Autowired
	WeaponService weaponService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("weapon", new Weapon());
		modelMap.addAttribute("mode", "new");

	return "formWeapon";
	}
	@RequestMapping("/saveWeapon")
	public String saveWeapon(@Valid Weapon weapon, BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formWeapon";
		weaponService.saveWeapon(weapon);
	return "formWeapon";
	}
	
	@RequestMapping("/ListeWeapons")
	public String listeWeapons(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)		
	{
	Page<Weapon> wps = weaponService.getAllWeaponParPage(page, size);
	modelMap.addAttribute("weapons", wps);
	modelMap.addAttribute("pages", new int[wps.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeWeapons";
	}
	
	@RequestMapping("/supprimerWeapon")
	public String supprimerWeapon(@RequestParam("id") Long id,
	 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{
		weaponService.deleteWeaponById(id);
	Page<Weapon> wps = weaponService.getAllWeaponParPage(page,
			size);
	modelMap.addAttribute("weapons", wps);
	modelMap.addAttribute("pages", new int[wps.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	  return "listeWeapons";
	}
	
	@RequestMapping("/modifierWeapon")
	public String editerWeapon(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Weapon w= weaponService.getWeapon(id);
	modelMap.addAttribute("weapon", w);
	modelMap.addAttribute("mode", "edit");

	return "formWeapon";
	}
	@RequestMapping("/updateWeapon")
	public String updateWeapon(@ModelAttribute("weapon") Weapon weapon,
	@RequestParam("date") String date,

	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 weapon.setDateCreation(dateCreation);

	 weaponService.updateWeapon(weapon);
	 List<Weapon> wps = weaponService.getAllWeapon();
	 modelMap.addAttribute("weapons", wps);
	return "listeWeapons";
	}
}
