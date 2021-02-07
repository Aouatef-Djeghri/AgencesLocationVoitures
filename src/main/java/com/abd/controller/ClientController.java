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

import com.abd.entity.Client;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.ClientRepository;
@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	 @Autowired
	    private ClientRepository clientRepository;
	    
		//get all Clients
	    @GetMapping
		public List<Client> getAllClients(){
			return clientRepository.findAll();
		}
	    
		// get Client by id
	    @GetMapping(value = "/{numCli}")
		public Client getClientById(@PathVariable (value = "numCli") int numCli) {
			return clientRepository.findById(numCli)
					.orElseThrow(()->new ResourceNotFoundException("Client not found with num :" + numCli));
		}
	    
	    // create Client
	    @PostMapping
		public Client createClient(@RequestBody Client client) {
			return clientRepository.save(client);
		}

		// update Client
		@PutMapping(value = "/{numCli}")
		public Client updateClient(@RequestBody Client client, @PathVariable ("numCli") int numCli) {
			Client existingClient = clientRepository.findById(numCli)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + numCli));
			existingClient.setNomCli(client.getNomCli());
			existingClient.setPrenomCli(client.getPrenomCli());
			existingClient.setNumPermis(client.getNumPermis());
			existingClient.setAdresseCli(client.getAdresseCli());
			existingClient.setTelCli(client.getTelCli());
			existingClient.setVilleCli(client.getVilleCli());
			 return clientRepository.save(existingClient);
		}
	    
		// delete Client by id
		@DeleteMapping(value = "/{numCli}")
		public ResponseEntity<Client> deleteClient(@PathVariable ("numCli") int numCli){
			Client existingClient = clientRepository.findById(numCli)
						.orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + numCli));
			clientRepository.delete(existingClient);
			 return ResponseEntity.ok().build();
		}
}
