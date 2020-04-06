package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
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
