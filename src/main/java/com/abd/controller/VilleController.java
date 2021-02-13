package com.abd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.abd.entity.Ville;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.VilleRepository;


@Controller
@RequestMapping(value = "/villes")
public class VilleController {
	
    @Autowired
    private VilleRepository villeRepository;
    
	//get all Villes
    @RequestMapping(value = "/")
	public List<Ville> getAllVilles(){
		return villeRepository.findAll();
	}
    
	// get Ville by id
    @GetMapping(value = "/{codePostal}")
	public Ville getVilleById(@PathVariable (value = "codePostal") int codePostal) {
		return villeRepository.findById(codePostal)
				.orElseThrow(()->new ResourceNotFoundException("Ville not found with num :" + codePostal));
	}
    
    // create Ville
    @PostMapping
	public Ville createVille(@RequestBody Ville ville) {
		return villeRepository.save(ville);
	}

	// update Ville
	@PutMapping(value = "/{codePostal}")
	public Ville updateVille(@RequestBody Ville ville, @PathVariable ("codePostal") int codePostal) {
		Ville existingVille = villeRepository.findById(codePostal)
			.orElseThrow(() -> new ResourceNotFoundException("Ville not found with id :" + codePostal));
		existingVille.setNomVille(ville.getNomVille());
		return villeRepository.save(existingVille);
	}
    
	// delete Ville by id
	@DeleteMapping(value = "/{numAg}")
	public ResponseEntity<Ville> deleteVille(@PathVariable ("numAg") int numAg){
		Ville existingVille = villeRepository.findById(numAg)
					.orElseThrow(() -> new ResourceNotFoundException("Ville not found with id :" + numAg));
		villeRepository.delete(existingVille);
		return ResponseEntity.ok().build();
	}
}
