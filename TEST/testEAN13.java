import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class testEAN13 {

    EAN13 cod_ean13;

    @Before
    public void init(){
        cod_ean13 =new EAN13();
    }

    @Test
    public void testEanVerificaCodiceValido(){
        cod_ean13.setCodice("3614273613422");
        assertTrue(cod_ean13.verificaCodice());
    }

    
    @Test
    public void testEanVerificaCodiceNonValido(){
        cod_ean13.setCodice("3614273613232323233422");
        assertFalse(cod_ean13.verificaCodice());
    }

    
    @Test
    public void testEanVerificaCodiceLunghezzaNonValida(){
        cod_ean13.setCodice("3614273666666613422");
        assertFalse(cod_ean13.verificaCodice());
    }

    
    @Test
    public void  testEanVerificaCodiceVuoto(){
        cod_ean13.setCodice("");
     assertThrows("errore", NullPointerException.class, null);
    }

}
