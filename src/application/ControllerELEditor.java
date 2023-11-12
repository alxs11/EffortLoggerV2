// by kaleb
package application;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.beans.value.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControllerELEditor {
	@FXML private ChoiceBox<String> projectType;
	@FXML private ChoiceBox<String> selectEntry;
	@FXML private ChoiceBox<String> lifeCycleStep;
	@FXML private ChoiceBox<String> effortCategory;
	@FXML private ChoiceBox<String> deliverable;
	@FXML private Button clear;
	@FXML private DatePicker date;
	@FXML public TextField startTime;
	@FXML private TextField stopTime;
	public int itemSelected;
	public ControllerELEditor() { }
	@FXML
	private void initialize() {
		projectType.getItems().add("Business Project");
		projectType.getItems().add("Development Project");

		
		lifeCycleStep.getItems().add("Problem Understanding");
		lifeCycleStep.getItems().add("Conceptual Design Plan");
		lifeCycleStep.getItems().add("Requirements");
		lifeCycleStep.getItems().add("Conceptual Design");
		lifeCycleStep.getItems().add("Conceptual Design Review");
		lifeCycleStep.getItems().add("Detailed Design Plan");
		lifeCycleStep.getItems().add("Detailed Design/Prototype");
		lifeCycleStep.getItems().add("Detailed Design Review");
		lifeCycleStep.getItems().add("Implementation Plan");
		lifeCycleStep.getItems().add("Test Case Generation");
		lifeCycleStep.getItems().add("Solution Specification");
		lifeCycleStep.getItems().add("Solution Review");
		lifeCycleStep.getItems().add("Solution Implementation");
		lifeCycleStep.getItems().add("Unit/System Test");
		lifeCycleStep.getItems().add("Reflection");
		lifeCycleStep.getItems().add("Repository Update");
		lifeCycleStep.getItems().add("Planning");
		lifeCycleStep.getItems().add("Information Gathering");
		lifeCycleStep.getItems().add("Information Understanding");
		lifeCycleStep.getItems().add("Verifying");
		lifeCycleStep.getItems().add("Outlining");
		lifeCycleStep.getItems().add("Drafting");
		lifeCycleStep.getItems().add("Finalizing");
		lifeCycleStep.getItems().add("Team Meeting");
		lifeCycleStep.getItems().add("Coach Meeting");
		lifeCycleStep.getItems().add("Stakeholder Meeting");
		
		effortCategory.getItems().add("Plans");
		effortCategory.getItems().add("Deliverables");
		effortCategory.getItems().add("Interruptions");
		effortCategory.getItems().add("Defects");
		effortCategory.getItems().add("Others");
		
		deliverable.getItems().add("Conceptual Design");
		deliverable.getItems().add("Detailed Design");
		deliverable.getItems().add("Test Cases");
		deliverable.getItems().add("Solution");						
		deliverable.getItems().add("Reflection");
		deliverable.getItems().add("Outline");
		deliverable.getItems().add("Draft");
		deliverable.getItems().add("Report");
		deliverable.getItems().add("Other");
		
	    projectType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
	        @Override
	        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
	        	LogsData datas = new LogsData(true, false);

	        	if((projectType.getItems().get((Integer) number2)).equals("Business Project")){
		        	System.out.println(projectType.getItems().get((Integer) number2));
		        	String[] arr = datas.filterData(0);
		        	for(int i=0; i < arr.length; i++){
		        		selectEntry.getItems().add(arr[i]);
		        	}

	        	}
	        }
	    });
	    
	    selectEntry.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
	        @Override
	        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
	        	String [] vals = selectEntry.getItems().get((Integer) number2).split("  ");
	        	String itemSelectstr = vals[0];
	        	itemSelected = Integer.parseInt(itemSelectstr.substring(0, itemSelectstr.length()-1));
	        	
	        	lifeCycleStep.setValue(""+vals[4]);
	        	LocalDate date1 = LocalDate.parse(vals[1]);
	        	date.setValue(date1);
	        	startTime.setText(vals[2]);
	        	stopTime.setText(vals[3]);
	        	effortCategory.setValue(vals[5]);
	        	deliverable.setValue(vals[6]);
	        }
	    });
	}
	// logs user out reroute to login page
	public void logoutUser(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	// reroute to next page
	public void changeToConsole(MouseEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerConsole.fxml");
	}
	// reroute to prev Page
	public void changeToStory(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerStory.fxml");
	}
	public void changeToDefect(MouseEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("defectConsole.fxml");
	}
	public void changeToLog(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerLogs.fxml");
	}
	public void changeToUserStories(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerUserStories.fxml");
	}
	public void updateEntry(ActionEvent event) throws IOException {
		System.out.print(itemSelected);
		LogsData logs = new LogsData(true, false);
	    logs.modify(0, updateEntry1(), 0);
	    logs.saveEffortData();
	}
	public String [] updateEntry1() throws IOException {
		//ArrayList<String> strArr = new ArrayList<String>();
		String [] strArr = new String [7];
	    strArr[0] = String.valueOf(itemSelected);
	    strArr[1] = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    strArr[2] = startTime.getText();
	    strArr[3] = stopTime.getText();
	    strArr[4] = lifeCycleStep.getValue();
	    strArr[5] = effortCategory.getValue();
	    strArr[6] = deliverable.getValue();
		return strArr;
	}
	public void clearEntry(ActionEvent event) throws IOException {
		Main m1 = new Main();
		m1.changeScene("effortLoggerEditor.fxml");
	}
	public void deleteEntry(ActionEvent event) throws IOException {
		String [] d = {"" + itemSelected};
		LogsData logs = new LogsData(true, false);
		logs.modify(0, d, 1);
	    logs.saveEffortData();

	}
	public void splitEntry(ActionEvent event) throws IOException {
		
	}

}
