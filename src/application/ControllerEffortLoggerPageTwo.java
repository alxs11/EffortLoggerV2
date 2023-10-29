package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControllerEffortLoggerPageTwo {
	
	public ControllerEffortLoggerPageTwo() {
		
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
		m1.changeScene("effortLoggerPageThree.fxml");
	}

	@FXML
	private Button previous;
	
	public void prevPage(ActionEvent event) throws IOException {
		Main m2 = new Main();
		m2.changeScene("effortLoggerConsole.fxml");
	}

}

