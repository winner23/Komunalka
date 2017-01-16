import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import net.proteanit.sql.DbUtils;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Komunal {

	private JFrame frame;
	private JTable table;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Komunal window = new Komunal();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	Connection connection = null;
	public Komunal() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private ResultSet getData(){
		connection = SQLiteConnection.dbConnector();
		try{
			String query = "SELECT services.Name, data.LastCount, data.PrevCount, (data.LastCount - data.PrevCount) AS Delta , services.Price, data.Date, data.debt,"
					+ " (services.price* (data.LastCount- data.PrevCount)) AS Value FROM services, data WHERE (data.ServID = services.ID)";
			PreparedStatement pst = connection.prepareStatement(query);
			return pst.executeQuery();
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	
	private ArrayList<String> getYears(){
		connection = SQLiteConnection.dbConnector();
		ArrayList<String> res = new ArrayList<String>();
		try{
			String query = "SELECT DISTINCT date FROM data";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			try {
				  while (rs.next()) {
				    String date = rs.getString(1);
				    res.add(date);
				  }
				} finally {
				  rs.close();
				}
			return res;
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Комунальні платежі");
		frame.setBounds(50, 50, 718, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 13, 664, 70);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Рік");
		panel_1.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setSize(50, 12);
		panel_1.add(comboBox);
				
		JButton btnNewButton = new JButton("Новий рік");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
						
			}
		});
		panel_1.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(Komunal.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details.png")));
				
		JLabel lblNewLabel_1 = new JLabel("Місяць");
		panel_1.add(lblNewLabel_1);
				
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setSize(50,12);
		panel_1.add(comboBox_1);
			
		JButton btnNewButton_1 = new JButton("Новий місяць");
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(Komunal.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		
		JButton btnNewButton_2 = new JButton("Послуги");
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Poslugy poslWindow = new Poslugy();
				poslWindow.setModal(true);
				poslWindow.setSize(450, 300);
				poslWindow.setLocationRelativeTo(null);
				poslWindow.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Komunal.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Numbered-rtl.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me){
				Month newM = new Month();
				newM.setSize(530, 366);
				newM.setLocationRelativeTo(null);
				newM.setVisible(true); 
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 95, 691, 316);
		frame.getContentPane().add(panel);		
		ResultSet rs = getData();
		TableModel tm = DbUtils.resultSetToTableModel(rs);
		
		table = new JTable();
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setModel(tm);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(118);
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setPreferredWidth(58);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(94);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setLocation(5, 5);
		scrollPane.setSize(680, 296);
		panel.add(scrollPane);
		
		ArrayList<String> elements = getYears();
		for( String d:elements){
			comboBox.addItem(d.split("\\.")[2]);
			comboBox_1.addItem(d.split("\\.")[1]);
		}
	}

}
