package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Nicholas Dwiarto
 */
public class Person {
	private final StringProperty name;
	private final StringProperty language;
	private final IntegerProperty id;
	private final StringProperty ide;
	
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
		
		// Sample data
		this.id = new SimpleIntegerProperty(1);
		this.ide = new SimpleStringProperty("Visual Studio Code");
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
	
	// Getters and setters for ID.
	public int getId() {
		return this.id.get();
	}
	
	public void setId(int id) {
		this.id.set(id);
	}
	
	public IntegerProperty idProperty() {
		return id;
	}
	
	// Getters and setters for Language.
	public String getLanguage() {
		return this.language.get();
	}
	
	public void setLanguage(String language) {
		this.language.set(language);
	}
	
	public StringProperty languageProperty() {
		return language;
	}
	
	// Getters and setters for IDE.
	public String getIde() {
		return this.ide.get();
	}
	
	public void setIde(String ide) {
		this.ide.set(ide);
	}
	
	public StringProperty ideProperty() {
		return ide;
	}
	
}
