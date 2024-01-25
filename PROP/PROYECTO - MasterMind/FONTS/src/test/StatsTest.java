package test;

import main.domain.classes.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StatsTest {

    /**
     * Instància de Stats
     */
    private final Stats stats;

    /**
     * És la puntuacio del usuari quan és CodeMaker
     */
    private final Integer puntuacioCodeMaker;

    /**
     * És la puntuacio del usuari quan és CodeBraker
     */
    private final Integer puntuacioCodeBreaker;

    /**
     * Són les partides iniciades de l'usuari
     */
    private final Integer iniciades;

    /**
     * Són les partides acabades de l'usuari
     */
    private final Integer acabades;


    /** @brief Test de la creadora
     * <p>
     * Comprova si es crea correctament donat les stats.
     */
    public StatsTest(Stats stats, Integer puntuacioCodeMaker, Integer puntuacioCodeBreaker, Integer iniciades, Integer acabades, Integer ajudes) {
        this.stats = stats;
        this.puntuacioCodeMaker = puntuacioCodeMaker;
        this.puntuacioCodeBreaker = puntuacioCodeBreaker;
        this.iniciades = iniciades;
        this.acabades = acabades;
    }


    /** @brief conjunt d'objectes data donats uns conjunts de Stats representats per Integers.
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Stats(), 10, 20, 5, 3, 2},
                {new Stats(), 5, 8, 2, 1, 1},
                {new Stats(), 15, 30, 10, 5, 3}
        });
    }


    /** @brief Test getters i setters de Stats
     * <p>
     * Comprova que funciona correctament els getterss i setters de Stats
     */
    @Test
    public void testStats() {
        stats.setPuntuacioCodeMaker(puntuacioCodeMaker);
        stats.setPuntuacioCodeBreaker(puntuacioCodeBreaker);
        stats.setIniciades(iniciades);
        stats.setAcabades(acabades);

        assertEquals(puntuacioCodeMaker, stats.getPuntuacioCodeMaker());
        assertEquals(puntuacioCodeBreaker, stats.getPuntuacioCodeBreaker());
        assertEquals(iniciades, stats.getIniciades());
        assertEquals(acabades, stats.getAcabades());
    }

}