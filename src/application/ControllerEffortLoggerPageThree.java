package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControllerEffortLoggerPageThree {
	
	public ControllerEffortLoggerPageThree() {
		
	}

	@FXML
	private Button logout;
	
	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}


	@FXML
	private Button previous;
	
	public void prevPage(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerPageTwo.fxml");
	}
}
