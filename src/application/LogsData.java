/**
 * 
 */
package application;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

/**
 * 
 */
public class LogsData {

	private ObservableList<String[]> EffortLogs;
	private ObservableList<String[]> DefectLogs;
	//private ObservableList<String[]>DevelopmentLogs; //probably necessary
	
	public LogsData(boolean effortFromFile, boolean defectFromFile) {
		EffortLogs = FXCollections.observableArrayList();
		DefectLogs = FXCollections.observableArrayList();
		if (effortFromFile)
			loadEffortData();
		if (defectFromFile)
			loadDefectData();
	}
	//EffortLogs = [Date, Start, Stop, Time, LifeCycleStep, Category, Deliverable / Interruption / etc.]
	//DefectLogs = [Name, Detail, #Injected, #Removed, Category, Status, Fix]
	
	public void displayDefectLogs(){ //for testing
		try {
			for(int i = 0; i < DefectLogs.size(); i ++) {
				for(int t = 0; t < 7; t ++ ) {
					System.out.println(DefectLogs.get(i)[t]);
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addEffortData(String [] entry) { //Add an entry to Effort Log
		assert entry.length == 7;
		EffortLogs.add(entry);
	}
	public void addDefectData(String [] entry) { // Add an entry to Defect Log
		assert entry.length == 7;
		DefectLogs.add(entry);
	}
	public String [] filterData(int type) {
		//type: 0 = Business, 1 = Development
		String[] out = new String[EffortLogs.size()];
		for(int i = 0; i < EffortLogs.size(); i ++) {
			for (int t = 0; t < 7; t++) {
				if(t == 3)
					continue;
				out[i] += EffortLogs.get(i)[t];
			}
		}
		return out;
	}
	public String [] filterDefectData(int type) {
		//type: 0 = Business, 1 = Development
				String[] out = new String[DefectLogs.size()];
				for(int i = 0; i < DefectLogs.size(); i ++) {
					for (int t = 0; t < 7; t++) {
						if(t == 3)
							continue;
						out[i] += DefectLogs.get(i)[t];
					}
				}
				return out;
	}
	public void loadEffortData() { // Load Effort Logs from the file effortLogs
		try {
			int i = -1, t = 0;
			File file = new File("effortLogs");
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				if (t % 7 == 0) {
					EffortLogs.add(new String[7]);
					i += 1;
				}
				String line = input.nextLine();
				EffortLogs.get(i)[t] = line;
				t += 1;
			}
			input.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void loadDefectData() {  //Load Defect Logs from the file defectLogs
		try {
			int i = -1, t = 0;
			File file = new File("defectLogs");
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				if (t % 7 == 0) {
					DefectLogs.add(new String[7]);
					i += 1;
				}
				DefectLogs.get(i)[t] = input.nextLine();
				t += 1;
			}
			//DefectLogs.remove(i);
			input.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	public void saveEffortData(String filename) throws IOException{ //Save Effort logs to file filename
		try {
			PrintWriter out = new PrintWriter(filename);
			for (int i = 0; i < EffortLogs.size(); i++) {
				for(int t = 0; t < 7; t++) {
					out.printf(EffortLogs.get(i)[t] + "\n");
				}
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveDefectData(String filename) throws IOException{ // Save Defect logs to file filename
		try {
			PrintWriter out = new PrintWriter(filename);
			for (int i = 0; i < DefectLogs.size(); i++) {
				for(int t = 0; t < 7; t++) {
					out.printf(DefectLogs.get(i)[t] + "\n");
				}
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Log[] effortAsLogs() {
		Log[] out = new Log [EffortLogs.size()];
		for(int i = 0; i < EffortLogs.size(); i++) {
			out[i].setc1(Integer.toString(i+1));
			out[i].setc2(EffortLogs.get(i)[0]);
			out[i].setc2(EffortLogs.get(i)[1]);
			out[i].setc2(EffortLogs.get(i)[2]);
			out[i].setc2(EffortLogs.get(i)[3]);
			out[i].setc2(EffortLogs.get(i)[4]);
			out[i].setc2(EffortLogs.get(i)[5]);
			out[i].setc2(EffortLogs.get(i)[6]);
		}
		return out;
	}
	public Log[] defectAsLogs() {
		Log[] out = new Log [DefectLogs.size()];
		for(int i = 0; i < DefectLogs.size(); i++) {
			out[i].setc1(Integer.toString(i+1));
			out[i].setc2(DefectLogs.get(i)[0]);
			out[i].setc2(DefectLogs.get(i)[1]);
			out[i].setc2(DefectLogs.get(i)[2]);
			out[i].setc2(DefectLogs.get(i)[3]);
			out[i].setc2(DefectLogs.get(i)[4]);
			out[i].setc2(DefectLogs.get(i)[5]);
			out[i].setc2(DefectLogs.get(i)[6]);
		}
		return out;
	}
	//public Log[] developmentAsLogs() {} //probably necessary
		
}
