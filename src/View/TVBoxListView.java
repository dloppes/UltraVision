package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TVBoxListView extends JFrame {

	private JPanel contentPane;


	public TVBoxListView() {
		
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 657, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoLabel = new JLabel("New label");
		logoLabel.setIcon(new ImageIcon(TVBoxListView.class.getResource("/img/logo3-removebg-preview.png")));
		logoLabel.setBounds(-136, 0, 458, 145);
		contentPane.add(logoLabel);
		
		JLabel lblTvBoxList = new JLabel("    TV BOX LIST");
		lblTvBoxList.setForeground(Color.WHITE);
		lblTvBoxList.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTvBoxList.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTvBoxList.setBackground(Color.BLACK);
		lblTvBoxList.setBounds(398, 40, 204, 59);
		contentPane.add(lblTvBoxList);
		
		JComboBox<Object> tvBoxListComboBox = new JComboBox<Object>();
		tvBoxListComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		tvBoxListComboBox.setBounds(28, 172, 448, 38);
		contentPane.add(tvBoxListComboBox);
		
		JButton selectButton = new JButton("Select");
		selectButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		selectButton.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		selectButton.setActionCommand("select");
		selectButton.setBounds(488, 172, 114, 38);
		contentPane.add(selectButton);
	}

}
