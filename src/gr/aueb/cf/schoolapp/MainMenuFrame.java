package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection connection;

	/**
	 * Create the frame.
	 */
	public MainMenuFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenuFrame.class.getResource("/resources/eduv2.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				String sql = "jdbc:mysql://localhost:3306/shool6db?serverTimeZone=UTC";
				String username = "userdb6";
				String password = "1234";
				
				try {
				connection = DriverManager.getConnection(sql, username, password);
				System.out.println("Connection Succes");
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			}	
		});
		setTitle("Ποιότητα στην Εκπαίδευση");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 336);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator headerSeparator = new JSeparator();
		headerSeparator.setBounds(10, 61, 414, 1);
		contentPane.add(headerSeparator);
		
		JPanel header = new JPanel();
		header.setBackground(Color.BLUE);
		header.setBounds(0, 0, 457, 50);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Coding Factory");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(20, 11, 111, 14);
		header.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersMenuFrame().setVisible(true);
				Main.getMainmenuFrame().setEnabled(false);
			}
		});
		btnNewButton.setBounds(10, 91, 40, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Εκπαιδευτές");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(60, 91, 107, 40);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(10, 142, 40, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Εκπαιδευόμενοι");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(60, 142, 107, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel footer = new JPanel();
		footer.setBackground(Color.LIGHT_GRAY);
		footer.setBounds(0, 227, 457, 70);
		contentPane.add(footer);
		footer.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Εγχειρίδιο Χρήσης");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 24, 103, 21);
		footer.add(lblNewLabel_2);
		}
	public static Connection getConnection() {
		return connection;
	}
}
