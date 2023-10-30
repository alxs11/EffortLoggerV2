//author alexis urias
package application;

import javafx.event.ActionEvent;

import java.io.FileInputStream; //libraries for files
import java.io.IOException;
import javafx.fxml.FXML;	//libraries for FXML files
import javafx.scene.control.*;	// libraries for control
import java.util.*;			// java utility
import java.security.NoSuchAlgorithmException;	//libraries for encryption
import java.util.Base64;
import java.security.MessageDigest; 

public class ControllerLogin {
	
	public ControllerLogin() {	//constructor
		
	}
	
	@FXML					//FXML elements
	private Button button;
	@FXML
	private Label badCredentials;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	
	public void loginUser(ActionEvent event) throws IOException {	//when the user clicks login perform action
		checkLogin();
	}
	
	private String getPasswordFromConfigFile() {	//get the password from the config file
        Properties property = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            property.load(input);
            return property.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	private void checkLogin() throws IOException { //action method for login
		Main m = new Main();
		String storedPassword = getPasswordFromConfigFile(); //file password
		String hashedPassword = hashPassword(storedPassword); //hashed password
		
		if(username.getText().toString().equals("user1") && password.getText().toString().equals(storedPassword)) {
			badCredentials.setText("Access Granted.");	// if the credentials are good, grant access
			m.changeScene("effortLoggerConsole.fxml");
		}
		else if(username.getText().isEmpty() && password.getText().isEmpty()) {	//if the fields are empty
			badCredentials.setText("Please enter your credentials.");
		}
		else {
			badCredentials.setText("Incorrect username or password."); //enter invalid credentials
		}
	}
	
	private String hashPassword(String password) {	//method that hashes password
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] bytes = md.digest(password.getBytes());
	        return Base64.getEncoder().encodeToString(bytes);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";	//Side note - would have liked to setup a proper database using MySQL but here is the general idea
	}
}

