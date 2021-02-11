package com.abd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abd.entity.Client;
import com.abd.entity.Ville;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.ClientRepository;
import com.abd.repository.VilleRepository;


@Controller
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
    @Autowired
    private VilleRepository villeRepository;
   
    
	//get all Clients
    @RequestMapping(value = "/clients")
	public String getAllClients(Model model){
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("Clients", clients);      
        model.addAttribute("client", new Client());
        model.addAttribute("uneville", new Ville());
        model.addAttribute("villes", villeRepository.findAll());
        return "clients";
	}
    
	// get Client by id
    @RequestMapping(value = "/clients/{numCli}")
	public Client getClientById(@PathVariable (value = "numCli") int numCli) {
		return clientRepository.findById(numCli)
				.orElseThrow(()->new ResourceNotFoundException("Client not found with num :" + numCli));
	}
    
    // create Client
    @PostMapping(value = "/clients/create")
	public String createClient(@Valid @ModelAttribute("client") Client client) { //,BindingResult bindingResult//if (!bindingResult.hasErrors()) {}
    	clientRepository.save(client);	
	    return "redirect:/clients"; 	
	}
   

	// update Client
    @PostMapping(value = "/clients/update")
	public String updateClient(@Valid @ModelAttribute("client")  Client client) {
		Client existingClient = clientRepository.findById(client.getNumCli())
			.orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + client.getNumCli()));
		existingClient.setNomCli(client.getNomCli());
		existingClient.setPrenomCli(client.getPrenomCli());
		existingClient.setNumPermis(client.getNumPermis());
		existingClient.setAdresseCli(client.getAdresseCli());
		existingClient.setTelCli(client.getTelCli());
		existingClient.setVilleCli(client.getVilleCli());
	    clientRepository.save(existingClient);
		return "redirect:/clients"; 
	}
    
    
	// delete Client by id
    @RequestMapping(value = "/clients/delete/{numCli}")
	public String deleteClient(@PathVariable ("numCli") int numCli){
		Client existingClient = clientRepository.findById(numCli)
					.orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + numCli));
		clientRepository.delete(existingClient);
	    return "redirect:/clients";
	}
}

