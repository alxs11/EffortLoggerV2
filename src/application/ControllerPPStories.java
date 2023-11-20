//author Ahmad Samara

package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerPPStories implements Initializable {
	
	@FXML private Button logout;
	@FXML private Button next;
	@FXML private Button previous;
	@FXML private Text TextTimer; // countdown timer
    @FXML private Button Snooze;
    @FXML private Button Start;
    @FXML private Slider SnoozeSlider; //snooze time value
    @FXML private Slider TimeSlider; //timer value
	Stage stage;
	Scene scene;
    boolean value = true;

    Main m3 = new Main();
    int i = 100; //start time before restarting
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	TextTimer.setText(String.valueOf(i));
    	
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
			
			i--;
			TextTimer.setText(String.valueOf(i));
			
			
			if(i == 0) {
				try {
					if(stage != null)
						stage.close();
					m3.changeScene("effortLoggerScore.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} ));
		
		timeline.setCycleCount(Animation.INDEFINITE);
		
		if(value) {
		timeline.play();
		}
	}
    
	public void StartTimer(ActionEvent event) throws IOException {
		i = (int) TimeSlider.getValue();
		TextTimer.setText(String.valueOf(i));	
	}
	
	public void SnoozeAction(ActionEvent event) throws IOException {
		i += (int) SnoozeSlider.getValue();
		TextTimer.setText(String.valueOf(i));
	}
	
	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
		
	public void nextPage(ActionEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerVoting.fxml");
	}

	public void prevPage(ActionEvent event) throws IOException {
		Main m2 = new Main();
		m2.changeScene("effortLoggerConsole.fxml");
	}
	@FXML private ToggleButton logs;

	public void openLogsWindow(ActionEvent event) throws IOException{
		try {
			if(logs.isSelected()) {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("effortLoggerLogs2.fxml"));
		        scene = new Scene(fxmlLoader.load(), 800, 500);
		        stage = new Stage();
		        stage.setResizable(false);
		        stage.setTitle("Logs");
		        stage.setScene(scene);
		        stage.show();
		        logs.setText("Close Logs");
	        }
			else {
				stage.close();
				logs.setText("See Logs");
				}
			}
	    catch (IOException e) {
	    	e.printStackTrace();
	    }

	}


	



	

}

