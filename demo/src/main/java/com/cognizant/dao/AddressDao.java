package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Address;

public interface AddressDao {

	public int create(Address address);
	public List<Address> findAll();
}
