/**
 * 
 */
package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleButton;

/**
 * 
 */
public class ControllerLogs {
	@FXML private TableView<Log> tableView;
	@FXML private TableColumn<Log, String> NumberColumn;
	@FXML private TableColumn<Log, String> DateColumn;
	@FXML private TableColumn<Log, String> StopColumn;
	@FXML private TableColumn<Log, String> TimeColumn;
	@FXML private TableColumn<Log, String> LifeCycleColumn;
	@FXML private TableColumn<Log, String> CategoryColumn;
	@FXML private TableColumn<Log, String> DeliverableColumn;
	
	@FXML private ToggleButton tb;
	
	public ControllerLogs() {
		
	}
	public void initialize() {
		NumberColumn.setCellValueFactory(new PropertyValueFactory<Log, String>("c1"));
		DateColumn.setCellValueFactory(new PropertyValueFactory<Log, String>("c2"));
		StopColumn.setCellValueFactory(new PropertyValueFactory<Log, String>("c3"));
		TimeColumn.setCellValueFactory(new PropertyValueFactory<Log, String>("c4"));
		LifeCycleColumn.setCellValueFactory(new PropertyValueFactory<Log, String>("c5"));
		CategoryColumn.setCellValueFactory(new PropertyValueFactory<Log, String>("c6"));
		DeliverableColumn.setCellValueFactory(new PropertyValueFactory<Log, String>("c7"));
		tableView.setOpacity(0);
	}
}
