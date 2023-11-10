// by kaleb
package application;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import java.util.ArrayList;
import java.io.IOException;

public class ControllerELEditor {
	
	public ControllerELEditor() {

	}

	// logs user out reroute to login page
	public void logoutUser(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}

	// reroute to next page
	public void changeToConsole(MouseEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerConsole.fxml");
	}
	// reroute to prev Page
	public void changeToStory(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerStory.fxml");
	}

	public void updateEntry(ActionEvent event) throws IOException {
		
	}
	public void clearEntry(ActionEvent event) throws IOException {
		
	}
	public void deleteEntry(ActionEvent event) throws IOException {
		
	}
	public void splitEntry(ActionEvent event) throws IOException {
		
	}
	public void updateDateEntry(ActionEvent event) throws IOException {
		
	}
	public void updateStartTime(ActionEvent event) throws IOException {
		
	}
	public void updateStopTime(ActionEvent event) throws IOException {
		
	}
	public void selectProject(ActionEvent event) throws IOException {
		
	}
	public void selectEntry(ActionEvent event) throws IOException {
		
	}
	public void updateLifeCycleStep(ActionEvent event) throws IOException {
		
	}
	public void updateEffortCategory(ActionEvent event) throws IOException {
		
	}
	public void updateDeliverable(ActionEvent event) throws IOException {
		
	}


}
