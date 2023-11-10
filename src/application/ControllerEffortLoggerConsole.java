// console functionality by Jake
package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

import java.io.IOException;

public class ControllerEffortLoggerConsole {
	
	public ControllerEffortLoggerConsole() {
		
	}
	
	public Timer timer;
	public int seconds;
	
	@FXML
	private void initialize() {
		stopActivity.setDisable(true);
		
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
		
		deliverable.getItems().add("item-name");
//		Conceptual Design								
//		Detailed Design								
//		Test Cases								
//		Solution								
//		Reflection								
//		Outline								
//		Draft								
//		Report								
//		User Defined								
//		Other								
	}
	
	@FXML
	private Button newActivity;
	public void newActivity(ActionEvent event) throws IOException {
		newActivity.setDisable(true);
		stopActivity.setDisable(false);
		seconds = 0;
		updateLabel();
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds++;
				updateLabel();
			}
		};
		timer.scheduleAtFixedRate(task, 1000, 1000);
		next.setDisable(true);
		logout.setDisable(true);
	}
	
	@FXML
	private Button stopActivity;
	public void stopActivity(ActionEvent event) throws IOException {
		newActivity.setDisable(false);
		stopActivity.setDisable(true);
		timer.cancel();
		next.setDisable(false);
		logout.setDisable(false);
	}
	
	@FXML
	private ChoiceBox projectType;
	@FXML
	private ChoiceBox lifeCycleStep;
	@FXML
	private ChoiceBox effortCategory;
	@FXML
	private ChoiceBox deliverable;
	
	@FXML
	private Label elapsedTime;
	private void updateLabel() {
		Platform.runLater(() -> {
			elapsedTime.setText("Elapsed Time: " + formatTime(seconds));
		});
	}
	
	public static String formatTime(int seconds) {
	    int hours = seconds / 3600;
	    int minutes = (seconds % 3600) / 60;
	    int remainingSeconds = seconds % 60;

	    String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);

	    return formattedTime;
	}

	@FXML private Button logout;
	public void logoutUser(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	
	@FXML private Text next;
	public void nextPage(MouseEvent mouse) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerStory.fxml");
	}
	@FXML
	public void changeToEditor(MouseEvent mouse) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerEditor.fxml");
		System.out.print("editor");
	}

	
	@FXML
	private Button employeeList;
	
	@FXML
	public void employeeListPage(ActionEvent event) throws IOException {
		Main m2 = new Main();
		m2.changeScene("EmployeeListPage.fxml");
	}


}
