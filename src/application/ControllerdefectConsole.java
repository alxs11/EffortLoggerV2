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
		
		injectedStep.getItems().add("Problem Understanding");
		injectedStep.getItems().add("Conceptual Design Plan");
		injectedStep.getItems().add("Requirements");
		injectedStep.getItems().add("Conceptual Design");
		injectedStep.getItems().add("Conceptual Design Review");
		injectedStep.getItems().add("Detailed Design Plan");
		injectedStep.getItems().add("Detailed Design/Prototype");
		injectedStep.getItems().add("Detailed Design Review");
		injectedStep.getItems().add("Implementation Plan");
		injectedStep.getItems().add("Test Case Generation");
		injectedStep.getItems().add("Solution Specification");
		injectedStep.getItems().add("Solution Review");
		injectedStep.getItems().add("Solution Implementation");
		injectedStep.getItems().add("Unit/System Test");
		injectedStep.getItems().add("Reflection");
		injectedStep.getItems().add("Repository Update");
		injectedStep.getItems().add("Planning");
		injectedStep.getItems().add("Information Gathering");
		injectedStep.getItems().add("Information Understanding");
		injectedStep.getItems().add("Verifying");
		injectedStep.getItems().add("Outlining");
		injectedStep.getItems().add("Drafting");
		injectedStep.getItems().add("Finalizing");
		injectedStep.getItems().add("Team Meeting");
		injectedStep.getItems().add("Coach Meeting");
		injectedStep.getItems().add("Stakeholder Meeting");
		
		removedStep.getItems().add("Problem Understanding");
		removedStep.getItems().add("Conceptual Design Plan");
		removedStep.getItems().add("Requirements");
		removedStep.getItems().add("Conceptual Design");
		removedStep.getItems().add("Conceptual Design Review");
		removedStep.getItems().add("Detailed Design Plan");
		removedStep.getItems().add("Detailed Design/Prototype");
		removedStep.getItems().add("Detailed Design Review");
		removedStep.getItems().add("Implementation Plan");
		removedStep.getItems().add("Test Case Generation");
		removedStep.getItems().add("Solution Specification");
		removedStep.getItems().add("Solution Review");
		removedStep.getItems().add("Solution Implementation");
		removedStep.getItems().add("Unit/System Test");
		removedStep.getItems().add("Reflection");
		removedStep.getItems().add("Repository Update");
		removedStep.getItems().add("Planning");
		removedStep.getItems().add("Information Gathering");
		removedStep.getItems().add("Information Understanding");
		removedStep.getItems().add("Verifying");
		removedStep.getItems().add("Outlining");
		removedStep.getItems().add("Drafting");
		removedStep.getItems().add("Finalizing");
		removedStep.getItems().add("Team Meeting");
		removedStep.getItems().add("Coach Meeting");
		removedStep.getItems().add("Stakeholder Meeting");
		
		defectCat.getItems().add("Defect Type 1");
		defectCat.getItems().add("Defect Type 2");
		defectCat.getItems().add("Defect Type 3");
		defectCat.getItems().add("Defect Type 4");
	
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
	@FXML
	private ChoiceBox<String> injectedStep;
	@FXML
	private ChoiceBox<String> removedStep;
	@FXML
	private ChoiceBox<String> defectCat;
	
	
	
	
	
}