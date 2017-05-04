import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Poslugy extends JDialog { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -6495597805956861531L;
	private JTable table;
	Connection connection;
	private JButton okButton;
	private JButton cancelButton;
	
	public Poslugy() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				updateTable();
				
			}
		});
		
		JPanel contentPanel = new JPanel();
		setTitle("Послуги");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//Collection data of Services
		ResultSet data = getPoslugy();
		TableModel tm = DbUtils.resultSetToTableModel(data);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(tm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, Color.LIGHT_GRAY, null));
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		
		table.setVisible(true);
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		        	try {
		        		Integer id = (Integer)table.getValueAt(row, 0);
						AddPoslug framen = new AddPoslug(id);
						framen.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					} 
		             
		        }
		    }
		});
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
						try {//Add New Service window
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
						//Remove some service with ID,
						//Get ID from table even if the table was sorted.
						int row = table.getSelectedRow();
						if(row<0){
							JOptionPane.showMessageDialog(null,"Виберіть рядок для видалення");
							return;
						}
						String iDs = table.getValueAt(row, 0).toString();
						int iD = Integer.parseInt(iDs);
						remPosl(iD);
						updateTable();
						
					}
				});
				buttonPane.add(cancelButton);
			}
			setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{table, okButton, cancelButton}));
		
	}
	
	private void updateTable(){
		ResultSet data = getPoslugy();
		TableModel tm = table.getModel();
		List<Integer> columns = new ArrayList<Integer>();
		int cols = tm.getColumnCount();
		for(int i=0 ; i<cols ; i++){
			
			columns.add(table.getColumnModel().getColumn(i).getPreferredWidth());
		}
		tm = DbUtils.resultSetToTableModel(data);
		
		table.setModel(tm);
		for(int i=0 ; i<cols ; i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(columns.get(i));
		}
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
			pst.executeUpdate();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return -1;
		}
		
		return 0;
	}
	
	
}
