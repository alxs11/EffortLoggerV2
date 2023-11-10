// by kaleb
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.io.IOException;

public class ControllerPPScores {
	
	public ControllerPPScores() {
	}

	@FXML private Button logout;
	@FXML private Button next;
	@FXML private Button previous;
	@FXML private Button tryAgain;
	@FXML private Text score;
	@FXML private Text round;

	public void initialize() {
		
		round.setText(""+ ControllerPPVoting.getRounds());
		score.setText("" + ControllerPPVoting.getMean());

	}
	public void logoutUser(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	public void nextPage(ActionEvent event) throws IOException {
	}
	public void prevPage(ActionEvent event) throws IOException {
		Main m2 = new Main();
		m2.changeScene("effortLoggerVoting.fxml");
	}
	public void tryAgain(ActionEvent event) throws IOException {
		if (ControllerPPVoting.getRounds() != 0) {
			Main m1 = new Main();
			m1.changeScene("effortLoggerScore.fxml");
		}
	}
	public void nextStory(ActionEvent event) throws IOException {
		Main m2 = new Main();
		ControllerPPVoting.setRounds(4);
		m2.changeScene("effortLoggerStory.fxml");
	}
}
