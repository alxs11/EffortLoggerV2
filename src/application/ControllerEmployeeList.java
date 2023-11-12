//Author: Benjamin Paul
package application;

import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.io.IOException;
import javafx.scene.control.Button;



public class ControllerEmployeeList {
	@FXML private TableView<Employee> tableView;
	@FXML private TableColumn<Employee, String> firstNameColumn;
	@FXML private TableColumn<Employee, String> lastNameColumn;
	@FXML private TableColumn<Employee, String> userNameColumn;
	@FXML private TableColumn<Employee, String> rankColumn;
	
	@FXML private Button backButton;
	@FXML private Button logoutButton;
	
	private ObservableList<Employee> employees;
	
	public ControllerEmployeeList() {
		employees = getEmployees();
	}
	
	public void initialize() {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		userNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("userName"));
		rankColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("rank"));
		
		tableView.setItems(employees); // setting the information retrieved from getEmployees()
	}
	
	public ObservableList<Employee> getEmployees(){ // using dummy values for the table
		ObservableList<Employee> output = FXCollections.observableArrayList();
		for(int i = 1; i < 24; i++) {
			output.add(new Employee("Employee" + Integer.toString(i), "LastName" + Integer.toString(i), "user" + Integer.toString(i), Integer.toString(i % 2)));
		}
		return output;
	}
	
	public void goBack(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("effortLoggerConsole.fxml");
	}
	public void signOut(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
}
