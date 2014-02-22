import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sample {

	TreeNode root;
	Operations op = new Operations();

	private JFrame frame;
	private JTextField txtBookName;
	private JTextField txtIsbn;
	private JTextField txtAutherName;
	private JTextField txtSurName;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField txtSe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sample window = new Sample();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Insert",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(7, 12, 223, 350);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 17, 213, 333);
		panel_1.add(panel);
		panel.setLayout(null);

		txtBookName = new JTextField();
		txtBookName.setText("book name");
		txtBookName.setBounds(53, 45, 114, 19);
		panel.add(txtBookName);
		txtBookName.setColumns(10);

		txtIsbn = new JTextField();
		txtIsbn.setText("ISBN");
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(53, 76, 114, 19);
		panel.add(txtIsbn);

		txtAutherName = new JTextField();
		txtAutherName.setText("Auther name");
		txtAutherName.setColumns(10);
		txtAutherName.setBounds(53, 107, 114, 19);
		panel.add(txtAutherName);

		txtSurName = new JTextField();
		txtSurName.setText("Sur name");
		txtSurName.setColumns(10);
		txtSurName.setBounds(53, 138, 114, 19);
		panel.add(txtSurName);

		final JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 265, 201, 15);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (root == null) {
					// root = new TreeNode(textField.getText(),
					// Integer.parseInt(textField_1.getText()),
					// textField_2.getText(), textField_3.getText());
					root = new TreeNode(txtBookName.getText(), Integer
							.parseInt(txtIsbn.getText()), txtAutherName
							.getText(), txtSurName.getText());
					lblNewLabel.setText("Added new node");
				} else {
					op.insert(root, txtBookName.getText(),
							Integer.parseInt(txtIsbn.getText()),
							txtAutherName.getText(), txtSurName.getText());
					lblNewLabel.setText("value added");
				}
				txtBookName.setText(null);
			}
		});
		btnNewButton.setBounds(53, 195, 117, 25);
		panel.add(btnNewButton);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"New column", "New column", "New column", "New column" }));
		table.setBounds(252, 64, 408, 136);
		frame.getContentPane().add(table);

		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				op.getAll(root);
				while (!op.data.isEmpty()) {
					TreeNode node = op.data.remove();
					model.addRow(new Object[] { node.bTitle, node.ISBN, node.aName, node.aSurname });
				}
			}
		});
		btnNewButton_1.setBounds(433, 27, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				//String temp = textField_search.getText();
				TreeNode node= op.searchByName(root, txtSe.getText());
				model.addRow(new Object[] { node.bTitle, node.ISBN, node.aName, node.aSurname });
			}
		});
		btnNewButton_2.setBounds(417, 253, 117, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		txtSe = new JTextField();
		txtSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSe.setText(null);
			}
		});
		txtSe.setText("Search");
		txtSe.setColumns(10);
		txtSe.setBounds(417, 212, 114, 19);
		frame.getContentPane().add(txtSe);

	}
}
