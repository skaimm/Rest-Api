package com.hibernate.jpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.Entities.City;

// JPA STANDART 
@Repository
public class HibCityDao implements ICityDao{

	private EntityManager entityManager;
	
	@Autowired
	public HibCityDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<City> GetAll() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		
		return cities;
	}

	@Override
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.save(city);
		
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City deleteCity = session.get(City.class, city.getId());
		session.delete(city);
		
	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, id);
		return city;
	}
	
	

}
