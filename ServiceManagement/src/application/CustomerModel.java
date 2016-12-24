package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerModel {

	private ArrayList<Customer> editableList = new ArrayList<>();
	private ObservableList<Customer> customerList = FXCollections.observableArrayList(editableList);
	
	
	
	public ArrayList<Customer> getEditableList() {
		return editableList;
	}



	public void setEditableList(ArrayList<Customer> editableList) {
		this.editableList = editableList;
	}



	public ObservableList<Customer> getCustomerList() {
		return customerList;
	}

	
}
