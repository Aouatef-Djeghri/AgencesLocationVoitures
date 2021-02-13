package com.abd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.abd.entity.Type;
import com.abd.exception.ResourceNotFoundException;
import com.abd.repository.TypeRepository;

@Controller
@RequestMapping(value = "/types")
public class TypeController {
	
    @Autowired
    private TypeRepository typeRepository;
    
	//get all Types
    @GetMapping
	public List<Type> getAllTypes(){
		return typeRepository.findAll();
	}
    
	// get Type by id
    @GetMapping(value = "/{numType}")
	public Type getTypeById(@PathVariable (value = "numType") int numType) {
		return typeRepository.findById(numType)
				.orElseThrow(()->new ResourceNotFoundException("Type not found with num :" + numType));
	}
    
    // create Type
    @PostMapping
	public Type createType(@RequestBody Type type) {
		return typeRepository.save(type);
	}

	// update Type
	@PutMapping(value = "/{numType}")
	public Type updateType(@RequestBody Type type, @PathVariable ("numType") int numType) {
		Type existingType = typeRepository.findById(numType)
			.orElseThrow(() -> new ResourceNotFoundException("Type not found with id :" + numType));
		existingType.setLibType(type.getLibType());
		 return typeRepository.save(existingType);
	}
    
	// delete Type by id
	@DeleteMapping(value = "/{numType}")
	public ResponseEntity<Type> deleteType(@PathVariable ("numType") int numType){
		Type existingType = typeRepository.findById(numType)
					.orElseThrow(() -> new ResourceNotFoundException("Type not found with id :" + numType));
		typeRepository.delete(existingType);
		 return ResponseEntity.ok().build();
	}
}
