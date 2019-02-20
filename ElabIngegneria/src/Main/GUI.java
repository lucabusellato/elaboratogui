package Main;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.BorderLayout;

import Exception.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static java.lang.Math.abs;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	static int indexOrder = 0, indexArticle = 0, indexShop = 0, indexIngressi = 0, indexUscite = 0, orderArticleSelected = 1, from = 0, index = 0, modificaOrCreaOrdine = 0;    
	//private int backSel; // serve per lo storico, selezione del combobox che cambia
	private String sportType="";
	//prendiamo l'istanza di magazzino -- singleton
	private static final Magazzino warehouse = Magazzino.getInstance();
	private int varflag;
	private Articolo temp;
	private Negozio tempNegozio;

	//pannelli
	private JPanel BGPANE; // panel principale

	private JPanel Login, menuazioni, panelArticoli, panelGenerale,panelNegozi,TablePanel,panelIngressi,panelNuovoIngresso;
	private JPanel PanelMainArt,PanelMainNeg,panelUscite,PanelTableOrdiniPrinc;


	//bottoni
	private JButton btnLogin,btnArticoli,btnNegozi,btnOrdini,btnIngressi,btnUscite,btnStorico;
	private JButton btnAggiungiArticolo,btnModificaArticolo,btnEliminaArt,btnDettagli,btnCambiaPos;

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
	private JLabel lblGestioneArticolo;
	private JButton btnArticoloReset;
	private JButton btnUpdateArticolo;
	private JButton btnAnnullaArticolo;
	private JLabel lblGenArticolo;
	private JTextField txtNomeArticolo;
	private JTextField txtPrezzoArticolo;
	private JTextField txtData;
	private JTextField txtDescrizioneArticolo;

	//ingressi
	private JLabel labelViewId ;
	private JButton btnNuovoIngresso;
	private JLabel lblViewData;
	private JTextPane textPane;
	private JButton buttonIngressiIndietro;
	private JLabel labelCountIngressi;
	private JButton buttonIngressiAvanti;

	//radio btns

	private JRadioButton rdbtnPoliestere;
	private JRadioButton rdbtnSilicone;
	private JRadioButton rdbtnPelleSintetica; 
	private JRadioButton rdbtnGoretex;  
	private JRadioButton rdbtnElastan; 
	private JRadioButton rdbtnPolietilene; 
	private JRadioButton rdbtnPoliammide;

	private ButtonGroup group_btn;
	private JButton btnModNegozio;
	private JButton btnEliminaNegozio;
	private JButton btnCreaNegozio;
	private JPanel PanelAggiungiNegozio;
	private JTextField txtCFNegozio;
	private JTextField txtNomeNegozio;
	private JTextField txtIndNegozio;
	private JTextField txtCitNegozio;

	private JTextField textFieldGiorno;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textFieldMese;
	private JTextField textFieldAnno;


	//riepilogo
	private JPanel panelRiepilogo;
	private JTextArea textArea;
	private JButton btnNewButton;//-
	private JButton button_2;//+
	private JLabel lblMese;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

	//Uscite
	private JLabel labelIndexUscita;
	private JButton buttonUscitaIndietro;
	private JButton buttonUscitaAvanti;
	private JTextArea textAreaUscite;

	//Ordini
	private JPanel panelOrdini;
	private JPanel PanelCreaNuovoOrd;
	private JPanel PanelTableOrdini;
	private JTable tableOrdini;
	private JLabel labelOrdini;
	private JButton btnCreaNuovoOrd; 
	private JButton btnGeneraUscita;
	private JTextField quantita1;
	private JTextField quantita2;
	private JTextField quantita3;
	private JTextField quantita4;
	private JTextField quantita5;
	private JTextField textCorriere;
	private JTextField quantita6;
	private JLabel lblArticoliEQuantit;
	private JLabel lblNegozio_o;


	/**
	 *
	 * Create the frame.
	 * @throws ArticleDontExistInWareHouseException 
	 */
	public GUI() throws ArticleDontExistInWareHouseException {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Programma gestione magazzino");
		
		

		//inizializza i componenti
		startGUI();

		hideGUI();

	}
	private void nascondiPannelli() {
		panelArticoli.setVisible(false);
		panelNegozi.setVisible(false);
		panelOrdini.setVisible(false);
		panelIngressi.setVisible(false);
		panelNuovoIngresso.setVisible(false);
		panelUscite.setVisible(false); 
		panelRiepilogo.setVisible(false);
	}


	public final void hideGUI() {
		menuazioni.setVisible(false);
		panelGenerale.setVisible(false);
		nascondiPannelli();

	}
	void ingressi() {
		if (warehouse.ingressiIsEmpty()) {
			labelViewId.setText("");
			labelCountIngressi.setText("");
			btnNuovoIngresso.setEnabled(true);
			buttonIngressiIndietro.setVisible(false);
			buttonIngressiAvanti.setVisible(false);			
		} else {
			if (indexIngressi == 0) {
				buttonIngressiIndietro.setEnabled(false);
			}else {
				buttonIngressiIndietro.setEnabled(true);
			}
			if (indexIngressi == warehouse.ingressiSize() - 1) {
				buttonIngressiAvanti.setEnabled(false);
			} else {
				buttonIngressiAvanti.setEnabled(true);
			}
			lblViewData.setText(warehouse.getIngresso(indexIngressi).getDataInString());
			labelCountIngressi.setText(""+ (indexIngressi + 1));
			labelViewId.setText("" + abs(warehouse.getIngresso(indexIngressi).getID()));
			textPane.setText("" + warehouse.getIngresso(indexIngressi).toString());
		}
	}

	void uscite() {
		if (warehouse.usciteIsEmpty()) {
			labelIndexUscita.setText("");
			label_2.setText("");
			label_3.setText("");
			label_4.setText("");
			buttonUscitaIndietro.setVisible(false);
			buttonUscitaAvanti.setVisible(false);			
		} else {
			if (indexUscite == 0) {
				buttonUscitaIndietro.setEnabled(false);
			}else {
				buttonUscitaIndietro.setEnabled(true);
			}
			if (indexUscite == warehouse.usciteSize() - 1) {
				buttonUscitaAvanti.setEnabled(false);
			} else {
				buttonUscitaAvanti.setEnabled(true);
			}
			label_4.setText(warehouse.getUscita(indexUscite).getDataInString());
			labelIndexUscita.setText(""+ (indexUscite + 1));
			label_2.setText("" + abs(warehouse.getUscita(indexUscite).getOrdine().getID()));
			label_3.setText(warehouse.getUscita(indexUscite).getOrdine().getNegozio().getNome());
			textAreaUscite.setText("" + warehouse.getUscita(indexUscite).toString());
		}
	}
	private void report() {
		if (index == 0) {
			btnNewButton.setEnabled(false);
		} else {
			btnNewButton.setEnabled(true);
		}
		if (index == 11) {
			button_2.setEnabled(false);

		} else {
			button_2.setEnabled(true);
		}
		textArea.setText("" + warehouse.ChiusuraMesi(index,sportType));
		switch(index){ // index del Mese
		case 0:
			lblMese.setText(""+ "Gennaio");
			break;
		case 1:
			lblMese.setText(""+ "Febbraio");
			break;
		case 2:
			lblMese.setText(""+ "Marzo");
			break;
		case 3:
			lblMese.setText(""+ "Aprile");
			break;
		case 4:
			lblMese.setText(""+ "Maggio");
			break;
		case 5:
			lblMese.setText(""+ "Giugno");
			break;
		case 6:
			lblMese.setText(""+ "Luglio");
			break;
		case 7:
			lblMese.setText(""+ "Agosto");
			break;
		case 8:
			lblMese.setText(""+ "Settembre");
			break;
		case 9:
			lblMese.setText(""+ "Ottobre");
			break;
		case 10:
			lblMese.setText(""+ "Novembre");
			break;
		case 11:
			lblMese.setText(""+ "Dicembre");
			break;
		default:
			lblMese.setText(""+"errore");
		}
	}



	private void startGUI() throws ArticleDontExistInWareHouseException {
		//INIT GUI DESIGN
		group_btn = new ButtonGroup();//GRUPPO DI BOTTONI
		BGPANE = new JPanel();
		BGPANE.setBackground(SystemColor.controlHighlight);
		BGPANE.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BGPANE);
		BGPANE.setLayout(null);

		panelNuovoIngresso = new JPanel();
		panelNuovoIngresso.setBounds(147, 0, 635, 565);
		BGPANE.add(panelNuovoIngresso);
		panelNuovoIngresso.setLayout(null);

		JLabel label = new JLabel("Data:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(193, 83, 41, 23);
		panelNuovoIngresso.add(label);

		JLabel label_1 = new JLabel("Crea Nuovo Ingresso");
		label_1.setFont(new Font("Arial", Font.PLAIN, 30));
		label_1.setBounds(175, 13, 289, 35);
		panelNuovoIngresso.add(label_1);

		textFieldGiorno = new JTextField();
		textFieldGiorno.setColumns(10);
		textFieldGiorno.setBounds(232, 84, 30, 23);
		panelNuovoIngresso.add(textFieldGiorno);

		JLabel lblPosizioni = new JLabel("Posizioni");
		lblPosizioni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPosizioni.setBounds(193, 127, 80, 16);
		panelNuovoIngresso.add(lblPosizioni);

		JLabel lblQuantit = new JLabel("Quantit\u00E0");
		lblQuantit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantit.setBounds(307, 127, 85, 16);
		panelNuovoIngresso.add(lblQuantit);

		JLabel lblNewLabel_45 = new JLabel("/");
		lblNewLabel_45.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_45.setBounds(267, 85, 17, 16);
		panelNuovoIngresso.add(lblNewLabel_45);

		textFieldMese = new JTextField();
		textFieldMese.setBounds(279, 84, 30, 22);
		panelNuovoIngresso.add(textFieldMese);
		textFieldMese.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(309, 85, 17, 16);
		panelNuovoIngresso.add(lblNewLabel_5);

		textFieldAnno = new JTextField();
		textFieldAnno.setBounds(321, 84, 80, 22);
		panelNuovoIngresso.add(textFieldAnno);
		textFieldAnno.setColumns(10);

		JButton button = new JButton("Annulla");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(232, 499, 145, 35);
		panelNuovoIngresso.add(button);

		JButton button_1 = new JButton("Crea Ingresso");

		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBounds(212, 445, 180, 35);
		panelNuovoIngresso.add(button_1);

		JLabel lblArticolo = new JLabel("Articolo");
		lblArticolo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblArticolo.setBounds(79, 126, 80, 16);
		panelNuovoIngresso.add(lblArticolo);
		
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(79, 155, 109, 22);
		panelNuovoIngresso.add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<>();
		comboBox_2.setBounds(79, 178, 109, 22);
		panelNuovoIngresso.add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<>();
		comboBox_3.setBounds(79, 202, 109, 22);
		panelNuovoIngresso.add(comboBox_3);
		
		JComboBox<String> comboBox_4 = new JComboBox<>();
		comboBox_4.setBounds(79, 225, 109, 22);
		panelNuovoIngresso.add(comboBox_4);
		
		JComboBox<String> comboBox_5 = new JComboBox<>();
		comboBox_5.setBounds(79, 249, 109, 22);
		panelNuovoIngresso.add(comboBox_5);
		
		JComboBox<String> comboBox_6 = new JComboBox<>();
		comboBox_6.setBounds(79, 274, 109, 22);
		panelNuovoIngresso.add(comboBox_6);
		
		JComboBox<String> comboBox_7 = new JComboBox<>();
		comboBox_7.setBounds(79, 298, 109, 22);
		panelNuovoIngresso.add(comboBox_7);
		
		JComboBox<String> comboBox_8 = new JComboBox<>();
		comboBox_8.setBounds(79, 322, 109, 22);
		panelNuovoIngresso.add(comboBox_8);
		
		JComboBox<String> comboBox_9 = new JComboBox<>();
		comboBox_9.setBounds(79, 345, 109, 22);
		panelNuovoIngresso.add(comboBox_9);
		
		JComboBox<String> comboBox_10 = new JComboBox<>();
		comboBox_10.setBounds(79, 369, 109, 22);
		panelNuovoIngresso.add(comboBox_10);
	
		textField_12 = new JTextField();
		textField_12.setBounds(193, 155, 116, 22);
		panelNuovoIngresso.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(193, 178, 116, 22);
		panelNuovoIngresso.add(textField_13);
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setBounds(193, 202, 116, 22);
		panelNuovoIngresso.add(textField_14);
		textField_14.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setBounds(193, 225, 116, 22);
		panelNuovoIngresso.add(textField_15);
		textField_15.setColumns(10);

		textField_16 = new JTextField();
		textField_16.setBounds(193, 249, 116, 22);
		panelNuovoIngresso.add(textField_16);
		textField_16.setColumns(10);

		textField_17 = new JTextField();
		textField_17.setBounds(193, 274, 116, 22);
		panelNuovoIngresso.add(textField_17);
		textField_17.setColumns(10);

		textField_18 = new JTextField();
		textField_18.setBounds(193, 298, 116, 22);
		panelNuovoIngresso.add(textField_18);
		textField_18.setColumns(10);

		textField_19 = new JTextField();
		textField_19.setBounds(193, 322, 116, 22);
		panelNuovoIngresso.add(textField_19);
		textField_19.setColumns(10);

		textField_20 = new JTextField();
		textField_20.setBounds(193, 345, 116, 22);
		panelNuovoIngresso.add(textField_20);
		textField_20.setColumns(10);

		textField_21 = new JTextField();
		textField_21.setBounds(193, 369, 116, 22);
		panelNuovoIngresso.add(textField_21);
		textField_21.setColumns(10);

		textField_22 = new JTextField();
		textField_22.setBounds(307, 155, 116, 22);
		panelNuovoIngresso.add(textField_22);
		textField_22.setColumns(10);

		textField_23 = new JTextField();
		textField_23.setBounds(307, 178, 116, 22);
		panelNuovoIngresso.add(textField_23);
		textField_23.setColumns(10);

		textField_24 = new JTextField();
		textField_24.setBounds(307, 202, 116, 22);
		panelNuovoIngresso.add(textField_24);
		textField_24.setColumns(10);

		textField_25 = new JTextField();
		textField_25.setBounds(307, 225, 116, 22);
		panelNuovoIngresso.add(textField_25);
		textField_25.setColumns(10);

		textField_26 = new JTextField();
		textField_26.setBounds(307, 249, 116, 22);
		panelNuovoIngresso.add(textField_26);
		textField_26.setColumns(10);

		textField_27 = new JTextField();
		textField_27.setBounds(307, 274, 116, 22);
		panelNuovoIngresso.add(textField_27);
		textField_27.setColumns(10);

		textField_28 = new JTextField();
		textField_28.setBounds(307, 298, 116, 22);
		panelNuovoIngresso.add(textField_28);
		textField_28.setColumns(10);

		textField_29 = new JTextField();
		textField_29.setBounds(307, 322, 116, 22);
		panelNuovoIngresso.add(textField_29);
		textField_29.setColumns(10);

		textField_30 = new JTextField();
		textField_30.setBounds(307, 345, 116, 22);
		panelNuovoIngresso.add(textField_30);
		textField_30.setColumns(10);

		textField_31 = new JTextField();
		textField_31.setBounds(307, 369, 116, 22);
		panelNuovoIngresso.add(textField_31);
		textField_31.setColumns(10);

		//button crea nuovo ingresso
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Articolo a1=null,a2=null,a3=null,a4=null,a5=null,a6=null,a7=null,a8=null,a9=null,a10 = null;
				String Articolo1="",Articolo2="",Articolo3="",Articolo4="",Articolo5="",Articolo6="",Articolo7="",Articolo8="",Articolo9="",Articolo10="";
				try {
					Map<Articolo, Integer> posizioni = new TreeMap<>();
					Map<Articolo, Integer> quantita = new TreeMap<>();
					//dichiaro le variabili intere
					int quantita1, quantita2, quantita3, quantita4, quantita5, quantita6, quantita7, quantita8, quantita9, quantita10;
					int posizione1, posizione2, posizione3, posizione4, posizione5, posizione6, posizione7, posizione8, posizione9, posizione10;
					
					
					//mi prendo l'articolo in base alla selezione
					Articolo1 = (String) comboBox_1.getSelectedItem();
					Articolo2 = (String) comboBox_2.getSelectedItem();
					Articolo3 = (String) comboBox_3.getSelectedItem();
					Articolo4 = (String) comboBox_4.getSelectedItem();
					Articolo5 = (String) comboBox_5.getSelectedItem();
					Articolo6 = (String) comboBox_6.getSelectedItem();
					Articolo7 = (String) comboBox_7.getSelectedItem();
					Articolo8 = (String) comboBox_8.getSelectedItem();
					Articolo9 = (String) comboBox_9.getSelectedItem();
					Articolo10 = (String) comboBox_10.getSelectedItem();

					//controllo gli articoli entrati

					if(!(Articolo1.equals("")))
						a1 = warehouse.articoloContainedByName(Articolo1);
					if(!(Articolo2.equals("")))
						a2 = warehouse.articoloContainedByName(Articolo2);
					if(!(Articolo3.equals("")))
						a3 = warehouse.articoloContainedByName(Articolo3);
					if(!(Articolo4.equals("")))
						a4 = warehouse.articoloContainedByName(Articolo4);
					if(!(Articolo5.equals("")))
						a5 = warehouse.articoloContainedByName(Articolo5);
					if(!(Articolo6.equals("")))
						a6 = warehouse.articoloContainedByName(Articolo6);
					if(!(Articolo7.equals("")))
						a7 = warehouse.articoloContainedByName(Articolo7);
					if(!(Articolo8.equals("")))
						a8 = warehouse.articoloContainedByName(Articolo8);
					if(!(Articolo9.equals("")))
						a9 = warehouse.articoloContainedByName(Articolo9);
					if(!(Articolo10.equals("")))
						a10 = warehouse.articoloContainedByName(Articolo10);

					//mi prendo o mi setto i valori di quantita e posizione
					quantita1 = textField_22.getText().equals("") || textField_22.getText().equals(" ") ? 0 : Integer.parseInt(textField_22.getText());
					quantita2 = textField_23.getText().equals("") || textField_23.getText().equals(" ") ? 0 : Integer.parseInt(textField_23.getText());
					quantita3 = textField_24.getText().equals("") || textField_24.getText().equals(" ") ? 0 : Integer.parseInt(textField_24.getText());
					quantita4 = textField_25.getText().equals("") || textField_25.getText().equals(" ") ? 0 : Integer.parseInt(textField_25.getText());
					quantita5 = textField_26.getText().equals("") || textField_26.getText().equals(" ") ? 0 : Integer.parseInt(textField_26.getText());
					quantita6 = textField_27.getText().equals("") || textField_27.getText().equals(" ") ? 0 : Integer.parseInt(textField_27.getText());
					quantita7 = textField_28.getText().equals("") || textField_28.getText().equals(" ") ? 0 : Integer.parseInt(textField_28.getText());
					quantita8 = textField_29.getText().equals("") || textField_29.getText().equals(" ") ? 0 : Integer.parseInt(textField_29.getText());
					quantita9 = textField_30.getText().equals("") || textField_30.getText().equals(" ") ? 0 : Integer.parseInt(textField_30.getText());
					quantita10 = textField_31.getText().equals("") || textField_31.getText().equals(" ") ? 0 : Integer.parseInt(textField_31.getText());

					posizione1 = textField_12.getText().equals("") || textField_12.getText().equals(" ") ? 0 : Integer.parseInt(textField_12.getText());
					posizione2 = textField_13.getText().equals("") || textField_13.getText().equals(" ") ? 0 : Integer.parseInt(textField_13.getText());
					posizione3 = textField_14.getText().equals("") || textField_14.getText().equals(" ") ? 0 : Integer.parseInt(textField_14.getText());
					posizione4 = textField_15.getText().equals("") || textField_15.getText().equals(" ") ? 0 : Integer.parseInt(textField_15.getText());
					posizione5 = textField_16.getText().equals("") || textField_16.getText().equals(" ") ? 0 : Integer.parseInt(textField_16.getText());
					posizione6 = textField_17.getText().equals("") || textField_17.getText().equals(" ") ? 0 : Integer.parseInt(textField_17.getText());
					posizione7 = textField_18.getText().equals("") || textField_18.getText().equals(" ") ? 0 : Integer.parseInt(textField_18.getText());
					posizione8 = textField_19.getText().equals("") || textField_19.getText().equals(" ") ? 0 : Integer.parseInt(textField_19.getText());
					posizione9 = textField_20.getText().equals("") || textField_20.getText().equals(" ") ? 0 : Integer.parseInt(textField_20.getText());
					posizione10 = textField_21.getText().equals("") || textField_21.getText().equals(" ") ? 0 : Integer.parseInt(textField_21.getText());

					//ora devo solo controllare che l'utente non mi abbia selezionato lo stesso articolo, in tal caso prensdo le quantità e le sommo
					//le posizioni invece prendo solo l'ultima
					if(!(Articolo10.equals(""))) {
						if (quantita10 == 0 || posizione10 == 0 ) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
						}
						if (quantita.containsKey(a10)) {
							quantita.put(a10, quantita.get(a10) + quantita10);
						} else {
							quantita.put(a10, quantita10);
						}
						posizioni.put(a10, posizione10);
					}
					if(!(Articolo9.equals(""))) {
						if (quantita9 == 0 || posizione9 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a9)) {
							quantita.put(a9, quantita.get(a9) + quantita9);
						} else {
							quantita.put(a9, quantita9);
						}
						posizioni.put(a9, posizione9);
					}
					if(!(Articolo8.equals(""))) {
						if (quantita8 == 0 || posizione8 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a8)) {
							quantita.put(a8, quantita.get(a8) + quantita8);
						} else {
							quantita.put(a8, quantita8);
						}
						posizioni.put(a8, posizione8);
					}
					if(!(Articolo7.equals(""))) {
						if (quantita7 == 0 || posizione7 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a7)) {
							quantita.put(a7, quantita.get(a7) + quantita7);
						} else {
							quantita.put(a7, quantita7);
						}
						posizioni.put(a7, posizione7);
					}
					if(!(Articolo6.equals(""))) {
						if (quantita6 == 0 || posizione6 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a6)) {
							quantita.put(a6, quantita.get(a6) + quantita6);
						} else {
							quantita.put(a6, quantita6);
						}
						posizioni.put(a6, posizione6);
					}
					if(!(Articolo5.equals(""))) {
						if (quantita5 == 0 || posizione5 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a5)) {
							quantita.put(a10, quantita.get(a5) + quantita5);
						} else {
							quantita.put(a5, quantita5);
						}
						posizioni.put(a5, posizione5);
					}
					if(!(Articolo4.equals(""))) {
						if (quantita4 == 0 || posizione4 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a4)) {
							quantita.put(a4, quantita.get(a4) + quantita4);
						} else {
							quantita.put(a4, quantita4);
						}
						posizioni.put(a4, posizione4);
					}

					if(!(Articolo3.equals(""))) {
						if (quantita3 == 0 || posizione3 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a3)) {
							quantita.put(a3, quantita.get(a3) + quantita3);
						} else {
							quantita.put(a3, quantita3);
						}
						posizioni.put(a3, posizione3);
					}
					if(!(Articolo2.equals(""))) {
						if (quantita2 == 0 || posizione2 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a2)) {
							quantita.put(a2, quantita.get(a2) + quantita2);
						} else {
							quantita.put(a2, quantita2);
						}
						posizioni.put(a2, posizione2);
					}
					if(!(Articolo1.equals(""))) {
						if (quantita1 == 0 || posizione1 == 0) {
							JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
							return;
						}

						if (quantita.containsKey(a1)) {
							quantita.put(a1, quantita.get(a1) + quantita2);
						} else {
							quantita.put(a1, quantita1);
						}
						posizioni.put(a1, posizione1);
					}
					int day = Integer.parseInt(textFieldGiorno.getText());
					int month = Integer.parseInt(textFieldMese.getText());
					int year = Integer.parseInt(textFieldAnno.getText());
					GregorianCalendar c = new GregorianCalendar(year, month, day);

					if (posizioni.isEmpty() && quantita.isEmpty()) {  //forzo il controllo su entrambe le mappe anche se non dovrebbe essere necessario visto che devono essere identiche
						//se le mappe sono identiche ignoro l'inserimento 
						nascondiPannelli();
						ingressi();
						panelIngressi.setVisible(true);
						return;
					}

					//ora posso aggiungere l'ingresso
					warehouse.addIngresso(quantita, posizioni, c);
					indexIngressi = warehouse.ingressiSize() - 1;
					nascondiPannelli();
					ingressi();
					panelIngressi.setVisible(true);

					//resetto le stringhe
					comboBox_1.removeAllItems();
					textField_12.setText("");
					textField_22.setText("");
					comboBox_2.removeAllItems();
					textField_13.setText("");
					textField_23.setText("");
					comboBox_3.removeAllItems();
					textField_14.setText("");
					textField_24.setText("");
					comboBox_4.removeAllItems();
					textField_15.setText("");
					textField_25.setText("");
					comboBox_5.removeAllItems();
					textField_16.setText("");
					textField_26.setText("");
					comboBox_6.removeAllItems();
					textField_17.setText("");
					textField_27.setText("");					
					comboBox_7.removeAllItems();
					textField_18.setText("");
					textField_28.setText("");
					comboBox_8.removeAllItems();
					textField_19.setText("");
					textField_29.setText("");
					comboBox_9.removeAllItems();
					textField_20.setText("");
					textField_30.setText("");
					comboBox_10.removeAllItems();
					textField_21.setText("");
					textField_31.setText("");
				} catch (Exception ex) {
					Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		//chiudi pannello Inserisci nuovo ingresso
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textFieldGiorno.setText("");
				textFieldMese.setText("");
				textFieldAnno.setText("");
				comboBox_1.removeAllItems();
				textField_12.setText("");
				textField_22.setText("");
				comboBox_2.removeAllItems();
				textField_13.setText("");
				textField_23.setText("");
				comboBox_3.removeAllItems();
				textField_14.setText("");
				textField_24.setText("");
				comboBox_4.removeAllItems();
				textField_15.setText("");
				textField_25.setText("");
				comboBox_5.removeAllItems();
				textField_16.setText("");
				textField_26.setText("");
				comboBox_6.removeAllItems();
				textField_17.setText("");
				textField_27.setText("");					
				comboBox_7.removeAllItems();
				textField_18.setText("");
				textField_28.setText("");
				comboBox_8.removeAllItems();
				textField_19.setText("");
				textField_29.setText("");
				comboBox_9.removeAllItems();
				textField_20.setText("");
				textField_30.setText("");
				comboBox_10.removeAllItems();
				textField_21.setText("");
				textField_31.setText("");
				nascondiPannelli();
				panelIngressi.setVisible(true);
			}
		});

		
		panelIngressi = new JPanel();
		panelIngressi.setBounds(147, 0, 650, 565);
		BGPANE.add(panelIngressi);
		panelIngressi.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(45, 72, 25, 26);
		panelIngressi.add(lblId);

		JLabel lblVisualizzaIngressi = new JLabel("Visualizza Ingressi");
		lblVisualizzaIngressi.setBounds(209, 5, 246, 35);
		lblVisualizzaIngressi.setFont(new Font("Arial", Font.PLAIN, 30));
		panelIngressi.add(lblVisualizzaIngressi);

		labelViewId = new JLabel("");
		labelViewId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelViewId.setBounds(77, 78, 106, 16);
		panelIngressi.add(labelViewId);

		JLabel lblData = new JLabel("Data ingresso:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setBounds(195, 77, 94, 16);
		panelIngressi.add(lblData);

		lblViewData = new JLabel("");
		lblViewData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblViewData.setBounds(295, 78, 106, 16);
		panelIngressi.add(lblViewData);

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(45, 112, 550, 307);
		panelIngressi.add(textPane);

		JLabel lblN = new JLabel("Ingresso n:");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblN.setBounds(409, 78, 75, 16);
		panelIngressi.add(lblN);

		btnNuovoIngresso = new JButton("Nuovo ingresso");				
		btnNuovoIngresso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNuovoIngresso.setBounds(231, 432, 133, 35);
		panelIngressi.add(btnNuovoIngresso);

		buttonIngressiIndietro = new JButton("<");
		buttonIngressiIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexIngressi--;
				ingressi();
			}
		});
		buttonIngressiIndietro.setBounds(485, 74, 41, 25);
		panelIngressi.add(buttonIngressiIndietro);

		labelCountIngressi = new JLabel("");
		labelCountIngressi.setBounds(528, 78, 25, 16);
		panelIngressi.add(labelCountIngressi);

		buttonIngressiAvanti = new JButton(">");
		buttonIngressiAvanti.setBounds(553, 74, 41, 25);
		panelIngressi.add(buttonIngressiAvanti);
		buttonIngressiAvanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexIngressi++;
				ingressi();
			}
		});


		//da ingressi a crea nuovo ingresso
		btnNuovoIngresso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nascondiPannelli();
				panelNuovoIngresso.setVisible(true);
				comboBox_1.removeAllItems();
				comboBox_1.addItem("");
				textField_12.setText("");
				textField_22.setText("");
				comboBox_2.removeAllItems();
				comboBox_2.addItem("");
				textField_13.setText("");
				textField_23.setText("");
				comboBox_3.removeAllItems();
				comboBox_3.addItem("");
				textField_14.setText("");
				textField_24.setText("");
				comboBox_4.removeAllItems();
				comboBox_4.addItem("");
				textField_15.setText("");
				textField_25.setText("");
				comboBox_5.removeAllItems();
				comboBox_5.addItem("");
				textField_16.setText("");
				textField_26.setText("");
				comboBox_6.removeAllItems();
				comboBox_6.addItem("");
				textField_17.setText("");
				textField_27.setText("");					
				comboBox_7.removeAllItems();
				comboBox_7.addItem("");
				textField_18.setText("");
				textField_28.setText("");
				comboBox_8.removeAllItems();
				comboBox_8.addItem("");
				textField_19.setText("");
				textField_29.setText("");
				comboBox_9.removeAllItems();
				comboBox_9.addItem("");
				textField_20.setText("");
				textField_30.setText("");
				comboBox_10.removeAllItems();
				comboBox_10.addItem("");
				textField_21.setText("");
				textField_31.setText("");
				
				for(Articolo art : warehouse.getArticoloList()) {
					comboBox_1.addItem(art.getTipoArticolo().getName());
					comboBox_2.addItem(art.getTipoArticolo().getName());
					comboBox_3.addItem(art.getTipoArticolo().getName());
					comboBox_4.addItem(art.getTipoArticolo().getName());
					comboBox_5.addItem(art.getTipoArticolo().getName());
					comboBox_6.addItem(art.getTipoArticolo().getName());
					comboBox_7.addItem(art.getTipoArticolo().getName());
					comboBox_8.addItem(art.getTipoArticolo().getName());
					comboBox_9.addItem(art.getTipoArticolo().getName());
					comboBox_10.addItem(art.getTipoArticolo().getName());

				}
				
			}


		});


		panelOrdini = new JPanel();
		panelOrdini.setBounds(147, 0, 650, 570);
		BGPANE.add(panelOrdini);
		panelOrdini.setLayout(null);

		PanelCreaNuovoOrd = new JPanel();
		PanelCreaNuovoOrd.setBounds(0, 0, 650, 570);
		panelOrdini.add(PanelCreaNuovoOrd);
		PanelCreaNuovoOrd.setLayout(null);


		JLabel lblCreaNuovoOrdine = new JLabel("Crea Nuovo Ordine:");
		lblCreaNuovoOrdine.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreaNuovoOrdine.setFont(new Font("Arial", Font.ITALIC, 30));
		lblCreaNuovoOrdine.setBackground(Color.WHITE);
		lblCreaNuovoOrdine.setBounds(104, 11, 348, 50);
		PanelCreaNuovoOrd.add(lblCreaNuovoOrdine);



		lblNegozio_o = new JLabel("Negozio:");
		lblNegozio_o.setBounds(424, 242, 71, 14);
		PanelCreaNuovoOrd.add(lblNegozio_o);

		JComboBox<String> SelectNegozio = new JComboBox<>();

		SelectNegozio.setBounds(383, 259, 124, 20);
		PanelCreaNuovoOrd.add(SelectNegozio);


		JPanel CorniceArticoloLabel = new JPanel();
		CorniceArticoloLabel.setBounds(105, 70, 228, 227);
		PanelCreaNuovoOrd.add(CorniceArticoloLabel);
		CorniceArticoloLabel.setLayout(null);

		JLabel lblArticoli_1 = new JLabel("Articoli:");
		lblArticoli_1.setVerticalAlignment(SwingConstants.TOP);
		lblArticoli_1.setBounds(132, 11, 42, 14);
		CorniceArticoloLabel.add(lblArticoli_1);

		quantita1 = new JTextField();
		quantita1.setBounds(10, 31, 86, 20);
		CorniceArticoloLabel.add(quantita1);
		quantita1.setColumns(10);

		quantita2 = new JTextField();
		quantita2.setBounds(10, 62, 86, 20);
		CorniceArticoloLabel.add(quantita2);
		quantita2.setColumns(10);

		quantita3 = new JTextField();
		quantita3.setBounds(10, 93, 86, 20);
		CorniceArticoloLabel.add(quantita3);
		quantita3.setColumns(10);

		JComboBox<String> comboBoxSel1 = new JComboBox<>();

		comboBoxSel1.setBounds(132, 31, 86, 20);
		CorniceArticoloLabel.add(comboBoxSel1);

		JComboBox<String> comboBoxSel2 = new JComboBox<>();
		comboBoxSel2.setBounds(132, 62, 86, 20);
		CorniceArticoloLabel.add(comboBoxSel2);

		JComboBox<String> comboBoxSel3 = new JComboBox<>();
		comboBoxSel3.setBounds(132, 93, 86, 20);
		CorniceArticoloLabel.add(comboBoxSel3);

		quantita4 = new JTextField();
		quantita4.setBounds(10, 124, 86, 20);
		CorniceArticoloLabel.add(quantita4);
		quantita4.setColumns(10);

		quantita5 = new JTextField();
		quantita5.setBounds(10, 155, 86, 20);
		CorniceArticoloLabel.add(quantita5);
		quantita5.setColumns(10);

		JComboBox<String> comboBoxSel4 = new JComboBox<>();
		comboBoxSel4.setBounds(132, 124, 86, 20);
		CorniceArticoloLabel.add(comboBoxSel4);

		JComboBox<String> comboBoxSel5 = new JComboBox<>();
		comboBoxSel5.setBounds(132, 155, 86, 20);
		CorniceArticoloLabel.add(comboBoxSel5);

		quantita6 = new JTextField();
		quantita6.setBounds(10, 186, 86, 20);
		CorniceArticoloLabel.add(quantita6);
		quantita6.setColumns(10);

		JComboBox<String> comboBoxSel6 = new JComboBox<>();
		comboBoxSel6.setBounds(132, 186, 86, 20);
		CorniceArticoloLabel.add(comboBoxSel6);

		JLabel lblQuantit_1 = new JLabel("Quantit\u00E0");
		lblQuantit_1.setBounds(10, 11, 56, 16);
		CorniceArticoloLabel.add(lblQuantit_1);

		textCorriere = new JTextField();
		textCorriere.setBounds(383, 208, 124, 23);
		PanelCreaNuovoOrd.add(textCorriere);
		textCorriere.setColumns(10);

		JLabel lblCorriere = new JLabel("Corriere:");
		lblCorriere.setBounds(424, 192, 83, 14);
		PanelCreaNuovoOrd.add(lblCorriere);
		//
		//CREA ORDINE
		JButton btnCrea = new JButton("Crea");
		btnCrea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean voidSelection = false;


				String corriere = textCorriere.getText();

				if (corriere.equals("") && corriere.equals(" ")) {//controllo che sia stato inserito un corriere valido
					JOptionPane.showMessageDialog(null, "Inserire un campo corriere valido! ");
					return;
				}

				String negozio = (String) SelectNegozio.getSelectedItem();
				System.out.println(negozio);
				Negozio x = warehouse.negozioContainedByName(negozio);

				Map<Articolo, Integer> articoliAndQuantita = new HashMap<>();

				int qnt1;
				int qnt2;
				int qnt3;
				int qnt4;
				int qnt5;
				int qnt6;

				String articolo1 = (String) comboBoxSel1.getSelectedItem();
				String articolo2 = (String) comboBoxSel2.getSelectedItem();
				String articolo3 = (String) comboBoxSel3.getSelectedItem();
				String articolo4 = (String) comboBoxSel4.getSelectedItem();
				String articolo5 = (String) comboBoxSel5.getSelectedItem();
				String articolo6 = (String) comboBoxSel6.getSelectedItem();
				//DA QUA

				try {
					qnt1 = quantita1.getText().equals("") || quantita1.getText().equals(" ") ? 0 : Integer.parseInt(quantita1.getText());
					qnt2 = quantita2.getText().equals("") || quantita2.getText().equals(" ") ? 0 : Integer.parseInt(quantita2.getText());
					qnt3 = quantita3.getText().equals("") || quantita3.getText().equals(" ") ? 0 : Integer.parseInt(quantita3.getText());
					qnt4 = quantita4.getText().equals("") || quantita4.getText().equals(" ") ? 0 : Integer.parseInt(quantita4.getText());
					qnt5 = quantita5.getText().equals("") || quantita5.getText().equals(" ") ? 0 : Integer.parseInt(quantita5.getText());
					qnt6 = quantita6.getText().equals("") || quantita6.getText().equals(" ") ? 0 : Integer.parseInt(quantita6.getText());

					if (articolo1.equals("") && qnt1 != 0) {
						JOptionPane.showMessageDialog(null, "Selezionare un articolo!");
						voidSelection = true;
						return;
					}
					if (articolo2.equals("") && qnt2 != 0) {
						JOptionPane.showMessageDialog(null, "Selezionare un articolo!");
						voidSelection = true;
						return;
					}
					if (articolo3.equals("") && qnt3 != 0) {
						JOptionPane.showMessageDialog(null, "Selezionare un articolo!");
						voidSelection = true;
						return;
					}
					if (articolo4.equals("") && qnt4 != 0) {
						JOptionPane.showMessageDialog(null, "Selezionare un articolo!");
						voidSelection = true;
						return;
					}
					if (articolo5.equals("") && qnt5 != 0) {
						JOptionPane.showMessageDialog(null, "Selezionare un articolo!");
						voidSelection = true;
						return;
					}
					if (articolo6.equals("") && qnt6 != 0) {
						JOptionPane.showMessageDialog(null, "Selezionare un articolo!");
						voidSelection = true;
						return;
					}

					Articolo a1 = articolo1.equals("") ? null : warehouse.articoloContainedByName(articolo1);
					Articolo a2 = articolo2.equals("") ? null : warehouse.articoloContainedByName(articolo2);
					Articolo a3 = articolo3.equals("") ? null : warehouse.articoloContainedByName(articolo3);
					Articolo a4 = articolo4.equals("") ? null : warehouse.articoloContainedByName(articolo4);
					Articolo a5 = articolo5.equals("") ? null : warehouse.articoloContainedByName(articolo5);
					Articolo a6 = articolo6.equals("") ? null : warehouse.articoloContainedByName(articolo6);

					if (qnt1 > 0 && !(articolo1.equals(""))) {
						articoliAndQuantita.put(a1, qnt1);
					}


					if (qnt2 > 0 && !(articolo2.equals(""))) {
						if (articoliAndQuantita.containsKey(a2))//controllo se è già stato inserito
						{
							articoliAndQuantita.put(a2, qnt2 + articoliAndQuantita.get(a2));
						} else {
							articoliAndQuantita.put(a2, qnt2);
						}
					}

					if (qnt3 > 0 && !(articolo5.equals(""))) {
						if (articoliAndQuantita.containsKey(a3))//controllo se è già stato inserito
						{
							articoliAndQuantita.put(a3, qnt3 + articoliAndQuantita.get(a3));
						} else {
							articoliAndQuantita.put(a3, qnt3);
						}
					}

					if (qnt4 > 0 && !(articolo4.equals(""))) {
						if (articoliAndQuantita.containsKey(a4))//controllo se è già stato inserito
						{
							articoliAndQuantita.put(a4, qnt4 + articoliAndQuantita.get(a4));
						} else {
							articoliAndQuantita.put(a4, qnt4);
						}
					}

					if (qnt5 > 0 && !(articolo5.equals(""))) {
						if (articoliAndQuantita.containsKey(a5))//controllo se è già stato inserito
						{
							articoliAndQuantita.put(a5, qnt5 + articoliAndQuantita.get(a5));
						} else {
							articoliAndQuantita.put(a5, qnt5);
						}
					}

					if (qnt6>0 && !(articolo6.equals(""))) {
						if (articoliAndQuantita.containsKey(a6))//controllo se è già stato inserito
						{
							articoliAndQuantita.put(a6, qnt6 + articoliAndQuantita.get(a6));
						} else {
							articoliAndQuantita.put(a6, qnt6);
						}
					}
					if (articoliAndQuantita.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Inserisci almeno un oggetto!");
						return;
					}
					Ordine o1 = new Ordine(x, corriere, new GregorianCalendar(), articoliAndQuantita);
					System.out.println(x.toString());
					System.out.println(corriere.toString());
					System.out.println( new GregorianCalendar().toString());
					System.out.println(articoliAndQuantita.toString());



					warehouse.addOrdine(o1);
					indexOrder = warehouse.ordineSize() - 1;

					fillTable("ordini", (DefaultTableModel)tableOrdini.getModel());


				}catch (ArticleDontExistInWareHouseException | HeadlessException | VoidStringUnexpectedException e) {
					JOptionPane.showMessageDialog(null, "Eccezione");
				}finally {
					if (voidSelection) {
						return;
					}

					nascondiPannelli();
					panelOrdini.setVisible(true);
					textCorriere.setText("");
					quantita1.setText("");
					quantita2.setText("");
					quantita3.setText("");
					quantita4.setText("");
					quantita5.setText("");
					quantita6.setText("");


				}


			}
		});
		btnCrea.setBounds(383, 89, 124, 39);
		PanelCreaNuovoOrd.add(btnCrea);
		PanelCreaNuovoOrd.setVisible(false);

		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCreaNuovoOrd.setVisible(false);
				PanelTableOrdiniPrinc.setVisible(true);
				PanelTableOrdini.setVisible(true);

			}
		});
		btnChiudi.setBounds(383, 131, 124, 39);
		PanelCreaNuovoOrd.add(btnChiudi);


		PanelTableOrdiniPrinc = new JPanel();
		PanelTableOrdiniPrinc.setBounds(0, 0, 650, 570);
		panelOrdini.add(PanelTableOrdiniPrinc);
		PanelTableOrdiniPrinc.setLayout(null);

		PanelTableOrdini = new JPanel();
		PanelTableOrdini.setBounds(0, 50, 650, 370);
		PanelTableOrdiniPrinc.add(PanelTableOrdini);
		PanelTableOrdini.setLayout(new BorderLayout(0, 0));

		JTextArea articoliQuantitaTextArea = new JTextArea();
		articoliQuantitaTextArea.setEditable(false);
		articoliQuantitaTextArea.setBounds(75, 450, 160, 109);
		PanelTableOrdiniPrinc.add(articoliQuantitaTextArea);

		tableOrdini = new JTable();
		tableOrdini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				indexOrder = tableOrdini.getSelectedRow();
				articoliQuantitaTextArea.setText(""+ warehouse.getOrdine(indexOrder).toString());
			}
		});
		tableOrdini.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Data", "Prezzo", "Negozio", "Corriere", "Sped.", "Num. Articoli"
				}
				));
		tableOrdini.setShowVerticalLines(false);
		tableOrdini.setFont(new Font("Arial", Font.PLAIN, 13));
		tableOrdini.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tableOrdini.setBackground(Color.LIGHT_GRAY);
		PanelTableOrdini.add(tableOrdini.getTableHeader(), BorderLayout.NORTH);
		PanelTableOrdini.add(tableOrdini, BorderLayout.CENTER);

		fillTable("ordini",(DefaultTableModel) tableOrdini.getModel());

		lblArticoliEQuantit = new JLabel("Articoli e Quantit\u00E0:");
		lblArticoliEQuantit.setBounds(78, 435, 157, 14);
		PanelTableOrdiniPrinc.add(lblArticoliEQuantit);

		labelOrdini = new JLabel("Ordini");
		labelOrdini.setBounds(200, 0, 250, 50);
		PanelTableOrdiniPrinc.add(labelOrdini);
		labelOrdini.setHorizontalAlignment(SwingConstants.CENTER);
		labelOrdini.setFont(new Font("Arial", Font.ITALIC, 30));
		labelOrdini.setBackground(Color.WHITE);

		JButton btnEliminaOrdine = new JButton("Elimina Ordine");
		btnEliminaOrdine.setBounds(444, 501, 131, 23);
		PanelTableOrdiniPrinc.add(btnEliminaOrdine);
		btnEliminaOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warehouse.removeOrdine(warehouse.getOrdine(tableOrdini.getSelectedRow()));
				fillTable("ordini",(DefaultTableModel) tableOrdini.getModel());
			}
		});
		btnGeneraUscita = new JButton("Genera Uscita");
		btnGeneraUscita.setBounds(265, 474, 124, 50);
		PanelTableOrdiniPrinc.add(btnGeneraUscita);
		btnGeneraUscita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(warehouse.getOrdine(indexOrder).getIfShipped())
					JOptionPane.showMessageDialog(null,"Impossibile generare l' uscita: L' ordine è già stato spedito!");
				else try {
					warehouse.createExit(warehouse.getOrdine(indexOrder));
					fillTable("ordini",(DefaultTableModel) tableOrdini.getModel());
				}
				catch(OrderNotFound | ArticleNotFound | OrderImpossibleToCreate ex) {
					JOptionPane.showMessageDialog(null,"Quantità articoli non sufficiente");
				}
			}
		});

		btnCreaNuovoOrd = new JButton("Crea Nuovo Ordine");
		btnCreaNuovoOrd.setBounds(434, 465, 167, 23);
		PanelTableOrdiniPrinc.add(btnCreaNuovoOrd);

		//carica i combo box
		btnCreaNuovoOrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCreaOrdPanel();
				varflag = 0;
				comboBoxSel6.removeAllItems();
				comboBoxSel5.removeAllItems();
				comboBoxSel4.removeAllItems();
				comboBoxSel3.removeAllItems();
				comboBoxSel2.removeAllItems();
				comboBoxSel1.removeAllItems();
				comboBoxSel6.addItem("");
				comboBoxSel5.addItem("");
				comboBoxSel4.addItem("");
				comboBoxSel3.addItem("");
				comboBoxSel2.addItem("");
				comboBoxSel1.addItem("");
				for(Articolo art : warehouse.getArticoloList()) {
					comboBoxSel6.addItem(art.getTipoArticolo().getName());
					comboBoxSel5.addItem(art.getTipoArticolo().getName());
					comboBoxSel4.addItem(art.getTipoArticolo().getName());
					comboBoxSel3.addItem(art.getTipoArticolo().getName());
					comboBoxSel2.addItem(art.getTipoArticolo().getName());
					comboBoxSel1.addItem(art.getTipoArticolo().getName());

				}
				SelectNegozio.removeAllItems();
				SelectNegozio.addItem("");
				for(Negozio n : warehouse.getNegozioList())
					SelectNegozio.addItem(n.getNome());
			}
		});

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
				try {
					aggiungiAlDB(arg0,"articolo");
					if(varflag==1) {//cancelliamo l'articolo perchè l'hash cambia se cambia la data o prezzo
						warehouse.removeArticolo(temp);
					}
					clearTexts(arg0);
					closeButtonAction((JPanel)arg0.getComponent().getParent(),"articoli");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fillTable("articoli",(DefaultTableModel) tableArticoli.getModel());
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
		txtPrezzoArticolo.setBounds(186, 137, 150, 30);
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


		rdbtnPoliestere = new JRadioButton("Poliestere");
		rdbtnPoliestere.setBounds(25, 340, 100, 25);
		PanelAggiungiArticolo.add(rdbtnPoliestere);
		group_btn.add(rdbtnPoliestere);

		rdbtnSilicone = new JRadioButton("Silicone");
		rdbtnSilicone.setBounds(25, 368, 100, 25);
		PanelAggiungiArticolo.add(rdbtnSilicone);
		group_btn.add(rdbtnSilicone);

		rdbtnPelleSintetica = new JRadioButton("Finta Pelle");
		rdbtnPelleSintetica.setBounds(25, 396, 100, 25);
		PanelAggiungiArticolo.add(rdbtnPelleSintetica);
		group_btn.add(rdbtnPelleSintetica);

		rdbtnGoretex = new JRadioButton("Gore-Tex");
		rdbtnGoretex.setBounds(25, 424, 100, 25);
		PanelAggiungiArticolo.add(rdbtnGoretex);
		group_btn.add(rdbtnGoretex);

		rdbtnElastan = new JRadioButton("Elastan");
		rdbtnElastan.setBounds(125, 340, 100, 25);
		PanelAggiungiArticolo.add(rdbtnElastan);
		group_btn.add(rdbtnElastan);

		rdbtnPolietilene = new JRadioButton("Polietilene");
		rdbtnPolietilene.setBounds(125, 368, 100, 25);
		PanelAggiungiArticolo.add(rdbtnPolietilene);
		group_btn.add(rdbtnPolietilene);

		rdbtnPoliammide = new JRadioButton("Poliammide");
		rdbtnPoliammide.setBounds(125, 396, 100, 25);
		PanelAggiungiArticolo.add(rdbtnPoliammide);
		group_btn.add(rdbtnPoliammide);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleziona", "Atletica", "Basket", "Calcio", "Ciclismo", "Danza", "Hockey", "Golf", "Nuoto", "Palestra", "Pallavolo", "Rufting", "Rugby", "Scii", "Tennis"}));
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
				tabellaRigaSel(false,"articoli"); // false è l'azione, non visualizza il pannello ma mantiene solo il valore sul box debug

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
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("rawtypes")
			private
			Class[] types = new Class [] {
					java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class
			};

			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			@SuppressWarnings({ "rawtypes", "unused" })
			public Class[] getTypes() {
				return types;
			}
			@SuppressWarnings("unused")
			public void setTypes(@SuppressWarnings("rawtypes") Class[] types) {
				this.types = types;
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
		btnDettagli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabellaRigaSel(true,"articoli");
			}
		});
		btnDettagli.setBackground(SystemColor.control);
		btnDettagli.setFont(new Font("Comic Sans MS", Font.BOLD, 13));

		btnAggiungiArticolo = new JButton("Aggiungi Prodotto");
		btnAggiungiArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addArticlePanel();
				varflag = 0;
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


		btnModificaArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModArticlePanel(tableArticoli.getSelectedRow());
				} catch (ArticleDontExistInWareHouseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // passo la riga della tabella che è stata selezionata
			}
		});

		btnEliminaArt = new JButton("Elimina");
		btnEliminaArt.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnEliminaArt.setBounds(390, 495, 220, 49);
		PanelMainArt.add(btnEliminaArt);

		btnEliminaArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warehouse.removeArticolo(warehouse.getArticolo(tableArticoli.getSelectedRow()));
				fillTable("articoli",(DefaultTableModel) tableArticoli.getModel());

			}
		});

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

		panelRiepilogo = new JPanel();
		panelRiepilogo.setBounds(147, 0, 650, 565);
		BGPANE.add(panelRiepilogo);
		panelRiepilogo.setLayout(null);

		JLabel lblRiepilogoMese = new JLabel("Riepilogo mese:");
		lblRiepilogoMese.setBounds(77, 13, 243, 37);
		lblRiepilogoMese.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelRiepilogo.add(lblRiepilogoMese);

		lblMese = new JLabel("");
		lblMese.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMese.setBounds(326, 21, 169, 25);
		panelRiepilogo.add(lblMese);

		button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index++;
				report();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(495, 13, 51, 25);
		panelRiepilogo.add(button_2);

		btnNewButton = new JButton("-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index--;
				report();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(494, 36, 52, 25);
		panelRiepilogo.add(btnNewButton);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(77, 103, 496, 372);
		panelRiepilogo.add(textArea);

		JButton btnChiudiRiepilogo = new JButton("Chiudi Riepilogo");
		btnChiudiRiepilogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = 0;
				textArea.setText("");
				nascondiPannelli();
				menuazioni.setVisible(true);
			}
		});
		btnChiudiRiepilogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChiudiRiepilogo.setBounds(264, 498, 137, 37);
		panelRiepilogo.add(btnChiudiRiepilogo);


		JComboBox<String> comboBoxSports = new JComboBox<>();
		comboBoxSports.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		comboBoxSports.setModel(new DefaultComboBoxModel<String>(new String[] {"SPORTS"}));
		for(String s: TipoArticolo.sportArray) {
			comboBoxSports.addItem(s);
		}




		comboBoxSports.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if ( arg0.getStateChange() == ItemEvent.SELECTED) { // mi dice se ha cambiato elemento del combobox
					sportType = TipoArticolo.sportArray[(comboBoxSports.getSelectedIndex() - 1)];
					report();
				}


			}
		});

		comboBoxSports.setToolTipText("SPORT");
		comboBoxSports.setBounds(77, 61, 150, 31);
		panelRiepilogo.add(comboBoxSports);

		panelUscite = new JPanel();
		panelUscite.setBackground(UIManager.getColor("TabbedPane.highlight"));
		panelUscite.setBounds(147, 0, 650, 570);
		BGPANE.add(panelUscite);
		panelUscite.setLayout(null);

		JLabel lblUscite = new JLabel("Visualizza Uscite:");
		lblUscite.setFont(new Font("Arial", Font.PLAIN, 30));
		lblUscite.setBounds(81, 13, 233, 31);
		panelUscite.add(lblUscite);

		JLabel lblIdOrdine = new JLabel("ID Ordine:");
		lblIdOrdine.setBounds(57, 61, 66, 16);
		panelUscite.add(lblIdOrdine);

		JLabel lblNegozio = new JLabel("Negozio:");
		lblNegozio.setBounds(232, 61, 56, 16);
		panelUscite.add(lblNegozio);

		JLabel lblData_1 = new JLabel("Data:");
		lblData_1.setBounds(420, 61, 56, 16);
		panelUscite.add(lblData_1);

		textAreaUscite = new JTextArea();
		textAreaUscite.setEditable(false);
		textAreaUscite.setBounds(72, 90, 501, 327);
		panelUscite.add(textAreaUscite);

		labelIndexUscita = new JLabel("");
		labelIndexUscita.setBounds(367, 28, 29, 16);
		panelUscite.add(labelIndexUscita);

		buttonUscitaIndietro = new JButton("<");
		buttonUscitaIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexUscite--;
				uscite();
			}
		});
		buttonUscitaIndietro.setBounds(325, 22, 41, 25);
		panelUscite.add(buttonUscitaIndietro);

		buttonUscitaAvanti = new JButton(">");
		buttonUscitaAvanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexUscite++;
				uscite();
			}
		});
		buttonUscitaAvanti.setBounds(396, 22, 41, 25);
		panelUscite.add(buttonUscitaAvanti);

		label_2 = new JLabel("");
		label_2.setBounds(120, 61, 89, 16);
		panelUscite.add(label_2);

		label_3 = new JLabel("");
		label_3.setBounds(286, 61, 110, 16);
		panelUscite.add(label_3);

		label_4 = new JLabel("");
		label_4.setBounds(454, 61, 56, 16);
		panelUscite.add(label_4);



		panelNegozi = new JPanel();
		panelNegozi.setBackground(SystemColor.controlHighlight);
		panelNegozi.setBounds(147, 0, 650, 570);
		BGPANE.add(panelNegozi);
		panelNegozi.setLayout(null);

		PanelAggiungiNegozio = new JPanel();
		PanelAggiungiNegozio.setVisible(false);
		PanelAggiungiNegozio.setBounds(0, 0, 500, 570);
		panelNegozi.add(PanelAggiungiNegozio);
		PanelAggiungiNegozio.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Aggiungi Negozio");
		lblNewLabel_4.setFont(new Font("Arial", Font.ITALIC, 29));
		lblNewLabel_4.setBounds(136, 0, 227, 46);
		PanelAggiungiNegozio.add(lblNewLabel_4);

		txtCFNegozio = new JTextField();
		txtCFNegozio.setHorizontalAlignment(SwingConstants.CENTER);
		txtCFNegozio.setText("Codice Fiscale");
		txtCFNegozio.setForeground(Color.GRAY);
		txtCFNegozio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCFNegozio.setBounds(150, 105, 200, 35);
		PanelAggiungiNegozio.add(txtCFNegozio);
		txtCFNegozio.setColumns(10);

		txtNomeNegozio = new JTextField();
		txtNomeNegozio.setText("Nome");
		txtNomeNegozio.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeNegozio.setForeground(Color.GRAY);
		txtNomeNegozio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNomeNegozio.setColumns(10);
		txtNomeNegozio.setBounds(150, 151, 200, 35);
		PanelAggiungiNegozio.add(txtNomeNegozio);

		txtIndNegozio = new JTextField();
		txtIndNegozio.setText("Indirizzo");
		txtIndNegozio.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndNegozio.setForeground(Color.GRAY);
		txtIndNegozio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtIndNegozio.setColumns(10);
		txtIndNegozio.setBounds(150, 197, 200, 35);
		PanelAggiungiNegozio.add(txtIndNegozio);

		txtCitNegozio = new JTextField();
		txtCitNegozio.setHorizontalAlignment(SwingConstants.CENTER);
		txtCitNegozio.setText("Citt\u00E0");
		txtCitNegozio.setForeground(Color.GRAY);
		txtCitNegozio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCitNegozio.setColumns(10);
		txtCitNegozio.setBounds(150, 243, 200, 35);
		PanelAggiungiNegozio.add(txtCitNegozio);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 496, 480, 2);
		PanelAggiungiNegozio.add(separator_2);

		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clearTexts(arg0);
			}
		});
		btnReset.setBounds(17, 509, 100, 50);
		PanelAggiungiNegozio.add(btnReset);

		JButton btnUpdateNegozio = new JButton("Aggiorna");
		btnUpdateNegozio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aggiungiAlDB(e,"negozio");
					if(varflag==1) {
						warehouse.removeNegozio(tempNegozio);
					}
					clearTexts(e);
					closeButtonAction((JPanel)e.getComponent().getParent(),"negozi");
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				fillTable("negozi",(DefaultTableModel) tableNegozi.getModel());

			}
		});
		btnUpdateNegozio.setBounds(134, 509, 230, 50);
		PanelAggiungiNegozio.add(btnUpdateNegozio);

		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeButtonAction((JPanel)e.getComponent().getParent(),"negozi");
			}
		});
		btnAnnulla.setBounds(381, 509, 100, 50);
		PanelAggiungiNegozio.add(btnAnnulla);

		PanelMainNeg = new JPanel();
		PanelMainNeg.setBounds(0, 0, 650, 570);
		panelNegozi.add(PanelMainNeg);
		PanelMainNeg.setLayout(null);

		TablePanelNegozi = new JPanel();
		TablePanelNegozi.setBounds(0, 46, 650, 375);
		PanelMainNeg.add(TablePanelNegozi);
		TablePanelNegozi.setLayout(new BorderLayout(0, 0));

		tableNegozi = new JTable();
		tableNegozi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabellaRigaSel(false,"negozi");
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
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
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
		labelNegozi.setBounds(270, 0, 109, 46);
		PanelMainNeg.add(labelNegozi);
		labelNegozi.setHorizontalAlignment(SwingConstants.CENTER);
		labelNegozi.setFont(new Font("Arial", Font.ITALIC, 30));
		labelNegozi.setBackground(Color.WHITE);

		btnModNegozio = new JButton("Modifica");
		btnModNegozio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModNegoziPanel(tableNegozi.getSelectedRow());
			}
		});
		btnModNegozio.setBackground(SystemColor.control);
		btnModNegozio.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnModNegozio.setBounds(10, 434, 220, 50);
		PanelMainNeg.add(btnModNegozio);

		btnEliminaNegozio = new JButton("Elimina");
		btnEliminaNegozio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warehouse.removeNegozio(warehouse.getNegozio(tableNegozi.getSelectedRow()));
				fillTable("negozi",(DefaultTableModel) tableNegozi.getModel());

			}
		});
		btnEliminaNegozio.setBackground(SystemColor.control);
		btnEliminaNegozio.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnEliminaNegozio.setBounds(390, 434, 220, 50);
		PanelMainNeg.add(btnEliminaNegozio);

		btnCreaNegozio = new JButton("Crea");
		btnCreaNegozio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addNegozioPanel();

			}
		});
		btnCreaNegozio.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnCreaNegozio.setBackground(SystemColor.control);
		btnCreaNegozio.setBounds(240, 434, 140, 110);
		PanelMainNeg.add(btnCreaNegozio);




		menuazioni = new JPanel();
		menuazioni.setForeground(new Color(0, 0, 0));
		menuazioni.setBorder(new TitledBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(192, 192, 192)), "Azioni", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		menuazioni.setBackground(SystemColor.controlHighlight);
		menuazioni.setBounds(0, 0, 147, 425);
		BGPANE.add(menuazioni);

		btnArticoli = new JButton("Articoli");
		btnArticoli.setBounds(33, 21, 80, 23);
		btnArticoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nascondiPannelli();
				panelArticoli.setVisible(true);
				btnCambiaPos.setEnabled(false);
				btnDettagli.setEnabled(false);
				btnEliminaArt.setEnabled(false);
			}
		});
		menuazioni.setLayout(null);
		btnArticoli.setBackground(SystemColor.control);
		menuazioni.add(btnArticoli);

		btnNegozi = new JButton("Negozi");
		btnNegozi.setBounds(33, 49, 80, 23);
		btnNegozi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nascondiPannelli();
				panelNegozi.setVisible(true);
				btnModNegozio.setEnabled(false);
				btnEliminaNegozio.setEnabled(false);
			}
		});

		btnNegozi.setBackground(SystemColor.control);
		menuazioni.add(btnNegozi);

		btnOrdini = new JButton("Ordini");
		btnOrdini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nascondiPannelli();
				panelOrdini.setVisible(true);
			}
		});
		btnOrdini.setBounds(33, 77, 80, 23);
		btnOrdini.setBackground(SystemColor.control);
		menuazioni.add(btnOrdini);

		btnIngressi = new JButton("Ingressi");
		btnIngressi.setBounds(33, 105, 80, 23);
		btnIngressi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nascondiPannelli();
				panelIngressi.setVisible(true);
				indexIngressi = 0;
				ingressi();

			}
		});
		btnIngressi.setBackground(SystemColor.control);
		menuazioni.add(btnIngressi);

		btnUscite = new JButton("Uscite");
		btnUscite.setBounds(33, 133, 80, 23);
		btnUscite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nascondiPannelli();
				panelUscite.setVisible(true);
				indexUscite = 0;
				uscite();
			}
		});
		btnUscite.setBackground(SystemColor.control);
		menuazioni.add(btnUscite);

		btnStorico = new JButton("Riepilogo Mensile");
		btnStorico.setBounds(10, 161, 127, 23);
		btnStorico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				nascondiPannelli();
				index = 0;
				panelRiepilogo.setVisible(true);
				textArea.setText("");
				report();
			}
		});
		btnStorico.setBackground(SystemColor.control);
		menuazioni.add(btnStorico);

		panelGenerale = new JPanel();
		panelGenerale.setBackground(SystemColor.controlHighlight);
		panelGenerale.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGenerale.setBounds(0, 423, 147, 148);
		BGPANE.add(panelGenerale);

		JButton btnNewButton_6 = new JButton("Salva");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				warehouse.save();
			}
		});
		btnNewButton_6.setBackground(SystemColor.control);
		btnNewButton_6.setBounds(24, 19, 94, 23);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelGenerale.setLayout(null);
		panelGenerale.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Logout");
		btnNewButton_7.setBackground(SystemColor.control);
		btnNewButton_7.setBounds(24, 55, 94, 23);
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				hideGUI();
				resetbuttons(); //rende visibili/abilitati tutti i buttons modificati nel login dei vari accounts
				Login.setVisible(true);
				textField.setText("");
				passwordField.setText("");
			}

			private void resetbuttons() {
				//magazziniere
				btnNegozi.setEnabled(true);
				btnUscite.setEnabled(true);
				btnEliminaArt.setVisible(true);
				btnModificaArticolo.setVisible(true);
				btnAggiungiArticolo.setVisible(true);
				btnDettagli.setVisible(true);
				//segreteria
				btnCambiaPos.setVisible(true);
				btnNuovoIngresso.setEnabled(true);
				btnGeneraUscita.setEnabled(true);
				//responsabile negozio
				btnArticoli.setEnabled(true);
				btnNegozi.setVisible(true);
				btnIngressi.setEnabled(true);
				btnCreaNuovoOrd.setEnabled(true);
				btnStorico.setEnabled(true);

			}
		});
		panelGenerale.add(btnNewButton_7);

		DEBUG = new JLabel("DBG");
		DEBUG.setHorizontalAlignment(SwingConstants.CENTER);
		DEBUG.setBounds(0, 91, 147, 57);
		panelGenerale.add(DEBUG);
		DEBUG.setVisible(false);

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
		textField.setText(""); // loginuser

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(24, 82, 80, 30);
		panel_1.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(89, 82, 141, 30);
		panel_1.add(passwordField);
		passwordField.setText("");


		//BOTTONE LOGIN
		btnLogin = new JButton("Accedi");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButtonActionToDo(e);
			}
		});


		btnLogin.setBounds(90, 123, 112, 41);
		panel_1.add(btnLogin);

		//
		fillTable("negozi",(DefaultTableModel) tableNegozi.getModel());
		//SelectNegozio.setModel(new DefaultComboBoxModel<>(new String[] {"negozio1", "negozio2", "negozio3", "negozio4"}));
		for(Negozio n : warehouse.getNegozioList())
			SelectNegozio.addItem(n.getNome());






	}


	// AZIONI DEGLI EVENTI


	// --- PULSANTI ---
	private void loginButtonActionToDo(ActionEvent e) {
		//System.out.println(textField.getText());
		String user = textField.getText();
		@SuppressWarnings("deprecation")
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
		case "negozi":
			pannello.setVisible(false); //
			PanelMainNeg.setVisible(true);

		}


	}



	// --- END PULSANTI ---!


	private void panelMagazziniere(){
		panelComuni();
		btnNegozi.setEnabled(false);

		btnEliminaArt.setVisible(false);
		btnModificaArticolo.setVisible(false);
		btnAggiungiArticolo.setVisible(false);
		btnDettagli.setVisible(false);
		
		btnCreaNuovoOrd.setEnabled(false);

	}

	private void panelSegreteria(){
		panelComuni();
		btnCambiaPos.setVisible(false);
		btnNuovoIngresso.setEnabled(false);
		btnCreaNuovoOrd.setEnabled(false);
	}
	private void panelResponsabile(){
		panelComuni();
		btnArticoli.setEnabled(false);
		btnNegozi.setEnabled(false);
		btnIngressi.setEnabled(false);
		btnGeneraUscita.setEnabled(false);
		btnUscite.setEnabled(false);
		btnStorico.setEnabled(false);
	}

	private void panelComuni(){ // pannelli in comune per tutti e 3 i tipi di user
		Login.setVisible(false);
		menuazioni.setVisible(true);
		panelGenerale.setVisible(true);

	}


	//TEXTBOX EVENTS

	private void clearText(MouseEvent e) {
		JTextField temp = (JTextField) e.getSource();
		temp.setText("");
	}


	//TABELLA EVENTS

	private void tabellaRigaSel(boolean act, String type){
		//funzione che abilita i bottoni giusti se viene selezionata una riga della tabella

		switch(type) {
		case "articoli":
			dettaglioArticolo(act, tableArticoli.getSelectedRow()); // prende la riga dell'articolo selezionato, solo 1 alla volta
			btnCambiaPos.setEnabled(true);
			btnDettagli.setEnabled(true);
			btnModificaArticolo.setEnabled(true);
			btnEliminaArt.setEnabled(true);
			break;

		case "negozi":
			dettaglioNegozio(act, tableNegozi.getSelectedRow());
			btnModNegozio.setEnabled(true);
			btnEliminaNegozio.setEnabled(true);
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
			l0.setText(""+abs(temp.hashCode()));
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




	//modifica la posizione di un articolo
	private void modificaPosizioneArticolo(ActionEvent evt, int row) {                                                                   
		int newPosition = 0;
		String s = "";
		do {
			do {
				s = JOptionPane.showInputDialog("Nuova posizione: ");
				if(s == null) return;
			} while (s.equals(" ") || s.equals(""));
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
			btnDettagli.setEnabled(false);;
			btnEliminaArt.setEnabled(false);
			btnModificaArticolo.setEnabled(false);
			break;

		case "negozi":
			model.setRowCount(0);
			for(Negozio n : warehouse.getNegozioList()) {

				System.out.println(n.toString());//	
				model.addRow(new Object[]{n.getCodiceFiscale(),n.getNome(),""+n.getindirizzo()+","+n.getCitta()});
			}

			break;

		case "ordini":
			model.setRowCount(0);
			for(Ordine o : warehouse.getOrdineList()) {
				System.out.println(o.toString());
				//	Sistemare per il checkbox come si mette? sistemare il num articoli
				model.addRow(new Object[]{abs(o.getID()),o.getDataInString(),o.getTotalPrice(),o.getNegozio().getNome(),o.getCorriere(), o.getIfShipped(), o.articoliSize()});
			}




		}

	}

	//PULSANTE AGGIUNGI
	private void addArticlePanel(){
		PanelMainArt.setVisible(false);
		PanelAggiungiArticolo.setVisible(true);
		varflag = 0;
	}

	private void addNegozioPanel() {
		PanelMainNeg.setVisible(false);
		PanelAggiungiNegozio.setVisible(true);
		varflag = 0;
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
					JComboBox<?> a = (JComboBox<?>)c;
					a.setSelectedIndex(0);

				}
			}
		}
	}

	public void ModArticlePanel(int nrow) throws ArticleDontExistInWareHouseException {
		PanelMainArt.setVisible(false);
		PanelAggiungiArticolo.setVisible(true);

		Component[] comp = PanelAggiungiArticolo.getComponents();

		temp = warehouse.getArticolo(nrow); 

		String[] sAll = new String[5];
		sAll[0] = temp.getTipoArticolo().getName();
		sAll[2] = temp.getDataInString();
		sAll[1] = ""+temp.getPrezzo();
		sAll[3] = ""+warehouse.getQuantita(temp);
		sAll[4] = temp.getTipoArticolo().getDescription();

		int i= 0;
		for(Component c: comp) {
			if(c instanceof JTextField)
				((JTextField) c).setText(""+(sAll[i++]));
			if(c instanceof JRadioButton  && ((JRadioButton) c).getText().equals(temp.getTipoArticolo().getMaterial())){					
				switch(temp.getTipoArticolo().getMaterial()){
				case "Poliestere":
					rdbtnPoliestere.setSelected(true);
					break;
				case "Silicone":
					rdbtnSilicone.setSelected(true);
					break;
				case "Finta Pelle":
					rdbtnPelleSintetica.setSelected(true);
					break;
				case "Gore-Tex":
					rdbtnGoretex.setSelected(true);
					break;
				case "Elastan":
					rdbtnElastan.setSelected(true);
					break;
				case "Polietilene":
					rdbtnPolietilene.setSelected(true);
					break;
				case "Poliammide":
					rdbtnPoliammide.setSelected(true);
					break;
				}


			}

			if(c instanceof JComboBox)
				((JComboBox<?>)c).setSelectedIndex(TipoArticolo.sportArray2Num(temp.getTipoArticolo().getSports()));
			DEBUG.setText("Sport "+temp.getTipoArticolo().getMaterial());
		}



		varflag=1; // settiamo varflag = 1 cioè è la modifica dell'articolo
	}


	private void ModNegoziPanel(int nrow) {
		PanelMainNeg.setVisible(false);
		PanelAggiungiNegozio.setVisible(true);


		Component[] comp = PanelAggiungiNegozio.getComponents();

		tempNegozio = warehouse.getNegozio(nrow);

		String[] sAll = new String[4];
		sAll[0] = tempNegozio.getCodiceFiscale();
		sAll[1] = tempNegozio.getNome();
		sAll[2] = tempNegozio.getindirizzo();
		sAll[3] = tempNegozio.getCitta();

		int i = 0;
		// per ogni componente (in questo caso sono text box) riempe con i dati del negozio 
		for(Component c: comp) {
			if(c instanceof JTextField)
				((JTextField) c).setText(""+(sAll[i++]));
		}

		varflag=1;// siamo in modifica, non in creazione del negozio
	}





	private void aggiungiAlDB(MouseEvent e, String tipo) throws ArticleAlreadyExistException, NumberFormatException, ArticleDontExistInWareHouseException, ShopAlreadyExistException {

		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();	
			Component[] compList =  btn.getParent().getComponents();
			String p[];
			int i = 0;
			switch(tipo) {
			case "articolo":
				i=0;
				p = new String[7];
				//prendo i valori (testi, quale radio button ecc..) e li metto dentro l'array p
				for(Component c: compList) {
					if(c instanceof JTextField)
						p[i++] = ((JTextField) c).getText();
					if(c instanceof JRadioButton && ((JRadioButton) c).isSelected())					
						p[i++] = ((JRadioButton)c).getText();
					if(c instanceof JComboBox)
						p[i++] = ((JComboBox<?>)c).getSelectedItem().toString();

				}
				//if(p[0].equals("")) return 0; // se il nome dell' articolo è vuoto non va bene, torno 0

				TipoArticolo tempTipo = new TipoArticolo(p[0], p[4], TipoArticolo.sportArray2Num(p[6]), TipoArticolo.materialArray2Num(p[5]));
				String[] split = p[2].split("/"); // per avere giorno, mese, anno divisi
				Articolo temp = new Articolo(Float.parseFloat(p[1]),Integer.valueOf(split[0]),Integer.valueOf(split[1]),Integer.valueOf(split[2]), tempTipo);
				warehouse.addArticolo(temp); // aggiungo l'articolo
				warehouse.setQuantity(temp,Integer.valueOf(p[3])); // setto la quantità
				break;

			case "negozio":
				i=0;
				p = new String[4];
				for(Component c: compList) {
					if(c instanceof JTextField) {
						p[i++] = ((JTextField) c).getText();
					}
				}
				Negozio tempNeg = new Negozio(p[0], p[1], p[2], p[3]);	
				System.out.println("NEGOZIO in : "+ p[0] + " " + p[1] +" " + p[2] +" " + p[3]);

				warehouse.addNegozi(tempNeg);
				break;
			}


		}
	}

	public void calcMonthlyStats(ItemEvent arg0){
		Object sourceComp = arg0.getSource();
		@SuppressWarnings("rawtypes")
		JComboBox SourceCompAsJComboBox = (JComboBox)sourceComp;
		int selSport;

		selSport = (SourceCompAsJComboBox.getSelectedIndex() - 1);
		textArea.setText(warehouse.nuovaChiusuraMensile(TipoArticolo.sportArray[selSport]));

	}
	private void addCreaOrdPanel() {
		PanelTableOrdiniPrinc.setVisible(false);
		PanelCreaNuovoOrd.setVisible(true);
		varflag = 0;
	}
}

