// author: Ahmad Samara
package application;

import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;

import java.util.*;
import java.time.Instant;
import java.awt.TextArea;
import java.io.IOException;

public class ControllerdefectConsole {
	
	
	public ControllerdefectConsole() {}
	
	@FXML
	private void initialize() { //adding the dropdown items
	
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
		
		defectCat.getItems().add("10 Documentation");
		defectCat.getItems().add("20 Syntax");
		defectCat.getItems().add("30 Build, Package");
		defectCat.getItems().add("40 Assignment");
		defectCat.getItems().add("50 interface");
		defectCat.getItems().add("60 Checking");
		defectCat.getItems().add("70 Data");
		defectCat.getItems().add("80 Function");
		defectCat.getItems().add("90 System");
		defectCat.getItems().add("100 Environment");
		
	
	}
	
	@FXML private Button logout;
	
	public void logoutUser(ActionEvent event) throws IOException {
		Main m6 = new Main();
		m6.changeScene("LoginPage.fxml");
	}
	
	@FXML private Button EffortConsole;

	public void EffortLoggerConsole(ActionEvent event) throws IOException {
		Main m7 = new Main();
		m7.changeScene("effortLoggerConsole.fxml");
	}
	
	public void changeToConsole(MouseEvent event)throws IOException {
		Main m6 = new Main();
		m6.changeScene("effortLoggerConsole.fxml");
	}
	public void changeToEditor(MouseEvent event)throws IOException {
		Main m6 = new Main();
		m6.changeScene("effortLoggerEditor.fxml");
	}	
	public void changeToDefinition(MouseEvent event)throws IOException {
		Main m6 = new Main();
	}	
	public void changeToLog(MouseEvent event)throws IOException {
		Main m6 = new Main();
		m6.changeScene("effortLoggerLogs.fxml");
	}	
	public void changeToUserStories(MouseEvent event)throws IOException {
		Main m6 = new Main();
		m6.changeScene("effortLoggerUserStories.fxml");
	}
	public void changeToPlanningPoker(MouseEvent event)throws IOException {
		Main m6 = new Main();
		m6.changeScene("effortLoggerStory.fxml");
	}
	
	
	// this clock deals with page to page transitions

	
	
	public boolean status = true;
	
	
	public void statusClose(ActionEvent event) {
		
		status = false;
	}
	
	public void statusOpen(ActionEvent event) {
		
		status = true;
	}
	
	
	public String[] newDefect (ActionEvent event) throws IOException {//creates a new defect from the selected options
		String project = projectTyped.getValue();
		String defect =  currentDefect.getValue();
		String defectName = defectText.getText();
		String defectDisc = defectSymp.getText();
		String stepWhenInjected = injectedStep.getValue();
		String stepWhenRemoved = removedStep.getValue();
		String defectCategory = defectCat.getValue();
		String fixValue = fixText.getText();
		String statusval = String.valueOf(status);
		
		String[] defectData = new String[] {project, defect, defectName, defectDisc, stepWhenInjected, stepWhenRemoved,defectCategory,statusval,fixValue};
		LogsData logs = new LogsData(true, true);
		logs.addDefectData(defectData);
		logs.saveDefectData();
		return defectData;	
	
	}
	
	
	//dropdown menus
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
	@FXML
    private TextField defectSymp;
    @FXML
    private TextField defectText;
    @FXML
    private TextField fixText;
    
public void clearDefect(ActionEvent event) throws IOException {
		
		defectText.clear();
		defectSymp.clear();
		fixText.clear();
		projectTyped.valueProperty().set(null);
		currentDefect.valueProperty().set(null);
		injectedStep.valueProperty().set(null);
		removedStep.valueProperty().set(null);
		defectCat.valueProperty().set(null);	
}
	
	
	
	
	
}