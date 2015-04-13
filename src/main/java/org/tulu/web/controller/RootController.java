/**
 * 
 */
package org.tulu.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tulu.core.services.CountryLanguageService;
import org.tulu.model.Country;
import org.tulu.model.Language;

/**
 * @author Jagannath
 *
 */
@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	CountryLanguageService countryLanguageService;

	static{
		System.out.println("class loaded..");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model){
		System.out.println("GET came to /");
		
		List<Country> countryList = countryLanguageService.getAllCountries();
		model.addAttribute("countryList", countryList);
		return "homepage";
	}
	
	@RequestMapping(value="/get-languages-by-country-id", method=RequestMethod.POST)
	public @ResponseBody List<Language> getLnaguagesByCountryId(Model model, @RequestParam(value="countryId")Long countryId){
		System.out.println("POST came to get languages");
		List<Language> languageList = countryLanguageService.getLanguagesByCountry(countryId);
		System.out.println("languageList: "+languageList.size());
		return languageList;
	}
	
	@RequestMapping(value="/get-all-languages", method=RequestMethod.GET)
	public String getAllLanguage(Model model){
		List<Language> allLanguages = countryLanguageService.getAllLanguages();
		model.addAttribute("allLanguages", allLanguages);
		return "languagepage";
	}
}
