package com.abd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abd.entity.Vehicule;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.VehiculeRepository;

@RestController
@RequestMapping(value = "/vehicules")
public class VehiculeController {
	
    @Autowired
    private VehiculeRepository vehiculeRepository;
    
	//get all Vehicules
    @GetMapping
	public List<Vehicule> getAllVehicules(){
		return vehiculeRepository.findAll();
	}
    
	// get Vehicule by id
    @GetMapping(value = "/{immatriculation}")
	public Vehicule getVehiculeById(@PathVariable (value = "immatriculation") int immatriculation) {
		return vehiculeRepository.findById(immatriculation)
				.orElseThrow(()->new ResourceNotFoundException("Vehicule not found with num :" + immatriculation));
	}
    
    // create Vehicule
    @PostMapping
	public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
		return vehiculeRepository.save(vehicule);
	}

	// update Vehicule
	@PutMapping(value = "/{immatriculation}")
	public Vehicule updateVehicule(@RequestBody Vehicule vehicule, @PathVariable ("immatriculation") int immatriculation) {
		Vehicule existingVehicule = vehiculeRepository.findById(immatriculation)
			.orElseThrow(() -> new ResourceNotFoundException("Vehicule not found with id :" + immatriculation));
		existingVehicule.setCouleur(vehicule.getCouleur());
		existingVehicule.setAge(vehicule.getAge());
		existingVehicule.setNumAgence(vehicule.getNumAgence());
		existingVehicule.setNumModeLocation(vehicule.getNumModeLocation());
		existingVehicule.setNumType(vehicule.getNumType());
		existingVehicule.setNumcat(vehicule.getNumcat());
		return vehiculeRepository.save(existingVehicule);
	}
    
	// delete Vehicule by id
	@DeleteMapping(value = "/{immatriculation}")
	public ResponseEntity<Vehicule> deleteVehicule(@PathVariable ("immatriculation") int immatriculation){
		Vehicule existingVehicule = vehiculeRepository.findById(immatriculation)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicule not found with id :" + immatriculation));
		vehiculeRepository.delete(existingVehicule);
		 return ResponseEntity.ok().build();
	}
}
