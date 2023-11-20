// Author: Jake Gresh
package application;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerEffortLoggerDefinitions {
	
	public ControllerEffortLoggerDefinitions() {}
	
	@FXML public TextArea projectType;
	@FXML public TextArea lifeCycleStep;
	@FXML public TextArea effortCategory;
	@FXML public TextArea deliverable;
	
	private String[][] definitions = new String[4][100];
	
	@FXML
	private void initialize() {
		loadDefinitionsFile();
		updateTextAreas();
	}
	
	private void updateTextAreas() {
		String projectTypeString = "";
		String lifeCycleStepString = "";
		String effortCategoryString = "";
		String deliverableString = "";
		
		for (int i = 0; i < definitions[0].length; i++) {
			System.out.println(definitions[0][i] + " 0 " + i);
			if (!definitions[0][i].equals("null"))
				projectTypeString += definitions[0][i] + "\n";
		}
		for (int i = 0; i < definitions[1].length; i++) {
			if (!definitions[1][i].equals("null"))
				lifeCycleStepString += definitions[1][i] + "\n";
		}
		for (int i = 0; i < definitions[2].length; i++) {
			if (!definitions[2][i].equals("null"))
				effortCategoryString += definitions[2][i] + "\n";
		}
		for (int i = 0; i < definitions[3].length; i++) {
			if (!definitions[3][i].equals("null"))
				deliverableString += definitions[3][i] + "\n";
		}
		
		projectType.setText(projectTypeString);
		lifeCycleStep.setText(lifeCycleStepString);
		effortCategory.setText(effortCategoryString);
		deliverable.setText(deliverableString);
	}
	
	private void getTextAreas() {
		String projectTypeString = projectType.getText();
		String lifeCycleStepString = lifeCycleStep.getText();
		String effortCategoryString = effortCategory.getText();
		String deliverableString = deliverable.getText();
		
		Scanner s1 = new Scanner(projectTypeString);
		int i = 0;
		while (s1.hasNextLine()) {
			definitions[0][i] = s1.nextLine();
			i++;
		}
		s1.close();
		
		Scanner s2 = new Scanner(lifeCycleStepString);
		int j = 0;
		while (s2.hasNextLine()) {
			definitions[1][j] = s2.nextLine();
			i++;
		}
		s2.close();
		
		Scanner s3 = new Scanner(effortCategoryString);
		int k = 0;
		while (s3.hasNextLine()) {
			definitions[2][k] = s3.nextLine();
			i++;
		}
		s3.close();
		
		Scanner s4 = new Scanner(deliverableString);
		int l = 0;
		while (s4.hasNextLine()) {
			definitions[3][l] = s4.nextLine();
			i++;
		}
		s4.close();
	}
	
	private void loadDefinitionsFile() { 
		try {
			File file = new File("definitions");
			Scanner input = new Scanner(file);
			
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < definitions[j].length; i++) {
					definitions[j][i] = input.nextLine();
					System.out.println(definitions[j][i]);
				}
			}
			
			input.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveDefinitionsFile() {
		try {
			PrintWriter out = new PrintWriter("definitions");
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < definitions[j].length; i++) {
//					definitions[j][i] = j + " " + i;
					out.printf(definitions[j][i] + "\n");
				}
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@FXML private Text saveButton;
	public void saveClicked(MouseEvent event) throws IOException {
		definitions = new String[4][100];
		getTextAreas();
		saveDefinitionsFile();
		
		Main m = new Main();
		m.changeScene("effortLoggerConsole.fxml");
	}
}