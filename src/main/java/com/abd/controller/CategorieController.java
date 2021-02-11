package com.abd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.abd.entity.Agence;
import com.abd.entity.Categorie;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.CategorieRepository;

@Controller
@RequestMapping(value = "/categories")
public class CategorieController {
	
    @Autowired
    private CategorieRepository categorieRepository;
    
	//get all Categories
    @RequestMapping(value = "/")
	public String getAllCategories(Model model){
        List<Categorie> categories = categorieRepository.findAll();
        model.addAttribute("Categories", categories);       
        return "categories";
	}
    
	// get Categorie by id
    @RequestMapping(value ="/{numCat}")
	public Categorie getCategorieById(@PathVariable (value = "numCat") int numCat) {
		return categorieRepository.findById(numCat)
				.orElseThrow(()->new ResourceNotFoundException("Categorie not found with num :" + numCat));
	}
    
    // create Categorie
    @RequestMapping(value ="/create")
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	// update Categorie
    @RequestMapping(value ="/update/{numCat}")
	public Categorie updateCategorie(@RequestBody Categorie categorie, @PathVariable ("numCat") int numCat) {
		Categorie existingCategorie = categorieRepository.findById(numCat)
			.orElseThrow(() -> new ResourceNotFoundException("Categorie not found with id :" + numCat));
		existingCategorie.setLibCat(categorie.getLibCat());
		 return categorieRepository.save(existingCategorie);
	}
    
	// delete Categorie by id
    @RequestMapping(value ="/delete/{numCat}")
	public ResponseEntity<Categorie> deleteCategorie(@PathVariable ("numCat") int numCat){
		Categorie existingCategorie = categorieRepository.findById(numCat)
					.orElseThrow(() -> new ResourceNotFoundException("Categorie not found with id :" + numCat));
		categorieRepository.delete(existingCategorie);
		 return ResponseEntity.ok().build();
	}
}
