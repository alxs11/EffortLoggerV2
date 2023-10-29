package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerEffortLoggerScore {
	
	public ControllerEffortLoggerScore() {
	}

	@FXML private Button logout;
	@FXML private Button next;
	@FXML private Button previous;
	@FXML private Button tryAgain;
	@FXML private Text score;
	@FXML private Text round;

	
	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	public void nextPage(ActionEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerPageThree.fxml");
	}
	public void prevPage(ActionEvent event) throws IOException {
		Main m2 = new Main();
		m2.changeScene("effortLoggerPageThree.fxml");
	}
	public void tryAgain(ActionEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerPageThree.fxml");
	}
}
