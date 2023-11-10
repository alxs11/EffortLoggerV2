// by kaleb
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import java.util.ArrayList;
import java.io.IOException;

public class ControllerPPVoting {
	
	public ControllerPPVoting() {

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
	static int rounds = 4;
	static int avg;
	static int length;
	static int mean;
	static int sd;

	// logs user out reroute to login page
	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}

	// reroute to next page
	public void nextPage(ActionEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerScore.fxml");
	}
	// reroute to prev Page
	public void prevPage(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerStory.fxml");
	}

	// read value from sliders, calculate mean based on rounds
	public void submitPoints(ActionEvent event) throws IOException {
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
	    ArrayList<Integer> pointsFinal = new ArrayList<Integer>();

	    memberPoints.add(memberOnePoints);
	    memberPoints.add(memberTwoPoints);
	    memberPoints.add(memberThreePoints);
	    memberPoints.add(memberFourPoints);
	    memberPoints.add(memberFivePoints);
	    memberPoints.add(memberSixPoints);
	    int sum = 0;
	    if (rounds > 1) {	
		    for (double i : memberPoints) {sum += i;}		    
		    length = memberPoints.size();
		    mean = sum / length;
		    sd = 0;
		    for (double num : memberPoints) {
		        sd += Math.pow(num - mean, 2);
		    }
		    sd =  (int) Math.sqrt(sd / length);
			Main m = new Main();
			rounds -= 1;
			m.changeScene("effortLoggerScore.fxml");
		}
	    else {
		    for (int i: memberPoints) {
		    	if(i > mean - sd && i < mean + sd) {
		    		pointsFinal.add(i);
		    	}}
	    	for (double i : pointsFinal) {sum += i;}
		    length = pointsFinal.size();
		    mean = sum / length;
			Main m = new Main();
			rounds -= 1;
			m.changeScene("effortLoggerScore.fxml");
		}
	}
	public static int getRounds() {
		return rounds;
	}
	public static int getMean() {
		return mean;
	}
	public static void setRounds (int round) {
		rounds = round;
	}


}
