package com.abd.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.abd.entity.Vehicule;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.AgenceRepository;
import com.abd.repository.CategorieRepository;
import com.abd.repository.ModeleRepository;
import com.abd.repository.TypeRepository;
import com.abd.repository.VehiculeRepository;

@Controller
public class VehiculeController {
	
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private ModeleRepository modeleRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private AgenceRepository agenceRepository;
    
	//get all Vehicules
    @RequestMapping(value = "/vehicules")
	public String getAllVehicules(Model model){
            model.addAttribute("vehicule", new Vehicule());
	        model.addAttribute("Vehicules", vehiculeRepository.findAll());   
	        model.addAttribute("models", modeleRepository.findAll());
	        model.addAttribute("categories", categorieRepository.findAll());
	        model.addAttribute("types", typeRepository.findAll());
	        model.addAttribute("agences", agenceRepository.findAll());
	        return "vehicules";
	}
    
	// get Vehicule by id
    @RequestMapping(value = "/vehicules/{immatriculation}")
	public Vehicule getVehiculeById(@PathVariable (value = "immatriculation") int immatriculation) {
		return vehiculeRepository.findById(immatriculation)
				.orElseThrow(()->new ResourceNotFoundException("Vehicule not found with num :" + immatriculation));
	}
    
    // create Vehicule
    @PostMapping(value = "/vehicules/create")
	public String createVehicule(@Valid @ModelAttribute("vehicule") Vehicule vehicule) {
		 vehiculeRepository.save(vehicule);
		 return "redirect:/vehicules";
	}

	// update Vehicule
    @PostMapping(value = "/vehicules/update")
	public String updateVehicule(@Valid @ModelAttribute("vehicule") Vehicule vehicule) {
		Vehicule existingVehicule = vehiculeRepository.findById(vehicule.getImmatriculation())
			.orElseThrow(() -> new ResourceNotFoundException("Vehicule not found with id :" + vehicule.getImmatriculation()));
		existingVehicule.setCouleur(vehicule.getCouleur());
		existingVehicule.setAge(vehicule.getAge());
		existingVehicule.setNumAgence(vehicule.getNumAgence());
		existingVehicule.setNumModele(vehicule.getNumModele());
		existingVehicule.setNumType(vehicule.getNumType());
		existingVehicule.setNumcat(vehicule.getNumcat());
		vehiculeRepository.save(existingVehicule);
		return "redirect:/vehicules";
	}
    
	// delete Vehicule by id
    @RequestMapping(value = "/vehicules/delete/{immatriculation}")
	public String deleteVehicule(@PathVariable ("immatriculation") int immatriculation){
		Vehicule existingVehicule = vehiculeRepository.findById(immatriculation)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicule not found with id :" + immatriculation));
		vehiculeRepository.delete(existingVehicule);
		ResponseEntity.ok().build();
		return "redirect:/vehicules";
	}
}
