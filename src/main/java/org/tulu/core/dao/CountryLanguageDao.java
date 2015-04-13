package org.tulu.core.dao;

import java.util.List;

import org.tulu.model.Country;
import org.tulu.model.Language;


public interface CountryLanguageDao {

 	public List<Country> getAllCountries();

	public List<Language> getLanguagesByCountry(Long countryId);

	public List<Language> getAllLanguages();
	

}
