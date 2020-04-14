package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.UpdateCustomerView;
import model.Customer;

public class UpdateCustomerController implements ActionListener {

	UpdateCustomerView UpdateCustomerView;
	Customer customer;
	private String userID;

	public UpdateCustomerController(String userID) {

		this.userID = userID;
		this.UpdateCustomerView = new UpdateCustomerView(this, userID);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String ac = e.getActionCommand();
		if(ac.equals("update")){
			
		

		String fName = UpdateCustomerView.getFirstName();
		String lName = UpdateCustomerView.getLastName();
		String email = UpdateCustomerView.getEmail();
		String cardNumber = UpdateCustomerView.getCardNumber();
		String plan = UpdateCustomerView.getPlan();
		String phoneNumber = UpdateCustomerView.getPhoneNumber();

		Customer customer = new Customer(fName, lName, phoneNumber, email, plan, cardNumber );

		Customer.updateCustomer updateCustomer = customer.new updateCustomer();

		boolean updatedCustomer = updateCustomer.updateCustomerDetails(customer, userID);

		if (updatedCustomer) {

			this.UpdateCustomerView.dispose();
			JOptionPane.showMessageDialog(null, customer.getfName() + " " + customer.getlName() + " Updated Successfuly!");

		} else {
			JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");

		}

	}
	}

}
