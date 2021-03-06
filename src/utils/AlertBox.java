package utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Display an pop up dialogue box to notify the user.
 * 
 * Built on top of the JavaFX Alert class to make easier use.
 * 
 * @author sharvenp
 *
 */
public class AlertBox {

	public static void showAlert(String title, String header, String context, AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(context);

		alert.showAndWait();
	}
	
	public static AlertType errorType() {
		return AlertType.ERROR;
	}
	
	public static AlertType cautionType() {
		return AlertType.WARNING;
	}
	
	public static AlertType informationType() {
		return AlertType.INFORMATION;
	}
}
