import javax.swing.JOptionPane;

public class DataExpetion extends Exception {
	
	private static final long serialVersionUID = -265470686437954458L;

	public DataExpetion(String string) {
		JOptionPane.showMessageDialog(null,string);
		
	}
}
