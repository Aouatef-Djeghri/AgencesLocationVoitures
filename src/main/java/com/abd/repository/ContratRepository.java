package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {

}
