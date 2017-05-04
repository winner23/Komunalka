import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import org.threeten.bp.DayOfWeek;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Month extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1708696877353784057L;
	private JFormattedTextField tPokaz_1;
	private JFormattedTextField tPokaz_2;
	private JFormattedTextField tPokaz_3;
	private JFormattedTextField tPokaz_4;
	private JFormattedTextField tPokaz_5;
	private JFormattedTextField tPokaz_6;
	private JFormattedTextField tPokaz_7;
	private JTextField pPokaz_1;
	private JTextField pPokaz_2;
	private JTextField pPokaz_3;
	private JTextField pPokaz_4;
	private JTextField pPokaz_5;
	private JTextField pPokaz_6;
	private JTextField pPokaz_7;
	private DatePicker month;
	private ArrayList<KOServices> poslug;

	
	public Month() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setResizable(false);
		setModal(true);
		setTitle("Показники за місяць");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_header = new JPanel();
		getContentPane().add(panel_header);
		panel_header.setLayout(null);
		
		JLabel labelTitle_1 = new JLabel("Тип послуги");
		labelTitle_1.setBounds(10, 11, 96, 14);
		panel_header.add(labelTitle_1);
		
		JLabel labelTitle_2 = new JLabel("Тепер. Показник");
		labelTitle_2.setBounds(136, 11, 85, 14);
		panel_header.add(labelTitle_2);
		
		JLabel labelTitle_3 = new JLabel("Попередн. Показник");
		labelTitle_3.setBounds(232, 11, 110, 14);
		panel_header.add(labelTitle_3);
		
		JLabel labelTitle_4 = new JLabel("Різниця");
		labelTitle_4.setBounds(362, 11, 46, 14);
		panel_header.add(labelTitle_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setName("p1");
		panel_1.setForeground(Color.GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItemListener(new ItemListener() {
			

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String selected = (String) comboBox_1.getSelectedItem();
				Integer id = getIDbyName(selected);
				String type="";
				for(KOServices el:poslug){
					if(el.getiD()==id){
						type=el.getType();
					}
				}
				if(type=="2"){
					tPokaz_1.setEditable(false);
					pPokaz_1.setEditable(false);
					
				}
				if(type=="1"){
					tPokaz_1.setEditable(true);
					pPokaz_1.setEditable(true);
				}
				
			}
		});
		
		comboBox_1.setBounds(6, 6, 120, 20);
		panel_1.add(comboBox_1);
		
		NumberFormat formatCounter = NumberFormat.getIntegerInstance();
		formatCounter.setMinimumIntegerDigits(0);
		formatCounter.setMaximumFractionDigits(7);
		
		NumberFormatter formatterCounter = new NumberFormatter(formatCounter);
		formatterCounter.setAllowsInvalid(false);
		
		tPokaz_1 = new JFormattedTextField(formatterCounter);
		tPokaz_1.setBounds(136, 6, 86, 20);
		tPokaz_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tPokaz_1);
		tPokaz_1.setColumns(10);
		
		pPokaz_1 = new JTextField();
		pPokaz_1.setHorizontalAlignment(SwingConstants.CENTER);
		pPokaz_1.setBounds(232, 6, 86, 20);
		panel_1.add(pPokaz_1);
		pPokaz_1.setColumns(10);
		
		
		
		JButton bUpdate_1 = new JButton("");
		bUpdate_1.setName("bUpdate_1");
		bUpdate_1.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		bUpdate_1.setBounds(321, 5, 28, 23);
		panel_1.add(bUpdate_1);
		
		
		JLabel difLabel_1 = new JLabel("0000");
		difLabel_1.setForeground(Color.BLUE);
		difLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		difLabel_1.setBounds(360, 9, 51, 14);
		panel_1.add(difLabel_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setName("p2");
		panel_2.setForeground(Color.GRAY);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		tPokaz_2 = new JFormattedTextField(formatterCounter);
		tPokaz_2.setBounds(136, 6, 86, 20);
		tPokaz_2.setHorizontalAlignment(SwingConstants.CENTER);
		tPokaz_2.setColumns(10);
		panel_2.add(tPokaz_2);
		
		pPokaz_2 = new JTextField();
		pPokaz_2.setHorizontalAlignment(SwingConstants.CENTER);
		pPokaz_2.setBounds(232, 6, 86, 20);
		panel_2.add(pPokaz_2);
		pPokaz_2.setColumns(10);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(6, 6, 120, 20);
		panel_2.add(comboBox_2);
		
		JButton bUpdate_2 = new JButton("");
		bUpdate_2.setName("bUpdate_2");
		bUpdate_2.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		bUpdate_2.setBounds(321, 5, 28, 23);
		panel_2.add(bUpdate_2);
		
		JLabel difLabel_2 = new JLabel("0000");
		difLabel_2.setForeground(Color.BLUE);
		difLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		difLabel_2.setBounds(360, 8, 51, 14);
		panel_2.add(difLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setName("p3");
		panel_3.setForeground(Color.GRAY);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		tPokaz_3 = new JFormattedTextField(formatterCounter);
		tPokaz_3.setBounds(136, 6, 86, 20);
		tPokaz_3.setHorizontalAlignment(SwingConstants.CENTER);
		tPokaz_3.setColumns(10);
		panel_3.add(tPokaz_3);
		
		pPokaz_3 = new JTextField();
		pPokaz_3.setHorizontalAlignment(SwingConstants.CENTER);
		pPokaz_3.setBounds(232, 6, 86, 20);
		panel_3.add(pPokaz_3);
		pPokaz_3.setColumns(10);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setBounds(6, 6, 120, 20);
		panel_3.add(comboBox_3);
		
		JButton bUpdate_3 = new JButton("");
		bUpdate_3.setName("bUpdate_3");
		bUpdate_3.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		bUpdate_3.setBounds(321, 5, 28, 23);
		panel_3.add(bUpdate_3);
		
		JLabel difLabel_3 = new JLabel("0000");
		difLabel_3.setForeground(Color.BLUE);
		difLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		difLabel_3.setBounds(360, 8, 51, 14);
		panel_3.add(difLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setName("p4");
		panel_4.setForeground(Color.GRAY);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		tPokaz_4 = new JFormattedTextField(formatterCounter);
		tPokaz_4.setBounds(136, 6, 86, 20);
		tPokaz_4.setHorizontalAlignment(SwingConstants.CENTER);
		tPokaz_4.setColumns(10);
		panel_4.add(tPokaz_4);
		
		pPokaz_4 = new JTextField();
		pPokaz_4.setHorizontalAlignment(SwingConstants.CENTER);
		pPokaz_4.setBounds(232, 6, 86, 20);
		panel_4.add(pPokaz_4);
		pPokaz_4.setColumns(10);
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setBounds(6, 6, 120, 20);
		panel_4.add(comboBox_4);
		
		JButton bUpdate_4 = new JButton("");
		bUpdate_4.setName("bUpdate_4");
		bUpdate_4.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		bUpdate_4.setBounds(321, 5, 28, 23);
		panel_4.add(bUpdate_4);
		
		JLabel difLabel_4 = new JLabel("0000");
		difLabel_4.setForeground(Color.BLUE);
		difLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		difLabel_4.setBounds(360, 8, 51, 14);
		panel_4.add(difLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setName("p5");
		panel_5.setForeground(Color.GRAY);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		tPokaz_5 = new JFormattedTextField(formatterCounter);
		tPokaz_5.setBounds(136, 6, 86, 20);
		tPokaz_5.setHorizontalAlignment(SwingConstants.CENTER);
		tPokaz_5.setColumns(10);
		panel_5.add(tPokaz_5);
		
		pPokaz_5 = new JTextField();
		pPokaz_5.setHorizontalAlignment(SwingConstants.CENTER);
		pPokaz_5.setBounds(232, 6, 86, 20);
		panel_5.add(pPokaz_5);
		pPokaz_5.setColumns(10);
		
		JComboBox<String> comboBox_5 = new JComboBox<String>();
		comboBox_5.setBounds(6, 6, 120, 20);
		panel_5.add(comboBox_5);
		
		JButton bUpdate_5 = new JButton("");
		bUpdate_5.setName("bUpdate_5");
		bUpdate_5.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		bUpdate_5.setBounds(321, 5, 28, 23);
		panel_5.add(bUpdate_5);
		
		JLabel difLabel_5 = new JLabel("0000");
		difLabel_5.setForeground(Color.BLUE);
		difLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		difLabel_5.setBounds(360, 8, 51, 14);
		panel_5.add(difLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setName("p6");
		panel_6.setForeground(Color.GRAY);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		tPokaz_6 = new JFormattedTextField(formatterCounter);
		tPokaz_6.setBounds(136, 6, 86, 20);
		tPokaz_6.setHorizontalAlignment(SwingConstants.CENTER);
		tPokaz_6.setColumns(10);
		panel_6.add(tPokaz_6);
		
		pPokaz_6 = new JTextField();
		pPokaz_6.setHorizontalAlignment(SwingConstants.CENTER);
		pPokaz_6.setBounds(232, 6, 86, 20);
		panel_6.add(pPokaz_6);
		pPokaz_6.setColumns(10);
		
		JComboBox<String> comboBox_6 = new JComboBox<String>();
		comboBox_6.setBounds(6, 6, 120, 20);
		panel_6.add(comboBox_6);
		
		JButton bUpdate_6 = new JButton("");
		bUpdate_6.setName("bUpdate_6");
		bUpdate_6.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		bUpdate_6.setBounds(321, 5, 28, 23);
		panel_6.add(bUpdate_6);
		
		JLabel difLabel_6 = new JLabel("0000");
		difLabel_6.setForeground(Color.BLUE);
		difLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		difLabel_6.setBounds(360, 8, 51, 14);
		panel_6.add(difLabel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setName("p7");
		panel_7.setForeground(Color.GRAY);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		tPokaz_7 = new JFormattedTextField(formatterCounter);
		tPokaz_7.setBounds(136, 6, 86, 20);
		tPokaz_7.setHorizontalAlignment(SwingConstants.CENTER);
		tPokaz_7.setColumns(10);
		panel_7.add(tPokaz_7);
		
		pPokaz_7 = new JTextField();
		pPokaz_7.setHorizontalAlignment(SwingConstants.CENTER);
		pPokaz_7.setBounds(232, 6, 86, 20);
		panel_7.add(pPokaz_7);
		pPokaz_7.setColumns(10);
		
		JComboBox<String> comboBox_7 = new JComboBox<String>();
		comboBox_7.setBounds(6, 6, 120, 20);
		panel_7.add(comboBox_7);
		
		JButton bUpdate_7 = new JButton("");
		bUpdate_7.setName("bUpdate_7");
		bUpdate_7.setIcon(new ImageIcon(Month.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		bUpdate_7.setBounds(321, 5, 28, 23);
		panel_7.add(bUpdate_7);
		
		JLabel difLabel_7 = new JLabel("0000");
		difLabel_7.setForeground(Color.BLUE);
		difLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		difLabel_7.setBounds(360, 8, 51, 14);
		panel_7.add(difLabel_7);
		
		JPanel panelControl = new JPanel();
		getContentPane().add(panelControl);
		panelControl.setLayout(null);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(222, 7, 89, 23);
		panelControl.add(btnEnter);
		
		DatePickerSettings settin = new DatePickerSettings(getLocale());
		settin.setFirstDayOfWeek(DayOfWeek.MONDAY);
		settin.setFormatForDatesCommonEra("dd-MM-yyyy");
		//settin.setFormatForDatesBeforeCommonEra("01-mm-uuuu");*/
				
		month = new DatePicker(settin);
		month.setDateToToday();
		month.setBounds(79, 9, 110, 25);
		panelControl.add(month);
		
		
		
		
		JLabel label_1 = new JLabel("Місяць:");
		label_1.setBounds(23, 12, 46, 14);
		panelControl.add(label_1);
		
		//List posluga for ComboBoxes
		comboBox_2.addItem(" ");
		comboBox_3.addItem(" ");
		comboBox_4.addItem(" ");
		comboBox_5.addItem(" ");
		comboBox_6.addItem(" ");
		comboBox_7.addItem(" ");
		comboBox_1.addItem(" ");
		poslug = getPoslugy();
		for(KOServices el:poslug){
			comboBox_2.addItem(el.getName());
			comboBox_3.addItem(el.getName());
			comboBox_4.addItem(el.getName());
			comboBox_5.addItem(el.getName());
			comboBox_6.addItem(el.getName());
			comboBox_7.addItem(el.getName());
			comboBox_1.addItem(el.getName());
		}
		
		MouseAdapter updateReaction = new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me){
				JButton tb = (JButton) me.getSource();
				JPanel pPanel = (JPanel) tb.getParent();
				update4Parent(pPanel);
			}
		};
		
		bUpdate_1.addMouseListener(updateReaction);
		bUpdate_2.addMouseListener(updateReaction);
		bUpdate_3.addMouseListener(updateReaction);
		bUpdate_4.addMouseListener(updateReaction);
		bUpdate_5.addMouseListener(updateReaction);
		bUpdate_6.addMouseListener(updateReaction);
		bUpdate_7.addMouseListener(updateReaction);
		
		
		ItemListener servSelection = new ItemListener()
		 {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String selected = (String) comboBox_1.getSelectedItem();
				Integer id = getIDbyName(selected);
				String type="";
				for(KOServices el:poslug){
					if(el.getiD()==id){
						type=el.getType();
					}
				}
				if(type=="2"){
					tPokaz_1.setEditable(false);
					pPokaz_1.setEditable(false);
					
				}
				if(type=="1"){
					tPokaz_1.setEditable(true);
					pPokaz_1.setEditable(true);
				}
				
			}
		};
		comboBox_1.addItemListener(servSelection);
		comboBox_2.addItemListener(servSelection);
		comboBox_3.addItemListener(servSelection);
		comboBox_4.addItemListener(servSelection);
		comboBox_5.addItemListener(servSelection);
		comboBox_6.addItemListener(servSelection);
		comboBox_7.addItemListener(servSelection);
		
		
		
		
		
		
	}
	
	private void update4Parent(JPanel currPanel){
		Integer id = 0;
		String lCount[] = new String[2];
		JComboBox<String> combo = (JComboBox) currPanel.findComponentAt(7, 7);
		JTextField outText = (JTextField) currPanel.findComponentAt(235, 11);
		id = getIDbyName(combo.getSelectedItem().toString());
		if(id!=0) {
			lCount = getLastCount(id);
			outText.setText(lCount[1]);
			chackDate(lCount);
		}
		
	}
		
	private void chackDate(String[] lCount) {
	        SimpleDateFormat parser;
	        Date dateIn,today;
	        try {
	        	parser = new SimpleDateFormat("dd.MM.yyyy");
				dateIn = parser.parse(lCount[0]);
				parser = new SimpleDateFormat("dd-MM-yyyy");
				String mon = (month.getText());
				today =  parser.parse(mon);
				long diff = (today.getTime()-dateIn.getTime());
				long defD = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				if(defD>32){
					JOptionPane.showMessageDialog(null, "Попередня оплата була давно! "+lCount[0]);
				};
				
	        } catch (ParseException e) {
				
	        	JOptionPane.showMessageDialog(null, e);
			}
			
	}
	
	private Integer getIDbyName(String name){
		for(KOServices el:poslug){
			if(el.getName() == name){
				return el.getiD();
			}
		}
		return 0;
	}
	
	
	private String[] getLastCount(Integer id){
		Connection connection = SQLiteConnection.dbConnector();
		String [] res = new String[2];
		res[0]="";//for Date
		res[1]="";//for Counter
		
		try{
			String query = "SELECT Date, LastCount FROM Data WHERE Date=(SELECT MAX(Date)";
			query+="FROM (SELECT LastCount, Date FROM data WHERE ServID="+id.toString()+" ORDER BY date)) AND ServID="+id.toString()+";";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				res[0]=rs.getString(1);
				res[1]=rs.getString(2);
			}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		return res;
		
	}
	private ArrayList<KOServices> getPoslugy(){
		Connection connection = SQLiteConnection.dbConnector();
		ArrayList<KOServices> res = new ArrayList<KOServices>();
		try{
			String query = "SELECT * FROM services";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			try {
				  while (rs.next()) {
					  KOServices date=new KOServices();
					  date.setiD(rs.getInt(1));
					  date.setName(rs.getString(2));
					  date.setType(rs.getString(5));
					  date.setPrice(rs.getDouble(4));
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
