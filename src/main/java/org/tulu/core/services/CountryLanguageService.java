package org.tulu.core.services;

import java.util.List;

import org.tulu.model.Country;
import org.tulu.model.Language;

public interface CountryLanguageService {
	
	public List<Country> getAllCountries();

	public List<Language> getLanguagesByCountry(Long countryId);

	public List<Language> getAllLanguages();

}
