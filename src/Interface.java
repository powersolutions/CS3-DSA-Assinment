import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.RowId;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class Interface extends JFrame {

	TreeNode root;
	Operations op = new Operations();
	TreeNode name = null;

	private void orderByName() {
		name = null;
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

		op.getAll(name);

	}

	private void delByName(String book) {
		orderByName();
		if (name == null) {
			JOptionPane.showMessageDialog(null, "Database is empty",
					"Database Error", JOptionPane.ERROR_MESSAGE);
		} else {
			TreeNode temp;

			try {
				temp = op.searchByName(name, book);
				root = op.deleteByIsbn(root, temp.ISBN);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Invalid value",
						"Database Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		name = null;
	}

	//private JFrame frame;
	private JTextField txtBookName;
	private JTextField txtISBN;
	private JTextField txtAuthorFname;
	private JTextField txtAuthorSname;
	private JButton btnAdd;
	private JTextField textsearch;
	private JTable table;
	private JTextField textField;
	private JLabel radioselect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() 
	{
		//setvisible(true);
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		setBounds(100, 100, 1086, 355);
		setTitle("Tree Node App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)), "Insert", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 204)));
		panel.setBounds(10, 11, 335, 305);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtBookName = new JTextField();
		txtBookName.setBounds(145, 57, 178, 20);
		panel.add(txtBookName);
		txtBookName.setColumns(10);

		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(10, 59, 117, 14);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookName.setLabelFor(txtBookName);
		panel.add(lblBookName);

		txtISBN = new JTextField();
		txtISBN.setBounds(145, 100, 178, 20);
		panel.add(txtISBN);
		txtISBN.setColumns(10);

		JLabel lblISBN = new JLabel("ISBN No");
		lblISBN.setBounds(10, 102, 117, 14);
		lblISBN.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblISBN);

		txtAuthorFname = new JTextField();
		txtAuthorFname.setBounds(145, 145, 178, 20);
		panel.add(txtAuthorFname);
		txtAuthorFname.setColumns(10);

		JLabel lblAuthorFname = new JLabel("Author Name");
		lblAuthorFname.setBounds(10, 147, 117, 14);
		lblAuthorFname.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblAuthorFname);

		txtAuthorSname = new JTextField();
		txtAuthorSname.setBounds(145, 187, 178, 20);
		panel.add(txtAuthorSname);
		txtAuthorSname.setColumns(10);

		JLabel lblAuthorSname = new JLabel("Author Surname");
		lblAuthorSname.setBounds(10, 189, 141, 14);
		lblAuthorSname.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblAuthorSname);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(145, 234, 89, 23);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(btnAdd);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207,
				229)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 205)));
		panel_2.setBounds(357, 11, 422, 305);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 23, 400, 270);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		ButtonGroup btnGroupRmove = new ButtonGroup();

		final JRadioButton radisbn = new JRadioButton("ISBN No");
		radisbn.setBounds(23, 23, 81, 23);
		panel_1.add(radisbn);

		final JRadioButton radbok = new JRadioButton("Book Name");
		radbok.setBounds(23, 49, 109, 23);
		panel_1.add(radbok);

		btnGroupRmove.add(radisbn);
		btnGroupRmove.add(radbok);

		textsearch = new JTextField();
		textsearch.setBounds(162, 24, 123, 20);
		panel_1.add(textsearch);
		textsearch.setColumns(10);

		radioselect = new JLabel("");
		radioselect.setBounds(23, 86, 238, 14);
		panel_1.add(radioselect);

		JButton search = new JButton("Search");
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// commented because there's a error not handled

				if (radisbn.isSelected()) {
					DefaultTableModel model = (DefaultTableModel) table
							.getModel();
					model.setRowCount(0);
					// String temp = textsearch.getText();

					TreeNode node;
					try {
						node = op.searchByIsbn(root,
								Integer.parseInt(textsearch.getText()));
						model.addRow(new Object[] { node.bTitle, node.ISBN,
								node.aName, node.aSurname });
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Invalid value",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} else if (radbok.isSelected()) {
					DefaultTableModel model = (DefaultTableModel) table
							.getModel();
					model.setRowCount(0);
					// String temp = textsearch.getText();

					TreeNode node;
					try {
						orderByName();
						node = op.searchByName(name, textsearch.getText());
						model.addRow(new Object[] { node.bTitle, node.ISBN,
								node.aName, node.aSurname });
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Invalid value",
								"Database Error", JOptionPane.ERROR_MESSAGE);
					}
					
					model.removeRow(0);

				} else {
					// radioselect.setText("Please select ISBN NO or Book Name");
					JOptionPane.showMessageDialog(null,"Please select ISBN NO or Book Name");
				}
				textsearch.setText(null);

			}
		});
		search.setBounds(172, 55, 89, 23);
		panel_1.add(search);

		JButton searchall = new JButton("Search All");
		searchall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel tab = (DefaultTableModel) table.getModel();
				tab.setRowCount(0);
				// tab.addRow(new
				// Object[]{"Book Name","ISBN NO","Author","Surname"});
				
				Table t = new Table();
				op.getAll(root);
				t.val=op.data;
				t.loadData();
				t.setVisible(true);
			}
		});
		searchall.setBounds(95, 111, 114, 23);
		panel_1.add(searchall);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 146, 388, 112);
		panel_1.add(scrollPane);
		
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Title", "ISBN", "Author Name1", "Author Name2"
					}
				));
				table.getColumnModel().getColumn(1).setPreferredWidth(52);
				table.getColumnModel().getColumn(2).setPreferredWidth(84);
				table.getColumnModel().getColumn(3).setPreferredWidth(84);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(184, 207,
				229)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 205)));
		panel_4.setBounds(791, 11, 277, 305);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 21, 253, 272);
		panel_4.add(panel_3);
		panel_3.setLayout(null);

		ButtonGroup btnGroupRemove = new ButtonGroup();
		final JRadioButton radioButton = new JRadioButton("ISBN No");
		radioButton.setBounds(8, 8, 80, 23);
		radioButton.setSelected(true);
		panel_3.add(radioButton);

		final JRadioButton radioButton_1 = new JRadioButton("Book Name");
		radioButton_1.setBounds(123, 8, 109, 23);
		panel_3.add(radioButton_1);

		btnGroupRemove.add(radioButton);
		btnGroupRemove.add(radioButton_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(8, 54, 233, 20);
		panel_3.add(textField);

		JButton button = new JButton("Delete");
		button.setBounds(87, 86, 89, 23);
		panel_3.add(button);

		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (txtBookName.getText().equals(null)
						|| txtBookName.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Error:Book Name is null");
				} else if (txtISBN.getText().equals(null)
						|| txtISBN.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Error:Book ISBN is null");
				} else if (txtAuthorFname.getText().equals(null)
						|| txtAuthorFname.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Error:Author First Name is null");
				} else if (txtAuthorSname.getText().equals(null)
						|| txtAuthorSname.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Error:Author Surname is null");
				} else {
					try {
						if (root == null) {
							root = new TreeNode(txtBookName.getText(), Integer
									.parseInt(txtISBN.getText()),
									txtAuthorFname.getText(), txtAuthorSname
											.getText());
							txtBookName.setText(null);
							txtISBN.setText(null);
							txtAuthorFname.setText(null);
							txtAuthorSname.setText(null);
						} else {

							op.insertByIsbn(root, txtBookName.getText(),
									Integer.parseInt(txtISBN.getText()),
									txtAuthorFname.getText(),
									txtAuthorSname.getText());

							txtBookName.setText(null);
							txtISBN.setText(null);
							txtAuthorFname.setText(null);
							txtAuthorSname.setText(null);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,
								"input values are not in correct format",
								"Insert Error", JOptionPane.ERROR_MESSAGE);
					}

				}
			}

		});

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Error:Specify a value to remove");
				} else {
					if (radioButton.isSelected()) {
						int x = JOptionPane.showConfirmDialog(null,
								"are you sure?", "Remove confirm",
								JOptionPane.YES_NO_OPTION);
						if (x == 0) {
							try {

								root = op.deleteByIsbn(root,
										Integer.parseInt(textField.getText()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null,
										"Invalid value", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					} else if (radioButton_1.isSelected()) {
						int x = JOptionPane.showConfirmDialog(null,
								"are you sure?", "Remove confirm",
								JOptionPane.YES_NO_OPTION);
						if (x == 0) {
							delByName(textField.getText());
						}
					}
				}
				textField.setText(null);
			}

		});

	}

}