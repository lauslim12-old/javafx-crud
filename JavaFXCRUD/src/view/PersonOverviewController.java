package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import application.Main;
import model.Person;

public class PersonOverviewController {
	
	@FXML
	private TableView<Person> personTable;
	
	@FXML
	private TableColumn<Person, String> nameColumn;
	
	@FXML
	private TableColumn<Person, String> languageColumn;
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label languageLabel;
	
	@FXML
	private Label ideLabel;
	
	private Main main;
	
	public PersonOverviewController() {}
	
	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		languageColumn.setCellValueFactory(cellData -> cellData.getValue().languageProperty());
		
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
			ideLabel.setText(person.getIde());
		}
		else {
			nameLabel.setText("");
			languageLabel.setText("");
			ideLabel.setText("");
		}

	}
	
	public void setMainApp(Main main) {
		this.main = main;
		
		personTable.setItems(main.getPersonData());
	}
	

}
