package application;

import java.time.Duration;
import java.time.Instant;

import data.Machine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainSceneController {

	ObservableList<String> machineName;

	private CustomerModel customerModel;

	private MachineModel machineModel;

	@FXML
	private TextField nameInput;

	@FXML
	private ChoiceBox<String> machineDropdown;

	@FXML
	private TextField timeInput;

	@FXML
	private Button entryButton;

	@FXML
	private TableView<Customer> customerTable;

	@FXML
	private TableColumn<Customer, String> nameCol;

	@FXML
	private TableColumn<Customer, String> machineNameCol;

	@FXML
	private TableColumn<Customer, String> startTimeCol;

	@FXML
	private TableColumn<Customer, String> endTimeCol;

	@FXML
	private TableColumn<Customer, Double> amountCol;

	private Main mainApp;

	/* setter region for external resources */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	public void setCustomerModel(CustomerModel model) {
		this.customerModel = model;
		customerTable.setItems(model.getCustomerList());
	}

	public void setMachineModel(MachineModel machineModel) {
		this.machineModel = machineModel;
		machineName=machineModel.getKeyList();
		machineDropdown.setValue(machineName.get(0));
		machineDropdown.setItems(machineName);
	}

	/* controller specific region */
	public MainSceneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@FXML
	private void initialize() {	
		columnBinding();//if you use shared model initialize the value when setting model.dont do it here. 2 hours wasted
	}

	@FXML
	private void EntryButtonAction(ActionEvent event) {
		String name = nameInput.getText();
		String machine = machineDropdown.getSelectionModel().getSelectedItem();
		Instant startTime = Instant.now();
		String startTimeString = startTime.toString();

		customerModel.getCustomerList().add(new Customer(name, machine, startTime, startTimeString));

		timeInput.setText(startTimeString);

	}

	private void columnBinding() {
		nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		machineNameCol.setCellValueFactory(cellData -> cellData.getValue().machineNameProperty());
		startTimeCol.setCellValueFactory(cellData -> cellData.getValue().startTimeStringProperty());
		endTimeCol.setCellValueFactory(cellData -> cellData.getValue().stopTimeStringProperty());

		// important part is calling asObject() method
		amountCol.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
	}

	@FXML
	private void deleteCustomerRow(ActionEvent event) {
		int index = customerTable.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			customerModel.getCustomerList().remove(index);
		}
	}

	@FXML
	private void computeCustomerInfo(ActionEvent event) {

		int index = customerTable.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			Instant endTime = Instant.now();
			Customer selectedCustomer = customerModel.getCustomerList().get(index);
			Machine machineUsed = machineModel.getMachineMap().get(selectedCustomer.getMachineName());
			selectedCustomer.setStopTime(endTime);
			selectedCustomer.setStopTimeString(endTime.toString());
			selectedCustomer.setAmount(totalPaybleAmount(selectedCustomer,machineUsed));
		}
	}

	private double totalPaybleAmount(Customer customer,Machine machineUsed) {

		double time = (double) Duration.between(customer.getStartTime(), customer.getStopTime()).toMinutes();
		double amount = time *machineUsed.getMachineRate() *machineModel.TIME_UNIT;
		
		System.out.println("time is :" + time + " minutes");
		return time;
	}

}
