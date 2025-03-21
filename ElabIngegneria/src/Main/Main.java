/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Exception.*;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.*;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	    	//System.out.println(info);
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}

	Object[] options = {"Importa DB", "DB Prova"};
	int buttonPressed = JOptionPane.showOptionDialog(null, "Magazzino esistente o usarne uno di prova?", "", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);

	if (buttonPressed == 0) {
	    
	    try {
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("File dati binari (.dat)", "dat");
		jfc.setFileFilter(filter);
		int button = jfc.showOpenDialog(null);
		File file;

		if (button == JFileChooser.APPROVE_OPTION) {
		    try {
			
			file = jfc.getSelectedFile();
			ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream((file)));
			Magazzino.uploadInstance(fileIn);
			fileIn.close();
			//JOptionPane.showMessageDialog(null, "Caricamento riuscito");
                        
		    } catch (HeadlessException | IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Errore caricamento DB");
			System.exit(0);
		    } catch(Exception e){
			System.out.println("Exception "+e.getMessage());
			System.exit(0);
		    }
		}
		else{
		    System.exit(0);
		}

	    } catch (HeadlessException e) {
		JOptionPane.showMessageDialog(null, "Errore nell'aprire il file database: " + e.getMessage());
		System.exit(0);
	    }
	} else {

	    //ISTANZIO UN PO DI OGGETTI DA USARE COME PROVA
	    try {
                Magazzino m = Magazzino.getInstance();
		m.addUser(new Utente("magazziniere", "1111", 1));
                m.addUser(new Utente("segreteria", "2222", 2));
                m.addUser(new Utente("responsabile", "3333", 3));
                
		Articolo a1 = new Articolo((float) 14, new TipoArticolo("nome1", "Descrizione art1", 2, 1));
		Articolo a2 = new Articolo((float) 17, new TipoArticolo("nome2", "Descrizione art2", 3, 3));
		Articolo a3 = new Articolo((float) 87, new TipoArticolo("nome3", "Descrizione art3", 2, 1));
		Articolo a4 = new Articolo((float) 90, new TipoArticolo("nome4", "Descrizione art4", 9, 2));
		Articolo a5 = new Articolo((float) 15, new TipoArticolo("nome5", "Descrizione art5", 7, 1));
		Articolo a6 = new Articolo((float) 18, new TipoArticolo("nome6", "Descrizione art6", 10, 4));
                
		Negozio n1 = new Negozio("ABABABABABABABAB", "Adidas Milano", "via Roma", "Milano");
		Negozio n2 = new Negozio("BBBBBBBBBBBBBBBB", "Snipes Malpensa", "via 2", "Milano");
		Negozio n3 = new Negozio("CCCCCCCCCCCCCCCC", "Puma EUROMA2", "via 3", "Roma");
		Negozio n4 = new Negozio("DDDDDDDDDDDDDDDD", "Foot Loocker", "via bio", "City");
        
		//Ingresso i1= new Ingresso()
		
		Ordine o1 = new Ordine(n1, "SDA-Express");
		m.addOrdine(o1);
		o1.addArticle(a2, 10);
		o1.addArticle(a1, 4);
		o1.addArticle(a3, 4);
		o1.addArticle(a4, 10);
		Ordine o2 = new Ordine(n2, "Fedex");
		m.addOrdine(o2);
		o2.addArticle(a2, 10);
		o2.addArticle(a1, 4);
		m.addArticolo(a1);
		m.addArticolo(a2);
		m.addArticolo(a3);
		m.addArticolo(a4);
		m.addArticolo(a5);
		m.addArticolo(a6);

		Map<Articolo, Integer> q = new TreeMap<>();
		Map<Articolo, Integer> p = new TreeMap<>();
		
		q.put(a1, 100);
		q.put(a2, 100);
		q.put(a3, 100);
		q.put(a5, 100);
		q.put(a4, 100);
		
		p.put(a1, 1);
		p.put(a2, 2);
		p.put(a3, 3);
		p.put(a5, 4);
		p.put(a4, 5);
		m.addIngresso(q, p, new GregorianCalendar());

		m.addIngresso(q, p, new GregorianCalendar());

		m.addNegozi(n1);
		m.addNegozi(n2);
		m.addNegozi(n3);
		m.addNegozi(n4);
		m.addOrdine(o1);
		m.addOrdine(o2);
		
		//o1.isShipped();
		//o1.createShip();
		//m.createExit(o1);
		o2.isShipped();
		o2.createShip();
		m.createExit(o2);
		

	    } catch (ArticleAlreadyExistException | ShopAlreadyExistException | UserAlreadyExist | VoidStringUnexpectedException e) {
		JOptionPane.showMessageDialog(null, "Eccezione nell'instanziare gli oggetti demo");
	    } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	java.awt.EventQueue.invokeLater(() -> {
	    try {
			new GUI().setVisible(true);
		} catch (ArticleDontExistInWareHouseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	});

    }//fine main
}
