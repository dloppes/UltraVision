package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.newCustomerView;
import model.Customer;

public class newCustomerController implements ActionListener{

	newCustomerView newCustomerView;
	
	
	public newCustomerController() {
		
		newCustomerView = new newCustomerView(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String fName = newCustomerView.getFirstName();
        String lName = newCustomerView.getLastName();
        String email = newCustomerView.getEmail();
        int phoneNumber = newCustomerView.getPhoneNumber();
        String cardNumber = newCustomerView.getCardNumber();
        String plan = newCustomerView.getPlan();
		
		Customer customer = new Customer(fName, lName, phoneNumber, email, cardNumber, plan);
		
		if(e.getActionCommand().equals("create")) {
			
			Customer.newCustomer customermodel = customer.new newCustomer();
			
			boolean newCustomer = customermodel.insertNewCustomer(customer);
			
			if(newCustomer) {
				newCustomerView.dispose();
				customermodel.newLoyaltyCard(customer);
				JOptionPane.showMessageDialog(null,"New Customer " +  customer.getEmail() +  " Successfully Created!");
			}
		}
	}
}
