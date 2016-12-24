package application;

import java.time.Instant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

	ObservableList<String> machineName = FXCollections.observableArrayList("ps4", "xbox one", "ps3", "xbox 360", "ps2");
	
	private CustomerModel model ;

	public void setModel(CustomerModel model) {
		this.model = model;
		customerTable.setItems(model.getCustomerList());
	}

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
	
	private TableColumn<Customer, Double> amountCol;

	private Main mainApp;

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	

	public MainSceneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@FXML
	private void initialize() {
		machineDropdown.setValue("ps4");
		machineDropdown.setItems(machineName);
		columnBinding();
	}

	@FXML
	private void EntryButtonAction(ActionEvent event) {
		String name = nameInput.getText();
		String machine = machineDropdown.getSelectionModel().getSelectedItem();
		Instant startTime = Instant.now();
		String startTimeString = startTime.toString();

		model.getCustomerList().add(new Customer(name, machine, startTime, startTimeString));

		timeInput.setText(startTimeString);

	}

	private void columnBinding() {
		nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		machineNameCol.setCellValueFactory(cellData -> cellData.getValue().machineNameProperty());
		startTimeCol.setCellValueFactory(cellData -> cellData.getValue().startTimeStringProperty());
		endTimeCol.setCellValueFactory(cellData -> cellData.getValue().stopTimeStringProperty());
		
		//important part is calling asObject() method
		amountCol.setCellValueFactory(cellData-> cellData.getValue().amountProperty().asObject());
	}
	
	@FXML
	private void deleteCustomerRow(ActionEvent event){
		int index = customerTable.getSelectionModel().getSelectedIndex();
		model.getCustomerList().remove(index);
	}

	@FXML
	private void computeCustomerInfo(ActionEvent event){
		Instant endTime = Instant.now();
		int index = customerTable.getSelectionModel().getSelectedIndex();
		Customer selectedCustomer =model.getCustomerList().get(index);
		selectedCustomer.setStopTime(endTime);
		selectedCustomer.setStopTimeString(endTime.toString());
	}

}
