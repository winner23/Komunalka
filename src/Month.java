import javax.swing.JApplet;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class Month extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1708696877353784057L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JLabel label;

	
	public Month() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setResizable(false);
		setTitle("Показники за місяць");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JLabel label_6 = new JLabel("Тепер. Показник");
		label_6.setBounds(116, 11, 85, 14);
		panel_8.add(label_6);
		
		JLabel label_7 = new JLabel("Попередн. Показник");
		label_7.setBounds(222, 11, 110, 14);
		panel_8.add(label_7);
		
		label = new JLabel("Тип послуги");
		label.setBounds(10, 11, 96, 14);
		panel_8.add(label);
		
		JLabel label_2 = new JLabel("Різниця");
		label_2.setBounds(342, 11, 46, 14);
		panel_8.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox_f = new JComboBox();
		comboBox_f.setBounds(6, 6, 100, 20);
		panel.add(comboBox_f);
		
		textField = new JTextField();
		textField.setBounds(116, 6, 86, 20);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setBounds(212, 6, 86, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnNewButton.setBounds(301, 5, 28, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("0000");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(340, 9, 51, 14);
		panel.add(lblNewLabel_1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 6, 86, 20);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBounds(212, 6, 86, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(6, 6, 100, 20);
		panel_1.add(comboBox);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		button.setBounds(301, 5, 28, 23);
		panel_1.add(button);
		
		JLabel label_3 = new JLabel("0000");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(340, 8, 51, 14);
		panel_1.add(label_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.GRAY);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 6, 86, 20);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setBounds(212, 6, 86, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(6, 6, 100, 20);
		panel_2.add(comboBox_1);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		button_1.setBounds(301, 5, 28, 23);
		panel_2.add(button_1);
		
		JLabel label_4 = new JLabel("0000");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(340, 8, 51, 14);
		panel_2.add(label_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.GRAY);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(116, 6, 86, 20);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		panel_3.add(textField_3);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBounds(212, 6, 86, 20);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(6, 6, 100, 20);
		panel_3.add(comboBox_2);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		button_2.setBounds(301, 5, 28, 23);
		panel_3.add(button_2);
		
		JLabel label_5 = new JLabel("0000");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(340, 8, 51, 14);
		panel_3.add(label_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(Color.GRAY);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBounds(116, 6, 86, 20);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		panel_4.add(textField_4);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setBounds(212, 6, 86, 20);
		panel_4.add(textField_11);
		textField_11.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(6, 6, 100, 20);
		panel_4.add(comboBox_3);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		button_3.setBounds(301, 5, 28, 23);
		panel_4.add(button_3);
		
		JLabel label_8 = new JLabel("0000");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(340, 8, 51, 14);
		panel_4.add(label_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(Color.GRAY);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setBounds(116, 6, 86, 20);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		panel_5.add(textField_5);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setBounds(212, 6, 86, 20);
		panel_5.add(textField_12);
		textField_12.setColumns(10);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(6, 6, 100, 20);
		panel_5.add(comboBox_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		button_5.setBounds(301, 5, 28, 23);
		panel_5.add(button_5);
		
		JLabel label_9 = new JLabel("0000");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(340, 8, 51, 14);
		panel_5.add(label_9);
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(Color.GRAY);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setBounds(116, 6, 86, 20);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		panel_7.add(textField_6);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setBounds(212, 6, 86, 20);
		panel_7.add(textField_13);
		textField_13.setColumns(10);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(6, 6, 100, 20);
		panel_7.add(comboBox_5);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		button_4.setBounds(301, 5, 28, 23);
		panel_7.add(button_4);
		
		JLabel label_10 = new JLabel("0000");
		label_10.setForeground(Color.BLUE);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(340, 8, 51, 14);
		panel_7.add(label_10);
		
		JPanel panel_6 = new JPanel();
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(194, 6, 89, 23);
		panel_6.add(btnEnter);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new SimpleDateFormat("MM-yyyy"));
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextField.setColumns(7);
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		formattedTextField.setValue(new Date());
		formattedTextField.setBounds(79, 9, 94, 20);
		panel_6.add(formattedTextField);
		
		JLabel label_1 = new JLabel("Місяць:");
		label_1.setBounds(23, 12, 46, 14);
		panel_6.add(label_1);
		
		//List posluga for ComboBoxes
		comboBox.addItem(" ");
		comboBox_1.addItem(" ");
		comboBox_2.addItem(" ");
		comboBox_3.addItem(" ");
		comboBox_4.addItem(" ");
		comboBox_5.addItem(" ");
		comboBox_f.addItem(" ");
		ArrayList<String> poslug = getPoslugy(2);
		int size = poslug.size();
		for(String el:poslug){
			comboBox.addItem(el);
			comboBox_1.addItem(el);
			comboBox_2.addItem(el);
			comboBox_3.addItem(el);
			comboBox_4.addItem(el);
			comboBox_5.addItem(el);
			comboBox_f.addItem(el);
		}
		

	}
	private ArrayList<String> getPoslugy(int column){
		Connection connection = SQLiteConnection.dbConnector();
		ArrayList<String> res = new ArrayList<String>();
		try{
			String query = "SELECT * FROM services";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			try {
				  while (rs.next()) {
				    String date = rs.getString(column);
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
}
