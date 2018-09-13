package Main;

import java.io.Serializable;

public class Utente implements UserInterface, Comparable<Utente>, Serializable{
    
        
    private String usr;
    private String pwd;
    private int t; 
    
    /*********************COSTRUTTORE**********************/
    public Utente(String user, String password, int type){
                    usr = user;
                    pwd = password;
                    this.t = type;

    }

    
    /********************* METODI SET *********************/
    @Override
    public boolean setUser(String newUser){
        if(!" ".equals(newUser) && !"".equals(newUser)){
            usr = newUser;
            return true;//lancia eccezione VoidStringUnexpectedException
        }else return false;
    }//fine setUser
    
    @Override
    public boolean setPassword(String newPassword){//La password deve essere almeno lunga 8 caratteri
        if( !"".equals(newPassword) && !"".equals(newPassword) ){
         pwd = newPassword;
         return true;//lancia eccezione VoidStringUnexpectedException
        }else
        return false;
    }//setPassword

    @Override
    public boolean setType(int newType){
        switch(newType){
            case 1: 
            case 2:
            case 3: t=newType; return true;
            default: return false;
        }//switch   
    }//fine setType
    
    
    
        
    
    
    
    
    /*********************METODI GET**********************/
    @Override
    public String getUsr(){
        return usr;
    }
            
    @Override
    public int getTypeInt(){
        return t;
    }

    
    
    
    
    
    /***************************************** HASHCODE *******************************************/
    @Override
    public int hashCode(){
	return usr.hashCode()^pwd.hashCode();
    }
    
    
    
    
    
    
    /***************************************** EQUALS *******************************************/
    @Override
    public boolean equals(Object obj) {//due utenti sono uguali se hanno lo stesso username
        return obj instanceof Utente && ((Utente)obj).usr.equals(usr);
    }
    
    
    
    
    
    /***************************************** COMPARE-TO *******************************************/
    @Override
    public int compareTo(Utente other){//ordine prima per tipo di utente e poi per nome utente 
        //se t-other.t == 0 ritorna il compareTo degli username altrimenti ritorna la differenza tra i tipi
        return t-other.t == 0 ? usr.compareToIgnoreCase(other.usr) : t-other.t;
    }
        
    
    
    
    
    
    /*****************************************TO-STRING*******************************************/
    @Override
    public String toString(){//per sicurezza non passo la password in chiaro
        return "Username: "+usr+"\nPassword: "+"********\n"+"Tipo Account: "+t+" ";
    }

}//fine Utente
