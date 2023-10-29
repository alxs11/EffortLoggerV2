package application;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerLogin {
	
	public ControllerLogin() {
		
	}
	
	@FXML
	private Button button;
	@FXML
	private Label badCredentials;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	public void loginUser(ActionEvent event) throws IOException {
		checkLogin();
	}
	
	private void checkLogin() throws IOException {
		Main m = new Main();
		if(username.getText().toString().equals("user1") && password.getText().toString().equals("loveCarter")) {
			badCredentials.setText("Access Granted.");
			m.changeScene("effortLoggerConsole.fxml");
		}
		else if(username.getText().isEmpty() && password.getText().isEmpty() ) {
			badCredentials.setText("Please enter your credentials.");
		}
		else {
			badCredentials.setText("Incorrect username or password.");
		}
	}
}

