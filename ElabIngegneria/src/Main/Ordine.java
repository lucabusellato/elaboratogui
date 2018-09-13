package Main;

import java.util.*;//gregorianCalendar e tutti i tipi di collezzione set, treeset,treemap,arraylist, linkedlist, hashmap, hashset...
import Exception.*;
import java.io.Serializable;


public class Ordine extends WarehouseMovement implements Comparable<Ordine>, Serializable{


    private Negozio negozio;
    private float prezzo;
    private boolean shipped = false;
    private final String corriere;

    private Map<Articolo, Integer> mappa = new TreeMap<>();

    /*-------------COSTRUTTORI---------------------*/
    public Ordine(Negozio n, String corriere, int day, int month, int year, Map<Articolo, Integer> m) throws VoidStringUnexpectedException {//DATA PASSATA IN INTERO 
        if (corriere.equals("") || corriere.equals(" ")) {
            throw new VoidStringUnexpectedException("Corierre non valido, stringa vuota!");
        }
        this.prezzo = 0;
        this.negozio = n;
        this.mappa = m;
        this.data = new GregorianCalendar(year, month, year);
        //Calcolo il costo totale degli articoli nella mappa
        calcolaPrezzo();
        this.corriere = corriere;
        ID = hashCode();
    }//costruttore con data come parametri interi

    public Ordine(Negozio n, String corriere) throws VoidStringUnexpectedException {//se non mi viene passata la data prendo la data odieran
        if (corriere.equals("") || corriere.equals(" ")) {
            throw new VoidStringUnexpectedException("Corriere non valido, stringa vuota!");
        }
        this.negozio = n;
        this.data = new GregorianCalendar();
        calcolaPrezzo();
        this.corriere = corriere;
        ID = hashCode();
    }

    public Ordine(Negozio n, String corriere, GregorianCalendar data) throws VoidStringUnexpectedException {
        if (corriere.equals("") || corriere.equals(" ")) {
            throw new VoidStringUnexpectedException("Corriere non valido, stringa vuota!");
        }
        this.negozio = n;
        this.data = data;
        calcolaPrezzo();
        this.corriere = corriere;
        ID = hashCode();
    }

    public Ordine(Negozio n, String corriere, GregorianCalendar data, Map<Articolo, Integer> m) throws VoidStringUnexpectedException {
        if (corriere.equals("") || corriere.equals(" ")) {
            throw new VoidStringUnexpectedException("Corriere non valido, stringa vuota!");
        }
        this.negozio = n;
        this.data = data;
        mappa.putAll(m);
        calcolaPrezzo();
        this.corriere = corriere;
        ID = hashCode();
    }

    //------------------METODI-GET-------------------//
    public Negozio getNegozio() {
        return negozio;
    }
    
    public int articoliSize(){
        int sum = 0;
        for(Articolo X: mappa.keySet())
            sum += mappa.get(X) == 0 ? 1: mappa.get(X);
        return sum;
    }

    public float getTotalPrice() {
        return prezzo;
    }

    public boolean getIfShipped() {
        return shipped;
    }

    public Map<Articolo, Integer> getArticle() {
        return mappa;
    }

    public String getCorriere() {
        return corriere;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    public void removeArticle(Articolo o) throws ArticleNotFound {
        if (!mappa.containsKey(o))//Se l'articolo non esiste nella mappa
        {
            throw new ArticleNotFound("L'articolo non è presente nell'ordine!");
        }
        mappa.remove(o);//altrimenti 
        calcolaPrezzo();
    }

    public void addArticle(Articolo a, int q) throws ArticleAlreadyExistException {
        if (mappa.containsKey(a))// se la mappa ha già l'articolo
        {
            throw new ArticleAlreadyExistException("L'articolo è già presente in questo ordine");
        } else {
            mappa.put(a, q);
            calcolaPrezzo();
        }
    }//addArticle

    public void setArticle(Articolo a, int q) throws NegativeIntUnexpectedException { //se q = 0 allora rimuovo l'articolo //se q > 0 modifico la quantità dell'articolo 

        if (q == 0) {
            if (mappa.containsKey(a)) {
                mappa.remove(a);
                calcolaPrezzo();
            }
        }

        if (q > 0) {
            if (mappa.containsKey(a)) {
                mappa.replace(a, q);//modifica il value se la chiave è già mappata
                calcolaPrezzo();
            }
        }

        if (q < 0) {
            throw new NegativeIntUnexpectedException("Quantità inserita negativa, Inserire una quantita >0 per modificare la quantità dell'oggetto\no inserire 0 per eliminare l'oggetto");
        }

    }//set article

    private void calcolaPrezzo() {
        //Calcolo il costo totale degli articoli nella mappa
        for (Map.Entry<Articolo, Integer> entry : mappa.entrySet()) {
            Articolo a = entry.getKey();
            int q = entry.getValue();
            this.prezzo = q * a.getPrezzo();
        }
    }

    public void createShip() {
        this.shipped = true;
    }

    public boolean isShipped() {
        return this.shipped;
    }

    @Override
    public int getID(){
        return ID;
    }
    
    @Override
    public int hashCode() {
        return data.hashCode() ^ mappa.hashCode() ^ (int) prezzo ^ data.get(GregorianCalendar.MINUTE) ^ data.get(GregorianCalendar.MILLISECOND) ^ data.get(GregorianCalendar.SECOND);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Ordine && ((Ordine) other).data.equals(data) && ((Ordine) other).mappa.equals(mappa) && negozio.equals( ((Ordine) other).negozio) && ((Ordine) other).prezzo == prezzo;
    }

    @Override
    public int compareTo(Ordine other) {
        //ordino per data, poi nella stessa data ordino per negozio, si veda il compareTo di negozio per gli ordinamenti di negozio,
        // nello stesso negozio ordino per prezzo totale poi per dimensione della mappa di articoloe quantità
        int diff = data.compareTo(other.data);
        if (diff != 0) {
            return diff;
        }

        diff = negozio.compareTo(other.negozio);
        if (diff != 0) {
            return diff;
        }

        float diffF = prezzo - other.prezzo;
        if (diffF != 0) {
            return (int) diffF;
        }

        return other.mappa.size() - mappa.size();//ordino per ordini con meno articoli fino a quelli con più ordini

    }

    @Override
    public String toString() {
        String s = "";
        Set<Articolo> set = new HashSet<>(mappa.keySet());

        for (Articolo X : set) {
            s = s.concat(X.getTipoArticolo().getName() + ": " + mappa.get(X) + "pezzi\n");
        }

        return s;
    }
}//fine ordine
