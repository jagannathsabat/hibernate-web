package org.tulu.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tulu.core.dao.CountryLanguageDao;
import org.tulu.model.Country;
import org.tulu.model.Language;

@Service
public class CountryLanguageServiceImpl implements CountryLanguageService {
	
	@Autowired
	CountryLanguageDao countryLanguageDao;

	public List<Country> getAllCountries() {
		
		List<Country> countryList = countryLanguageDao.getAllCountries();
		return countryList;
	}

	@Override
	public List<Language> getLanguagesByCountry(Long countryId) {
		return countryLanguageDao.getLanguagesByCountry(countryId);
	}

	@Override
	public List<Language> getAllLanguages() {
		List<Language> languageList = countryLanguageDao.getAllLanguages();
		return languageList;
	}

}
