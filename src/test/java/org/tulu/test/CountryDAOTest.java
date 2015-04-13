/**
 * 
 */
package org.tulu.test;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.tulu.model.Country;

/**
 * @author Jagannath
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration(defaultRollback=false)
public class CountryDAOTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*@Test
	@Transactional
	public void testSaveCountry(){
		Session session = sessionFactory.getCurrentSession();
		Country cnt = new Country("India");
		Long cntId = (Long) session.save(cnt);	
		System.out.println("cntId: "+cntId);
		Assert.assertNotNull(cntId);		
	}*/
	
	@Test
	@Transactional
	public void testCountry(){
		Session session = sessionFactory.getCurrentSession();
		Criteria crt = session.createCriteria(Country.class);
		List<Country> countryList = crt.list();
		Assert.assertEquals(1, countryList.size());
	}
}
