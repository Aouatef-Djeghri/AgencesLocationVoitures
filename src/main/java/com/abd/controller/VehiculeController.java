package com.abd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.abd.entity.Agence;
import com.abd.entity.Vehicule;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.VehiculeRepository;

@Controller
@RequestMapping(value = "/vehicules")
public class VehiculeController {
	
    @Autowired
    private VehiculeRepository vehiculeRepository;
    
	//get all Vehicules
    @RequestMapping(value = "/")
	public String getAllVehicules(Model model){
	        List<Vehicule> vehicules =  vehiculeRepository.findAll();
	        model.addAttribute("Vehicules", vehicules);       
	        return "vehicules";
	}
    
	// get Vehicule by id
    @RequestMapping(value = "/{immatriculation}")
	public Vehicule getVehiculeById(@PathVariable (value = "immatriculation") int immatriculation) {
		return vehiculeRepository.findById(immatriculation)
				.orElseThrow(()->new ResourceNotFoundException("Vehicule not found with num :" + immatriculation));
	}
    
    // create Vehicule
    @RequestMapping(value = "/create")
	public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
		return vehiculeRepository.save(vehicule);
	}

	// update Vehicule
    @RequestMapping(value = "/update/{immatriculation}")
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
    @RequestMapping(value = "/delete/{immatriculation}")
	public ResponseEntity<Vehicule> deleteVehicule(@PathVariable ("immatriculation") int immatriculation){
		Vehicule existingVehicule = vehiculeRepository.findById(immatriculation)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicule not found with id :" + immatriculation));
		vehiculeRepository.delete(existingVehicule);
		 return ResponseEntity.ok().build();
	}
}
