package com.abd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abd.entity.*;
import com.abd.repository.*;

@SpringBootApplication
public class AgencesLocationVoituresApplication implements CommandLineRunner{

	@Autowired
	private ModeleRepository modeleRepository;
	
	@Autowired
	private AgenceRepository agenceRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Autowired
	private ContratRepository contratRepository;
	
	@Autowired
	private EtatContratRepository etatcontratRepository; 
	
	@Autowired
	private ModeLocationRepository modeLocationRepository;
	
	
	@Autowired
	private PaysRepository paysRepository;
	
	@Autowired
	private TarifsRepository tarifsRepository;
	
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	@Autowired
	private VilleRepository villeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgencesLocationVoituresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Modele> models = modeleRepository.findAll();
//		models.forEach(System.out :: println);
//		
//		List<Agence> agences = agenceRepository.findAll();
//		agences.forEach(System.out :: println);
//		
//		List<Categorie> categories = categorieRepository.findAll();
//		categories.forEach(System.out :: println);		
//		List<Contrat> contarts = contratRepository.findAll();
//		contarts.forEach(System.out :: println);
//		List<EtatContrat> etatcontarts = etatcontratRepository.findAll();
//		etatcontarts.forEach(System.out :: println);
//		List<ModeLocation> modelocation = modeLocationRepository.findAll();
//		modelocation.forEach(System.out :: println);
		
//		List<Pays> pays = paysRepository.findAll();
//		pays.forEach(System.out :: println);
		
//		List<Tarifs> tarifs =tarifsRepository.findAll();
//		tarifs.forEach(System.out :: println);
		
//		List<Type> tyoes =typeRepository.findAll();
//		tyoes.forEach(System.out :: println);
		
//		List<Vehicule> vehicule =vehiculeRepository.findAll();
//		vehicule.forEach(System.out :: println);
		
//		List<Ville> villes =villeRepository.findAll();
//		villes.forEach(System.out :: println);
	} 
}
