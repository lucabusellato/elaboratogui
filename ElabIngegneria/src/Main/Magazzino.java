package Main;

import java.util.*;
import Exception.*; //importo tutte le mie eccezzioni
import java.awt.HeadlessException;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

//GLI ARRAYLIST, COME PER GLI ARRAY, PARTONO DA 0
public class Magazzino implements Serializable {

    private List<Uscita> uscite;
    private List<Ordine> ordini;
    private List<Articolo> articoli;
    private List<Ingresso> ingressi;
    private List<Negozio> negozi;
    private List<Utente> utenti;
    private List<String> report;
    private Map<Articolo, Integer> quantita, posizione;
    private Map<Articolo, Integer> ingressiMensili, usciteMensili;

    private static Magazzino INSTANCE = null;

    
    private Magazzino() {
	this.negozi = new ArrayList();
	this.uscite = new ArrayList<>();
	this.utenti = new ArrayList<>();
	this.ingressi = new ArrayList<>();
	this.articoli = new ArrayList<>();
	this.ordini = new ArrayList<>();
	this.quantita = new TreeMap<>();
	this.posizione = new TreeMap<>();
	this.ingressiMensili = new TreeMap<>();
	this.usciteMensili = new TreeMap<>();
	this.report = new ArrayList();
    }

    //singleton Methods
    public static Magazzino getInstance() {
	if (INSTANCE == null) {
	    INSTANCE = new Magazzino();
	}
	return INSTANCE;
    }

    public static void uploadInstance(ObjectInputStream ois) throws IOException, ClassNotFoundException{
	INSTANCE = (Magazzino) ois.readObject();
    }
    
    
    
    public void addUser(Utente u) throws UserAlreadyExist {
	for (Utente X : utenti) {
	    if (u.equals(X)) {
		throw new UserAlreadyExist("L'utente passato è già presente nella lista degli utenti!");
	    }
	}
	utenti.add(u);
    }

    public boolean removeUser(Utente u) {
	return utenti.remove(u);
    }

    public void removeUser(int i) {
	utenti.remove(i);
    }

    public Utente getUser(int i) {
	return utenti.get(i);
    }

    public boolean usersIsEmpty() {
	return utenti.isEmpty();
    }

    public int loginHashCode(Utente u) throws UserNotFoundException {
	for (Utente X : utenti) {
            System.out.println("123:"+X.hashCode());
            System.out.println("u" +u.hashCode());
            System.out.println();
	    if (u.hashCode() == X.hashCode()) {
		return X.getTypeInt();
	    }
	}
	throw new UserNotFoundException("Utente non trovato! \n Username o Password errata!");
    }

    //ARTICOLI
    public void addArticolo(Articolo a) throws ArticleAlreadyExistException {
	if (articoli.contains(a)) {
	    throw new ArticleAlreadyExistException("L'articolo è già presente nella lista!");
	}
	articoli.add(a);
	posizione.put(a, 0);
	quantita.put(a, 0);
	Collections.sort(articoli);
    }

    public boolean removeArticolo(Articolo u) {
	if (articoli.contains(u)) {
	    return articoli.remove(u);
	}
	return false;
    }

    public void removeArticolo(int i) {
	posizione.remove(articoli.get(i));
	quantita.remove(articoli.get(i));
	articoli.remove(i);
	Collections.sort(articoli);
    }

    public Articolo getArticolo(int i) throws IndexOutOfBoundsException {
	if (i >= 0 && i < articoli.size()) {
	    return articoli.get(i);
	} else if (i < 0) {
	    throw new IndexOutOfBoundsException("Non sono acettati indici con numeri negativi");
	} else {
	    throw new IndexOutOfBoundsException("Indice troppo grande!");
	}
    }

    public boolean articoliIsEmpty() {
	return articoli.isEmpty();
    }

    public int articoliSize() {
	return articoli.size();
    }

    public boolean exist(Articolo a) {
	return articoli.contains(a);
    }

    public Articolo articoloContainedByName(String s) throws ArticleDontExistInWareHouseException {
	for (Articolo X : articoli) {
	    if (X.getTipoArticolo().getName().equals(s)) {
		return X;
	    }
	}
	throw new ArticleDontExistInWareHouseException("Nome articolo non trovato!");
    }

    //POSIZIONI E QUANTITA
    public int getQuantita(Articolo a) throws ArticleDontExistInWareHouseException {
	if (!articoli.contains(a)) {
	    throw new ArticleDontExistInWareHouseException("Articolo inesistente!");
	}
	return quantita.get(a);
    }

    public int getPosition(Articolo a) throws ArticleDontExistInWareHouseException {
	if (!articoli.contains(a)) {
	    throw new ArticleDontExistInWareHouseException("Articolo inesistente!");
	}
	return posizione.get(a);// se l'articolo è contenuto nell'arraylist allora sicuramente si troca in posizione
    }

    public void setPosition(Articolo a, int posizione) throws ArticleDontExistInWareHouseException, PositionAlreadyOccupiedException {
	if (!articoli.contains(a)) //se l'articolo non esiste nel magazzino
	{
	    throw new ArticleDontExistInWareHouseException("Articolo inesistente!");
	}//non controllo se la posizione esiste già, ci possono essere posizioni doppie per ora 
	this.posizione.put(a, posizione); //sovrascrivo la coppia articolo, posizione
    }

    public void setQuantity(Articolo a, int quantita) throws ArticleDontExistInWareHouseException {
	if (!articoli.contains(a)) //se l'articolo esiste nel magazzino
	{
	    throw new ArticleDontExistInWareHouseException("Articolo inesistente!");
	}
	this.quantita.put(a, quantita);
    }

    //NEGOZI
    public boolean addNegozi(Negozio i) throws ShopAlreadyExistException {
	for (Negozio X : negozi) {
	    if (X.equals(i)) {
		throw new ShopAlreadyExistException("Il negozio non esiste nel Database!");
	    }
	}
	Collections.sort(negozi);
	return negozi.add(i);
    }

    public void removeNegozi(Negozio i) throws ShopAlreadyExistException {
	if (!negozi.remove(i)) {
	    throw new ShopAlreadyExistException("Il negozio non esiste nel Database!");
	}
	negozi.remove(i);
	Collections.sort(negozi);
    }

    public Negozio getNegozio(int i) {
	return negozi.get(i);
    }
    
    public boolean negoziExist(Negozio i){
        return negozi.contains(i);
    }

    public void removeNegozio(int i) {
	negozi.remove(i);
	Collections.sort(negozi);
    }

    public boolean negoziIsEmpty() {
	return negozi.isEmpty();
    }

    public int negoziSize() {
	return negozi.size();
    }

    public boolean exist(Negozio n) {
	return negozi.contains(n);
    }

    public int negozioIndex(Negozio n) throws ShopNotFoundException {
	if (exist(n)) {
	    return negozi.lastIndexOf(n);
	}
	throw new ShopNotFoundException("Negozio non trovato nella lista dei negozi!");
    }

    public Negozio negozioContainedByName(String s) { //controlla se esiste un negozio con quel nome
	for (Negozio X : negozi) {
	    if (X.getNome().equals(s)) {
		return X;
	    }
	}
	return null;
    }

    public void addIngresso(Map<Articolo, Integer> quantitaParameter, Map<Articolo, Integer> posizioneParameter, GregorianCalendar data) throws Exception {

	if (!quantitaParameter.keySet().equals(posizioneParameter.keySet())) {
	    throw new Exception("Le mappe passate come parametro non hanno gli stessi articoli!!");
	}

	for (Articolo X : quantitaParameter.keySet()) {
	    if (articoli.contains(X) == false) {
		throw new Exception("Alcuni Articoli non sono presenti nel catalogo in magazzino!!");
	    }
	}

	for (Articolo X : quantitaParameter.keySet()) {//itero su quantitaparameter tanto se arrivo qui so per certo che hanno gli stessi articoli
	    if (this.quantita.containsKey(X)) {
		this.quantita.put(X, (this.quantita.get(X) + quantitaParameter.get(X)));
		this.posizione.put(X, posizioneParameter.get(X));
	    } else {
		this.quantita.put(X, quantitaParameter.get(X));
		this.posizione.put(X, posizioneParameter.get(X));
	    }

	    if (ingressiMensili.containsKey(X)) {
		ingressiMensili.put(X, ingressiMensili.get(X) + quantitaParameter.get(X));
	    } else {
		ingressiMensili.put(X, quantitaParameter.get(X));
	    }
	}//for
	Ingresso nuovoIngresso = new Ingresso(quantitaParameter, posizioneParameter, data);
	ingressi.add(nuovoIngresso);
    }

    public boolean ingressiIsEmpty() {
	return ingressi.isEmpty();
    }

    public Ingresso getIngresso(int i) {
	return ingressi.get(i);
    }

    public int ingressiSize() {
	return ingressi.size();
    }

    public int getIndex(Ingresso i) {
	//ritorna l'indica della prima occorrenza dell'ingresso specificato nella lista
	return ingressi.indexOf(i);
    }

    public void createExit(Ordine n) throws OrderNotFound, ArticleNotFound, OrderImpossibleToCreate {
	boolean isPossible = true;

	for (Ordine x : ordini)//scorro array ordini per vedere se l'ordine esiste
	{
	    if (x.equals(n)) {//ho trovato l'ordine nella lista

		Map<Articolo, Integer> mappaOrdine = x.getArticle();//mi prendo la mappa degli articoli dell'ordine
		Set<Articolo> listaArticoli = mappaOrdine.keySet();

		for (Articolo a : listaArticoli)//scorro tutti gli articoli della lista delle quantita in ordine
		{
		    if (quantita.containsKey(a)) {//controllo che la mappa delle quantità contenga l'articolo
			if (mappaOrdine.get(a) > quantita.get(a))//se la quantità richiesta è maggiore della quantità in magazzino 
			{
			    isPossible = false;
			}
		    } else//se la mappa non contiene l'articolo
		    {
			throw new ArticleNotFound("Articolo non presente in magazzino, attendere un ingresso di questo articolo e poi ritentare l'uscita!");
		    }
		}

		//finito il ciclo controllo allora se è possibile effettuare l'uscita
		if (isPossible) {
		    for (Articolo articoloOrdine : listaArticoli) {
			quantita.replace(articoloOrdine, quantita.get(articoloOrdine) - mappaOrdine.get(articoloOrdine));
		    }
		    for (Articolo X : n.getArticle().keySet()) {
			if (usciteMensili.containsKey(X)) {
			    usciteMensili.put(X, usciteMensili.get(X) + n.getArticle().get(X));
			} else {
			    usciteMensili.put(X, n.getArticle().get(X));
			}
		    }

		    uscite.add(new Uscita(n));
		    n.createShip();
		    return;
		} else {
		    throw new OrderImpossibleToCreate("Quantità in magazzino insufficenti per effettuare spedire l'ordine!");
		}

	    }//if equals
	}
	throw new OrderNotFound("Impossibile generare l'uscita per l'ordine indicato!\nL'ordine non si trova nella lista degli ordini!");
    }//createExit()

    public boolean addOrdine(Ordine o) {
	return ordini.add(o);
    }

    public boolean removeOrdine(Ordine o) {
	return ordini.remove(o);
    }

    public void removeOrdine(int i) {
	ordini.remove(i);
    }

    public Ordine getOrdine(int i) {
	return ordini.get(i);
    }

    public boolean ordineIsEmpty() {
	return ordini.isEmpty();
    }

    public int ordineSize() {
	return ordini.size();
    }
    
    public void setOrdine(int i, Ordine o){
        ordini.remove(i);
        ordini.add(i, o);
    } 
    public boolean isShipped(int i) {
	return ordini.get(i).isShipped();
    }

    public boolean isShipped(Ordine o) throws OrderNotFound {
	if (ordini.contains(o)) {
	    for (Ordine X : ordini) {
		if (X.equals(o)) {
		    return X.isShipped();
		}
	    }
	}
	throw new OrderNotFound("Impossibile trovare l'ordine specificato!");
    }


    /**
     * SAVE DATA IN FILE
     */
    public void save() {
	
	try {
	    JFileChooser jfc = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("File dati binari (.dat)", "dat");
	    jfc.setFileFilter(filter);
	    int buttonPressed = jfc.showSaveDialog(null);
	    File file;

	    if (buttonPressed == JFileChooser.APPROVE_OPTION) {

		try {
		    file = jfc.getSelectedFile();
		    ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream((file)));
		    fileOut.writeObject(INSTANCE);
		    fileOut.flush();
		    fileOut.close();
		    JOptionPane.showMessageDialog(null, "Salvataggio riuscito");
		} catch (HeadlessException | IOException e) {
		    JOptionPane.showMessageDialog(null, "Salvataggio non riuscito");
		}
	    }

	} catch (HeadlessException e) {
	    JOptionPane.showMessageDialog(null, "Errore nell'aprire il file");
	}
    }

    public String getReportMensile(int i) {
	return report.get(i);
    }

    public int reportSize() {
	return report.size();
    }

    public boolean reportIsEmpty() {
	return report.isEmpty();
    }

    public String chiusuraMensile() {
	GregorianCalendar dataOdierna = new GregorianCalendar();
	String s = "Report mensile riferito al " + dataOdierna.get(GregorianCalendar.MONTH) + "" + dataOdierna.get(GregorianCalendar.YEAR) + "\n";
	s = "Ingressi:\n";
	for (Articolo X : ingressiMensili.keySet()) {
	    s += "Nome Articolo: " + X.getTipoArticolo().getName() + "\t" + ingressiMensili.get(X) + "pezzi\n";
	}
	s += "\n\nUscite: \n";
	for (Articolo X : usciteMensili.keySet()) {
	    s += "Nome Articolo" + X.getTipoArticolo().getName() + "\t" + usciteMensili.get(X) + "pezzi\n";
	}
	ingressiMensili.clear();
	usciteMensili.clear();
	report.add(s);
	return s;
    }

}//MAGAZZINO

/**
 * ********************************************************** FINE
 * *************************************************************************
 */
