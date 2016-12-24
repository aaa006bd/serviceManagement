package application;

import java.time.Instant;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleStringProperty name;
	private SimpleStringProperty machineName;
	private Instant startTime;
	private Instant stopTime;
	private SimpleStringProperty startTimeString;
	private SimpleStringProperty stopTimeString;
	private SimpleDoubleProperty amount;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name,String machineName,Instant startTime,String StartTimeString){
		this.name = new SimpleStringProperty(name);
		this.machineName = new SimpleStringProperty(machineName);
		this.startTimeString = new SimpleStringProperty(StartTimeString);
		this.stopTimeString = new SimpleStringProperty();
		this.amount = new SimpleDoubleProperty();
		
		this.startTime = startTime;
		
	}
	
	public final SimpleStringProperty nameProperty() {
		return this.name;
	}

	public final String getName() {
		return this.nameProperty().get();
	}
	

	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	

	public final SimpleStringProperty machineNameProperty() {
		return this.machineName;
	}
	

	public final String getMachineName() {
		return this.machineNameProperty().get();
	}
	

	public final void setMachineName(final String machineName) {
		this.machineNameProperty().set(machineName);
	}
	

	public final SimpleStringProperty startTimeStringProperty() {
		return this.startTimeString;
	}
	

	public final String getStartTimeString() {
		return this.startTimeStringProperty().get();
	}
	

	public final void setStartTimeString(final String startTimeString) {
		this.startTimeStringProperty().set(startTimeString);
	}
	

	public final SimpleStringProperty stopTimeStringProperty() {
		return this.stopTimeString;
	}
	

	public final String getStopTimeString() {
		return this.stopTimeStringProperty().get();
	}
	

	public final void setStopTimeString(final String stopTimeString) {
		this.stopTimeStringProperty().set(stopTimeString);
	}

	public Instant getStartTime() {
		return startTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public Instant getStopTime() {
		return stopTime;
	}

	public void setStopTime(Instant stopTime) {
		this.stopTime = stopTime;
	}

	public final SimpleDoubleProperty amountProperty() {
		return this.amount;
	}
	

	public final double getAmount() {
		return this.amountProperty().get();
	}
	

	public final void setAmount(final double amount) {
		this.amountProperty().set(amount);
	}
	
	
	
	
	


}
