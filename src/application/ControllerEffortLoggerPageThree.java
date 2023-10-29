package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import java.util.ArrayList;

import java.io.IOException;

public class ControllerEffortLoggerPageThree {
	
	public ControllerEffortLoggerPageThree() {

	}

	@FXML private Button logout;
	@FXML private Button previous;
	@FXML private Slider memberOne;
	@FXML private Slider memberTwo;
	@FXML private Slider memberThree;
	@FXML private Slider memberFour;
	@FXML private Slider memberFive;
	@FXML private Slider memberSix;
	@FXML private Button submit;
	protected int memberOnePoints;
	protected int memberTwoPoints;
	protected int memberThreePoints;
	protected int memberFourPoints;
	protected int memberFivePoints;
	protected int memberSixPoints;
	protected int[] memberPoints;

	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}

	public void nextPage(ActionEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerScore.fxml");
	}
	
	public void prevPage(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerPageTwo.fxml");
	}

	public void submitPoints(ActionEvent event) throws IOException {
		System.out.print("yes");
		memberPoints = new int[]{
		((int) memberOne.getValue()),
		(int) memberTwo.getValue(),
		(int) memberThree.getValue(),
		(int) memberFour.getValue(),
		(int) memberFive.getValue(),
		(int) memberSix.getValue()
		};

		memberOnePoints = (int) memberOne.getValue();
		memberTwoPoints = (int) memberTwo.getValue();
		memberThreePoints = (int) memberThree.getValue();
		memberFourPoints = (int) memberFour.getValue();
		memberFivePoints = (int) memberFive.getValue();
		memberSixPoints = (int) memberSix.getValue();
	    ArrayList<Integer> memberPoints = new ArrayList<Integer>();
	    memberPoints.add(memberOnePoints);
	    memberPoints.add(memberTwoPoints);
	    System.out.print(memberPoints);
	}
	
}
