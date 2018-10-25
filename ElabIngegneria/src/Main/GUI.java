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
import java.awt.Graphics;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
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
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;

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
	private JButton btnCambiaPos,btnDettagli;

	//textboxes
	private JTextField textField;

	//pass boxes
	private JPasswordField passwordField;

	//jlabels
	private JLabel DEBUG;





	private JTable tableArticoli;
	private JPanel PanelDettagli;
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
	private JLabel labelNegozi;
	private JPanel PanelAggiungiArticolo;
	private JButton btnModificaArticolo;
	private JLabel lblGestioneArticolo;
	private JButton btnArticoloReset;
	private JButton btnUpdateArticolo;
	private JButton btnAnnullaArticolo;
	private JLabel lblGenArticolo;
	private JTextField txtNomeArticolo;
	private JTextField txtPrezzoArticolo;
	private JTextField txtData;
	private JTextField txtQuantit;
	private JTextField txtDescrizioneArticolo;

	
	ButtonGroup group_btn;
	
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

		panelArticoli = new JPanel();
		panelArticoli.setBackground(SystemColor.controlHighlight);
		panelArticoli.setBounds(147, 0, 650, 570);
		BGPANE.add(panelArticoli);

		panelArticoli.setLayout(null);



		PanelAggiungiArticolo = new JPanel();
		PanelAggiungiArticolo.setBounds(0, 0, 500, 570);
		panelArticoli.add(PanelAggiungiArticolo);
		PanelAggiungiArticolo.setVisible(false);
		PanelAggiungiArticolo.setLayout(null);

		lblGestioneArticolo = new JLabel("Gestione Articolo");
		lblGestioneArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneArticolo.setFont(new Font("Arial", Font.ITALIC, 29));
		lblGestioneArticolo.setBounds(125, 0, 250, 50);
		PanelAggiungiArticolo.add(lblGestioneArticolo);

		lblGenArticolo = new JLabel("Info Generali");
		lblGenArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenArticolo.setFont(new Font("Arial", Font.BOLD, 13));
		lblGenArticolo.setBounds(192, 54, 115, 29);
		PanelAggiungiArticolo.add(lblGenArticolo);

		btnArticoloReset = new JButton("Reset");
		btnArticoloReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clearTexts(arg0);
			}
		});
		btnArticoloReset.setBounds(25, 509, 100, 50);
		PanelAggiungiArticolo.add(btnArticoloReset);

		btnUpdateArticolo = new JButton("Aggiorna");
		btnUpdateArticolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnUpdateArticolo.setBounds(135, 509, 230, 50);
		PanelAggiungiArticolo.add(btnUpdateArticolo);

		btnAnnullaArticolo = new JButton("Annulla");
		btnAnnullaArticolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeButtonAction((JPanel)e.getComponent().getParent(),"articoli");
			}
		});
		btnAnnullaArticolo.setBounds(375, 509, 100, 50);
		PanelAggiungiArticolo.add(btnAnnullaArticolo);

		txtNomeArticolo = new JTextField();
		txtNomeArticolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearText(e);
			}
		});
		lblGenArticolo.setLabelFor(txtNomeArticolo);
		txtNomeArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeArticolo.setForeground(Color.GRAY);
		txtNomeArticolo.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNomeArticolo.setText("Nome Articolo");
		txtNomeArticolo.setToolTipText("Nome");
		txtNomeArticolo.setBounds(66, 94, 150, 30);
		PanelAggiungiArticolo.add(txtNomeArticolo);
		txtNomeArticolo.setColumns(30);

		txtPrezzoArticolo = new JTextField();
		txtPrezzoArticolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearText(e);
			}
		});
		txtPrezzoArticolo.setForeground(Color.GRAY);
		txtPrezzoArticolo.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPrezzoArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrezzoArticolo.setText("Prezzo Articolo/i");
		txtPrezzoArticolo.setToolTipText("Prezzo");
		txtPrezzoArticolo.setColumns(10);
		txtPrezzoArticolo.setBounds(66, 135, 150, 30);
		PanelAggiungiArticolo.add(txtPrezzoArticolo);

		txtData = new JTextField();
		txtData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearText(e);
			}
		});
		txtData.setFont(new Font("Arial", Font.PLAIN, 13));
		txtData.setForeground(Color.GRAY);
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setText("gg/mm/aaaa");
		txtData.setToolTipText("Data");
		txtData.setColumns(10);
		txtData.setBounds(282, 94, 150, 30);
		PanelAggiungiArticolo.add(txtData);

		txtQuantit = new JTextField();
		txtQuantit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearText(e);
			}
		});
		txtQuantit.setForeground(Color.GRAY);
		txtQuantit.setFont(new Font("Arial", Font.PLAIN, 13));
		txtQuantit.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantit.setText("Quantit\u00E0");
		txtQuantit.setColumns(10);
		txtQuantit.setBounds(282, 135, 150, 30);
		PanelAggiungiArticolo.add(txtQuantit);

		txtDescrizioneArticolo = new JTextField();
		txtDescrizioneArticolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearText(e);
			}
		});
		txtDescrizioneArticolo.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDescrizioneArticolo.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescrizioneArticolo.setText("Descrizione Articolo");
		txtDescrizioneArticolo.setForeground(Color.GRAY);
		txtDescrizioneArticolo.setBounds(25, 183, 450, 80);
		PanelAggiungiArticolo.add(txtDescrizioneArticolo);
		txtDescrizioneArticolo.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 274, 480, 2);
		PanelAggiungiArticolo.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 496, 480, 2);
		PanelAggiungiArticolo.add(separator_1);

		JLabel lblSpecifiche = new JLabel("Specifiche");
		lblSpecifiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecifiche.setFont(new Font("Arial", Font.BOLD, 13));
		lblSpecifiche.setBounds(192, 287, 115, 29);
		PanelAggiungiArticolo.add(lblSpecifiche);

		JLabel lblMateriale = new JLabel("");
		lblMateriale.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMateriale.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Materiale", TitledBorder.CENTER, TitledBorder.BOTTOM, null, new Color(109, 109, 109)));
		lblMateriale.setForeground(Color.GRAY);
		lblMateriale.setHorizontalAlignment(SwingConstants.CENTER);
		lblMateriale.setBounds(10, 322, 235, 160);
		PanelAggiungiArticolo.add(lblMateriale);
		
		group_btn = new ButtonGroup();//GRUPPO DI BOTTONI
		
		
		JRadioButton rdbtnPoliestere = new JRadioButton("Poliestere");
		rdbtnPoliestere.setBounds(25, 340, 100, 25);
		PanelAggiungiArticolo.add(rdbtnPoliestere);
		group_btn.add(rdbtnPoliestere);
		
		JRadioButton rdbtnSilicone = new JRadioButton("Silicone");
		rdbtnSilicone.setBounds(25, 368, 100, 25);
		PanelAggiungiArticolo.add(rdbtnSilicone);
		group_btn.add(rdbtnSilicone);
		
		JRadioButton rdbtnPelleSintetica = new JRadioButton("Pelle Sintetica");
		rdbtnPelleSintetica.setBounds(25, 396, 100, 25);
		PanelAggiungiArticolo.add(rdbtnPelleSintetica);
		group_btn.add(rdbtnPelleSintetica);
		
		JRadioButton rdbtnGoretex = new JRadioButton("Gore-Tex");
		rdbtnGoretex.setBounds(25, 424, 100, 25);
		PanelAggiungiArticolo.add(rdbtnGoretex);
		group_btn.add(rdbtnGoretex);
		
		JRadioButton rdbtnElastan = new JRadioButton("Elastan");
		rdbtnElastan.setBounds(125, 340, 100, 25);
		PanelAggiungiArticolo.add(rdbtnElastan);
		group_btn.add(rdbtnElastan);
		
		JRadioButton rdbtnPolietilene = new JRadioButton("Polietilene");
		rdbtnPolietilene.setBounds(125, 368, 100, 25);
		PanelAggiungiArticolo.add(rdbtnPolietilene);
		group_btn.add(rdbtnPolietilene);
		
		JRadioButton rdbtnPoliammide = new JRadioButton("Poliammide");
		rdbtnPoliammide.setBounds(125, 396, 100, 25);
		PanelAggiungiArticolo.add(rdbtnPoliammide);
		group_btn.add(rdbtnPoliammide);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleziona", "Atletica", "Basket", "Calcio", "Ciclismo", "Danza", "Hockey", "Golf", "Nuoto", "Palestra", "Pallavolo", "Rufting", "Rugby", "Scii", "Tennis"}));
		comboBox.setBounds(275, 378, 200, 30);
		PanelAggiungiArticolo.add(comboBox);

		JLabel labelSport = new JLabel("");
		labelSport.setHorizontalAlignment(SwingConstants.CENTER);
		labelSport.setForeground(Color.GRAY);
		labelSport.setFont(new Font("Arial", Font.PLAIN, 15));
		labelSport.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Sport", TitledBorder.CENTER, TitledBorder.BOTTOM, null, new Color(109, 109, 109)));
		labelSport.setBounds(255, 322, 235, 160);
		PanelAggiungiArticolo.add(labelSport);
		PanelAggiungiArticolo.setVisible(false);

		PanelDettagli = new JPanel();
		PanelDettagli.setBounds(75, 0, 500, 571);
		panelArticoli.add(PanelDettagli);
		PanelDettagli.setVisible(false);
		PanelDettagli.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Dettagli Articolo");
		lblNewLabel_3.setBackground(SystemColor.controlHighlight);
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 24, 132, 34);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		PanelDettagli.add(lblNewLabel_3);

		InfoPanel = new JPanel();
		InfoPanel.setBackground(SystemColor.controlHighlight);
		InfoPanel.setBounds(10, 59, 480, 100);
		PanelDettagli.add(InfoPanel);
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
				closeButtonAction((JPanel)arg0.getComponent().getParent(),"articoli");
			}
		});
		btnNewButton_2.setBounds(193, 444, 114, 45);
		PanelDettagli.add(btnNewButton_2);

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


		btnCambiaPos = new JButton("Cambia Posizione");
		btnCambiaPos.setBounds(10, 434, 220, 50);
		PanelMainArt.add(btnCambiaPos);
		btnCambiaPos.setBackground(SystemColor.control);
		btnCambiaPos.setFont(new Font("Comic Sans MS", Font.BOLD, 13));

		btnDettagli = new JButton("Dettagli");
		btnDettagli.setBounds(240, 434, 140, 110);
		PanelMainArt.add(btnDettagli);
		btnDettagli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabellaRigaSel(true,"articoli",arg0);
			}
		});
		btnDettagli.setBackground(SystemColor.control);
		btnDettagli.setFont(new Font("Comic Sans MS", Font.BOLD, 13));

		JButton btnAggiungiArticolo = new JButton("Aggiungi Prodotto");
		btnAggiungiArticolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addArticlePanel();
			}
		});
		btnAggiungiArticolo.setBounds(390, 434, 220, 50);
		PanelMainArt.add(btnAggiungiArticolo);
		btnAggiungiArticolo.setBackground(SystemColor.control);
		btnAggiungiArticolo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));

		btnModificaArticolo = new JButton("Modifica");
		btnModificaArticolo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnModificaArticolo.setBounds(10, 495, 220, 50);
		PanelMainArt.add(btnModificaArticolo);

		//
		fillTable("articoli",(DefaultTableModel) tableArticoli.getModel()); // riempe la tabella



		JLabel lblArticoli = new JLabel("Articoli");
		lblArticoli.setBounds(279, 0, 91, 35);
		PanelMainArt.add(lblArticoli);
		lblArticoli.setFont(new Font("Arial", Font.ITALIC, 30));
		lblArticoli.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticoli.setBackground(SystemColor.window);
		btnCambiaPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificaPosizioneArticolo(arg0, tableArticoli.getSelectedRow());
			}
		});

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
				btnCambiaPos.setEnabled(false);
				btnDettagli.setEnabled(false);
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
		tableNegozi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabellaRigaSel(false,"negozi",e);
			}
		});
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

		labelNegozi = new JLabel("Negozi");
		labelNegozi.setHorizontalAlignment(SwingConstants.CENTER);
		labelNegozi.setFont(new Font("Arial", Font.ITALIC, 30));
		labelNegozi.setBackground(Color.WHITE);
		labelNegozi.setBounds(200, 0, 250, 50);
		panelNegozi.add(labelNegozi);

		//
		fillTable("negozi",(DefaultTableModel) tableNegozi.getModel());


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
		textField.setText("magazziniere"); // loginuser

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(24, 82, 80, 30);
		panel_1.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(89, 82, 141, 30);
		panel_1.add(passwordField);
		passwordField.setText("1111");


		//BOTTONE LOGIN
		btnLogin = new JButton("Accedi");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButtonActionToDo(e);
			}
		});


		btnLogin.setBounds(90, 123, 112, 41);
		panel_1.add(btnLogin);


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
	//chiude il pannello, apre il box di prima.
	private void closeButtonAction(JPanel pannello,String panel) { // gestisce tutti i pulsanti di chiusura ! forse pattern
		switch(panel) {
		case "articoli":
			pannello.setVisible(false); //
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


	//TEXTBOX EVENTS

	private void clearText(MouseEvent e) {
		JTextField temp = (JTextField) e.getSource();
		temp.setText("");
	}


	//TABELLA EVENTS

	private void tabellaRigaSel(boolean act, String type, MouseEvent e){

		switch(type) {
		case "articoli":
			dettaglioArticolo(act, tableArticoli.getSelectedRow()); // prende la riga dell'articolo selezionato, solo 1 alla volta
			btnCambiaPos.setEnabled(true);
			btnDettagli.setEnabled(true);
			btnModificaArticolo.setEnabled(true);
			break;

		case "negozi":
			dettaglioNegozio(act, tableNegozi.getSelectedRow());
			break;
		}



	}

	//GENERAZIONE DEI DETTAGLI NEI PANEL DETTAGLI
	private void dettaglioArticolo(boolean act, int row) {
		//DEBUG BOX
		//act -- se è 1 visualizza il box, se 0 salva solo la riga selezionata
		if(act == true) {
			PanelDettagli.setVisible(true);
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

		DEBUG.setText("Details "+row);

	}

	private void dettaglioNegozio(boolean act,int row) {


	}
	private void dettaglioOrdine(boolean act,int row) {

	}

	private void dettaglioIngresso(boolean act,int row) {

	}



	//modifica la posizione di un articolo
	private void modificaPosizioneArticolo(ActionEvent evt, int row) {                                                                   
		int newPosition = 0;
		String s = "";
		do {
			do {
				s = JOptionPane.showInputDialog("Nuova posizione: ");
			} while (s.equals(" ") && s.equals(""));
			newPosition = Integer.parseInt(s);
		} while (newPosition < 0);

		try {
			System.out.println("Riga: "+row);
			warehouse.setPosition(warehouse.getArticolo(row), newPosition);
		} catch (ArticleDontExistInWareHouseException | PositionAlreadyOccupiedException ex) {
			// Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
		}

		fillTable("articoli",(DefaultTableModel) tableArticoli.getModel());

		DEBUG.setText("Cambia pos: "+row);
	}

	private void fillTable(String type, DefaultTableModel model) {

		switch(type) {
		case "articoli":
			model.setRowCount(0);
			for(Articolo a : warehouse.getArticoloList()) {

				System.out.println(a.toString());//
				try {
					model.addRow(new Object[]{abs(a.getID()), a.getTipoArticolo().getName(), a.getPrezzo() + " €", a.getTipoArticolo().getSports(), a.getDataInString() , a.getTipoArticolo().getMaterial(), warehouse.getQuantita(a), warehouse.getPosition(a)});
				} catch (ArticleDontExistInWareHouseException ex) {
					System.out.println("Eccezione, l'articolo non nel magazzino");
				}
			}
			btnCambiaPos.setEnabled(false);
			btnDettagli.setEnabled(false);
			btnModificaArticolo.setEnabled(false);
			break;

		case "negozi":
			model.setRowCount(0);
			for(Negozio n : warehouse.getNegozioList()) {

				System.out.println(n.toString());//	
				model.addRow(new Object[]{n.getCodiceFiscale(),n.getNome(),""+n.getindirizzo()+","+n.getCitta()});
			}

			break;
		}

	}
	
	//PULSANTE AGGIUNGI
	private void addArticlePanel(){
		//int row = tableArticoli.getSelectedRow();
		PanelMainArt.setVisible(false);
		PanelAggiungiArticolo.setVisible(true);
		}
	
	private void clearTexts(MouseEvent arg0) {
		if(arg0.getSource() instanceof JButton) {
			JButton btn = (JButton) arg0.getSource();	
			Component[] compList =  btn.getParent().getComponents();
			
			for(Component c: compList) {
				if(c instanceof JTextField)
					((JTextField) c).setText("");
			
				if(c instanceof JRadioButton && ((JRadioButton) c).isSelected())
					group_btn.clearSelection();
				
				if(c instanceof JComboBox) {
					JComboBox a = (JComboBox)c;
					a.setSelectedIndex(0);
					
				}
			}
		}
	}
}

