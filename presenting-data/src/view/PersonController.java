package view;

import model.*;
import application.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonController {
	@FXML
	private TableView<Person> personTable;
	
	@FXML
	private TableColumn<Person, String> nameColumn;
	
	@FXML
	private TableColumn<Person, String> languageColumn;
	
	@FXML
	private TableView<Person> allNameTable;
	
	@FXML
	private TableView<Person> allLangTable;
	
	@FXML
	private TableColumn<Person, String> allNameColumn;
	
	@FXML
	private TableColumn<Person, String> allLangColumn;
	
	@FXML
	private ListView<String> websiteList;
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label languageLabel;
		
	// Reference to main
	private Main main;
	
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
	public PersonController() {}
	
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	@FXML
	private void initialize() {
		// Leftmost table.
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		languageColumn.setCellValueFactory(cellData -> cellData.getValue().languageProperty());
		
		// Table with tabs.
		allNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		allLangColumn.setCellValueFactory(e -> e.getValue().languageProperty());
		
		// List
		// No need to add anything because it's a String. Automatically parsed by the Java.
		// If you need to pass an object to ListViews, then parse it by overriding the updateItems() function.
		
		// Clear person details first.
		showPersonDetails(null);
		
		// Listen for any changes.
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(newValue));
	}
	
	/**
	 * Fills all text fields to show details about the person.
	 * If the specified person is null, all text fields are cleared.
	 * 
	 * @param person the person or null
	 */
	private void showPersonDetails(Person person) {
		if(person != null) {
			nameLabel.setText(person.getName());
			languageLabel.setText(person.getLanguage());
		}
		else {
			nameLabel.setText("");
			languageLabel.setText("");
		}
	}
	
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param Main
     */
	public void setMainApp(Main main) {
		this.main = main;
		
		personTable.setItems(main.getPersonData());
		allNameTable.setItems(main.getPersonData());
		allLangTable.setItems(main.getPersonData());
		websiteList.setItems(main.getWebsiteData());
	}
}
