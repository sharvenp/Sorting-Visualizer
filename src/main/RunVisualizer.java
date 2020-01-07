package main;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Driving code to make application functional.
 * Sets up MVC.
 * 
 * @author sharvenp
 */
public class RunVisualizer extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		MainPanel mainPanel = new MainPanel(stage);
	}
}
