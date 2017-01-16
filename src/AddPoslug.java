import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.BoxLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.ComponentOrientation;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class AddPoslug extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFormattedTextField textField_2;

	public AddPoslug() {
		setResizable(false);
		
		setModal(true);
		setTitle("Нова Послуга");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		
		JTextPane textPane = new JTextPane();
		textPane.setOpaque(false);
		textPane.setFocusable(false);
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setEditable(false);
		textPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textPane.setText("Потрібно ввести дані по послузі:\r\nID - ідентифікатор (генерується автоматично, вводити не потрібно)\r\nName - Назва послуги (Паприклад: Газ, Електрика, ...)\r\nAccount - Рахунок (взяти № договору)\r\nPrice - Ціна за одиниц(фіксована ціна)\r\nType - Визначити тип нарахування (1 - по лічильнику, 2 - фіксовано за місяць)");
		panel.add(textPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Назва:");
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Рахунок:");
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(12);
		
		JLabel lblNewLabel_2 = new JLabel("Ціна:");
		panel_2.add(lblNewLabel_2);
		
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
		format.setMaximumFractionDigits(0);

		textField_2 = new JFormattedTextField(format);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Тип:");
		panel_2.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 - лічильник", "2 - фіксовано"}));
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_3);
		
		JButton btnNewButton = new JButton("Додати");
		btnNewButton.setIcon(new ImageIcon(AddPoslug.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Outdent-Black-rtl.png")));
		panel_3.add(btnNewButton);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, textField_1, textField_2, comboBox, btnNewButton}));
	}
}
