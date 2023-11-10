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

import java.util.*;
import java.time.Instant;

import java.io.IOException;

public class ControllerEffortLoggerConsole {
	
	public ControllerEffortLoggerConsole() {}
	
	public Timer timer;
	public int seconds;
	
	public int logNumber = 0;
	public List<EffortLog> logs = new ArrayList<EffortLog>();
	
	@FXML
	private void initialize() {
		stopActivity.setDisable(true); // disables timer stop button until timer is started
		
		// aligns with design goal: the organization will have the option to set dropdown options:
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
//		deliverable.getItems().add("User Defined");	
		deliverable.getItems().add("Other");
	}
	
	// stopwatch start button:
	@FXML
	private Button newActivity;
	public void newActivity(ActionEvent event) throws IOException {
		stopActivity.setDisable(false); // enables stopwatch stop button
		// disable buttons to leave page so no data is lost:
		newActivity.setDisable(true);
		next.setDisable(true);
		logout.setDisable(true);
		employeeList.setDisable(true);
		
		// start stopwatch:
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
	}
	
	// aligns with design goal: button disabling means unintended inputs can't be accessed
	
	// stopwatch stop button: 
	@FXML
	private Button stopActivity;
	public void stopActivity(ActionEvent event) throws IOException {
		stopActivity.setDisable(true); // disables this button
		// enable buttons to leave page:
		newActivity.setDisable(false);
		next.setDisable(false);
		logout.setDisable(false);
		employeeList.setDisable(false);
		
		timer.cancel(); // terminates stopwatch, value is saved in public int seconds
		
		// save this effort log to logs list:
		EffortLog e = new EffortLog(++logNumber, Instant.now(), seconds, 
				projectType.getValue(), lifeCycleStep.getValue(), 
				effortCategory.getValue(), deliverable.getValue());
		logs.add(e);
	}
	
	// declare dropdowns:
	@FXML
	private ChoiceBox<String> projectType;
	@FXML
	private ChoiceBox<String> lifeCycleStep;
	@FXML
	private ChoiceBox<String> effortCategory;
	@FXML
	private ChoiceBox<String> deliverable;
	
	@FXML
	private Label elapsedTime;
	private void updateLabel() {
		Platform.runLater(() -> {
			elapsedTime.setText("Elapsed Time: " + formatTime(seconds));
		});
	}
	
	// take int seconds and return a string in the format of "00:00:00":
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
	// open employee list database for testing:
	@FXML
	private Button employeeList;
	
	@FXML
	public void employeeListPage(ActionEvent event) throws IOException {
		Main m2 = new Main();
		m2.changeScene("EmployeeListPage.fxml");
	}
	
	@FXML private Button defectbutton;
	public void defectConsole(MouseEvent event) throws IOException{
		Main m1 = new Main();
		m1.changeScene("defectConsole.fxml");
	}
	
}
