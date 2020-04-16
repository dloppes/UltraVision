package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.NewCustomerView;
import model.Customer;
import model.Queries;
import model.Queries.customerClass;

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
			
			Queries newCustomerQuery = new Queries();
			
			customerClass newCustomer = newCustomerQuery.new customerClass();
			
			boolean newCustomerBoolean = newCustomer.insertNewCustomer(customer);
			
			
			if(newCustomerBoolean) {
				newCustomerView.dispose();
				newCustomer.newLoyaltyCard(customer);
				JOptionPane.showMessageDialog(null,"New Customer " +  customer.getEmail() +  " Successfully Created!");
			}
		}
	}
}
