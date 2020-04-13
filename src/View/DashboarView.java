package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.DashboardController;

public class DashboarView extends JFrame {
	
	private JPanel contentPane;
	private DashboardController controllerInternalRef;
	
	public DashboarView(DashboardController controller) {
		
		this.controllerInternalRef = controller;
		
		components();
		
	}
		public void components() {
			
		
		
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 933, 567);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setIgnoreRepaint(true);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-136, -11, 510, 144);
		lblNewLabel.setIcon(new ImageIcon(DashboarView.class.getResource("/img/logo3-removebg-preview.png")));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(712, 30, 218, 62);
		lblNewLabel_1.setIcon(new ImageIcon(DashboarView.class.getResource("/img/dashboard.png")));
		contentPane.add(lblNewLabel_1);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 138, 890, 117);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 894, 117);
		panel.add(menuBar);
		
		JMenu mnCustomer = new JMenu("Customer");
		mnCustomer.setBackground(Color.BLACK);
		mnCustomer.setBorder(new LineBorder(null, 2, true));
		mnCustomer.setIcon(new ImageIcon(DashboarView.class.getResource("/img/customer.png")));
		mnCustomer.setFont(new Font("Verdana", Font.BOLD, 20));
		menuBar.add(mnCustomer);
		
		JMenuItem mntmNewCustomer = new JMenuItem("New Customer");
		mntmNewCustomer.setIcon(new ImageIcon(DashboarView.class.getResource("/img/new_customer_icon.png")));
		mntmNewCustomer.setBorder(new LineBorder(Color.WHITE, 1, true));
		mntmNewCustomer.setBackground(Color.WHITE);
		mntmNewCustomer.setFont(new Font("Verdana", Font.BOLD, 18));
		mnCustomer.add(mntmNewCustomer);
		mntmNewCustomer.addActionListener((ActionListener)controllerInternalRef);
		mntmNewCustomer.setActionCommand("newCustomer");
		
		JMenuItem mntmUpdateCustomer = new JMenuItem("Update Customer");
		mntmUpdateCustomer.setIcon(new ImageIcon(DashboarView.class.getResource("/img/updateCustomerIcon.png")));
		mntmUpdateCustomer.setFont(new Font("Verdana", Font.BOLD, 18));
		mntmUpdateCustomer.setBorder(new LineBorder(Color.WHITE, 1, true));
		mnCustomer.add(mntmUpdateCustomer);
		mntmUpdateCustomer.addActionListener((ActionListener)controllerInternalRef);
		mntmUpdateCustomer.setActionCommand("updateCustomer");
		
		JMenu mnNewMenu = new JMenu("Titles");
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setIcon(new ImageIcon(DashboarView.class.getResource("/img/titles.png")));
		mnNewMenu.setFont(new Font("Verdana", Font.BOLD, 20));
		mnNewMenu.setBorder(new LineBorder(Color.WHITE, 2, true));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMusic = new JMenuItem("New Music");
		mntmNewMusic.setIcon(new ImageIcon(DashboarView.class.getResource("/img/music_menu_icon.png")));
		mntmNewMusic.setFont(new Font("Verdana", Font.BOLD, 18));
		mntmNewMusic.setBorder(new LineBorder(Color.WHITE, 1, true));
		mnNewMenu.add(mntmNewMusic);
		mntmNewMusic.addActionListener((ActionListener)controllerInternalRef);
		mntmNewMusic.setActionCommand("newTitle");
		
		JMenuItem mntmNewMovie = new JMenuItem("New Movie");
		mntmNewMovie.setIcon(new ImageIcon(DashboarView.class.getResource("/img/movies_menu_icon.png")));
		mntmNewMovie.setFont(new Font("Verdana", Font.BOLD, 18));
		mnNewMenu.add(mntmNewMovie);
		
		JMenuItem mntmNewLiveConcert = new JMenuItem("New Live Concert");
		mntmNewLiveConcert.setIcon(new ImageIcon(DashboarView.class.getResource("/img/liveCOncert_menu_icon.png")));
		mntmNewLiveConcert.setFont(new Font("Verdana", Font.BOLD, 18));
		mnNewMenu.add(mntmNewLiveConcert);
		
		JMenuItem mntmNewTvBox = new JMenuItem("New TV BOX");
		mntmNewTvBox.setIcon(new ImageIcon(DashboarView.class.getResource("/img/tvBox_menu_icon.png")));
		mntmNewTvBox.setFont(new Font("Verdana", Font.BOLD, 18));
		mnNewMenu.add(mntmNewTvBox);
		
		JMenu mnStock = new JMenu("Stock");
		mnStock.setIcon(new ImageIcon(DashboarView.class.getResource("/img/stock_icon.png")));
		mnStock.setFont(new Font("Verdana", Font.BOLD, 20));
		mnStock.setBorder(new LineBorder(Color.WHITE, 2, true));
		mnStock.setBackground(Color.WHITE);
		menuBar.add(mnStock);
		
		JMenuItem mntmAvailable = new JMenuItem("Available");
		mntmAvailable.setIcon(new ImageIcon(DashboarView.class.getResource("/img/available_icon..png")));
		mntmAvailable.setFont(new Font("Verdana", Font.BOLD, 18));
		mntmAvailable.setBorder(new LineBorder(Color.WHITE, 1, true));
		mnStock.add(mntmAvailable);
		mntmAvailable.addActionListener((ActionListener)controllerInternalRef);
		mntmAvailable.setActionCommand("titlesAvailable");
		
		JMenuItem mntmRented = new JMenuItem("Rented");
		mntmRented.setIcon(new ImageIcon(DashboarView.class.getResource("/img/rented_icon.png")));
		mntmRented.setFont(new Font("Verdana", Font.BOLD, 18));
		mntmRented.setBorder(new LineBorder(Color.WHITE, 1, true));
		mntmRented.setBackground(Color.BLACK);
		mnStock.add(mntmRented);
		mntmRented.addActionListener((ActionListener)controllerInternalRef);
		mntmRented.setActionCommand("titlesRented");
		
		JMenu mnNewMenu_1 = new JMenu("Loyalty Card");
		mnNewMenu_1.setIcon(new ImageIcon(DashboarView.class.getResource("/img/loyaltycard_menu_icon.png")));
		mnNewMenu_1.setFont(new Font("Verdana", Font.BOLD, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCheckPoints = new JMenuItem("Check Points");
		mntmCheckPoints.setIcon(new ImageIcon(DashboarView.class.getResource("/img/checkPoints_menu_icon.png")));
		mntmCheckPoints.setFont(new Font("Verdana", Font.BOLD, 18));
		mnNewMenu_1.add(mntmCheckPoints);
		
		JMenu mnRent = new JMenu("Rent");
		mnRent.setIcon(new ImageIcon(DashboarView.class.getResource("/img/rent_icon_menu.png")));
		mnRent.setFont(new Font("Verdana", Font.BOLD, 20));
		menuBar.add(mnRent);
		
		JMenuItem mntmRentMusic = new JMenuItem("Rent Music");
		mntmRentMusic.setIcon(new ImageIcon(DashboarView.class.getResource("/img/music_menu_icon.png")));
		mntmRentMusic.setFont(new Font("Verdana", Font.BOLD, 18));
		mnRent.add(mntmRentMusic);
		
		JMenuItem mntmRentMovie = new JMenuItem("Rent Movie");
		mntmRentMovie.setIcon(new ImageIcon(DashboarView.class.getResource("/img/movies_menu_icon.png")));
		mntmRentMovie.setFont(new Font("Verdana", Font.BOLD, 18));
		mnRent.add(mntmRentMovie);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Rent Live Concert");
		mntmNewMenuItem_1.setIcon(new ImageIcon(DashboarView.class.getResource("/img/liveCOncert_menu_icon.png")));
		mntmNewMenuItem_1.setFont(new Font("Verdana", Font.BOLD, 18));
		mnRent.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Rent TV BOX");
		mntmNewMenuItem.setIcon(new ImageIcon(DashboarView.class.getResource("/img/tvBox_menu_icon.png")));
		mntmNewMenuItem.setFont(new Font("Verdana", Font.BOLD, 18));
		mnRent.add(mntmNewMenuItem);
		
		JMenu mnLogout = new JMenu("Logout");
		mnLogout.setIcon(new ImageIcon(DashboarView.class.getResource("/img/logout_icon.png")));
		mnLogout.setFont(new Font("Verdana", Font.BOLD, 20));
		mnLogout.setBorder(new LineBorder(Color.WHITE, 1, true));
		menuBar.add(mnLogout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(DashboarView.class.getResource("/img/exit_icon.png")));
		mntmExit.setFont(new Font("Verdana", Font.BOLD, 18));
		mntmExit.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		mnLogout.add(mntmExit);
		mntmExit.addActionListener((ActionListener)controllerInternalRef);
		mntmExit.setActionCommand("exit");
		
		frame.validate();
		frame.repaint();
		
		
		
	}
}
