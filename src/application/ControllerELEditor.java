// by kaleb
package application;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.beans.value.*;
import java.io.IOException;

public class ControllerELEditor {
	@FXML private ChoiceBox<String> projectType;
	@FXML private ChoiceBox<String> selectEntry;
	@FXML private ChoiceBox<String> lifeCycleStep;
	@FXML private ChoiceBox<String> effortCategory;
	@FXML private ChoiceBox<String> deliverable;
	@FXML private Button clear;
	@FXML private DatePicker date;
	@FXML private TextField startTime;
	@FXML private TextField stopTime;
	
	
	public ControllerELEditor() { }
	@FXML
	private void initialize() {
		projectType.getItems().add("Business Project");
		projectType.getItems().add("Development Project");
		
		lifeCycleStep.getItems().add("Problem Understanding");
		lifeCycleStep.getItems().add("Conceptual Design Plan");
		lifeCycleStep.getItems().add("Requirements");
		lifeCycleStep.getItems().add("Conceptual Design");
		lifeCycleStep.getItems().add("Conceptual Design Review");
		lifeCycleStep.getItems().add("Detailed Design Plan");
		lifeCycleStep.getItems().add("Detailed Design/Prototype");
		lifeCycleStep.getItems().add("Detailed Design Review");
		lifeCycleStep.getItems().add("Implementation Plan");
		lifeCycleStep.getItems().add("Test Case Generation");
		lifeCycleStep.getItems().add("Solution Specification");
		lifeCycleStep.getItems().add("Solution Review");
		lifeCycleStep.getItems().add("Solution Implementation");
		lifeCycleStep.getItems().add("Unit/System Test");
		lifeCycleStep.getItems().add("Reflection");
		lifeCycleStep.getItems().add("Repository Update");
		lifeCycleStep.getItems().add("Planning");
		lifeCycleStep.getItems().add("Information Gathering");
		lifeCycleStep.getItems().add("Information Understanding");
		lifeCycleStep.getItems().add("Verifying");
		lifeCycleStep.getItems().add("Outlining");
		lifeCycleStep.getItems().add("Drafting");
		lifeCycleStep.getItems().add("Finalizing");
		lifeCycleStep.getItems().add("Team Meeting");
		lifeCycleStep.getItems().add("Coach Meeting");
		lifeCycleStep.getItems().add("Stakeholder Meeting");
		
		effortCategory.getItems().add("Plans");
		effortCategory.getItems().add("Deliverables");
		effortCategory.getItems().add("Interruptions");
		effortCategory.getItems().add("Defects");
		effortCategory.getItems().add("Others");
		
		deliverable.getItems().add("Conceptual Design");
		deliverable.getItems().add("Detailed Design");
		deliverable.getItems().add("Test Cases");
		deliverable.getItems().add("Solution");						
		deliverable.getItems().add("Reflection");
		deliverable.getItems().add("Outline");
		deliverable.getItems().add("Draft");
		deliverable.getItems().add("Report");
		deliverable.getItems().add("Other");
		
		
	    projectType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
	        @Override
	        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
	        	LogsData datas = new LogsData(false, true);
	        	String[] arr;
	        	if((projectType.getItems().get((Integer) number2)).equals("Business Project")){
		        	System.out.println(projectType.getItems().get((Integer) number2));
		        	arr = datas.filterData(0);
		        	for(int i=0; i < arr.length; i++){
		        		selectEntry.getItems().add(arr[i]);
		        	}
	        	}
	        }
	    });
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
