package com.challenge.api.service;

import java.util.List;

import com.challenge.api.model.Costumer;

public interface CostumerService {
	public Costumer saveCostumer(Costumer costumer);
	public List<Costumer> costumers();
	public String deleteCostumer(int id);
	public Costumer updateCostumer(int id, Costumer costumer);
}
