// by Jake Gresh
package application;
import java.time.Instant;

public class EffortLog {
	int number;
	Instant date;
	int seconds;
	String projectType;
	String lifeCycleStep;
	String effortCategory;
	String deliverable;

	// Constructor Declaration of Class
	public EffortLog(int number, Instant date, int seconds, String projectType, String lifeCycleStep,
			 String effortCategory, String deliverable) {
		this.number = number;
		this.date = date;
		this.projectType = projectType;
		this.lifeCycleStep = lifeCycleStep;
		this.effortCategory = effortCategory;
		this.deliverable = deliverable;
	 }

	 public int getNumber() { return number; }
	 public Instant getDate() { return date; }
	 public int getSeconds() { return seconds; }
	 public String getProjectType() { return projectType; }
	 public String getLifeCycleStep() { return lifeCycleStep; }
	 public String getEffortCategory() { return effortCategory; }
	 public String getDeliverable() { return deliverable; }

	 @Override public String toString() {
		 return("");
	}
}