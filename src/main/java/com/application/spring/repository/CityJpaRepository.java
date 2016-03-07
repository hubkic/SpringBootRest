package com.application.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.spring.model.City;

public interface CityJpaRepository extends JpaRepository<City, Long>{
	
	List<City> findByName(String name);

}
