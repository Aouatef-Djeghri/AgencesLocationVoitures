package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.abd.entity.Contrat;


@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {

	@Query(value = "select DB_PACKAGE.nbrContract(:etatContrat) from DUAL",nativeQuery = true)
	int getNbrContractWithState(@Param("etatContrat") String etatContrat);
	
}
