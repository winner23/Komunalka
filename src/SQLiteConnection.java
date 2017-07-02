import java.sql.*;

import javax.swing.JOptionPane;

public class SQLiteConnection implements dbOper {

	public SQLiteConnection() {
		// TODO Auto-generated constructor stub
	}
	protected static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:data\\data.sqlite");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}

	}
	
}
