package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {

}
