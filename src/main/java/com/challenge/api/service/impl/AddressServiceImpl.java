package com.challenge.api.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.challenge.api.model.Address;
import com.challenge.api.model.Costumer;
import com.challenge.api.repository.AddressRepository;
import com.challenge.api.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired private AddressRepository addressRepository;
	
	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> addresses() {
		return addressRepository.findAll();
	}

	@Override
	public String deleteAddress(int id) {
		if(addressRepository.existsById(id)) {
			addressRepository.deleteById(id);
			return "The address with the given {"+id+"} id has been deleted.";
		}else {
			return "Bad input!! no address with the giving id is existed.";
		}
		
	}

	@Override
	public Address updateAddress(int id, Address address) {
		Address address1 = null;
		if(addressRepository.existsById(id)) {
			address1 = addressRepository.findById(id).get();
			address1.setId(id);
			address1.setName(address.getName());
			address1.setCity(address.getCity());
			address1.setDistrict(address.getDistrict());
			address1.setCostumer(address.getCostumer());
		}else {
			try {
				throw new Exception("No such address with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return addressRepository.save(address1);
	}
	
}
