package org.tulu.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tulu.model.Country;
import org.tulu.model.Language;


@Repository
public class CountryLanguageDaiImpl implements CountryLanguageDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Transactional
	public List<Country> getAllCountries() {
		
		String hql = "from Country";
		Query query = getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Country> countryList =query.list();  
		System.out.println("===========================");
		System.out.println(countryList.toString());
		return countryList;
	}


	@SuppressWarnings("unchecked")
	@Transactional	
	@Override
	public List<Language> getLanguagesByCountry(Long countryId) {
		return getCurrentSession().createCriteria(Language.class).add(Restrictions.eq("country.id", countryId)).list();
	}


	@Transactional
	@Override
	public List<Language> getAllLanguages() {
		String hql = "from Language";
		Query query = getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Language> languageList =query.list();
		System.out.println(languageList.toString());
		return languageList;
	}

}
