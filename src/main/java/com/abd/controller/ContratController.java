package com.abd.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.abd.entity.*;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.*;

@Controller
public class ContratController {

    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private ClientRepository cientRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository; 
    @Autowired
    private ModeLocationRepository modeLocationRepository;
    @Autowired
    private EtatContratRepository etatContratRepository;
    
	//get all Contrats
    @RequestMapping(value = "/contrats")
	public String getAllContrats(Model model){
        List<Contrat> contrats = contratRepository.findAll();
        model.addAttribute("Contrats", contrats);  
        model.addAttribute("contrat", new Contrat());
        model.addAttribute("clients", cientRepository.findAll());
        model.addAttribute("vehicules", vehiculeRepository.findAll());
        model.addAttribute("modesLocation", modeLocationRepository.findAll());
        model.addAttribute("etatsContrat", etatContratRepository.findAll());
        return "contrats";
	}
    
	// get Contrat by id
    @RequestMapping("/contrats/{numContrat}")
	public Contrat getContratById(@PathVariable (value = "numContrat") int numContrat) {
		return contratRepository.findById(numContrat)
				.orElseThrow(()->new ResourceNotFoundException("Contrat not found with num :" + numContrat));
	}
    
    // create Contrat
    @PostMapping("/contrats/create")
	public String createContrat(@Valid @ModelAttribute("contrat")  Contrat contrat){
        //TODO check why itsn't working in html
    	contrat.setEtatContrat(1);
    	contratRepository.save(contrat);
		return "redirect:/contrats"; 
	}

	// update Contrat
    @PostMapping("/contrats/update")
	public String updateContrat(@Valid @ModelAttribute("contrat") Contrat contrat) {
		Contrat existingContrat = contratRepository.findById(contrat.getNumContrat())
			.orElseThrow(() -> new ResourceNotFoundException("Contrat not found with id :" + contrat.getNumContrat()));
		existingContrat.setDatDContrat(contrat.getDatDContrat());
		existingContrat.setDatFContrat(contrat.getDatFContrat());
		existingContrat.setCaution(contrat.getCaution());
		existingContrat.setKmDep(contrat.getKmDep());
		existingContrat.setKmRet(contrat.getKmRet());
		existingContrat.setEtatContrat(contrat.getEtatContrat());
		existingContrat.setNumClient(contrat.getNumClient());
		existingContrat.setVehiculeImmatriculation(contrat.getVehiculeImmatriculation());
		existingContrat.setModeLocation(contrat.getModeLocation());
		contratRepository.save(existingContrat);
		return "redirect:/contrats";  
	}
    
	// delete Contrat by id
    @RequestMapping("/contrats/delete/{numContrat}")
	public String deleteContrat(@PathVariable ("numContrat") int numContrat){
		Contrat existingContrat = contratRepository.findById(numContrat)
					.orElseThrow(() -> new ResourceNotFoundException("Contrat not found with id :" + numContrat));
		contratRepository.delete(existingContrat);
		return "redirect:/contrats"; 
	}
}
