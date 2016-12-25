package data;

public class Machine {
	
	private String machineName;
	private double machineRate;
	
	
	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Machine(String machineName, double machineRate) {
		super();
		this.machineName = machineName;
		this.machineRate = machineRate;
	}



	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public double getMachineRate() {
		return machineRate;
	}
	public void setMachineRate(double machineRate) {
		this.machineRate = machineRate;
	}
	
	

}
