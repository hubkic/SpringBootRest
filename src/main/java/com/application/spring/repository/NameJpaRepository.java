package com.application.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.application.spring.model.Name;
import com.application.spring.model.projections.NameDetail;

@Repository
@RepositoryRestResource(excerptProjection=NameDetail.class)
public interface NameJpaRepository extends JpaRepository<Name, Long> {

	List<Name> findByFirstNameLike(String string);

	List<Name> findByFirstNameOrLastName(String string1, String string2);
	
	List<Name> findByIdGreaterThanEqual(Long i);
}
