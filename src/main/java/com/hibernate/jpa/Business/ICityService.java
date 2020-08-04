package com.hibernate.jpa.Business;

import java.util.List;

import com.hibernate.jpa.Entities.City;

public interface ICityService {

	List<City> GetAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
}
