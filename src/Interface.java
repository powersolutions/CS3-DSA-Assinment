import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Interface {
	
	TreeNode root;
	Operations op = new Operations();

	private JFrame frame;
	private JTextField txtBookName;
	private JTextField txtISBN;
	private JTextField txtAuthorFname;
	private JTextField txtAuthorSname;
	private JButton btnAdd;
	private JTextField textsearch;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(100, 100, 802, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)), "Insert", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 204)));
		panel.setBounds(10, 11, 240, 282);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtBookName = new JTextField();
		txtBookName.setBounds(127, 57, 86, 20);
		panel.add(txtBookName);
		txtBookName.setColumns(10);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookName.setLabelFor(txtBookName);
		lblBookName.setBounds(10, 59, 117, 14);
		panel.add(lblBookName);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(127, 100, 86, 20);
		panel.add(txtISBN);
		txtISBN.setColumns(10);
		
		JLabel lblISBN = new JLabel("ISBN No");
		lblISBN.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblISBN.setBounds(10, 102, 117, 14);
		panel.add(lblISBN);
		
		txtAuthorFname = new JTextField();
		txtAuthorFname.setBounds(127, 145, 86, 20);
		panel.add(txtAuthorFname);
		txtAuthorFname.setColumns(10);
		
		JLabel lblAuthorFname = new JLabel("Author Name");
		lblAuthorFname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthorFname.setBounds(10, 147, 117, 14);
		panel.add(lblAuthorFname);
		
		txtAuthorSname = new JTextField();
		txtAuthorSname.setBounds(127, 187, 86, 20);
		panel.add(txtAuthorSname);
		txtAuthorSname.setColumns(10);
		
		JLabel lblAuthorSname = new JLabel("Author Surname");
		lblAuthorSname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthorSname.setBounds(10, 189, 117, 14);
		panel.add(lblAuthorSname);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(124, 230, 89, 23);
		panel.add(btnAdd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(268, 11, 315, 282);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 23, 295, 248);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton radisbn = new JRadioButton("ISBN No");
		radisbn.setBounds(23, 23, 81, 23);
		panel_1.add(radisbn);
		
		JRadioButton radbok = new JRadioButton("Book Name");
		radbok.setBounds(23, 49, 109, 23);
		panel_1.add(radbok);
		
		textsearch = new JTextField();
		textsearch.setBounds(162, 24, 123, 20);
		panel_1.add(textsearch);
		textsearch.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setBounds(172, 55, 89, 23);
		panel_1.add(search);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(10, 145, 275, 90);
		panel_1.add(table);
		
		JButton searchall = new JButton("Search All");
		searchall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				DefaultTableModel tab = (DefaultTableModel) table.getModel();
				tab.setRowCount(0);
				//tab.addRow(new Object[]{"Book Name","ISBN NO","Author","Surname"});
				op.getAll(root);
				while (!op.data.isEmpty()) {
					TreeNode node = op.data.remove();
					tab.addRow(new Object[] { node.bTitle, node.ISBN,
							node.aName, node.aSurname });
				}
			}
		});
		searchall.setBounds(95, 111, 114, 23);
		panel_1.add(searchall);
		
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (root == null) {
					root = new TreeNode(txtBookName.getText(), Integer
							.parseInt(txtISBN.getText()), txtAuthorFname
							.getText(), txtAuthorSname.getText());
					}
					 else 
					{
					op.insert(root, txtBookName.getText(),
							Integer.parseInt(txtISBN.getText()),
							txtAuthorFname.getText(), txtAuthorSname.getText());
					
				}
				txtBookName.setText(null);
				txtISBN.setText(null);
				txtAuthorFname.setText(null);
				txtAuthorSname.setText(null);
			}

		});
		
	}
}
