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
import com.abd.entity.EtatContrat;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.EtatContratRepository;


@Controller
@RequestMapping(value = "/etatscontrat")
public class EtatContratContoller {
	
    @Autowired
    private EtatContratRepository etatContratRepository;
    
	//get all EtatContrats
    @GetMapping
	public List<EtatContrat> getAllEtatsContrat(){
		return etatContratRepository.findAll();
	}
    
	// get EtatContrat by id
    @GetMapping(value = "/{etatCont}")
	public EtatContrat getEtatContratById(@PathVariable (value = "etatCont") int etatCont ) {
		return etatContratRepository.findById(etatCont)
				.orElseThrow(()->new ResourceNotFoundException("EtatContrat not found with num :" + etatCont));
	}
    
    // create EtatContrat
    @PostMapping
	public EtatContrat createEtatContrat(@RequestBody EtatContrat etatContrat) {
		return etatContratRepository.save(etatContrat);
	}

	// update EtatContrat
	@PutMapping(value = "/{etatCont}")
	public EtatContrat updateEtatContrat(@RequestBody EtatContrat etatContrat, @PathVariable ("etatCont") int etatCont) {
		EtatContrat existingEtatContrat = etatContratRepository.findById(etatCont)
			.orElseThrow(() -> new ResourceNotFoundException("EtatContrat not found with id :" + etatCont));
		existingEtatContrat.setLibEtatContart(etatContrat.getLibEtatContart());
		 return etatContratRepository.save(existingEtatContrat);
	}
    
	// delete EtatContrat by id
	@DeleteMapping(value = "/{etatCont}")
	public ResponseEntity<EtatContrat> deleteEtatContrat(@PathVariable ("etatCont") int etatCont){
		EtatContrat existingEtatContrat = etatContratRepository.findById(etatCont)
					.orElseThrow(() -> new ResourceNotFoundException("EtatContrat not found with id :" + etatCont));
		etatContratRepository.delete(existingEtatContrat);
		 return ResponseEntity.ok().build();
	}
}
