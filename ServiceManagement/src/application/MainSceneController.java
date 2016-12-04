package application;

import java.time.Instant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainSceneController {

	ObservableList<String> machineName = FXCollections.observableArrayList("ps4", "xbox one", "ps3", "xbox 360", "ps2");

	ObservableList<Customer> customerList = FXCollections.observableArrayList();

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
	
	

	public MainSceneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@FXML
	private void initialize() {
		machineDropdown.setValue("ps4");
		machineDropdown.setItems(machineName);
		customerTable.setItems(customerList);
		columnBinding();
	}
	
	@FXML
	private void EntryButtonAction( ActionEvent event){
		String name = nameInput.getText();
		String machine = machineDropdown.getSelectionModel().getSelectedItem();
		Instant startTime = Instant.now();
		
		customerList.add(new Customer(name,machine,startTime,startTime.toString()));
		
		timeInput.setText(startTime.toString());
		
		
	}
	
	private void columnBinding(){
		nameCol.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
		machineNameCol.setCellValueFactory(new PropertyValueFactory<Customer,String>("machineName"));
		startTimeCol.setCellValueFactory(new PropertyValueFactory<Customer,String>("startTimeString"));
	}
	

}
