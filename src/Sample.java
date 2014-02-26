import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class Sample {

	TreeNode name=null;
	TreeNode node;

	TreeNode root = null;
	Operations op = new Operations();
	
	private boolean stat=false;

	private void orderByName() {
		name=null;
		op.getAll(root);
		while (!op.data.isEmpty()) {
			TreeNode tem = op.data.remove();
			if (name == null) {
				name = new TreeNode(tem.bTitle, tem.ISBN, tem.aName,
						tem.aSurname);
			} else {

				op.insert(name, tem.bTitle, tem.ISBN, tem.aName, tem.aSurname);
			}
		}
		// op.orderByIsbn(root, isbn);
		op.getAll(name);
		//name = null;

	}

	private void delByName(String book) {
		orderByName();
		if(name==null){
			txtSe.setText("empty db");
		}else{
			TreeNode temp;
			try {
				temp = op.searchByName(name, book);
				if(temp==null){
					txtSe.setText("invalid book name");
				}else{
					root = op.deleteByIsbn(root, temp.ISBN);
					txtSe.setText("deleted");
					name=null;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		name=null;
	}
	private void delByIsbn(int isbn){
		if(root==null){
			txtSe.setText("emty db");
		}
		else{
			TreeNode temp = op.searchByIsbn(root, isbn);
			if(temp==null){
				txtSe.setText("invalid isbn");
			}
			else{
				try {
					root = op.deleteByIsbn(root,temp.ISBN);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtSe.setText("deleted");
			}
		}
	}
	

	private JFrame frame;
	private JTextField txtBookName;
	private JTextField txtIsbn;
	private JTextField txtAutherName;
	private JTextField txtSurName;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField txtSe;
	private Scrollable tbScroll;
	private JButton btnDelByName;
	private JButton button_3;

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
		txtBookName.setText("book");
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
					try {
						op.insertByIsbn(root, txtBookName.getText(),
								Integer.parseInt(txtIsbn.getText()),
								txtAutherName.getText(), txtSurName.getText());
						lblNewLabel.setText("value added");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "error");
					}
				}
				txtBookName.setText(null);
			}
		});
		btnNewButton.setBounds(53, 195, 117, 25);
		panel.add(btnNewButton);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

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
				//node = null;
				op.getAll(root);
				
				while (!op.data.isEmpty()) {
					node = op.data.remove();
					model.addRow(new Object[] { node.bTitle, node.ISBN,
							node.aName, node.aSurname });
				}
			}
		});
		btnNewButton_1.setBounds(322, 27, 117, 25);
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("search by name");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				// String temp = textField_search.getText();

				orderByName();
				TreeNode node;
				try {
					node = op.searchByName(name, txtSe.getText());
					model.addRow(new Object[] { node.bTitle, node.ISBN, node.aName,
							node.aSurname });
					//name = null;
					op.data.clear();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(305, 253, 146, 25);
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

		JButton button = new JButton("New button");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name=null;
				orderByName();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);

				while (!op.data.isEmpty()) {
					node = op.data.remove();
					model.addRow(new Object[] { node.bTitle, node.ISBN,
							node.aName, node.aSurname });
				}
				name=null;
			}

		});
		button.setBounds(451, 27, 117, 25);
		frame.getContentPane().add(button);

		JButton btnSearchByIsbn = new JButton("search by isbn");
		btnSearchByIsbn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				// String temp = textField_search.getText();
				TreeNode node = op.searchByIsbn(root,
						Integer.parseInt(txtSe.getText()));
				model.addRow(new Object[] { node.bTitle, node.ISBN, node.aName,
						node.aSurname });

			}
		});
		btnSearchByIsbn.setBounds(496, 253, 137, 25);
		frame.getContentPane().add(btnSearchByIsbn);

		btnDelByName = new JButton("del by isbn");
		btnDelByName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delByIsbn(Integer.parseInt(txtSe.getText()));
			}
		});
		btnDelByName.setBounds(305, 310, 120, 25);
		frame.getContentPane().add(btnDelByName);

		button_3 = new JButton("New button");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreeNode node = op.minNode(root);

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				// String temp = textField_search.getText();
				model.addRow(new Object[] { node.bTitle, node.ISBN, node.aName,
						node.aSurname });
			}
		});
		button_3.setBounds(580, 27, 117, 25);
		frame.getContentPane().add(button_3);
		
		JButton btnDelByIsbn = new JButton("del by name");
		btnDelByIsbn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				delByName(txtSe.getText());
			}
		});
		btnDelByIsbn.setBounds(492, 310, 120, 25);
		frame.getContentPane().add(btnDelByIsbn);

	}
}
