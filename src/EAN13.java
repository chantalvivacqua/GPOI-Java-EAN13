/**
 * classe che controlla la validità di un codice EAN13
 * @author Vivacqua ida Chantal
 * @version 0.1
 * @since 10/05/2023
 */

public class EAN13 {
    
    private String codice;

    /**
     * metodo per assegnare un valore da parametro al codice
     * @param c stringa rappresentante il codice ean13
     */
   
    public void setCodice(String c){
        codice = c;
    }

    /**
     * metodo per ottenere il codice
     * @return il codice ean13
     */
    public String getCodice(){
        return codice;
    }

    /**
     * metodo che veerifica la correttezza di un codice ean13 secondo le regole di controllo specifiche ad esso
     * @return cifra di controllo per assicurare la correttezza
     */
    public boolean verificaCodice(){

        // Verifica se l'attributo codice è vuoto o nullo
        if (codice.equals(null) || codice == ""){
            throw new NullPointerException("Il codice EAN-13 risulta vuoto o nullo");
        }

        // Verifica se la lunghezza dell'attributo codice è di 13
        if(codice.length() != 13) {
            return false;
        }
        
        // Implementazione dell'algoritmo di calcolo della cifra di controllo
        int somma = 0;
        int cifra;
        
        for(int i = 0; i < codice.length() - 1; i++) {   
            cifra = Character.getNumericValue(codice.charAt(i));
            
            if(i % 2 == 0) {
                somma += cifra * 1;  
            } else {
                somma += cifra * 3; 
            }
        }
        
        // Calcola la cifra di controllo
        int cifraDiControllo = (10 - (somma % 10));

        // Confronta la cifra di controllo con quella contenuta nel codice EAN13 (ultima cifra)
        return cifraDiControllo == Character.getNumericValue(codice.charAt(12)); 
    }


}
