package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class TotalPointsView extends JFrame {

	private JPanel contentPane;
	private JTextField pointsTextField;
	private int numberOfPoints;

	public TotalPointsView(int numberOfPoints) {
		
		this.numberOfPoints = numberOfPoints;
		String points = Integer.toString(this.numberOfPoints);
		
		
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 713, 312);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TotalPointsView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-145, 0, 515, 141);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotalOfPoints = new JLabel("  TOTAL OF POINTS");
		lblTotalOfPoints.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTotalOfPoints.setForeground(new Color(189, 183, 107));
		lblTotalOfPoints.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTotalOfPoints.setBounds(436, 44, 236, 46);
		contentPane.add(lblTotalOfPoints);
		
		pointsTextField = new JTextField();
		pointsTextField.setFont(new Font("Verdana", Font.BOLD, 25));
		pointsTextField.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		pointsTextField.setBounds(148, 154, 406, 60);
		contentPane.add(pointsTextField);
		pointsTextField.setColumns(10);
		pointsTextField.setText(points);
		
		frame.validate();
		frame.repaint();
	}
}
