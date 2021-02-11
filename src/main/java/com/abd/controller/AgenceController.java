package com.abd.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.abd.entity.Agence;
import com.abd.entity.Pays;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.AgenceRepository;
import com.abd.repository.PaysRepository;



@Controller
public class AgenceController {
	
    @Autowired
    private AgenceRepository agenceRepository;
    @Autowired
    private PaysRepository paysRepository;
    
	//get all Agences
    @RequestMapping(value = "/agences")
	public String getAllAgences(Model model){
        List<Agence> agences = agenceRepository.findAll();
        model.addAttribute("Agences", agences);     
        model.addAttribute("agence", new Agence());
        model.addAttribute("unpays", new Pays());
        model.addAttribute("pays", paysRepository.findAll());
        return "agences";
	}
    
	// get Agence by id
    @RequestMapping(value = "/agences/{numAg}")
	public Agence getAgenceById(@PathVariable (value = "numAg") int numAg) {
		return agenceRepository.findById(numAg)
				.orElseThrow(()->new ResourceNotFoundException("Agence not found with num : " + numAg));
	}
    
    // create Agence
    @PostMapping(value = "/agences/create")
	public String createAgence(@Valid @ModelAttribute("agence") Agence agence) { //,BindingResult bindingResult//if (!bindingResult.hasErrors()) {}
		agenceRepository.save(agence);	
	    return "redirect:/agences"; 	
	}

	// update Agence
    @PostMapping(value = "/agences/update")
	public String updateAgence(@Valid @ModelAttribute("agence") Agence agence) {
		Agence existingAgence = agenceRepository.findById(agence.getNumAg())
			.orElseThrow(() -> new ResourceNotFoundException("Agence not found with id :" + agence.getNumAg()));
		existingAgence.setNomAg(agence.getNomAg());
		existingAgence.setNbrEmplyes(agence.getNbrEmplyes());
		existingAgence.setNumPays(agence.getNumPays());
		 agenceRepository.save(existingAgence);
		 return "redirect:/agences";  
	}
    
	// delete Agence by id
    @RequestMapping(value = "/agences/delete/{numAg}")
	public String deleteAgence(@PathVariable ("numAg") int numAg){
		Agence existingAgence = agenceRepository.findById(numAg)
					.orElseThrow(() -> new ResourceNotFoundException("Agence not found with id :" + numAg));
		agenceRepository.delete(existingAgence);
	    return "redirect:/agences";  
	}
}
