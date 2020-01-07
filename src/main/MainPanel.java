package main;

import controllers.SortButtonHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPanel extends GridPane {

	private CanvasPanel canvasPanel;
	private SortingModel model;
	
	private Stage stage;
	
	public MainPanel(Stage stage, SortingModel model) {
		
		this.stage = stage;
		this.model = model;
		
		this.setPadding(new Insets(16));
		this.setVgap(16);

		canvasPanel = new CanvasPanel();
		this.model.addObserver(canvasPanel);
		this.add(canvasPanel, 0, 0);
		
		VBox UIElements = this.makeUIElements();
		this.add(UIElements, 1, 0);
		
		Scene scene = new Scene(this);
		this.stage.setScene(scene);
		this.stage.setTitle("Sorting Visualizer");
		
		this.stage.setResizable(false);
		stage.show();
	}
	
	private VBox makeUIElements() {
		
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(16));
		vBox.setSpacing(25);
		vBox.setAlignment(Pos.CENTER);
		
		HBox sortingAlgorithmHBox = new HBox();
		sortingAlgorithmHBox.setSpacing(5);
		Label sortingAlgorithmLabel = new Label("Sorting Algorithm:");
		ComboBox<String> sortingAlgorithmComboBox = new ComboBox<>();
		for (String s : Settings.algorithms) {
			sortingAlgorithmComboBox.getItems().add(s);
		}
		sortingAlgorithmComboBox.getSelectionModel().selectFirst();
		sortingAlgorithmHBox.getChildren().addAll(sortingAlgorithmLabel, sortingAlgorithmComboBox);
		
		
		HBox arraySizeHBox = new HBox();
		arraySizeHBox.setSpacing(5);
		Label arraySizeLabel = new Label("Array Size:");
		final TextField arraySizeInput = new TextField();
		arraySizeInput.setPrefWidth(100);
		arraySizeInput.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		        	arraySizeInput.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		arraySizeHBox.getChildren().addAll(arraySizeLabel, arraySizeInput);
		
		
		HBox delayHBox = new HBox();
		arraySizeHBox.setSpacing(5);
		Label delayLabel = new Label("Step Delay:");
		final TextField delayInput = new TextField();
		delayInput.setPrefWidth(100);
		delayInput.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		        	delayInput.setText(newValue.replaceAll("[^\\d\\.]", ""));
		        }
		    }
		});
		delayHBox.getChildren().addAll(delayLabel, delayInput);
		
		Button sortButton = new Button("Sort");
		sortButton.setOnAction(new SortButtonHandler());
		
		
		vBox.getChildren().addAll(sortingAlgorithmHBox, arraySizeHBox, delayHBox);
		
		return vBox;
		
	}
	
}
