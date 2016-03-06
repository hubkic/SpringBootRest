package com.application.spring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.application.spring.model.Name;
import com.application.spring.repository.NameJpaRepository;

@SpringApplicationConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class NamePersistenceTests {
	
	@Autowired
	private NameJpaRepository nameJpaRepo;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void testFind() throws Exception{
		Name name = nameJpaRepo.findOne(1l);
		System.out.println("----->"+name.getFirstName()+"\n");
		assertEquals("Stephen",name.getFirstName());
	}
	
	@Test
	@Transactional
	public void testSave() throws Exception{
		Name name = new Name();
		name.setFirstName("Jok");
		name.setLastName("Elo");
		name = nameJpaRepo.saveAndFlush(name);
		System.out.println("----->"+name.getId()+"\n");
		for(Name n:nameJpaRepo.findAll()){
			System.out.println("------>"+n.getFirstName());
		}
		entityManager.clear();
		Name name2 = nameJpaRepo.findOne(name.getId());
		
		assertEquals("Jok",name2.getFirstName());
		nameJpaRepo.delete(name.getId());
	}
	
	@Test
	public void testFindWithLike() throws Exception{
		List<Name> name =  nameJpaRepo.findByFirstNameLike("Ste%");
		assertEquals(1, name.size());
	}
	
	@Test
	public void testFindWithLikeOr() throws Exception{
		List<Name> list = nameJpaRepo.findByFirstNameOrLastName("Connor", "Head");
		assertEquals(2, list.size());
	}
	
	@Test
	public void testGreaterThan() throws Exception{
		List<Name> list = nameJpaRepo.findByIdGreaterThanEqual(2l);
		assertEquals(2, list.size());
	}
	
}
