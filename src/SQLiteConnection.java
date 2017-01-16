import java.sql.*;

import javax.swing.JOptionPane;

public class SQLiteConnection implements dbOper {
	Connection con = null;
	
	public SQLiteConnection() {
		// TODO Auto-generated constructor stub
	}
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Develop\\Projects\\workspace\\Komunal\\data\\data.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection successful!");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	
		
		
	}
	
}
