import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Table extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public Queue<TreeNode> val = new LinkedList<TreeNode>();
	public void loadData(){
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		while(!val.isEmpty()){
			TreeNode node = val.remove();
			mod.addRow(new Object[] { node.bTitle, node.ISBN,
					node.aName, node.aSurname });
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Table dialog = new Table();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Table() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		GroupLayout groupLayout = new GroupLayout(contentPanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(groupLayout);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
}
