package com.abd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.entity.ModeLocation;

@Repository
public interface ModeLocationRepository extends JpaRepository<ModeLocation,String> {

}
