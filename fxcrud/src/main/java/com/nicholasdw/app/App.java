package com.nicholasdw.app;

// Natural Java Libraries
import java.io.IOException;

// JavaFX Libraries
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

// Model, View, Controller
import com.nicholasdw.model.Person;
import com.nicholasdw.view.*;

/**
 * JavaFX App
 */
public class App extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
    /**
     * The data as an observable list of Persons.
     */
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
    /**
     * Constructor
     */
	public App() {
		// Sample data.
		personData.add(new Person("Nicholas", "Python, Ruby"));
		personData.add(new Person("Attar", "Java, C"));
		personData.add(new Person("Sinzie", "PHP, HTML"));
	}
	
    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
	public ObservableList<Person> getPersonData() {
		return personData;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Programmer Notes");
		
		// Launch everything.
		initializeLayout();
		showOverview();
	}
	
    /**
     * Initializes the root layout.
     */
	public void initializeLayout() {
		try {
			// FXML Loader and casting.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Show the scene.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * Shows the person overview inside the root layout.
     */
	public void showOverview() {
		try {
			// FXML Loader and casting.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("UserInterface.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			
			// Set to center.
			rootLayout.setCenter(personOverview);
			
			// Give controller access to main application.
			PersonOverviewController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Returns the main stage.
     * @return
     */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * Opens a dialog to edit details for the specified person. If the user
	 * clicks OK, the changes are saved into the provided person object and true
	 * is returned.
	 * 
	 * @param person the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showPersonEditDialog(Person person) {
		try {
			// FXML Loader
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("UserInterfaceEditModal.fxml"));
			AnchorPane modal = (AnchorPane) loader.load();
			
			// Dialog Stage
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			
			Scene scene = new Scene(modal);
			dialogStage.setScene(scene);
			
			// Add controller
			PersonEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);
			
			// Show and wait.
			dialogStage.showAndWait();
			
			return controller.isClicked();
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}