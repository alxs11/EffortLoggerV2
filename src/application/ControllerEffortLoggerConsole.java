// console functionality by Jake
package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
	}
	
	@FXML
	private Button stopActivity;
	public void stopActivity(ActionEvent event) throws IOException {
		newActivity.setDisable(false);
		stopActivity.setDisable(true);
		timer.cancel();
	}
	
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

	@FXML
	private Button logout;
	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	
	@FXML
	private Button next;
	public void nextPage(ActionEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerPageTwo.fxml");
	}

}
