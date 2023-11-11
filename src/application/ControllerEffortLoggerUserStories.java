package application;

import javafx.event.ActionEvent;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream; //libraries for files
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;	//libraries for FXML files
import javafx.scene.control.*;	// libraries for control
import java.util.*;			// java utility


public class ControllerEffortLoggerUserStories {

	
	@FXML private Button saveButton;
    @FXML private Button clearButton;
    @FXML private TextArea textArea;
    @FXML private Button homeButton;
    @FXML private Button logout;
    
    public void goToHome(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("effortLoggerConsole.fxml");
    }
    
    public void userLogout(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("LoginPage.fxml");
    }
    
    public void clearText(ActionEvent event) throws IOException {
    	textArea.setText("");
    }
    
    public void saveUserStory(ActionEvent event) throws IOException {
    	try {
    		String file = "UserStories.txt";
    		FileWriter fileWriter = new FileWriter(file, true);
    		fileWriter.write(textArea.getText() + "\n");
    		fileWriter.close();
    		System.out.println("Success");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void  viewUserStories(ActionEvent event) throws IOException {
    	try {
    		File file = new File("UserStories.txt");
    		Desktop d = Desktop.getDesktop();
    		d.open(file);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
	
	
}