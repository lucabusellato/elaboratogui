package Main; //main

//MAIN 

import java.io.Serializable;
import java.util.GregorianCalendar; //In caso si vogliano fare delle manipolazione sulle date
import java.util.*;



public final class Ingresso extends WarehouseMovement implements Serializable, Comparable<Ingresso>{
    
    private final Map<Articolo, Integer> posizioni;
    private Map<Articolo, Integer> quantita;
    
    //COSTRUTTORI
    public Ingresso(Map<Articolo, Integer> quantita, Map<Articolo, Integer> posizioni){
        this.quantita = quantita;
        this.posizioni = posizioni;
        this.data = new GregorianCalendar();
        ID = hashCode();
    }
    
    public Ingresso(int d, int m, int y){
        this.posizioni = new TreeMap<>();
        this.quantita = new TreeMap<>();
        this.data = new GregorianCalendar(y, m, d);
        ID = hashCode();
    }
    
    public Ingresso(Map<Articolo, Integer> quantita, Map<Articolo, Integer> posizioni, GregorianCalendar data){
        this.quantita = quantita;
        this.posizioni = posizioni;
        this.data = data;
        ID = hashCode();
    }
    
    public Ingresso(Map<Articolo, Integer> quantita, Map<Articolo, Integer> posizioni, int d, int m, int y){
        this.quantita = quantita;
        this.posizioni = posizioni;
        this.data = new GregorianCalendar(y, m, d);
        ID = hashCode();
    }
 
    
    
    
    
    
    
    public int getPosition(Articolo a){
        if(a instanceof Articolo)
            if(posizioni.containsKey(a))
                return posizioni.get(a);
        return -1;//se non esiste un articolo così nella mappa restituisci  -1
    }
    
    
    public Articolo getArticleFromPosition(int i){//restituisce l'articolo nella posizione i 
        if(posizioni.containsValue(i))
            for(Articolo X: posizioni.keySet())
                if(posizioni.get(X) == i)
                    return X;
        return null;
    }
    
    public Map<Articolo, Integer> getQuantitaMap(){
        return this.quantita;
    }
    
    public Map<Articolo, Integer> getPositionMap(){
        return this.posizioni;
    }
    
    
    @Override
    public int hashCode(){//DEBUG
        return quantita.hashCode() ^ posizioni.hashCode() ^ data.hashCode();
    }

    @Override
    public int compareTo(Ingresso other){
        int diff = data.compareTo(other.data);
        if(diff != 0)
            return diff;
        
        return ID - other.ID;
          
    }
    @Override
    public boolean equals(Object other) {
        return other instanceof Ingresso && ((Ingresso)other).ID == ID;
    }
  
    @Override
    public String toString() {
        String s ="";
        for(Articolo X: (quantita.keySet()) )
            s += "Articolo: " + X.getTipoArticolo().getName() + "\tquantità: " + this.quantita.get(X) + " pezzi\tposizione: " + this.posizioni.get(X)+"\n";
        return s;
    }

}//fine ingresso
