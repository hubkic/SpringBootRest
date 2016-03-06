package com.application.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.spring.model.Name;


@Repository
public class NameRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private NameJpaRepository nameJpaRepo;
	
	/**
	 * Create
	 */
	public Name create(Name user) {
		return nameJpaRepo.saveAndFlush(user);
	}
	
	public Name update(Name user){
		return nameJpaRepo.saveAndFlush(user);
	}
	
	public Name find(Long id){
		return nameJpaRepo.findOne(id);
	}
	
	public List<Name> getNameByFirstName(String firstName) {
		@SuppressWarnings("unchecked")
		List<Name> list =entityManager
				.createQuery("select n from Name n where n.firstName like :state")
				.setParameter("state", firstName + "%").getResultList();
		
		return list;
	}
	
	
	
}
