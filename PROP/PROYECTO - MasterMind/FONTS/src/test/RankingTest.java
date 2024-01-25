package test;

import main.domain.classes.Ranking;
import main.domain.classes.Usuari;
import main.domain.controllers.CtrlDomain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RankingTest {

    /**
     * Instància de Tauler
     */
    private Ranking ranking;

    /**
     * Instància de CtrlDomain
     */
    private CtrlDomain domini;

    /**
     * Usuaris registrats al sistema
     */
    private final List<Usuari> usuarisRegistrats = new ArrayList<>();


    /** @brief setUp de la classe. Es crea una instància Ranking amb el controlador de domini com a parametre.
     * <p>
     * També s'hi afegeixen dades a usuarisRegistrats donats una sèrie de Strings i Integers que representen els usuaris
     */
    @Before
    public void setUp() {
    	Usuari usuari1 = new Usuari("usuari1", "contrasenya1", 100, 50);
        Usuari usuari2 = new Usuari("usuari2", "contrasenya2", 50, 90);
        Usuari usuari3 = new Usuari("usuari3", "contrasenya3", 150, 30);
        
        usuarisRegistrats.add(usuari1);
        usuarisRegistrats.add(usuari2);
        usuarisRegistrats.add(usuari3);
        
        ranking = new Ranking(domini);
    }


    /** @brief Test ordena
     * <p>
     * Comprova que ordena correctament els usuaris registrats per puntuació més alta donat un String que identifica rol CodeMaker
     */
    @Test
    public void testOrdenaCodeMaker() {
        
        ranking.ordena("CodeMaker");
        
        assertEquals("usuari3", usuarisRegistrats.get(0).getNom());
        assertEquals("usuari1", usuarisRegistrats.get(1).getNom());
        assertEquals("usuari2", usuarisRegistrats.get(2).getNom());
    }


    /** @brief Test ordena
     * <p>
     * Comprova que ordena correctament els usuaris registrats per puntuació més alta donat un String que identifica rol CodeBreaker
     */
    @Test
    public void testOrdenaCodeBraker() {
        
        ranking.ordena("CodeBraker");

        assertEquals("usuari2", usuarisRegistrats.get(0).getNom());
        assertEquals("usuari1", usuarisRegistrats.get(1).getNom());
        assertEquals("usuari3", usuarisRegistrats.get(2).getNom());
    }


    /** @brief Test getter Ranking CodeMaker
     * <p>
     * Comprova que retorna correctament una llista de jugadors (núm. en el ranking, nom i punts) ordenada per puntuació donat un String que identifica rol CodeMaker
     */
    @Test
    public void testGetListCodeMaker() {

        String[][] result = ranking.getList("CodeMaker");
        
        assertEquals("1", result[0][0]);
        assertEquals("2", result[1][0]);
        assertEquals("3", result[2][0]);

        assertEquals("usuari3", result[0][1]);
        assertEquals("usuari1", result[1][1]);
        assertEquals("usuari2", result[2][1]);

        assertEquals("150", result[0][2]);
        assertEquals("100", result[1][2]);
        assertEquals("50", result[2][2]);
    }


    /** @brief Test getter Ranking CodeBreaker
     * <p>
     * Comprova que retorna correctament una llista de jugadors (núm. en el ranking, nom i punts) ordenada per puntuació donat un String que identifica rol CodeBreaker
     */
    @Test
    public void testGetListCodeBraker() {
    	
        String[][] result = ranking.getList("CodeBreaker");

        assertEquals("1", result[0][0]);
        assertEquals("2", result[1][0]);
        assertEquals("3", result[2][0]);
        
        assertEquals("usuari2", result[0][1]);
        assertEquals("usuari1", result[1][1]);
        assertEquals("usuari3", result[2][1]);
        
        assertEquals("90", result[0][2]);
        assertEquals("50", result[1][2]);
        assertEquals("30", result[2][2]);
    }
}