// Author: Jake Gresh
package application;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;

public class ControllerEffortLoggerConsole {
	
	public ControllerEffortLoggerConsole() {}
	
	public static Timer effortTimer;
	public static int effortSeconds;
	public static boolean effortTimerRunning;
	private Timer labelTimer;
	public static LocalTime effortStartTime;
	
	@FXML
	private void initialize() {
		labelTimer = new Timer();
		TimerTask labelTask = new TimerTask() {
			@Override
			public void run() {
				updateEffortTimeElapsedLabel();
			}
		};
		labelTimer.scheduleAtFixedRate(labelTask, 0, 1000);
		
		if (effortTimerRunning) {
			newActivity.setDisable(true);
			stopActivity.setDisable(false);
		} else {
			newActivity.setDisable(false);
			stopActivity.setDisable(true);
		}
		
		// aligns with design goal: the user selects from a set of dropdown options:
		// 2d array of 100 strings for each of the 4 categories
		String[][] definitions = new String[4][100];
		definitions = ControllerEffortLoggerDefinitions.loadDefinitionsFile();
		for (int i = 0; i < definitions[0].length; i++) {
			if (!definitions[0][i].equals("null"))
				projectType.getItems().add(definitions[0][i]);
			if (!definitions[1][i].equals("null"))
				lifeCycleStep.getItems().add(definitions[1][i]);
			if (!definitions[2][i].equals("null"))
				effortCategory.getItems().add(definitions[2][i]);
			if (!definitions[3][i].equals("null"))
				deliverable.getItems().add(definitions[3][i]);
		}
	}
	
	// timer start button:
	@FXML
	private Button newActivity;
	public void newActivity(ActionEvent event) throws IOException {
		stopActivity.setDisable(false);
		newActivity.setDisable(true); 
		
		effortTimerRunning = true;
		effortSeconds = 0;
		updateEffortTimeElapsedLabel();
		effortStartTime = LocalTime.now();
		
		effortTimer = new Timer();
		TimerTask effortTask = new TimerTask() {
			@Override
			public void run() {
				effortSeconds++;
			}
		};
		effortTimer.scheduleAtFixedRate(effortTask, 1000, 1000);
	}
	
	// aligns with design goal: button disabling means unintended inputs can't be accessed
	
	// stopwatch stop button: 
	@FXML
	private Button stopActivity;
	public void stopActivity(ActionEvent event) throws IOException {
		stopActivity.setDisable(true);
		newActivity.setDisable(false);
		
		effortTimer.cancel(); // terminates timer, value has been saved in effortSeconds
		effortTimerRunning = false;
		
		String date = LocalDate.now().toString();
		String start = effortStartTime.truncatedTo(ChronoUnit.SECONDS).toString();
		String stop = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString();
		String time = formatTime(effortSeconds);
		String step = lifeCycleStep.getValue();
		String cat = effortCategory.getValue();
		String del = deliverable.getValue();
		
		String[] effortData = new String[] {date, start, stop, time, step, cat, del};
		newEffort(effortData);
	}
	
	public String[] newEffort (String effortData[]) throws IOException {

		
		LogsData logs = new LogsData(true, true);
		logs.addEffortData(effortData);
		logs.saveEffortData();
		return effortData;
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
	private void updateEffortTimeElapsedLabel() {
		Platform.runLater(() -> {
			elapsedTime.setText("Elapsed Time: " + formatTime(effortSeconds));
		});
	}
	// take int seconds and return a string in the format of "00h00m00s":
	public static String formatTime(int seconds) {
	    int hours = seconds / 3600;
	    int minutes = (seconds % 3600) / 60;
	    int remainingSeconds = seconds % 60;

	    String formattedTime = String.format("%02dh%02dm%02ds", hours, minutes, remainingSeconds);

	    return formattedTime;
	}

	@FXML private Button logout;
	public void logoutUser(MouseEvent event) throws IOException {
		labelTimer.cancel();
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	
	@FXML private Text next;
	public void nextPage(MouseEvent mouse) throws IOException {
		labelTimer.cancel();
		Main m = new Main();
		m.changeScene("effortLoggerStory.fxml");
	}
	
	@FXML
	public void changeToEditor(MouseEvent mouse) throws IOException {
		labelTimer.cancel();
		Main m = new Main();
		m.changeScene("effortLoggerEditor.fxml");
		System.out.print("editor");
	}
	
	// open employee list database for testing:
	@FXML
	private Button employeeList;
	public void employeeListPage(ActionEvent event) throws IOException {
		labelTimer.cancel();
		Main m = new Main();
		m.changeScene("EmployeeListPage.fxml");
	}
	
	@FXML private Button defectbutton;
	public void defectConsole(MouseEvent event) throws IOException{
		labelTimer.cancel();
		Main m = new Main();
		m.changeScene("defectConsole.fxml");
	}
	
	@FXML private Text userStoryTab;
	public void enterUserStories(MouseEvent event) throws IOException {
		labelTimer.cancel();
		Main m = new Main();
		m.changeScene("EffortLoggerUserStories.fxml");
	}

	@FXML private Text logsButton;
	public void effortDefectLogs(MouseEvent event) throws IOException{
		labelTimer.cancel();
		Main m = new Main();
		m.changeScene("effortLoggerLogs.fxml");
	}
	
	
	@FXML private Text definitionsButton;
	public void enterDefinitions(MouseEvent event) throws IOException{
		labelTimer.cancel();
		Main m = new Main();
		m.changeScene("effortLoggerDefinitions.fxml");
	}
}
