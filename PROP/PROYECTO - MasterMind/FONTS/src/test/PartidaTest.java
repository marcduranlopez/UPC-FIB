package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import main.domain.classes.Partida;

public class PartidaTest {

    /**
     * Instància de Partida
     */
    private Partida partida;

    /** @brief setUp de la classe. Es crea una instància de Partida global
     */
    @Before
    public void setUp() {
        partida = new Partida(1, 3, "CodeBreaker", 1);
    }


    /** @brief Test de la creadora i getters
     * <p>
     * Comprova si es crea correctament donat l'identificador, la dificultat i el rol.
     * <p>
     * Tambè es comprova que funcionen correctament els getters de la classe donades una sèrie de partides
     */
    @Test
    public void testCreadoraAmbParametres() {
        Partida partida1 = new Partida(1, 1, "CodeMaker", 1);
        Partida partida2 = new Partida(2, 2, "CodeBreaker", 1);
        Partida partida3 = new Partida(3, 3, "CodeMaker",2);

        //Ids
        assertEquals((Integer)1, partida1.getIdPartida());
        assertEquals((Integer)2, partida2.getIdPartida());
        assertEquals((Integer)3, partida3.getIdPartida());

        //dificultats
        assertEquals((Integer)1, partida1.getDificultat());
        assertEquals((Integer)2, partida2.getDificultat());
        assertEquals((Integer)3, partida3.getDificultat());

        //rols
        assertEquals("CodeMaker", partida1.getRol());
        assertEquals("CodeBreaker", partida2.getRol());

        //algorismes
        assertEquals((Integer)1, partida1.getAlgorisme());
        assertEquals((Integer)2, partida3.getAlgorisme());

        //Taulers
        assertEquals((Integer)4, partida1.getTauler().getNBolas());
        assertEquals((Integer)5, partida2.getTauler().getNBolas());
        assertEquals((Integer)6, partida3.getTauler().getNBolas());

    }

    /** @brief Test setter identificador
     * <p>
     * Comprova que funciona correctament el setter d'identificador partida donat un Integer
     */
    @Test
    public void testSetIdPartida() {
        partida.setIdPartida(2);
        assertEquals((Integer) 2, partida.getIdPartida());
    }


    /** @brief Test setter puntuació CodeMaker
     * <p>
     * Comprova que funciona correctament el setter de puntuacio CodeMaker donat un Integer
     */
    @Test
    public void testSetPuntuacioCM() {
        partida.setPuntuacioCM(100);
        assertEquals((Integer) 100, partida.getPuntuacioCM());
    }


    /** @brief Test setter puntuació CodeBreaker
     * <p>
     * Comprova que funciona correctament el setter de puntuacio CodeBreaker donat un Integer
     */
    @Test
    public void testSetPuntuacioCB() {
        partida.setPuntuacioCB(50);
        assertEquals((Integer) 50, partida.getPuntuacioCB());
    }
}