package com.abd.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.abd.entity.Modele;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.ModeleRepository;


@Controller
public class ModeleController {
    @Autowired
    private ModeleRepository modeleRepository;
    
    
	//get all Modeles
    @RequestMapping(value = "/models")
	public String getAllModeles(Model model){
        model.addAttribute("Modeles", modeleRepository.findAll());     
        model.addAttribute("modele", new Modele());
		return "models";
	}
    
	// get Modele by id
    @GetMapping(value = "/models/{numModel}")
	public Modele getModeleById(@PathVariable (value = "numModel") int numModel) {
		return modeleRepository.findById(numModel)
				.orElseThrow(()->new ResourceNotFoundException("Modele not found with num :" + numModel));
	}
    
    // create Modele
    @PostMapping(value = "/models/create")
	public String createModele(@Valid @ModelAttribute("modele") Modele modele) {
		 modeleRepository.save(modele);
		 return "redirect:/models"; 
	}

	// update Modele
    @PostMapping(value = "/models/{numModel}")
	public String updateModele(@Valid @ModelAttribute("modele") Modele modele) {
		Modele existingModele = modeleRepository.findById(modele.getNumModel())
			.orElseThrow(() -> new ResourceNotFoundException("Modele not found with id :" + modele.getNumModel()));
		existingModele.setMarque(modele.getMarque());
		modeleRepository.save(existingModele);
		return "redirect:/models"; 
	}
    
	// delete Modele by id
	@RequestMapping(value = "/models/delete/{numModel}")
	public String deleteModele(@PathVariable ("numModel") int numModel){
		Modele existingModele = modeleRepository.findById(numModel)
					.orElseThrow(() -> new ResourceNotFoundException("Modele not found with id :" + numModel));
		modeleRepository.delete(existingModele);
        return "redirect:/models"; 
	}
    
}


