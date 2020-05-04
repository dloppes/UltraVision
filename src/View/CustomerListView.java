package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.LineBorder;

import controller.UpdateCustomerController;
import model.connection;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
 * 
 * @author Daniel Lopes
 *
 *         This View will display a combox in which will have the customer
 *         objects so the customer can select in order to update its details.
 */
public class CustomerListView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private connection conn;
	private ResultSet rs;
	public String selectedCustomerID;
	private JComboBox<Object> customerComboBox;
	private JButton selectButton;
	private JFrame frame;
	private JLabel customerLabel;

	public CustomerListView() {

		components();
		populateComboBox();

	}

	public void components() {

		frame = new JFrame();

		frame.setVisible(true);

		frame.setTitle("Customer List");
		frame.setBounds(100, 100, 657, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CustomerListView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-139, 0, 580, 159);
		contentPane.add(lblNewLabel);

		customerComboBox = new JComboBox<Object>();
		customerComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		customerComboBox.setBounds(50, 172, 448, 38);
		contentPane.add(customerComboBox);

		selectButton = new JButton("Select");
		selectButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		selectButton.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		selectButton.setBounds(510, 172, 97, 38);
		contentPane.add(selectButton);
		selectButton.addActionListener(this);
		selectButton.setActionCommand("select");

		customerLabel = new JLabel(" CUSTOMER LIST");
		customerLabel.setForeground(Color.WHITE);
		customerLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		customerLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		customerLabel.setBackground(Color.BLACK);
		customerLabel.setBounds(403, 46, 204, 59);
		contentPane.add(customerLabel);

	}

	public void populateComboBox() {

		/*
		 * this method searches for all customers that are available in the database and
		 * populates the JCombobox
		 */

		conn = new connection();

		String query = "Select * FROM customer";
		rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				try {
					customerComboBox.addItem(
							rs.getString("customerID") + " " + rs.getString("fName") + " " + rs.getString("lName"));
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * Once customer is selected I am getting only the ID from the combobox field
		 * Having the ID I can therefore pass it to the update Customer Controller
		 */

		try {
			selectedCustomerID = customerComboBox.getSelectedItem().toString();
			selectedCustomerID = selectedCustomerID.split(" ")[0];

			String query = "Select * FROM customer WHERE customerID = '" + selectedCustomerID + "'";
			rs = conn.executeQuery(query);

			while (rs.next()) {
				rs.getString("fName");
				rs.getString("lName");
				rs.getString("email");
				rs.getString("cardNumber");
				rs.getString("plan");
				rs.getString("phoneNumber");

			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerListView.class.getName()).log(Level.SEVERE, null, ex);
		}

		String ac = e.getActionCommand();
		if (ac.equals("select")) {
			frame.dispose();
			try {
				new UpdateCustomerController(selectedCustomerID);
			} catch (ParseException e1) {

				e1.printStackTrace();
			}
		}

	}
}