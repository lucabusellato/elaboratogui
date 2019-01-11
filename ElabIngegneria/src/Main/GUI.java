package Main;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class GUI extends JFrame {
	
    static int indexOrder = 0, indexArticle = 0, indexShop = 0, indexIngressi = 0, orderArticleSelected = 1, ingressoArticleSelected = 1, from = 0, index = 0, modificaOrCreaOrdine = 0;
	//prendiamo l'istanza di magazzino -- singleton
	private static final Magazzino warehouse = Magazzino.getInstance();
	private int varflag;
	private Articolo temp;
	
	//pannelli
	private JPanel BGPANE; // panel principale
	private JPanel Login, menuazioni, panelArticoli, panelGenerale,panelNegozi,TablePanel;
	private JPanel PanelMainArt;
	private List<JPanel> listaPanel = new ArrayList<>();


	//bottoni
	private JButton btnLogin,btnArticoli,btnNegozi,btnOrdini,btnIngressi,btnFineMese,btnStorico;
	private JButton btnCambiaPos,btnDettagli;
	private JButton btnEliminaArt;

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
	
	
	//radio btns
	 private JRadioButton rdbtnPoliestere;
	 private JRadioButton rdbtnSilicone;
	 private JRadioButton rdbtnPelleSintetica; 
	 private JRadioButton rdbtnGoretex;  
	 private JRadioButton rdbtnElastan; 
	 private JRadioButton rdbtnPolietilene; 
	 private JRadioButton rdbtnPoliammide;
	
	 ButtonGroup group_btn;
	 private JTextField textFieldGiorno;
	 private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JTextField textField_5;
	 private JTextField textField_6;
	 private JTextField textField_7;
	 private JTextField textField_8;
	 private JTextField textField_9;
	 private JTextField textField_10;
	 private JTextField textField_11;
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
	private void nascondiPannelli() {
		panelArticoli.setVisible(false);
		panelNegozi.setVisible(false);
		//panelOrdini.setVisible(false);
		//panelIngressi.setVisible(false);
		//panelFineMese.setVisible(false);
		//panelStorico.setVisible(false);
	}


	public final void hideGUI() {
		menuazioni.setVisible(false);
		panelGenerale.setVisible(false);
		nascondiPannelli();

	}
	void ingressi() {/*
        if (warehouse.ingressiIsEmpty()) {
            ingressiIDLabel_VisualizzaIngressiPanel.setText("");
            searchFieldIngressiPanel.setText("");
            indietroButton_IngressiPanel.setEnabled(false);
            avantiButton_IngressiPanel.setEnabled(false);
            newIngressoButton_IngressiPanel.setEnabled(true);
            articoliQuantitaPosizioneIngressiPanel.setText("NESSUN INGRESSO DISPONIBILE NEL DATABASE");
            //JOptionPane.showMessageDialog(null, "Nessun ordine ancora presente nel Database, premi 'crea ordine ora' per crearne uno nuovo subito");
        } else {
            if (indexIngressi == 0) {
                indietroButton_IngressiPanel.setEnabled(false);
            } else {
                indietroButton_IngressiPanel.setEnabled(true);
            }
            if (indexIngressi == m.ingressiSize() - 1) {
                avantiButton_IngressiPanel.setEnabled(false);
            } else {
                avantiButton_IngressiPanel.setEnabled(true);
            }
            dataLabel_VisualizzaIngressiPanel.setText(m.getIngresso(indexIngressi).getDataInString());
            searchFieldIngressiPanel.setText("" + (indexIngressi + 1));
            ingressiIDLabel_VisualizzaIngressiPanel.setText("" + abs(m.getIngresso(indexIngressi).getID()));
            articoliQuantitaPosizioneIngressiPanel.setText("" + m.getIngresso(indexIngressi).toString());
        }
*/
    }


	private void startGUI() throws ArticleDontExistInWareHouseException {
		//INIT GUI DESIGN
		BGPANE = new JPanel();
		BGPANE.setBackground(SystemColor.controlHighlight);
		BGPANE.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BGPANE);
		BGPANE.setLayout(null);
		
		JPanel panelNuovoIngresso = new JPanel();
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
		
		JLabel lblNewLabel_4 = new JLabel("/");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(267, 85, 17, 16);
		panelNuovoIngresso.add(lblNewLabel_4);
		
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
		
		JButton button = new JButton("Chiudi");
		
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 155, 116, 22);
		panelNuovoIngresso.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(76, 178, 116, 22);
		panelNuovoIngresso.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(76, 202, 116, 22);
		panelNuovoIngresso.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(76, 225, 116, 22);
		panelNuovoIngresso.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(76, 249, 116, 22);
		panelNuovoIngresso.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(76, 274, 116, 22);
		panelNuovoIngresso.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(76, 298, 116, 22);
		panelNuovoIngresso.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(76, 322, 116, 22);
		panelNuovoIngresso.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(76, 345, 116, 22);
		panelNuovoIngresso.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(76, 369, 116, 22);
		panelNuovoIngresso.add(textField_11);
		textField_11.setColumns(10);
		
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
		
		JPanel panelIngressi = new JPanel();
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
		
		JLabel labelViewId = new JLabel("");
		labelViewId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelViewId.setBounds(77, 78, 56, 16);
		panelIngressi.add(labelViewId);
		
		JLabel lblData = new JLabel("Data ingresso:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setBounds(195, 77, 94, 16);
		panelIngressi.add(lblData);
		
		JLabel lblViewData = new JLabel("");
		lblViewData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblViewData.setBounds(295, 78, 56, 16);
		panelIngressi.add(lblViewData);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(45, 112, 550, 307);
		panelIngressi.add(textPane);
		
		JLabel lblN = new JLabel("Ingresso n:");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblN.setBounds(409, 78, 75, 16);
		panelIngressi.add(lblN);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner.setBounds(499, 75, 30, 22);
		panelIngressi.add(spinner);
		
		JButton btnNuovoIngresso = new JButton("Nuovo ingresso");
		
		btnNuovoIngresso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNuovoIngresso.setBounds(231, 432, 133, 35);
		panelIngressi.add(btnNuovoIngresso);
		
		JButton btnChiudiIngressi = new JButton("Chiudi visualizza ingressi");
		btnChiudiIngressi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChiudiIngressi.setBounds(195, 496, 193, 35);
		panelIngressi.add(btnChiudiIngressi);
		
		//button crea nuovo ingresso
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Map<Articolo, Integer> posizioni = new TreeMap<>();
		            Map<Articolo, Integer> quantita = new TreeMap<>();
		            //dichiaro le variabili intere
		            int quantita1, quantita2, quantita3, quantita4, quantita5, quantita6, quantita7, quantita8, quantita9, quantita10;
		            int posizione1, posizione2, posizione3, posizione4, posizione5, posizione6, posizione7, posizione8, posizione9, posizione10;
		           //mi prendo l'articolo in base alla selezione
		            String Articolo1 = (String) textField_2.getSelectedText();
		            String Articolo2 = (String) textField_3.getSelectedText();
		            String Articolo3 = (String) textField_4.getSelectedText();
		            String Articolo4 = (String) textField_5.getSelectedText();
		            String Articolo5 = (String) textField_6.getSelectedText();
		            String Articolo6 = (String) textField_7.getSelectedText();
		            String Articolo7 = (String) textField_8.getSelectedText();
		            String Articolo8 = (String) textField_9.getSelectedText();
		            String Articolo9 = (String) textField_10.getSelectedText();
		            String Articolo10 = (String) textField_11.getSelectedText();
		           
		            //mi prendo gli articolo in base al nome del textBox riga 3500
		           
		            Articolo a1 = warehouse.articoloContainedByName(Articolo1);
			        Articolo a2 = warehouse.articoloContainedByName(Articolo2);
			        Articolo a3 = warehouse.articoloContainedByName(Articolo3);
			        Articolo a4 = warehouse.articoloContainedByName(Articolo4);
			        Articolo a5 = warehouse.articoloContainedByName(Articolo5);
			        Articolo a6 = warehouse.articoloContainedByName(Articolo6);
			        Articolo a7 = warehouse.articoloContainedByName(Articolo7);
			        Articolo a8 = warehouse.articoloContainedByName(Articolo8);
			        Articolo a9 = warehouse.articoloContainedByName(Articolo9);
			        Articolo a10 = warehouse.articoloContainedByName(Articolo10);
			        
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
		            switch (ingressoArticleSelected) {
		                case 10:
		                    if (quantita10 == 0 || posizione10 == 0) {
		                        JOptionPane.showMessageDialog(null, "Non sono accettate 0 posizioni o 0 quantita!");
		                        return;
		                    }

		                    if (quantita.containsKey(a10)) {
		                        quantita.put(a10, quantita.get(a10) + quantita10);
		                    } else {
		                        quantita.put(a10, quantita10);
		                    }
		                    posizioni.put(a10, posizione10);

		                case 9:

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

		                case 8:
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

		                case 7:
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

		                case 6:
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

		                case 5:
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

		                case 4:
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

		                case 3:
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

		                case 2:
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

		                case 1:
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
	                textField_12.setText("");
	                textField_22.setText("");
	                textField_13.setText("");
	                textField_23.setText("");
	                textField_14.setText("");
	                textField_24.setText("");
	                textField_15.setText("");
	                textField_25.setText("");
	                textField_16.setText("");
	                textField_26.setText("");
	                textField_17.setText("");
	                textField_27.setText("");
	                textField_18.setText("");
	                textField_28.setText("");
	                textField_19.setText("");
	                textField_29.setText("");
	                textField_20.setText("");
	                textField_30.setText("");
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
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
				textField_21.setText("");
				textField_22.setText("");
				textField_23.setText("");
				textField_24.setText("");
				textField_25.setText("");
				textField_26.setText("");
				textField_27.setText("");
				textField_28.setText("");
				textField_29.setText("");
				textField_30.setText("");
				textField_31.setText("");
	            nascondiPannelli();
		        panelIngressi.setVisible(true);
			}
		});
		
		
		//da ingressi a crea nuovo ingresso
		btnNuovoIngresso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelIngressi.setVisible(false);
				panelNuovoIngresso.setVisible(true);
				
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
		
		
		btnModificaArticolo.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
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
		
		btnEliminaArt.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
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

		panelGenerale = new JPanel();
		panelGenerale.setBackground(SystemColor.controlHighlight);
		panelGenerale.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGenerale.setBounds(0, 423, 147, 148);
		BGPANE.add(panelGenerale);

		JButton btnNewButton_6 = new JButton("Salva");
		btnNewButton_6.setBackground(SystemColor.control);
		btnNewButton_6.setBounds(12, 18, 57, 23);
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
				btnEliminaArt.setEnabled(false);
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
			btnEliminaArt.setEnabled(true);
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
				((JComboBox)c).setSelectedIndex(TipoArticolo.sportArray2Num(temp.getTipoArticolo().getSports()));
			DEBUG.setText("Sport "+temp.getTipoArticolo().getMaterial());
		}
		
		
		
		varflag=1; // settiamo varflag = 1 cioè è la modifica dell'articolo
	}
	
	
	
	
	
	private int aggiungiAlDB(MouseEvent e, String tipo) throws ArticleAlreadyExistException, NumberFormatException, ArticleDontExistInWareHouseException {

		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();	
			Component[] compList =  btn.getParent().getComponents();
			String[] p = new String[7];
			int i=0;
			
			for(Component c: compList) {
				if(c instanceof JTextField)
					p[i++] = ((JTextField) c).getText();
				if(c instanceof JRadioButton && ((JRadioButton) c).isSelected())					
					p[i++] = ((JRadioButton)c).getText();
				if(c instanceof JComboBox)
					p[i++] = ((JComboBox)c).getSelectedItem().toString();
					
			}
			if(p[0].equals("")) return 0;
		
			//for(String ev: p)
				//System.out.println(ev);
			
			
			//System.out.println("NUM SPORT: " +TipoArticolo.sportArray2Num(p[6])+"NUM MAT: "+TipoArticolo.materialArray2Num(p[5]));
			//DA CREARE L'ARTICOLO NUOVO
			//Articolo daAggiungere, vedi costruttore Articolo
			
			TipoArticolo tempTipo = new TipoArticolo(p[0], p[4], TipoArticolo.sportArray2Num(p[6]), TipoArticolo.materialArray2Num(p[5]));
			String[] split = p[2].split("/");
			Articolo temp = new Articolo(Float.parseFloat(p[1]),Integer.valueOf(split[0]),Integer.valueOf(split[1]),Integer.valueOf(split[2]), tempTipo);
			warehouse.addArticolo(temp);
			warehouse.setQuantity(temp,Integer.valueOf(p[3]));
			return 1;
		}
		return 0;
		
	}
}

