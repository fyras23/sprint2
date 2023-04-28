package com.firas.weapon.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomWp", types = { Weapon.class })
public interface WeaponProjection {
	public String getNomWp();

}
