package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.NewCustomerView;
import model.Customer;

public class NewCustomerController implements ActionListener{

	NewCustomerView newCustomerView;
	
	
	public NewCustomerController() {
		
		newCustomerView = new NewCustomerView(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String fName = newCustomerView.getFirstName();
        String lName = newCustomerView.getLastName();
        String email = newCustomerView.getEmail();
        String phoneNumber = newCustomerView.getPhoneNumber();
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
