/*
 * Eccezzione generata quando ci si aspetta un numero positivo e viene passato un numero negativo
 * Ad esempio per gli indici degli arrayList o per modificare la quantità negli ordini
 */
package Exception;
public class NegativeIntUnexpectedException extends Exception{
    public NegativeIntUnexpectedException(String messaggio){
        super(messaggio);
    }
}
