/**
 * 
 */
package org.tulu.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Jagannath
 *
 */
@Entity
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private Long id;
	
	private String countryName;
	
	@OneToMany(mappedBy="country")
	private List<Language> languageList;
	
	public Country(){}

	public Country(String name) {
		this.countryName = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Language> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<Language> languageList) {
		this.languageList = languageList;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [id=");
		builder.append(id);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append(", languageList=");
		builder.append(languageList);
		builder.append("]");
		return builder.toString();
	}

	
}
