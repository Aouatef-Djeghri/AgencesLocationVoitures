package com.abd.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.abd.entity.Agence;
import com.abd.entity.ModeLocation;
import com.abd.entity.Pays;
import com.abd.repository.ModeLocationRepository;


@Controller
@RequestMapping(value = "/modeslocation")
public class ModeLocationController {
	 @Autowired
	    private ModeLocationRepository modeLocationRepository;
	    
		//get all ModeLocations
	    @RequestMapping(value = "/modeslocation")
		public String getAllAgences(Model model){
	        model.addAttribute("ModesLocation", modeLocationRepository.findAll());     
	        model.addAttribute("modeLocation", new ModeLocation());
	        model.addAttribute("unpays", new Pays());
	        return "agences";
		}
	    
		// get ModeLocation by id
	    @RequestMapping(value = "/modeslocation/{numAg}")
		public Agence getAgenceById(@PathVariable (value = "numAg") int numAg) {
//			return modeLocationRepository.findById(numAg)
//					.orElseThrow(()->new ResourceNotFoundException("ModeLocation not found with num : " + numAg));
	    	return null;
		}
	    
	    // create ModeLocation
	    @PostMapping(value = "/modeslocation/create")
		public String createAgence(@Valid @ModelAttribute("agence") Agence agence) { //,BindingResult bindingResult//if (!bindingResult.hasErrors()) {}
	    	//modeLocationRepository.save(agence);	
		    return "redirect:/modeslocation"; 	
		}

		// update ModeLocation
	    @PostMapping(value = "/modeslocation/update")
		public String updateAgence(@Valid @ModelAttribute("agence") Agence agence) {
//			Agence existingAgence = modeLocationRepository.findById(agence.getNumAg())
//				.orElseThrow(() -> new ResourceNotFoundException("ModeLocation not found with id :" + agence.getNumAg()));
//			existingAgence.setNomAg(agence.getNomAg());
//			existingAgence.setNbrEmplyes(agence.getNbrEmplyes());
//			existingAgence.setNumPays(agence.getNumPays());
			//modeLocationRepository.save(existingAgence);
			 return "redirect:/modeslocation";  
		}
	    
		// delete ModeLocation by id
	    @RequestMapping(value = "/modeslocation/delete/{numAg}")
		public String deleteAgence(@PathVariable ("numAg") int numAg){
//			Agence existingAgence = modeLocationRepository.findById(numAg)
//						.orElseThrow(() -> new ResourceNotFoundException("ModeLocation not found with id :" + numAg));
//			modeLocationRepository.delete(existingAgence);
		    return "redirect:/modeslocation";  
		}
}
