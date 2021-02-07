package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Integer> {

}
