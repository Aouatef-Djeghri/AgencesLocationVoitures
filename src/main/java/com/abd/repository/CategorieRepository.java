package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.Categorie;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {

}
