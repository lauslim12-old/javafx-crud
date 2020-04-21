package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

// Model, View, Controller
import model.*;
import view.*;

public class Main extends Application {
	// Variables
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
    /**
     * The data as an observable list of Persons.
     */
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	private ObservableList<String> websiteData = FXCollections.observableArrayList();
	
    /**
     * Constructor
     */
	public Main() {
		// Sample data.
		personData.add(new Person("Nicholas", "Node.js"));
		personData.add(new Person("Attar", "Python"));
		personData.add(new Person("Sinzie", "HTML"));
		personData.add(new Person("Sebastian", "SQL"));
		
		websiteData.add("https://www.linkedin.com/in/nicholasdwiarto/");
		websiteData.add("https://github.com/lauslim12");
		websiteData.add("https://www.nicholasdw.com");
		websiteData.add("https://www.nicholasdw.com/Intract");
		websiteData.add("https://www.nicholasdw.com/nodefarm");
	}
	
    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
	public ObservableList<Person> getPersonData() {
		return personData;
	}
	
    /**
     * Returns the data as an observable list of Nicholas websites. 
     * @return
     */
	public ObservableList<String> getWebsiteData() {
		return websiteData;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("A Showcase Application");
		
		// Add some icons.
		this.primaryStage.getIcons().add(new Image("file:src/view/favicon.png"));
		
		// Launch everything.
		initializeLayout();
		showOverview();
	}
	
	public void initializeLayout() {
		try {
			// FXML Loader and casting.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
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
			loader.setLocation(Main.class.getResource("/view/UserInterface.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			
			// Set to center.
			rootLayout.setCenter(personOverview);
			
			// Give controller access to main application.
			PersonController controller = loader.getController();
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
