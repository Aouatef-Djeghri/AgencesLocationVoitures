package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.Tarifs;
import com.abd.entity.TarifsId;

@Repository
public interface TarifsRepository extends JpaRepository<Tarifs,TarifsId> {

}
