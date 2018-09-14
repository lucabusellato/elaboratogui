package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

//import delle exception

import Exception.*;

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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static java.lang.Math.abs;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GUI extends JFrame {
	//prendiamo l'istanza di magazzino -- singleton
	private static final Magazzino warehouse = Magazzino.getInstance();
	
	
	//pannelli
	private JPanel BGPANE; // panel principale
	private JPanel Login, menuazioni;
	
	//bottoni
	private JButton btnLogin,btnArticoli,btnNegozi,btnOrdini,btnIngressi,btnFineMese,btnStorico;
	
	//textboxes
	private JTextField textField;
	
	//pass boxes
	private JPasswordField passwordField;
	private JTable tableArticoli;
	
	/**
	 * Create the frame.
	 * @throws ArticleDontExistInWareHouseException 
	 */
	public GUI() throws ArticleDontExistInWareHouseException {
		
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
		
		
		
	private void startGUI() throws ArticleDontExistInWareHouseException {
		//INIT GUI DESIGN
		BGPANE = new JPanel();
		BGPANE.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BGPANE);
		BGPANE.setLayout(null);
		
		JPanel panelArticoli = new JPanel();
		panelArticoli.setBounds(150, 0, 634, 571);
		BGPANE.add(panelArticoli);
		
		tableArticoli = new JTable();
		tableArticoli.setBounds(61, 444, 512, -317);
		tableArticoli.setSurrendersFocusOnKeystroke(true);
		tableArticoli.setFillsViewportHeight(true);
		tableArticoli.setCellSelectionEnabled(true);
		tableArticoli.setColumnSelectionAllowed(true);
		tableArticoli.setBackground(Color.MAGENTA);
		tableArticoli.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Prezzo", "Sport", "Data inserimento", "Materiale", "Q.ta", "Posizione"
			}
		));
		tableArticoli.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		//
		DefaultTableModel model = (DefaultTableModel) tableArticoli.getModel();
		panelArticoli.setLayout(null);
		
				//
				
				panelArticoli.add(tableArticoli);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 5, true));
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				scrollPane.setToolTipText("dsgsdg");
				scrollPane.setBounds(0, 146, 230, -144);
				panelArticoli.add(scrollPane);
      
		Login = new JPanel();
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
		btnLogin = new JButton("Accedi");
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

		btnArticoli = new JButton("Articoli");
		menuazioni.add(btnArticoli);

		btnNegozi = new JButton("Negozi");
		menuazioni.add(btnNegozi);

		btnOrdini = new JButton("Ordini");
		menuazioni.add(btnOrdini);

		btnIngressi = new JButton("Ingressi");
		menuazioni.add(btnIngressi);

		btnFineMese = new JButton("Fine Mese");
		menuazioni.add(btnFineMese);
		
		btnStorico = new JButton("Storico Mensile");
		menuazioni.add(btnStorico);

		JPanel panelGenerale = new JPanel();
		panelGenerale.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelGenerale.setBounds(0, 480, 137, 91);
		BGPANE.add(panelGenerale);

		JButton btnNewButton_6 = new JButton("Salva");
		btnNewButton_6.setBounds(10, 18, 59, 23);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelGenerale.setLayout(null);
		panelGenerale.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Esci");
		btnNewButton_7.setBounds(69, 18, 59, 23);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelGenerale.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Chiudi");
		btnNewButton_8.setBounds(33, 52, 70, 28);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelGenerale.add(btnNewButton_8);
		model.setRowCount(0);
		Articolo a = warehouse.getArticolo(0);
		System.out.println(a.toString());
		model.addRow(new Object[]{abs(a.getID()), a.getTipoArticolo().getName(), a.getPrezzo() + " €", a.getTipoArticolo().getSports(), a.getDataInString() , a.getTipoArticolo().getMaterial(), warehouse.getQuantita(a), warehouse.getPosition(a)});
	}

	
	// AZIONI DEGLI EVENTI


	//PULSANTI
	private void loginButtonActionToDo(ActionEvent e) {
		//System.out.println(textField.getText());
		String user = textField.getText();
		String pw = passwordField.getText();//	deprecato	String pass = ""+pw;
		
		
		//controllo spazi vuoti nei textbox
		/*if()
		
		} else {*/
		
		try {
		int perms = warehouse.loginCheck(pw.hashCode()^user.hashCode());
		
		System.out.println("Loggato l' Utente "+ user + " permessi: "+perms);
		//qui è da rendere visibile tutti i panel
				
		switch(perms) {
			case 1:
				panelMagazziniere();
				break;
			case 2:
				panelSegreteria();
				break;
			case 3:
				panelResponsabile();
				break;
			default:
				;
		
		
		}
		
		
        
        }catch (UserNotFoundException ecc) {
        	JOptionPane.showMessageDialog(null, "Impossibile effettuare il login,si prega di riprovare più tardi");
        	passwordField.setText("");
        }
        
      }
	
	private void panelMagazziniere(){
		panelComuni();
		
		
	}
	
	 /*
    1 - Magazziniere 
        Visualizza ingresso,crea ingresso, visualizza articolo, modifica posizione articolo, crea uscite per gli ordini quindi vede gli ordini
    2 - Segreteria Amministrativa
        creano articoli e quindi vedono gli articoli ma non possono spostare la posizione degli articoli, visualizzano ordini e ingressi senza modificarli o crearli ne cancellarli
    3 - Responsabile Negozi
        Visualizzano, creano e modificano gli ordini e i negozi, non possono vedere gli ingressi e le
     */
	
	private void panelSegreteria(){
		panelComuni();
	}
	private void panelResponsabile(){
		panelComuni();
	}
	
	private void panelComuni(){ // pannelli in comune per tutti e 3 i tipi di user
		Login.setVisible(false);
		menuazioni.setVisible(true);
	}
}



