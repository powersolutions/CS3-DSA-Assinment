import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.xml.bind.Binder;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer.Form;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class openpage extends JFrame {

	//private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					openpage window = new openpage();
					//window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public openpage() {
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		getContentPane().setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 916, 355);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				Interface in =new Interface();
			}
		});

		btnNewButton.addMouseListener(new MouseAdapter() {
		});
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("img/Untitled-5.jpg")));
		btnNewButton.setBounds(23, 25, 140, 109);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("img/Untitled-6.jpg")));
		lblNewLabel.setBounds(23, 37, 471, 256);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("13208319 - LAKAL SHAKTHI MANAWADU");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(526, 69, 337, 27);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("13208207 - G I RANGANA KANDAMBI");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(526, 120, 307, 27);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("13208203 - P UPEKSHA KAVINDI PERERA");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(526, 174, 317, 27);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("13208289 - R M BIMALI NIRASHA RATHNAYAKE");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(526, 227, 374, 23);
		getContentPane().add(lblNewLabel_4);
	}
}
