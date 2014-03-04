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
	private final JLabel lblNewLabel_6 = new JLabel("");

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
		setBounds(100, 100, 960, 517);
		setTitle("SPUTNIKS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		lblNewLabel_6.setIcon(new ImageIcon(openpage.class.getResource("/img/Untitled-5.jpg")));
		lblNewLabel_6.setBounds(52, 22, 146, 115);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("img/Untitled-6.jpg")));
		lblNewLabel.setBounds(23, 37, 471, 256);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("13208319 - L SHAKTHI MANAWADU");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(558, 414, 384, 27);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("13208207 - G I RANGANA KANDAMBI");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(23, 414, 337, 27);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("13208203 - P UPEKSHA KAVINDI PERERA");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(23, 453, 337, 27);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("13208289 - R M BIMALI NIRASHA RATHNAYAKE");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(558, 453, 384, 23);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Interface in =new Interface();
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(openpage.class.getResource("/img/st.png")));
		lblNewLabel_5.setBounds(627, 67, 315, 226);
		getContentPane().add(lblNewLabel_5);
	}
}
