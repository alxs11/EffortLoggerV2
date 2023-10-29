package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			primaryStage.setResizable(false);
//			Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
//			launch console on startup for testing:
			Parent root = FXMLLoader.load(getClass().getResource("effortLoggerConsole.fxml"));
			primaryStage.setTitle("Effort Logger V2.0.");
			primaryStage.setScene(new Scene(root, 600, 400));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException {
		Parent frame = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(frame);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
