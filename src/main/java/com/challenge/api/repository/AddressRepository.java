package com.challenge.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.api.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
