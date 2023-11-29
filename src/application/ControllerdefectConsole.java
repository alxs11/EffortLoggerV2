// author: Ahmad Samara
package application;

import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;

import java.util.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.TextArea;
import java.io.IOException;

public class ControllerdefectConsole {
	
	
	public ControllerdefectConsole() {}
	//dropdown menus
		@FXML
		private ChoiceBox<String> projectTyped;
		@FXML
		private ChoiceBox<String> currentDefect;
		@FXML
		private ChoiceBox<String> injectedStep;
		@FXML
		private ChoiceBox<String> removedStep;
		@FXML
		private ChoiceBox<String> defectCat;
		@FXML
	    private TextField defectSymp;
	    @FXML
	    private TextField defectText;
	    @FXML
	    private TextField fixText;
	    public int itemSelected;
	@FXML
	private void initialize() { //adding the dropdown items
	
		projectTyped.getItems().add("Business Project");
		projectTyped.getItems().add("Development Project");
		
		
		
		injectedStep.getItems().add("Problem Understanding");
		injectedStep.getItems().add("Conceptual Design Plan");
		injectedStep.getItems().add("Requirements");
		injectedStep.getItems().add("Conceptual Design");
		injectedStep.getItems().add("Conceptual Design Review");
		injectedStep.getItems().add("Detailed Design Plan");
		injectedStep.getItems().add("Detailed Design/Prototype");
		injectedStep.getItems().add("Detailed Design Review");
		injectedStep.getItems().add("Implementation Plan");
		injectedStep.getItems().add("Test Case Generation");
		injectedStep.getItems().add("Solution Specification");
		injectedStep.getItems().add("Solution Review");
		injectedStep.getItems().add("Solution Implementation");
		injectedStep.getItems().add("Unit/System Test");
		injectedStep.getItems().add("Reflection");
		injectedStep.getItems().add("Repository Update");
		injectedStep.getItems().add("Planning");
		injectedStep.getItems().add("Information Gathering");
		injectedStep.getItems().add("Information Understanding");
		injectedStep.getItems().add("Verifying");
		injectedStep.getItems().add("Outlining");
		injectedStep.getItems().add("Drafting");
		injectedStep.getItems().add("Finalizing");
		injectedStep.getItems().add("Team Meeting");
		injectedStep.getItems().add("Coach Meeting");
		injectedStep.getItems().add("Stakeholder Meeting");
		
		removedStep.getItems().add("Problem Understanding");
		removedStep.getItems().add("Conceptual Design Plan");
		removedStep.getItems().add("Requirements");
		removedStep.getItems().add("Conceptual Design");
		removedStep.getItems().add("Conceptual Design Review");
		removedStep.getItems().add("Detailed Design Plan");
		removedStep.getItems().add("Detailed Design/Prototype");
		removedStep.getItems().add("Detailed Design Review");
		removedStep.getItems().add("Implementation Plan");
		removedStep.getItems().add("Test Case Generation");
		removedStep.getItems().add("Solution Specification");
		removedStep.getItems().add("Solution Review");
		removedStep.getItems().add("Solution Implementation");
		removedStep.getItems().add("Unit/System Test");
		removedStep.getItems().add("Reflection");
		removedStep.getItems().add("Repository Update");
		removedStep.getItems().add("Planning");
		removedStep.getItems().add("Information Gathering");
		removedStep.getItems().add("Information Understanding");
		removedStep.getItems().add("Verifying");
		removedStep.getItems().add("Outlining");
		removedStep.getItems().add("Drafting");
		removedStep.getItems().add("Finalizing");
		removedStep.getItems().add("Team Meeting");
		removedStep.getItems().add("Coach Meeting");
		removedStep.getItems().add("Stakeholder Meeting");
		
		defectCat.getItems().add("10 Documentation");
		defectCat.getItems().add("20 Syntax");
		defectCat.getItems().add("30 Build, Package");
		defectCat.getItems().add("40 Assignment");
		defectCat.getItems().add("50 interface");
		defectCat.getItems().add("60 Checking");
		defectCat.getItems().add("70 Data");
		defectCat.getItems().add("80 Function");
		defectCat.getItems().add("90 System");
		defectCat.getItems().add("100 Environment");
		
		
		projectTyped.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		    	LogsData datas = new LogsData(false, true);

		    	if((projectTyped.getItems().get((Integer) number2)).equals("Business Project")){
		        	System.out.println(projectTyped.getItems().get((Integer) number2));
		        	String[] arr = datas.filterDefectData(0);
		        	
		        	for(int i=0; i < arr.length; i++){
		        		System.out.print(arr[i]);
		        		currentDefect.getItems().add(arr[i]);
		        	}

		    	}
		    }
		});
		
		 currentDefect.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		        @Override
		        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		        	String [] vals = currentDefect.getItems().get((Integer) number2).split("  ");
		        	System.out.print("\n");
		        	for(int i =0; i < vals.length; i++) {System.out.print(vals[i]);}
		        	
		        	String itemSelectstr = vals[0];
		        	System.out.print("\n");
		        	System.out.print(itemSelectstr);

		        	itemSelected = Integer.parseInt(itemSelectstr.substring(0, itemSelectstr.length()-1));
		        	System.out.print("\n");
		        	System.out.print(itemSelected);
		        	
		        	injectedStep.setValue(""+vals[3]);
		        	defectCat.setValue(vals[5]);
		        	defectText.setText(vals[1]);
		        	defectSymp.setText(vals[2]);
		        	removedStep.setValue(vals[4]);
		        }
		    });
	
	}
	
	public void logoutUser(MouseEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LoginPage.fxml");
	}
	public void EffortLoggerConsole(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerConsole.fxml");
	}
	public void changeToConsole(MouseEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerConsole.fxml");
	}
	public void changeToEditor(MouseEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerEditor.fxml");
	}	
	public void changeToDefinition(MouseEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerDefinitions.fxml");
	}	
	public void changeToLog(MouseEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerLogs.fxml");
	}	
	public void changeToUserStories(MouseEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerUserStories.fxml");
	}
	public void changeToPlanningPoker(MouseEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("effortLoggerUserStories.fxml");
	}
	
	
	// this clock deals with page to page transitions

	
	
	public boolean status = true;
	
	
	public void statusClose(ActionEvent event) {
		
		status = false;
	}
	
	public void statusOpen(ActionEvent event) {
		
		status = true;
	}
	
	
	public String[] newDefect (ActionEvent event) throws IOException {//creates a new defect from the selected options
		String project = projectTyped.getValue();
		String defect =  currentDefect.getValue();
		String defectName = defectText.getText();
		String defectDisc = defectSymp.getText();
		String stepWhenInjected = injectedStep.getValue();
		String stepWhenRemoved = removedStep.getValue();
		String defectCategory = defectCat.getValue();
		String fixValue = fixText.getText();
		String statusval = String.valueOf(status);
		
		String[] defectData = new String[] {defectName, defectDisc, stepWhenInjected, stepWhenRemoved,defectCategory,statusval,fixValue};
		LogsData logs = new LogsData(false, true);
		logs.addDefectData(defectData);
		logs.saveDefectData();
		return defectData;	
	
	}
	  
public void clearDefect(ActionEvent event) throws IOException {
		
	Main m1 = new Main();
	m1.changeScene("defectConsole.fxml");


}
public void updateEntry(ActionEvent event) throws IOException {
	
	LogsData logs = new LogsData(false, true);
    logs.modifyDefect(0, updateEntry1(), 0);
    logs.saveDefectData();
}
public String [] updateEntry1() throws IOException {
	//ArrayList<String> strArr = new ArrayList<String>();
	String [] strArr = new String [7];
    strArr[0] = String.valueOf(itemSelected);
    strArr[1] = defectText.getText();
    strArr[2] = defectSymp.getText();
    strArr[3] = injectedStep.getValue();
    strArr[4] = removedStep.getValue();
    strArr[5] = defectCat.getValue();
    System.out.print(strArr[0]);
	return strArr;
}

public void delete() throws IOException{
	
	LogsData logs = new LogsData(false, true);
	String [] d = {"" + itemSelected};
	logs.modifyDefect(0, d, 1);
	logs.saveDefectData();
	Main m1 = new Main();
	m1.changeScene("defectConsole.fxml");
}

	
	
	
	
	
}