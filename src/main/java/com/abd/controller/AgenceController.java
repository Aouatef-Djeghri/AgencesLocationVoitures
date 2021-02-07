package com.abd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.abd.entity.Agence;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.AgenceRepository;

@RestController
@RequestMapping(value = "/agences")
public class AgenceController {
	
    @Autowired
    private AgenceRepository agenceRepository;
    
	//get all Agences
    @GetMapping
	public List<Agence> getAllAgences(){
		return agenceRepository.findAll();
	}
    
	// get Agence by id
    @GetMapping(value = "/{numAg}")
	public Agence getAgenceById(@PathVariable (value = "numAg") int numAg) {
		return agenceRepository.findById(numAg)
				.orElseThrow(()->new ResourceNotFoundException("Agence not found with num : " + numAg));
	}
    
    // create Agence
    @PostMapping
	public Agence createAgence(@RequestBody Agence agence) {
		return agenceRepository.save(agence);
	}

	// update Agence
	@PutMapping(value = "/{numAg}")
	public Agence updateAgence(@RequestBody Agence agence, @PathVariable ("numAg") int numAg) {
		Agence existingAgence = agenceRepository.findById(numAg)
			.orElseThrow(() -> new ResourceNotFoundException("Agence not found with id :" + numAg));
		existingAgence.setNomAg(agence.getNomAg());
		existingAgence.setNbrEmplyes(agence.getNbrEmplyes());
		existingAgence.setNumPays(agence.getNumPays());
		 return agenceRepository.save(existingAgence);
	}
    
	// delete Agence by id
	@DeleteMapping(value = "/{numAg}")
	public ResponseEntity<Agence> deleteAgence(@PathVariable ("numAg") int numAg){
		Agence existingAgence = agenceRepository.findById(numAg)
					.orElseThrow(() -> new ResourceNotFoundException("Agence not found with id :" + numAg));
		agenceRepository.delete(existingAgence);
		 return ResponseEntity.ok().build();
	}
}
