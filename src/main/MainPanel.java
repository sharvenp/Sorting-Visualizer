package main;

import controllers.GenerateButtonHandler;
import controllers.SortButtonHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import stratergies.CurrentSortStratergy;

public class MainPanel extends GridPane {

	private CanvasPanel canvasPanel;
	
	private Stage stage;
	
	public MainPanel(Stage stage) {
		
		this.stage = stage;
		
		this.setPadding(new Insets(16));
		this.setVgap(16);
		
		this.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		canvasPanel = new CanvasPanel();
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
		final TextField arraySizeInput = new TextField("100");
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
		delayHBox.setSpacing(5);
		Label delayLabel = new Label("Step Delay:");
		Slider delaySlider = new Slider(1, 1000, 1);
		delaySlider.setShowTickMarks(true);
		delaySlider.setMajorTickUnit(10);
		delaySlider.setMinorTickCount(0);
		Label delayValue = new Label("1");
		delayValue.setPrefWidth(40);
		delaySlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                Number oldVal, Number newVal) {
	            	long val = newVal.longValue() * 10;
	            	delaySlider.setValue(val);
	            	delayValue.setText(Long.toString(val));
	            	if (CurrentSortStratergy.getInstance().getCurrentStratergy() != null)
	            		CurrentSortStratergy.getInstance().getCurrentStratergy().setDelay(val);
	            }
        	});
		delayHBox.getChildren().addAll(delayLabel, delaySlider, delayValue);
		
		
		HBox buttonHBox = new HBox();
		buttonHBox.setSpacing(5);
		buttonHBox.setAlignment(Pos.CENTER);
		Button generateButton = new Button("Generate Array");
		generateButton.setOnAction(new GenerateButtonHandler(this.canvasPanel, sortingAlgorithmComboBox, arraySizeInput));
		Button sortButton = new Button("Sort");
		sortButton.setOnAction(new SortButtonHandler(this.canvasPanel, sortingAlgorithmComboBox, arraySizeInput, delaySlider));
		buttonHBox.getChildren().addAll(generateButton, sortButton);
		
		vBox.getChildren().addAll(sortingAlgorithmHBox, arraySizeHBox, delayHBox, buttonHBox);
		
		return vBox;
		
	}
	
}
