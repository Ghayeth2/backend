package com.challenge.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.api.model.Costumer;

public interface CostumerRepository extends JpaRepository<Costumer, Integer> {

}
