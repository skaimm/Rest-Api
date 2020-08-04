package com.hibernate.jpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.DataAccess.ICityDao;
import com.hibernate.jpa.Entities.City;

@Service
public class CityManager implements ICityService{

	private ICityDao cityDao;
	
	@Autowired
	public CityManager(ICityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	@Transactional
	public List<City> GetAll() {
		return this.cityDao.GetAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		this.cityDao.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDao.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDao.delete(city);
		
	}

	@Override
	public City getById(int id) {
		return this.cityDao.getById(id);
	}

}
