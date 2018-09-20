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
import java.awt.event.ComponentAdapter;
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
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {
	//prendiamo l'istanza di magazzino -- singleton
	private static final Magazzino warehouse = Magazzino.getInstance();


	//pannelli
	private JPanel BGPANE; // panel principale
	private JPanel Login, menuazioni, panelArticoli, panelGenerale,panelNegozi,TablePanel;
	private JPanel PanelMainArt;
	private List<JPanel> listaPanel = new ArrayList<>();


	//bottoni
	private JButton btnLogin,btnArticoli,btnNegozi,btnOrdini,btnIngressi,btnFineMese,btnStorico;

	//textboxes
	private JTextField textField;

	//pass boxes
	private JPasswordField passwordField;

	//jlabels
	private JLabel DEBUG;





	private JTable tableArticoli;
	private JPanel PanelCambiaPos;
	private JPanel InfoPanel;
	private JLabel labelID;
	private JLabel lblE;
	private JLabel lblI;
	private JLabel lblB;
	private JLabel lblF;
	private JLabel lblNd;
	private JLabel lblC;
	private JLabel lblG;
	private JLabel lblNd_1;
	private JLabel lblD;
	private JLabel lblH;
	private JLabel lblNd_2;
	private JPanel TablePanelNegozi;
	private JTable tableNegozi;
	private JLabel Negozi;

	/**
	 * Create the frame.
	 * @throws ArticleDontExistInWareHouseException 
	 */
	public GUI() throws ArticleDontExistInWareHouseException {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		listaPanel.add(panelArticoli);
		listaPanel.add(panelNegozi);



		//inizializza i componenti
		startGUI();

		hideGUI();

	}




	public final void hideGUI() {
		menuazioni.setVisible(false);
		panelGenerale.setVisible(false);
		nascondiPannelli();

	}



	private void startGUI() throws ArticleDontExistInWareHouseException {
		//INIT GUI DESIGN
		BGPANE = new JPanel();
		BGPANE.setBackground(SystemColor.controlHighlight);
		BGPANE.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BGPANE);
		BGPANE.setLayout(null);

		panelGenerale = new JPanel();
		panelGenerale.setBackground(SystemColor.controlHighlight);
		panelGenerale.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGenerale.setBounds(0, 423, 147, 148);
		BGPANE.add(panelGenerale);

		JButton btnNewButton_6 = new JButton("Salva");
		btnNewButton_6.setBackground(SystemColor.control);
		btnNewButton_6.setBounds(10, 18, 59, 23);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelGenerale.setLayout(null);
		panelGenerale.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Esci");
		btnNewButton_7.setBackground(SystemColor.control);
		btnNewButton_7.setBounds(69, 18, 59, 23);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelGenerale.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Chiudi");
		btnNewButton_8.setBackground(SystemColor.control);
		btnNewButton_8.setBounds(33, 52, 70, 28);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelGenerale.add(btnNewButton_8);

		DEBUG = new JLabel("DBG");
		DEBUG.setHorizontalAlignment(SwingConstants.CENTER);
		DEBUG.setBounds(0, 91, 147, 57);
		panelGenerale.add(DEBUG);




		menuazioni = new JPanel();
		menuazioni.setForeground(new Color(0, 0, 0));
		menuazioni.setBorder(new TitledBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(192, 192, 192)), "Azioni", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		menuazioni.setBackground(SystemColor.controlHighlight);
		menuazioni.setBounds(0, 0, 147, 425);
		BGPANE.add(menuazioni);

		btnArticoli = new JButton("Articoli");
		btnArticoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nascondiPannelli();
				panelArticoli.setVisible(true);
				TablePanel.setEnabled(true);
			}
		});
		btnArticoli.setBackground(SystemColor.control);
		menuazioni.add(btnArticoli);

		btnNegozi = new JButton("Negozi");
		btnNegozi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nascondiPannelli();
				panelNegozi.setVisible(true);
			}
		});


		btnNegozi.setBackground(SystemColor.control);
		menuazioni.add(btnNegozi);

		btnOrdini = new JButton("Ordini");
		btnOrdini.setBackground(SystemColor.control);
		menuazioni.add(btnOrdini);

		btnIngressi = new JButton("Ingressi");
		btnIngressi.setBackground(SystemColor.control);
		menuazioni.add(btnIngressi);

		btnFineMese = new JButton("Fine Mese");
		btnFineMese.setBackground(SystemColor.control);
		menuazioni.add(btnFineMese);

		btnStorico = new JButton("Storico Mensile");
		btnStorico.setBackground(SystemColor.control);
		menuazioni.add(btnStorico);

		panelArticoli = new JPanel();
		panelArticoli.setBackground(SystemColor.controlHighlight);
		panelArticoli.setBounds(147, 0, 650, 571);
		BGPANE.add(panelArticoli);

		panelArticoli.setLayout(null);
				
						PanelCambiaPos = new JPanel();
						PanelCambiaPos.setBounds(75, 35, 500, 500);
						panelArticoli.add(PanelCambiaPos);
						PanelCambiaPos.setVisible(false);
						PanelCambiaPos.setLayout(null);
						
								JLabel lblNewLabel_3 = new JLabel("Dettagli Articolo");
								lblNewLabel_3.setBackground(SystemColor.controlHighlight);
								lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
								lblNewLabel_3.setBounds(10, 24, 132, 34);
								lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
								PanelCambiaPos.add(lblNewLabel_3);
								
										InfoPanel = new JPanel();
										InfoPanel.setBackground(SystemColor.controlHighlight);
										InfoPanel.setBounds(10, 59, 480, 100);
										PanelCambiaPos.add(InfoPanel);
										InfoPanel.setLayout(null);
										
												labelID = new JLabel("n/d");
												labelID.setHorizontalAlignment(SwingConstants.CENTER);
												labelID.setBounds(10, 11, 100, 20);
												
														//labelID.setText("ciao"); test modifica
												
														InfoPanel.add(labelID);
														
																lblE = new JLabel("n/d");
																lblE.setHorizontalAlignment(SwingConstants.CENTER);
																lblE.setBounds(10, 38, 100, 20);
																InfoPanel.add(lblE);
																
																		lblI = new JLabel("n/d");
																		lblI.setHorizontalAlignment(SwingConstants.CENTER);
																		lblI.setBounds(10, 66, 100, 20);
																		InfoPanel.add(lblI);
																		
																				lblB = new JLabel("n/d");
																				lblB.setHorizontalAlignment(SwingConstants.CENTER);
																				lblB.setBounds(120, 14, 100, 20);
																				InfoPanel.add(lblB);
																				
																						lblF = new JLabel("n/d");
																						lblF.setHorizontalAlignment(SwingConstants.CENTER);
																						lblF.setBounds(120, 41, 100, 20);
																						InfoPanel.add(lblF);
																						
																								lblNd = new JLabel("n/d");
																								lblNd.setHorizontalAlignment(SwingConstants.CENTER);
																								lblNd.setBounds(120, 69, 100, 20);
																								InfoPanel.add(lblNd);
																								
																										lblC = new JLabel("n/d");
																										lblC.setHorizontalAlignment(SwingConstants.CENTER);
																										lblC.setBounds(230, 14, 100, 20);
																										InfoPanel.add(lblC);
																										
																												lblG = new JLabel("n/d");
																												lblG.setHorizontalAlignment(SwingConstants.CENTER);
																												lblG.setBounds(230, 41, 100, 20);
																												InfoPanel.add(lblG);
																												
																														lblNd_1 = new JLabel("n/d");
																														lblNd_1.setHorizontalAlignment(SwingConstants.CENTER);
																														lblNd_1.setBounds(230, 69, 100, 20);
																														InfoPanel.add(lblNd_1);
																														
																																lblD = new JLabel("n/d");
																																lblD.setHorizontalAlignment(SwingConstants.CENTER);
																																lblD.setBounds(340, 14, 100, 20);
																																InfoPanel.add(lblD);
																																
																																		lblH = new JLabel("n/d");
																																		lblH.setHorizontalAlignment(SwingConstants.CENTER);
																																		lblH.setBounds(340, 41, 100, 20);
																																		InfoPanel.add(lblH);
																																		
																																				lblNd_2 = new JLabel("n/d");
																																				lblNd_2.setHorizontalAlignment(SwingConstants.CENTER);
																																				lblNd_2.setBounds(340, 69, 100, 20);
																																				InfoPanel.add(lblNd_2);
																																				
																																						JButton btnNewButton_2 = new JButton("Chiudi");
																																						btnNewButton_2.addMouseListener(new MouseAdapter() {
																																							@Override
																																							public void mouseClicked(MouseEvent arg0) {
																																								closeButtonAction("articoli");
																																							}
																																						});
																																						btnNewButton_2.setBounds(193, 444, 114, 45);
																																						PanelCambiaPos.add(btnNewButton_2);
				
				PanelMainArt = new JPanel();
				PanelMainArt.setBounds(0, 0, 650, 571);
				panelArticoli.add(PanelMainArt);
				PanelMainArt.setLayout(null);
				
						TablePanel = new JPanel();
						TablePanel.setBounds(0, 46, 650, 375);
						PanelMainArt.add(TablePanel);
						TablePanel.setLayout(new BorderLayout(0, 0));
						
						
						
								tableArticoli = new JTable();
								tableArticoli.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										tabellaRigaSel(false,"articoli",e); // false è l'azione, non visualizza il pannello ma mantiene solo il valore sul box debug
									}
								});
								TablePanel.add(tableArticoli, BorderLayout.CENTER);
								TablePanel.add(tableArticoli.getTableHeader(), BorderLayout.NORTH);
								tableArticoli.setAlignmentY(Component.TOP_ALIGNMENT);
								tableArticoli.setRowHeight(25);
								tableArticoli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								tableArticoli.setFont(new Font("Arial", Font.PLAIN, 13));
								tableArticoli.setShowVerticalLines(false);
								tableArticoli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								tableArticoli.setFillsViewportHeight(true);
								tableArticoli.setCellSelectionEnabled(true);
								tableArticoli.setBackground(Color.LIGHT_GRAY);
								tableArticoli.setModel(new DefaultTableModel(
										new Object[][] {
										},
										new String[] {
												"ID", "Nome", "Prezzo", "Sport", "Data inserimento", "Materiale", "Q.ta", "Posizione"
										}
										) {
									Class[] types = new Class [] {
											java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class
									};

									boolean[] columnEditables = new boolean[] {
											false, false, false, false, false, false, false, false
									};
									public boolean isCellEditable(int row, int column) {
										return columnEditables[column];
									}
								});
								tableArticoli.getColumnModel().getColumn(0).setResizable(false);
								tableArticoli.getColumnModel().getColumn(1).setResizable(false);
								tableArticoli.getColumnModel().getColumn(2).setResizable(false);
								tableArticoli.getColumnModel().getColumn(3).setResizable(false);
								tableArticoli.getColumnModel().getColumn(4).setResizable(false);
								tableArticoli.getColumnModel().getColumn(5).setResizable(false);
								tableArticoli.getColumnModel().getColumn(6).setResizable(false);
								tableArticoli.getColumnModel().getColumn(7).setResizable(false);
								tableArticoli.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
								
										JLabel lblArticoli = new JLabel("Articoli");
										lblArticoli.setBounds(279, 0, 91, 35);
										PanelMainArt.add(lblArticoli);
										lblArticoli.setFont(new Font("Arial", Font.ITALIC, 30));
										lblArticoli.setHorizontalAlignment(SwingConstants.CENTER);
										lblArticoli.setBackground(SystemColor.window);
										
												JButton btnNewButton = new JButton("Cambia Posizione");
												btnNewButton.setBounds(10, 434, 220, 50);
												PanelMainArt.add(btnNewButton);
												btnNewButton.setBackground(SystemColor.control);
												btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
												JButton btnDettagli = new JButton("Dettagli");
												btnDettagli.setBounds(240, 434, 140, 100);
												PanelMainArt.add(btnDettagli);
												btnDettagli.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent arg0) {
														tabellaRigaSel(true,"articoli",arg0);
													}
												});
												btnDettagli.setBackground(SystemColor.control);
												btnDettagli.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
												
														JButton btnNewButton_1 = new JButton("Aggiungi Prodotto");
														btnNewButton_1.setBounds(390, 434, 220, 50);
														PanelMainArt.add(btnNewButton_1);
														btnNewButton_1.setBackground(SystemColor.control);
														btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
														btnNewButton.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent arg0) {
															}
														});
														//
														DefaultTableModel model = (DefaultTableModel) tableArticoli.getModel();

		panelNegozi = new JPanel();
		panelNegozi.setBackground(SystemColor.controlHighlight);
		panelNegozi.setBounds(147, 0, 650, 571);
		BGPANE.add(panelNegozi);
		panelNegozi.setLayout(null);

		TablePanelNegozi = new JPanel();
		TablePanelNegozi.setBounds(0, 50, 650, 370);
		panelNegozi.add(TablePanelNegozi);
		TablePanelNegozi.setLayout(new BorderLayout(0, 0));

		tableNegozi = new JTable();
		tableNegozi.setShowVerticalLines(false);
		tableNegozi.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tableNegozi.setFont(new Font("Arial", Font.PLAIN, 13));
		tableNegozi.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"CF", "Nome", "Localit\u00E0"
				}
				) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableNegozi.getColumnModel().getColumn(0).setResizable(false);
		tableNegozi.getColumnModel().getColumn(1).setResizable(false);
		tableNegozi.getColumnModel().getColumn(2).setResizable(false);
		tableNegozi.setBackground(Color.LIGHT_GRAY);
		TablePanelNegozi.add(tableNegozi, BorderLayout.CENTER);
		TablePanelNegozi.add(tableNegozi.getTableHeader(), BorderLayout.NORTH);
		TablePanelNegozi.add(tableNegozi, BorderLayout.CENTER);

		Negozi = new JLabel("Negozi");
		Negozi.setHorizontalAlignment(SwingConstants.CENTER);
		Negozi.setFont(new Font("Arial", Font.ITALIC, 30));
		Negozi.setBackground(Color.WHITE);
		Negozi.setBounds(200, 0, 250, 50);
		panelNegozi.add(Negozi);


		Login = new JPanel();
		Login.setBackground(SystemColor.controlHighlight);
		Login.setBounds(245, 160, 293, 240);
		BGPANE.add(Login);
		Login.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBackground(SystemColor.controlHighlight);
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
		model.setRowCount(0);
		for(Articolo a : warehouse.getArticoloList()) {

			System.out.println(a.toString());//
			model.addRow(new Object[]{abs(a.getID()), a.getTipoArticolo().getName(), a.getPrezzo() + " €", a.getTipoArticolo().getSports(), a.getDataInString() , a.getTipoArticolo().getMaterial(), warehouse.getQuantita(a), warehouse.getPosition(a)});
		}	

	}


	// AZIONI DEGLI EVENTI


	// --- PULSANTI ---
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

	private void closeButtonAction(String panel) { // gestisce tutti i pulsanti di chiusura ! forse pattern
		switch(panel) {
		case "articoli":
			PanelCambiaPos.setVisible(false); //
			PanelMainArt.setVisible(true);
			break;

		}


	}



	// --- END PULSANTI ---!


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
		//panelArticoli.setVisible(true); al click del bottone
		panelGenerale.setVisible(true);

	}


	private void nascondiPannelli() {
		panelArticoli.setVisible(false);
		panelNegozi.setVisible(false);
		//panelOrdini.setVisible(false);
		//panelIngressi.setVisible(false);
		//panelFineMese.setVisible(false);
		//panelStorico.setVisible(false);
	}

	//TABELLA EVENTS

	private void tabellaRigaSel(boolean act, String type, MouseEvent e){
		
		switch(type) {
		case "articoli":

			dettaglioArticolo(act, tableArticoli.getSelectedRow()); // prende la riga dell'articolo selezionato, solo 1 alla volta
			break;

		}

	}

	//GENERAZIONE DEI DETTAGLI NEI PANEL DETTAGLI
	private void dettaglioArticolo(boolean act, int row) {
		//DEBUG BOX
		//act -- se è 1 visualizza il box, se 0 salva solo la riga selezionata
		if(act == true) {
			PanelCambiaPos.setVisible(true);
			PanelMainArt.setVisible(false);



			Component[] comp = InfoPanel.getComponents();
			JLabel l0 = (JLabel) comp[0];
			JLabel l1 = (JLabel) comp[1];
			JLabel l2 = (JLabel) comp[2];
			JLabel l3 = (JLabel) comp[3];
			JLabel l4 = (JLabel) comp[4];
			JLabel l5 = (JLabel) comp[5];
			JLabel l6 = (JLabel) comp[6];

			Articolo temp = warehouse.getArticolo(row); 
			l0.setText(""+temp.hashCode());
			l1.setText(""+temp.getTipoArticolo().getName());
			l2.setText(""+temp.getTipoArticolo().getSports());
			l3.setText(""+temp.getTipoArticolo().getMaterial());
			l4.setText(""+temp.getTipoArticolo().getDescription());
			l5.setText("€ "+temp.getPrezzo());
			l6.setText(""+temp.getDataInString());


		}
		
		DEBUG.setText(""+row);

	}

	private void dettaglioNegozio(int row) {


	}
	private void dettaglioOrdine(int row) {

	}

	private void dettaglioIngresso(int row) {

	}
}



