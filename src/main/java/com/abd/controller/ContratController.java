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
import com.abd.entity.Contrat;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.ContratRepository;

@RestController
@RequestMapping(value = "/contrats")
public class ContratController {

    @Autowired
    private ContratRepository contratRepository;
    
	//get all Contrats
    @GetMapping
	public List<Contrat> getAllContrats(){
		return contratRepository.findAll();
	}
    
	// get Contrat by id
    @GetMapping("/{numContrat}")
	public Contrat getContratById(@PathVariable (value = "numContrat") int numContrat) {
		return contratRepository.findById(numContrat)
				.orElseThrow(()->new ResourceNotFoundException("Contrat not found with num :" + numContrat));
	}
    
    // create Contrat
    @PostMapping
	public Contrat createContrat(@RequestBody Contrat contrat) {
		return contratRepository.save(contrat);
	}

	// update Contrat
	@PutMapping("/{numContrat}")
	public Contrat updateContrat(@RequestBody Contrat contrat, @PathVariable ("numContrat") int numContrat) {
		Contrat existingContrat = contratRepository.findById(numContrat)
			.orElseThrow(() -> new ResourceNotFoundException("Contrat not found with id :" + numContrat));
		existingContrat.setDatDContrat(contrat.getDatDContrat());
		existingContrat.setDatFContrat(contrat.getDatFContrat());
		existingContrat.setCaution(contrat.getCaution());
		existingContrat.setKmDep(contrat.getKmDep());
		existingContrat.setKmRet(contrat.getKmRet());
		existingContrat.setEtatContrat(contrat.getEtatContrat());
		existingContrat.setNumClient(contrat.getNumClient());
		existingContrat.setVehiculeImmatriculation(contrat.getVehiculeImmatriculation());
		existingContrat.setModeLocation(contrat.getModeLocation());
		return contratRepository.save(existingContrat);
	}
    
	// delete Contrat by id
	@DeleteMapping("/{numContrat}")
	public ResponseEntity<Contrat> deleteContrat(@PathVariable ("numContrat") int numContrat){
		Contrat existingContrat = contratRepository.findById(numContrat)
					.orElseThrow(() -> new ResourceNotFoundException("Contrat not found with id :" + numContrat));
		contratRepository.delete(existingContrat);
		 return ResponseEntity.ok().build();
	}
}
