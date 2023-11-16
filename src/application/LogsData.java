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
			out[i] = "" + (i + 1) + ".";
			for (int t = 0; t < 7; t++) {
				if(t == 3)
					continue;
				out[i] += "  " + EffortLogs.get(i)[t];
			}
		}
		return out;
	}
	public String [] filterDefectData(int type) {
		//type: 0 = Business, 1 = Development
		String[] out = new String[DefectLogs.size()];
		for(int i = 0; i < DefectLogs.size(); i ++) {
			out[i] = "" + (i + 1) + ".";
			out[i] = out[i] + DefectLogs.get(i)[0]
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
				EffortLogs.get(i)[t % 7] = line;
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
				DefectLogs.get(i)[t%7] = input.nextLine();
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
	public void saveEffortData() throws IOException{ //Save Effort logs to file filename
		try {
			PrintWriter out = new PrintWriter("effortLogs");
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
	public void saveDefectData() throws IOException{ // Save Defect logs to file filename
		try {
			PrintWriter out = new PrintWriter("defectLogs");
			
			for (int i = 0; i < DefectLogs.size(); i++) {
				for(int t = 0; t < 7; t++) {
					out.printf(DefectLogs.get(i)[t] + "\n");
					System.out.println("avajisn");
				}
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ObservableList<Log> effortAsLogs() {
		ObservableList<Log> out = FXCollections.observableArrayList();
		for(int i = 0; i < EffortLogs.size(); i++) {
			Log l = new Log(Integer.toString(i + 1), EffortLogs.get(i)[0], EffortLogs.get(i)[1], EffortLogs.get(i)[2],
					 EffortLogs.get(i)[3], EffortLogs.get(i)[4], EffortLogs.get(i)[5], EffortLogs.get(i)[6]);
			out.add(l);
		}
		return out;
	}
	public ObservableList<Log> defectAsLogs() {
		ObservableList<Log> out = FXCollections.observableArrayList();
		for(int i = 0; i < DefectLogs.size(); i++) {
			Log l = new Log(Integer.toString(i + 1), DefectLogs.get(i)[0], DefectLogs.get(i)[1], DefectLogs.get(i)[2],
					DefectLogs.get(i)[3], DefectLogs.get(i)[4], DefectLogs.get(i)[5], DefectLogs.get(i)[6]);
			out.add(l);
		}
		return out;
	}
	public void modify(int Ptype, String[] replacement, int action) throws IOException{
		if(action == 0) { //Update
			String [] r = new String[7];
			System.arraycopy(replacement, 1, r, 0, 3);
			System.arraycopy(replacement, 4, r, 4, 3);
			r[3] = deltaTime(replacement[2], replacement[3]);
			EffortLogs.set(Integer.parseInt(replacement[0])-1, r);
			
		}
		else if (action == 1) { // Delete
			EffortLogs.remove(Integer.parseInt(replacement[0]) - 1);
		}
	};
	//public Log[] developmentAsLogs() {} //probably necessary
	public String deltaTime(String t1, String t2) {
		//format hh:mm:ss
		int t2s = Integer.parseInt(t2.substring(6)) + Integer.parseInt(t2.substring(3,5)) * 60 + Integer.parseInt(t2.substring(0,2)) * 3600;
		int t1s = Integer.parseInt(t1.substring(6)) + Integer.parseInt(t1.substring(3,5)) * 60 + Integer.parseInt(t1.substring(0,2)) * 3600;		
		int seconds = t2s - t1s;
		return String.format("%02dh%02dm%02ds", seconds/3600, (seconds % 3600) / 60, seconds % 60);
	}
}
