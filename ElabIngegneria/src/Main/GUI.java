package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class GUI extends JFrame {

	private JPanel BGPANE;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel menuazioni;
	/**
	 * Create the frame.
	 */
	public GUI() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		
		
		
	
		
		//inizializza i componenti
		startGUI();
		
		hideGUI();
		
	}
		
		
		
		
	public final void hideGUI() {
		menuazioni.setVisible(false);
		
		
	}
		
		
		
	private void startGUI() {
		//INIT GUI DESIGN
		BGPANE = new JPanel();
		BGPANE.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BGPANE);
		BGPANE.setLayout(null);

		JPanel Login = new JPanel();
		Login.setBounds(245, 160, 293, 240);
		BGPANE.add(Login);
		Login.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 293, 66);
		Login.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 65, 293, 175);
		Login.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(24, 41, 80, 30);
		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(89, 41, 141, 30);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(24, 82, 80, 30);
		panel_1.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(89, 82, 141, 30);
		panel_1.add(passwordField);

		
		//BOTTONE LOGIN
		JButton btnLogin = new JButton("Accedi");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButtonActionToDo(e);
			}
		});
		
		
		btnLogin.setBounds(90, 123, 112, 41);
		panel_1.add(btnLogin);

		menuazioni = new JPanel();
		menuazioni.setForeground(new Color(0, 0, 0));
		menuazioni.setBorder(new TitledBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(192, 192, 192)), "Azioni", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		menuazioni.setBackground(SystemColor.controlHighlight);
		menuazioni.setBounds(0, 0, 147, 289);
		BGPANE.add(menuazioni);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuazioni.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("New button");
		menuazioni.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("New button");
		menuazioni.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("New button");
		menuazioni.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		menuazioni.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		menuazioni.add(btnNewButton_5);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(637, 0, 127, 91);
		BGPANE.add(panel);

		JButton btnNewButton_6 = new JButton("Salva");
		btnNewButton_6.setBounds(10, 18, 59, 23);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Esci");
		btnNewButton_7.setBounds(69, 18, 51, 23);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Chiudi");
		btnNewButton_8.setBounds(32, 52, 61, 23);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_8);
	}

	
	// AZIONI DEGLI EVENTI


	//PULSANTI
	private void loginButtonActionToDo(ActionEvent e) {
		
	
	}
}



