import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.DebugGraphics;
import java.awt.Dimension;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;

public class Poslugy extends JDialog { 
	private JTable table;
	Connection connection;
	private JButton okButton;
	private JButton cancelButton;
	
	public Poslugy() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel = new JPanel();
		setTitle("Послуги");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		ResultSet data = getPoslugy();
		TableModel tm = DbUtils.resultSetToTableModel(data);
		
		
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(tm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.LIGHT_GRAY, null));
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		
		table.setVisible(true);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(440, 180));
		scrollPane.setSize(300,300);
		contentPanel.add(scrollPane);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	
			{
				okButton = new JButton("Додати");
				okButton.setIcon(new ImageIcon(Poslugy.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Indent-Black.png")));
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent me){
						try {
							AddPoslug framen = new AddPoslug();
							framen.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Забрати");
				cancelButton.setIcon(new ImageIcon(Poslugy.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Cut-Black.png")));
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent me){
						//Get ID from table even if the table was sorted.
						String iDs = table.getValueAt(table.getSelectedRow(), 0).toString();
						int iD = Integer.parseInt(iDs);
						remPosl(iD);
					}
				});
				buttonPane.add(cancelButton);
			}
			setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{table, okButton, cancelButton}));
		
	}
	
	private ResultSet getPoslugy(){
		connection = SQLiteConnection.dbConnector();
		
		try{
			String query = "SELECT * FROM services";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			return rs;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		
	}
	private int remPosl(Integer iD){
		if(iD<1) {
			JOptionPane.showMessageDialog(null,"Виберіть рядок для видалення");
			return -1;
		}
		connection = SQLiteConnection.dbConnector();
		
		try{
			String query = "DELETE FROM services WHERE ID="+iD.toString();
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return -1;
		}
		
		return 0;
	}
	private int addPosl(Integer iD, String name, String account, Double price){
		
		return 0;
	}
	
}
