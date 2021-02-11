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
import org.springframework.web.bind.annotation.RestController;

import com.abd.entity.Modele;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.ModeleRepository;


@Controller
@RequestMapping(value = "/modeles")
public class ModeleController {
    @Autowired
    private ModeleRepository modeleRepository;
    
    
	//get all Modeles
    @GetMapping
	public List<Modele> getAllModeles(){
		return modeleRepository.findAll();
	}
    
	// get Modele by id
    @GetMapping(value = "/{numModel}")
	public Modele getModeleById(@PathVariable (value = "numModel") int numModel) {
		return modeleRepository.findById(numModel)
				.orElseThrow(()->new ResourceNotFoundException("Modele not found with num :" + numModel));
	}
    
    // create Modele
    @PostMapping
	public Modele createModele(@RequestBody Modele modele) {
		return modeleRepository.save(modele);
	}

	// update Modele
	@PutMapping(value = "/{numModel}")
	public Modele updateModele(@RequestBody Modele modele, @PathVariable ("numModel") int numModel) {
		Modele existingModele = modeleRepository.findById(numModel)
			.orElseThrow(() -> new ResourceNotFoundException("Modele not found with id :" + numModel));
		existingModele.setMarque(modele.getMarque());
		return modeleRepository.save(existingModele);
	}
    
	// delete Modele by id
	@DeleteMapping(value = "/{numModel}")
	public ResponseEntity<Modele> deleteModele(@PathVariable ("numModel") int numModel){
		Modele existingModele = modeleRepository.findById(numModel)
					.orElseThrow(() -> new ResourceNotFoundException("Modele not found with id :" + numModel));
		modeleRepository.delete(existingModele);
		 return ResponseEntity.ok().build();
	}
    
}


