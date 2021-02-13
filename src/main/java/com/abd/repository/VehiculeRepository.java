package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abd.entity.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {

	@Query(value = "select DB_PACKAGE.nbrVehicule(:libCategorie) from DUAL",nativeQuery = true)
	int getNbrVehiculeWithCategory(@Param("libCategorie") String libCategorie);
}
