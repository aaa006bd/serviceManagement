package application;

import java.time.Instant;

public class Customer {
	private String name;
	private String machineName;
	private Instant startTime;
	private Instant stopTime;
	private String startTimeString;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String machineName, Instant startTime) {
		super();
		this.name = name;
		this.machineName = machineName;
		this.startTime = startTime;
	}
	
	
	public Customer(String name, String machineName, Instant startTime, String startTimeString) {
		super();
		this.name = name;
		this.machineName = machineName;
		this.startTime = startTime;
		this.startTimeString = startTimeString;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
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

	public String getStartTimeString() {
		 return startTimeString;
	}

	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}
	
	

}
