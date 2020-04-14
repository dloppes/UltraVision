package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import View.UpdateCustomerView;
import model.Customer;
import model.connection;

public class UpdateCustomerController implements ActionListener {

	UpdateCustomerView UpdateCustomerView;
	Customer customer;
	private ResultSet rs;
	connection conn;
	private String userID;

	public UpdateCustomerController(String userID) {
		
		this.userID = userID;
		this.customer = getCustomerDetails(userID);
		this.UpdateCustomerView = new UpdateCustomerView(this, customer);
		
		
	}
		
		
		public Customer getCustomerDetails(String userID) {

			String fName = "";
			String lName = "";
			String email = "";
			String cardNumber = "";
			String phoneNumber = "";
			String plan = "";

			try {
				conn = new connection();

				String query = "Select * FROM customer WHERE customerID = '" + userID + "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					fName = rs.getString("fName");
					lName = rs.getString("lName");
					email = rs.getString("email");
					cardNumber = rs.getString("cardNumber");
					phoneNumber = rs.getString("phoneNumber");
					plan = rs.getString("plan");
				}
			} catch (Exception e) {
				System.out.println("SOmething went wrong");
			}

			customer = new Customer(fName, lName, phoneNumber, email, plan, cardNumber );

			return customer;

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
