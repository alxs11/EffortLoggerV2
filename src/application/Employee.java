//Author: Benjamin Paul
package application;

import javafx.beans.property.SimpleStringProperty;
public class Employee {
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty userName;
	private SimpleStringProperty rank;
	
	public Employee(String firstName, String lastName, String userName, String rank) { // Constructor
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.userName = new SimpleStringProperty(userName);
		this.rank = new SimpleStringProperty(rank);
	}
	public String getRank() { //returns rank of employee: 1 = supervisor, 0 = developer
		return this.rank.get();
	}
	public String getUserName() { //returns username of employee
		return this.userName.get();
	}
	public String getFirstName() { //returns employee name
		return this.firstName.get();
	}
	public String getLastName() { //returns employee name
		return this.lastName.get();
	}
	public SimpleStringProperty firstNameProperty() {
		return firstName;
	}
}