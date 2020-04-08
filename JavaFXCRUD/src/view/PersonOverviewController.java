package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	
	// Reference to main
	private Main main;
	
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
	public PersonOverviewController() {}
	
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
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
	
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		int index = personTable.getSelectionModel().getSelectedIndex();
		
		if(index >= 0) {
			personTable.getItems().remove(index);
		}
		else {
			// If user selects nothing.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(main.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected!");
			alert.setContentText("Please select a person in the table!");
			alert.showAndWait();
		}
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewPerson() {
		Person temp = new Person();
		boolean okClicked = main.showPersonEditDialog(temp);
		
		if(okClicked) {
			main.getPersonData().add(temp);
		}
	}
	
	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditPerson() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		
		if(selectedPerson != null) {
			boolean okClicked = main.showPersonEditDialog(selectedPerson);
			
			if(okClicked) {
				showPersonDetails(selectedPerson);
			}
		}
		else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(main.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table!");
			alert.showAndWait();
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
	}
	

}
