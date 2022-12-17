package com.challenge.api.service;

import java.util.List;

import com.challenge.api.model.Address;

public interface AddressService {
	public Address saveAddress(Address address);
	public List<Address> addresses();
	public String deleteAddress(int id);
	public Address updateAddress(int id, Address address);
}
