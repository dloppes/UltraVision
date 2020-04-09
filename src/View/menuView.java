package View;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.menuController;
import interfaces.View;

public class menuView extends JFrame implements View {

	private menuController controllerInternalRef;

	public menuView(menuController controller) {
		
		this.controllerInternalRef = controller;
		attributeSetter();
		components();
		validation();
	}

	@Override
	public void attributeSetter() {
		// TODO Auto-generated method stub

		this.setVisible(true);
		this.setSize(600, 300);
		this.setTitle("System Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void components() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel();
		this.add(p);
// --------------------------------------------------Creating JMenu Bar---------------------------------------------------------------------------
		JMenuBar myMenuBar = new JMenuBar();
		this.setJMenuBar(myMenuBar);
// --------------------------------------------------Creating JMenu ------------------------------------------------------------------------------
		JMenu customer = new JMenu(" Customer ");
		JMenu titles = new JMenu(" Titles ");
		JMenu stock = new JMenu(" Stock ");
		JMenu logout = new JMenu(" Logout ");
		JMenuItem exit = new JMenuItem(" Exit ");
		logout.add(exit);
		exit.addActionListener((ActionListener) controllerInternalRef); // adding button to action listener
		exit.setActionCommand("logout");// setting the value that actives action command
// --------------------------------------------------Adding the JMenu into my JMenu Bar------------------------------------------------------------
		myMenuBar.add(customer);
		myMenuBar.add(titles);
		myMenuBar.add(stock);
		myMenuBar.add(logout);
// --------------------------------------------------Creating JMenuItems & Adding into JMenu-------------------------------------------------------
		JMenuItem newCustomer = new JMenuItem(" New Customer");
		newCustomer.addActionListener((ActionListener) controllerInternalRef); // adding button to action listener
		newCustomer.setActionCommand("newCustomer");// setting the value that actives action command

		JMenuItem updateCustomer = new JMenuItem(" Update Customer ");
		updateCustomer.addActionListener((ActionListener) controllerInternalRef); // adding button to action listener
		updateCustomer.setActionCommand("updateCustomer");// setting the value that actives action command

		customer.add(newCustomer);
		customer.add(updateCustomer);

		JMenuItem newTitle = new JMenuItem(" New Title ");
		newTitle.addActionListener((ActionListener) controllerInternalRef); // adding button to action listener
		newTitle.setActionCommand("newTitle");// setting the value that actives action command

		titles.add(newTitle);

		JMenuItem renting = new JMenuItem(" Renting ");
		renting.addActionListener((ActionListener) controllerInternalRef); // adding button to action listener
		renting.setActionCommand("renting");// setting the value that actives action command

		JMenuItem returning = new JMenuItem(" Renturning ");
		returning.addActionListener((ActionListener) controllerInternalRef); // adding button to action listener
		returning.setActionCommand("returning");// setting the value that actives action command

		stock.add(renting);
		stock.add(returning);

	}
	// ------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public void validation() {
		// TODO Auto-generated method stub

		this.validate();
		this.repaint();

	}

}
