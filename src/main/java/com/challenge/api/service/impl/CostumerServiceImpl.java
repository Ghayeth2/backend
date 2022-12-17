package com.challenge.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.api.model.Costumer;
import com.challenge.api.repository.CostumerRepository;
import com.challenge.api.service.CostumerService;

@Service
public class CostumerServiceImpl implements CostumerService {
	
	@Autowired CostumerRepository costumerRepository;

	@Override
	public Costumer saveCostumer(Costumer costumer) {
		return costumerRepository.save(costumer);
	}

	@Override
	public List<Costumer> costumers() {
		return costumerRepository.findAll();
	}

	@Override
	public String deleteCostumer(int id) {
		if(costumerRepository.existsById(id)) {
			costumerRepository.deleteById(id);
			return "Costumer with "+id+" has been deleted";
		}else {
			return "Error, no costumer with {"+id+"} id.";
		}
	}

	@Override
	public Costumer updateCostumer(int id, Costumer costumer) {
		Costumer costumer1 = null;
		if(costumerRepository.existsById(id)) {
			costumer1 = costumerRepository.findById(id).get();
			costumer1.setId(id);
			costumer1.setEmail(costumer.getEmail());
			costumer1.setPassword(costumer.getPassword());
			costumer1.setAddresses(costumer.getAddresses());
		}else {
			try {
				throw new Exception("No such costumer with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return costumerRepository.save(costumer1);	
	}

}
