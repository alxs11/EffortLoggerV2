// console functionality by Jake
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControllerEffortLoggerConsole {
	
	public ControllerEffortLoggerConsole() {
		
	}
	
	@FXML
	private Button newActivity;
	
	public void newActivity(ActionEvent event) throws IOException {
		
	}
	
	@FXML
	private Button stopActivity;
	
	public void stopActivity(ActionEvent event) throws IOException {
		
	}

	@FXML
	private Button logout;
	
	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	
	@FXML
	private Button next;
	
	public void nextPage(ActionEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerPageTwo.fxml");
	}

}
