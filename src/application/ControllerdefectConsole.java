package application;

import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.util.*;
import java.time.Instant;



import java.io.IOException;

public class ControllerdefectConsole {
	
	
	public ControllerdefectConsole() {}
	
	@FXML
	private void initialize() {
	
		projectTyped.getItems().add("Business Project");
		projectTyped.getItems().add("Development Project");
		
		currentDefect.getItems().add("Defect1");
		currentDefect.getItems().add("Defect2");
		currentDefect.getItems().add("Defect3");
		currentDefect.getItems().add("Defect4");
	
	}
	
	@FXML
	private Button logout;
	
	public void logoutUser(ActionEvent event) throws IOException {
		Main m6 = new Main();
		m6.changeScene("LoginPage.fxml");
	}
	
	@FXML 
	private Button EffortConsole;

	public void EffortLoggerConsole(ActionEvent event) throws IOException {
		Main m7 = new Main();
		m7.changeScene("effortLoggerConsole.fxml");
	}
	@FXML
	private ChoiceBox<String> projectTyped;
	@FXML
	private ChoiceBox<String> currentDefect;
	
	
	
	
}