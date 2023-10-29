package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerEffortLoggerPageThree {
	
	public ControllerEffortLoggerPageThree() {

	}

	@FXML
	private Button logout;
	@FXML
	private Button previous;
	@FXML
	private Text score;
	@FXML
	private Text round;
	@FXML
	private Button tryagain;
	@FXML
	private Button NextStory;
	@FXML
	ChoiceBox<Object> dropdown1;
	@FXML
	ChoiceBox<Object> dropdown2;
	@FXML
	ChoiceBox<Object> dropdown3;
	
	
	public void runDrop() {
	dropdown1 = new ChoiceBox<Object>();
	dropdown1.getItems().add("0 points");
	dropdown1.getItems().add("25 points");
	dropdown1.getItems().add("50 points");
	dropdown1.getItems().add("75 points");
	dropdown1.getItems().add("100 points");
	dropdown2 = new ChoiceBox<Object>();
	dropdown2.getItems().add("0 points");
	dropdown2.getItems().add("25 points");
	dropdown2.getItems().add("50 points");
	dropdown2.getItems().add("75 points");
	dropdown2.getItems().add("100 points");		
	dropdown3 = new ChoiceBox<Object>();
	dropdown3.getItems().add("0 points");
	dropdown3.getItems().add("25 points");
	dropdown3.getItems().add("50 points");
	dropdown3.getItems().add("75 points");
	dropdown3.getItems().add("100 points");
	System.out.print("reached");
	}
	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}

	
	public void prevPage(ActionEvent event) throws IOException {
		Main m = new Main();
		runDrop();
		m.changeScene("effortLoggerPageTwo.fxml");
	}
}
