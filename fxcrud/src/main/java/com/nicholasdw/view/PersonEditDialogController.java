package com.nicholasdw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.nicholasdw.model.Person;

/**
 * Dialog to edit details of a person.
 * 
 * @author Nicholas Dwiarto
 */
public class PersonEditDialogController {
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField languageField;
	
	@FXML
	private TextField ideField;
	
	private Stage dialogStage;
	private Person person;
	private boolean hasClicked = false;
	
	@FXML
	private void initialize() {}
	
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Person person) {
    	this.person = person;
    	
    	nameField.setText(person.getName());
    	languageField.setText(person.getLanguage());
    	ideField.setText(person.getIde());
    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isClicked() {
        return hasClicked;
    }
    
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
    	String errorMessage = "";
    	
    	if(nameField.getText() == null || nameField.getText().length() == 0) {
    		errorMessage += "No valid name!";
    	}
    	
    	if(languageField.getText() == null || languageField.getText().length() == 0) {
    		errorMessage += "No valid language!";
    	}
    	
    	if(ideField.getText() == null || ideField.getText().length() == 0) {
    		errorMessage += "No valid IDE!";
    	}
    	
    	if(errorMessage.length() == 0) {
    		return true;
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.initOwner(dialogStage);
    		alert.setTitle("Invalid Fields");
    		alert.setHeaderText("Please correct invalid fields!");
    		alert.setContentText(errorMessage);
    		alert.showAndWait();
    		
    		return false;
    	}
    }
    
    
    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
    	if(isInputValid()) {
        	person.setName(nameField.getText());
        	person.setLanguage(languageField.getText());
        	person.setIde(ideField.getText());
        	
        	hasClicked = true;
        	dialogStage.close();
    	}
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
    	dialogStage.close();
    }
    
	
}
