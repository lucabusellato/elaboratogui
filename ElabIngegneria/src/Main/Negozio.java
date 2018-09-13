package Main;

import java.io.Serializable;

public class Negozio implements Comparable<Negozio>, Serializable{
    private String codiceFiscale;
    private String nome;
    private String indirizzo;
    private String citta;
    
    public Negozio(String cf, String name, String address, String city){
        codiceFiscale = cf;
        nome = name;
        indirizzo = address;
        citta = city;
    }
    
    
    /*----------------METODI SET--------------------------*/
    public boolean setCodiceFiscale(String cf){
        if(!" ".equals(cf) && !"".equals(cf)){
            codiceFiscale = cf;
            return true;
        }
        return false;
    }//setCodiceFiscale
    
    public boolean setNome(String x){
        if(!" ".equals(x) && !"".equals(x)){
            nome = x;
            return true;
        }
        return false;
    }//setNome
    
    public boolean setIndirizzo(String x){
        if(!" ".equals(x) && !"".equals(x)){
            indirizzo = x;
            return true;
        }
        return false;
    }//setIndirizzo
    
    public boolean setCitta(String x){
        if(!" ".equals(x) && !"".equals(x)){
            citta = x;
            return true;
        }
        return false;
    }//setCittà
    
    
    
    
    /*----------------METODI GET--------------------------*/
    public String getCodiceFiscale(){
        return codiceFiscale;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getindirizzo(){
        return indirizzo;
    }
    
    public String getCitta(){
        return citta;
    }
    
    
    
    
    @Override
    public int hashCode(){
        return codiceFiscale.hashCode() ^ nome.hashCode() ^ indirizzo.hashCode() ^ citta.hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        return other instanceof Negozio && ((Negozio) other).citta.equals(citta) && ((Negozio) other).codiceFiscale.equals(codiceFiscale) && ((Negozio) other).indirizzo.equals(indirizzo) && ((Negozio) other).nome.equals(nome);
    }
    
    
    @Override
    public int compareTo(Negozio other){
        
        int diff = nome.compareToIgnoreCase(other.nome);
        if ( diff != 0 )
            return diff;
        
        diff = codiceFiscale.compareToIgnoreCase(other.codiceFiscale);
        if ( diff != 0 )
            return diff;
        
        diff = citta.compareToIgnoreCase(other.citta);
        if ( diff != 0)
            return diff;
        
        return indirizzo.compareToIgnoreCase(other.indirizzo);
    }
    
    /*----------------TO STRING--------------------------*/
    @Override
    public String toString(){
        return "Codice Fiscale: " + codiceFiscale + "\nNome: " + nome + "\nIndirizzo: " + indirizzo + "\nCittà: " + citta;
    }
    
    
}//negozio
