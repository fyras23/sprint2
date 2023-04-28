package com.firas.weapon.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.firas.weapon.entities.Weapon;
import com.firas.weapon.entities.Class;


@RepositoryRestResource(path = "rest")
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
	List<Weapon> findByNomWp(String nom);
	 List<Weapon> findByNomWpContains(String nom);
	 
	/* @Query("select w from Weapon w where w.nomWp like %?1 and w.prixWp > ?2")
	 List<Weapon> findByNomWp (String nom, Double prix);*/
	 
	 @Query("select w from Weapon w where w.nomWp like %:nom and w.prixWp > :prix")
	 List<Weapon> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 @Query("select w from Weapon w where w.classe = ?1")
	 List<Weapon> findByClass (Class classe);
	 
	 List<Weapon> findByClasseIdClass(Long id);
	 
	 List<Weapon> findByOrderByNomWpAsc();

	 @Query("select w from Weapon w order by w.nomWp ASC, w.prixWp DESC")
	 List<Weapon> trierWeaponNomsPrix ();

}
