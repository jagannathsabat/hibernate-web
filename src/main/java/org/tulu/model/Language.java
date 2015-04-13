/**
 * 
 */
package org.tulu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Jagannath
 *
 */
@Entity
public class Language implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String languageName;
	
	@JsonIgnore
	@ManyToOne
	private Country country;
	
	public Language(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Language [id=");
		builder.append(id);
		builder.append(", languageName=");
		builder.append(languageName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
