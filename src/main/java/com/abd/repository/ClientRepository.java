package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.*;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}
