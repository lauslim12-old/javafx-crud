package application;

// Natural Java Libraries
import java.io.IOException;

// JavaFX Libraries
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

// Model, View, Controller
import model.*;
import view.*;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
	public Main() {
		// Sample data.
		personData.add(new Person("Nicholas", "Python, Ruby"));
		personData.add(new Person("Attar", "Java, C"));
		personData.add(new Person("Sinzie", "PHP, HTML"));
	}
	
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
	
	public void showOverview() {
		try {
			// FXML Loader and casting.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/UserInterface.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			
			// Set to center.
			rootLayout.setCenter(personOverview);
			
			PersonOverviewController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
