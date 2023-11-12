/**
Author: Benjamin Paul
 * 
 */
package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * 
 */
public class ControllerLogs {
	@FXML private TableView<Log> effortView;
	@FXML private TableColumn<Log, String> Column1;
	@FXML private TableColumn<Log, String> Column2;
	@FXML private TableColumn<Log, String> Column3;
	@FXML private TableColumn<Log, String> Column4;
	@FXML private TableColumn<Log, String> Column5;
	@FXML private TableColumn<Log, String> Column6;
	@FXML private TableColumn<Log, String> Column7;
	@FXML private TableColumn<Log, String> Column8;
	
	@FXML private TableView<Log> defectView;
	@FXML private TableColumn<Log, String> C1;
	@FXML private TableColumn<Log, String> C2;
	@FXML private TableColumn<Log, String> C3;
	@FXML private TableColumn<Log, String> C4;
	@FXML private TableColumn<Log, String> C5;
	@FXML private TableColumn<Log, String> C6;
	@FXML private TableColumn<Log, String> C7;
	@FXML private TableColumn<Log, String> C8;
	private ObservableList<Log> effortLogs; 
	private ObservableList<Log> defectLogs;
	@FXML private ToggleButton tb;
	
	public ControllerLogs() {
		LogsData logs = new LogsData(true, true);
		effortLogs = logs.effortAsLogs();
		defectLogs = logs.defectAsLogs();
	}
	public void initialize() {
		Column1.setCellValueFactory(new PropertyValueFactory<Log, String>("c1"));
		Column2.setCellValueFactory(new PropertyValueFactory<Log, String>("c2"));
		Column3.setCellValueFactory(new PropertyValueFactory<Log, String>("c3"));
		Column4.setCellValueFactory(new PropertyValueFactory<Log, String>("c4"));
		Column5.setCellValueFactory(new PropertyValueFactory<Log, String>("c5"));
		Column6.setCellValueFactory(new PropertyValueFactory<Log, String>("c6"));
		Column7.setCellValueFactory(new PropertyValueFactory<Log, String>("c7"));
		Column8.setCellValueFactory(new PropertyValueFactory<Log, String>("c8"));
		
		effortView.setItems(effortLogs);
		
		
		C1.setCellValueFactory(new PropertyValueFactory<Log, String>("c1"));
		C2.setCellValueFactory(new PropertyValueFactory<Log, String>("c2"));
		C3.setCellValueFactory(new PropertyValueFactory<Log, String>("c3"));
		C4.setCellValueFactory(new PropertyValueFactory<Log, String>("c4"));
		C5.setCellValueFactory(new PropertyValueFactory<Log, String>("c5"));
		C6.setCellValueFactory(new PropertyValueFactory<Log, String>("c6"));
		C7.setCellValueFactory(new PropertyValueFactory<Log, String>("c7"));
		C8.setCellValueFactory(new PropertyValueFactory<Log, String>("c8"));
		
		defectView.setItems(defectLogs);
	}
	
	public void disableDefectLog(ActionEvent event) throws IOException{
		defectView.setDisable(!defectView.isDisable());
		defectView.setOpacity(defectView.getOpacity() == 1.0 ? 0: 1);
		tb.setText(defectView.isDisable() ? "See Defect Logs" : "See Effort Logs");
	}

	@FXML private Button defectbutton;
	public void defectConsole(MouseEvent event) throws IOException{
		Main m1 = new Main();
		m1.changeScene("defectConsole.fxml");
	}
	public void toEffortConsole(MouseEvent event) throws IOException{
		Main m1 = new Main();
		m1.changeScene("effortLoggerConsole.fxml");
	}
	public void toEditor(MouseEvent event) throws IOException{
		Main m1 = new Main();
		m1.changeScene("effortLoggerEditor.fxml");
	}
	public void logOut(MouseEvent event) throws IOException{
		Main m1 = new Main();
		m1.changeScene("loginPage.fxml");
	}
	public void toPlanningPoker(MouseEvent event) throws IOException{
		Main m1 = new Main();
		m1.changeScene("FffortLoggerUserStories.fxml");
	}
	public void changeToUserStories(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerUserStories.fxml");
	}

}
