package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence,Integer> {

}
