package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private final StringProperty name;
	private final StringProperty language;
	
    /**
     * Default constructor.
     */
	public Person() {
		this(null, null);
	}
	
    /**
     * Constructor with some initial data.
     * 
     * @param name
     * @param language
     */
	public Person(String name, String language) {
		this.name = new SimpleStringProperty(name);
		this.language = new SimpleStringProperty(language);
	}
		
	// Getters and setters for name.
	public String getName() {
		return this.name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public String getLanguage() {
		return this.language.get();
	}
	
	public void setLanguage(String language) {
		this.language.set(language);
	}
	
	public StringProperty languageProperty() {
		return language;
	}
	
}
