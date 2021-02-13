package com.abd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abd.repository.AgenceRepository;
import com.abd.repository.CategorieRepository;
import com.abd.repository.ClientRepository;
import com.abd.repository.ContratRepository;
import com.abd.repository.EtatContratRepository;
import com.abd.repository.VehiculeRepository;


@Controller("/")
public class HomePageController {

    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private AgenceRepository agenceRepository;
    @Autowired
    private EtatContratRepository etatsContratRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    
    private int nbrContrat = 0;
    private String etatContratLabel = null;
    private int nbrVehicule = 0;
    private String categorieLabel = null;
    
    @RequestMapping("/")
    public String index(Model model) {    
        model.addAttribute("VehiculesCount", vehiculeRepository.findAll().size());
        model.addAttribute("ClientsCount", clientRepository.findAll().size()); 
        model.addAttribute("ContratsCount", contratRepository.findAll().size());
        model.addAttribute("AgencesCount", agenceRepository.findAll().size()); 
        model.addAttribute("EtatsContrat", etatsContratRepository.findAll()); 
        model.addAttribute("Categories", categorieRepository.findAll());  
        model.addAttribute("NbrContrat", nbrContrat); 
        model.addAttribute("EtatContratLabel", etatContratLabel); 
        model.addAttribute("NbrVehicule", nbrVehicule); 
        model.addAttribute("CategorieLabel", categorieLabel); 
        return "index";
    }
    
    @RequestMapping("/libEtatContrat")
    public String getNbrContrat(@RequestParam("libEtatContrat") String libEtatContrat,Model model) {    
    	etatContratLabel= libEtatContrat;
    	nbrContrat = contratRepository.getNbrContractWithState(libEtatContrat);
        return "redirect:/"; 	
    }
    
    @RequestMapping("/libCategorie")
    public String getNbrVehicule(@RequestParam("libCategorie") String libCategorie,Model model) {    
        nbrVehicule = vehiculeRepository.getNbrVehiculeWithCategory(libCategorie);
        categorieLabel = libCategorie;
        return "redirect:/"; 	
    }
    
}
