package com.abd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.abd.entity.Categorie;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.CategorieRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategorieController {
	
    @Autowired
    private CategorieRepository categorieRepository;
    
	//get all Categories
    @GetMapping
	public List<Categorie> getAllCategories(){
		return categorieRepository.findAll();
	}
    
	// get Categorie by id
    @GetMapping(value ="/{numCat}")
	public Categorie getCategorieById(@PathVariable (value = "numCat") int numCat) {
		return categorieRepository.findById(numCat)
				.orElseThrow(()->new ResourceNotFoundException("Categorie not found with num :" + numCat));
	}
    
    // create Categorie
    @PostMapping
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	// update Categorie
	@PutMapping(value ="/{numCat}")
	public Categorie updateCategorie(@RequestBody Categorie categorie, @PathVariable ("numCat") int numCat) {
		Categorie existingCategorie = categorieRepository.findById(numCat)
			.orElseThrow(() -> new ResourceNotFoundException("Categorie not found with id :" + numCat));
		existingCategorie.setLibCat(categorie.getLibCat());
		 return categorieRepository.save(existingCategorie);
	}
    
	// delete Categorie by id
	@DeleteMapping(value ="/{numCat}")
	public ResponseEntity<Categorie> deleteCategorie(@PathVariable ("numCat") int numCat){
		Categorie existingCategorie = categorieRepository.findById(numCat)
					.orElseThrow(() -> new ResourceNotFoundException("Categorie not found with id :" + numCat));
		categorieRepository.delete(existingCategorie);
		 return ResponseEntity.ok().build();
	}
}
