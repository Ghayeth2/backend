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

import com.challenge.api.model.Address;
import com.challenge.api.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired private AddressService addressService;
	
	@PostMapping("/new")
	public ResponseEntity<Address> save(@RequestBody Address address){
		return new ResponseEntity<Address>(addressService.saveAddress(address), HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Address>> costumers(){
		return new ResponseEntity<List<Address>>(addressService.addresses(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam("id") int id){
		return new ResponseEntity<String>(addressService.deleteAddress(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Address> update(@RequestParam("id") int id, @RequestBody Address address){
		return new ResponseEntity<Address>(addressService.updateAddress(id, address), HttpStatus.OK);
	}
}
