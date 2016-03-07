package com.application.spring.model.projections;

import org.springframework.data.rest.core.config.Projection;

import com.application.spring.model.City;
import com.application.spring.model.Name;

@Projection(name="nameDetail", types={Name.class})
public interface NameDetail {
	String getFirstName();
	String getLastName();
	City getCity();
}
