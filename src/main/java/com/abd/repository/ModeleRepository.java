package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.Modele;

@Repository
public interface ModeleRepository extends JpaRepository<Modele,Integer> {

}
