package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Address address) {
		String query = "insert into Address values(?,?)";
		return jdbcTemplate.update(query, new Object[] { address.getHouseNo(), address.getCity() });
	}

	@Override
	public List<Address> findAll() {
		String query = "select * from Address";
		return jdbcTemplate.query(query, (rs, rowNum) -> new Address(rs.getString(1), rs.getString(2)));
	}
}
