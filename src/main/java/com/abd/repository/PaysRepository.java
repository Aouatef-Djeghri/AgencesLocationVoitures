package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays,Integer> {

}
