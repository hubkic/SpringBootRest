package com.application.spring.model.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.application.spring.model.City;
import com.application.spring.model.Name;

@Projection(name="nameDetailView", types={Name.class})
public interface NameDetailView {
	@Value("#{target.firstName}")
	String getViewFirstName();
	String getLastName();
	City getCity();
}
