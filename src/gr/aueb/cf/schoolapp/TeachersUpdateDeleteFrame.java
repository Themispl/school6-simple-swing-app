package gr.aueb.cf.schoolapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class TeachersUpdateDeleteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable teachersTable;
	private DefaultTableModel model = new DefaultTableModel();
	private JTextField lastnameSearchText;
	private JTextField idText;
	private JTextField firstnameText;
	private JTextField lastnameText;
	/**
	 * Create the frame.
	 */
	public TeachersUpdateDeleteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 555);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		teachersTable = new JTable();
		teachersTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Κωδικός", "Όνομα", "Επώνυμο"}
		));
		
		model = (DefaultTableModel)teachersTable.getModel();
		
		teachersTable.setBounds(26, 32, 315, 414);
		contentPane.add(teachersTable);
		
		JScrollPane scrollPane = new JScrollPane(teachersTable);
		scrollPane.setBounds(26, 32, 315, 414);
		contentPane.add(scrollPane);
		
		JLabel lastnameSearchLabel = new JLabel("Επώνυμο");
		lastnameSearchLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastnameSearchLabel.setBounds(26, 4, 71, 14);
		contentPane.add(lastnameSearchLabel);
		
		lastnameSearchText = new JTextField();
		lastnameSearchText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastnameSearchText.setBounds(107, 1, 234, 20);
		contentPane.add(lastnameSearchText);
		lastnameSearchText.setColumns(10);
		
		JButton btnSearch = new JButton("Αναζήτηση");
		btnSearch.setBounds(444, 1, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lbLabel = new JLabel("Κωδικός");
		lbLabel.setBounds(362, 62, 59, 14);
		contentPane.add(lbLabel);
		
		JLabel firstnameLabel = new JLabel("Όνομα");
		firstnameLabel.setBounds(362, 103, 59, 14);
		contentPane.add(firstnameLabel);
		
		JLabel lastnameLabel = new JLabel("Επώνυμο");
		lastnameLabel.setBounds(362, 148, 59, 14);
		contentPane.add(lastnameLabel);
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(420, 59, 153, 20);
		contentPane.add(idText);
		idText.setColumns(10);
		
		firstnameText = new JTextField();
		firstnameText.setColumns(10);
		firstnameText.setBounds(420, 100, 153, 20);
		contentPane.add(firstnameText);
		
		lastnameText = new JTextField();
		lastnameText.setColumns(10);
		lastnameText.setBounds(421, 145, 153, 20);
		contentPane.add(lastnameText);
		
		JLabel errorFirstname = new JLabel("");
		errorFirstname.setForeground(new Color(255, 0, 0));
		errorFirstname.setBounds(420, 123, 153, 20);
		contentPane.add(errorFirstname);
		
		JLabel errorLastname = new JLabel("");
		errorLastname.setBounds(420, 165, 153, 20);
		contentPane.add(errorLastname);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(351, 41, 234, 144);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton updateBtn = new JButton("Ενημέρωση");
		updateBtn.setBounds(362, 234, 89, 23);
		contentPane.add(updateBtn);
		
		JButton deleteBtn = new JButton("Διαγραφή");
		deleteBtn.setBounds(484, 234, 89, 23);
		contentPane.add(deleteBtn);
		
		JButton closeBtn = new JButton("Κλείσιμο");
		closeBtn.setBounds(488, 426, 89, 23);
		contentPane.add(closeBtn);
	}
	
	private void buildTable() {
		
		Vector<String> vector;
		try {
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM TEACHERS WHERE LASTNAME LIKE ?";
			PreparedStatement ps = MainMenuFrame.getConnection().prepareStatement(sql);
			ps.setString(1, lastnameSearchText.getText().trim() + "%");
			
			ResultSet rs = ps.executeQuery();//ektelei to query kai fernei tis egrafes
			
			//clear model -> clear table MVVM model
			for(int i = model.getRowCount() -1; i>= 0; i--) {
				model.removeRow(i);
			}
			
			while(rs.next()){
				vector = new Vector<>(3);
				vector.add(rs.getString("ID"));
				vector.add(rs.getString("FIRSTNAME"));
				vector.add(rs.getString("LASTNAME"));
				model.addRow(vector);
			}
			
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
}
