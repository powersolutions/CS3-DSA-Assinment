package abc;

import java.awt.EventQueue;
import java.awt.image.RescaleOp;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class searchIn {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchIn window = new searchIn();
					window.frame.setVisible(true);
					search sch = new search();
					sch.search(node, val);
					if(res == true)
					{
						lblNewLabal_1 = "Not found";
					}
					else{
						lblNewLabal_1 = "Found";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public searchIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 553, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(136, 54, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Book No");
		lblNewLabel.setBounds(80, 57, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(109, 115, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Result");
		lblNewLabel_1.setBounds(173, 200, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
