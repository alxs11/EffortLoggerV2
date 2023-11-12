/**
Author: Benjamin Paul
 * 
 */
package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.collections.ObservableList;

/**
 * 
 */
public class ControllerLogs {
	@FXML private TableView<Log> tableView;
	@FXML private TableColumn<Log, String> Column1;
	@FXML private TableColumn<Log, String> Column2;
	@FXML private TableColumn<Log, String> Column3;
	@FXML private TableColumn<Log, String> Column4;
	@FXML private TableColumn<Log, String> Column5;
	@FXML private TableColumn<Log, String> Column6;
	@FXML private TableColumn<Log, String> Column7;
	@FXML private TableColumn<Log, String> Column8;
	private ObservableList<Log> effortLogs; 
	
	@FXML private ToggleButton tb;
	
	public ControllerLogs() {
		LogsData logs = new LogsData(true, true);
		effortLogs = logs.effortAsLogs();
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
		
		tableView.setItems(effortLogs);
	}

}
