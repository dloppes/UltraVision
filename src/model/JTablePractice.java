package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class JTablePractice extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTablePractice frame = new JTablePractice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public JTablePractice() {

		connection conn = new connection();

		String[][] data = null;
		boolean rented = false;
		int row = 0;
		String[] columnNames = new String[] {"Title ID", "Title", "Season", "Format"};

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		data = new String[100][columnNames.length];

		String query = "Select * FROM TVBox WHERE rented = '" + rented + "'";
		ResultSet rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				System.out.println(rs.getString("titleID") + rs.getString("title") + rs.getString("season") + rs.getString("format"));
				
				data[row][0] = rs.getString("titleID");
				data[row][1] = rs.getString("title");
				data[row][2] = rs.getString("season");
				data[row][3] = rs.getString("format");
				
				row++;

			}

		} catch (Exception e) {

		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 73, 707, 184);
		contentPane.add(scrollPane);
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
	}
	
	

}
