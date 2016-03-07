package com.application.spring.model.projections;

import org.springframework.data.rest.core.config.Projection;

import com.application.spring.model.City;

@Projection(name="cityDetail", types={City.class})
public interface CityDetail {
	String getName();
}
