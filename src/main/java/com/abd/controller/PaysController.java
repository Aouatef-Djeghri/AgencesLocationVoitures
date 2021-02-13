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
import com.abd.entity.Pays;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.PaysRepository;

@Controller
@RequestMapping(value = "/pays")
public class PaysController {

	
    @Autowired
    private PaysRepository paysRepository;
    
	//get all Pays
    @GetMapping
	public List<Pays> getAllPays(){
		return paysRepository.findAll();
	}
    
	// get Pays by id
    @GetMapping("/{numAg}")
	public Pays getPaysById(@PathVariable (value = "numPays") int numPays) {
		return paysRepository.findById(numPays)
				.orElseThrow(()->new ResourceNotFoundException("Pays not found with num :" + numPays));
	}
    
    // create Pays
    @PostMapping
	public Pays createPays(@RequestBody Pays pays) {
		return paysRepository.save(pays);
	}

	// update Pays
	@PutMapping("/{numPays}")
	public Pays updatePays(@RequestBody Pays pays, @PathVariable ("numPays") int numPays) {
		Pays existingPays = paysRepository.findById(numPays)
			.orElseThrow(() -> new ResourceNotFoundException("Pays not found with id :" + numPays));
		existingPays.setNomPays(pays.getNomPays());
		existingPays.setNbrHabitant(pays.getNbrHabitant());
		 return paysRepository.save(existingPays);
	}
    
	// delete Pays by id
	@DeleteMapping("/{numPays}")
	public ResponseEntity<Pays> deletePays(@PathVariable ("numPays") int numPays){
		Pays existingPays = paysRepository.findById(numPays)
					.orElseThrow(() -> new ResourceNotFoundException("Pays not found with id :" + numPays));
		paysRepository.delete(existingPays);
		 return ResponseEntity.ok().build();
	}
}
