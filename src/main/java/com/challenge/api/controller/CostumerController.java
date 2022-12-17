package com.challenge.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.api.model.Costumer;
import com.challenge.api.service.CostumerService;


@RestController
@RequestMapping("/costumer")
public class CostumerController {
	
	@Autowired private CostumerService costumerService;
	
	@PostMapping("/new")
	public ResponseEntity<Costumer> save(@RequestBody Costumer costumer){
		return new ResponseEntity<Costumer>(costumerService.saveCostumer(costumer), HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Costumer>> costumers(){
		return new ResponseEntity<List<Costumer>>(costumerService.costumers(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam("id") int id){
		return new ResponseEntity<String>(costumerService.deleteCostumer(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Costumer> update(@RequestParam("id") int id, @RequestBody Costumer costumer){
		return new ResponseEntity<Costumer>(costumerService.updateCostumer(id, costumer), HttpStatus.OK);
	}
	
}
