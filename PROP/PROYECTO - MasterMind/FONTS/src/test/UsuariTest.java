package test;

import main.domain.classes.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UsuariTest {

    /**
     * Instància d'Usuari
     */
    private Usuari usuari;

    /**
     * Nom del usuari
     */
    private final String nomusuari;

    /**
     * Password de l'usuari
     */
    private final String password;


    /** @brief Test de la creadora
     * <p>
     * Comprova si es crea correctament donat el nom d'usuari i la contrasenya.
     */
    public UsuariTest(String nomusuari, String password) {
        this.nomusuari = nomusuari;
        this.password = password;
    }


    /** @brief setUp de la classe. Es crea una instància d'Usuari amb nom d'usuari i contrasenya
     */
    @Before
    public void setUp() {
        usuari = new Usuari(nomusuari, password);
    }

    /** @brief conjunt d'objectes data donats usuaris i contrasenyes com Strings
     */
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
            { "user1", "pass1" }, 
            { "user2", "pass2" }, 
            { "user3", "pass3" } 
        };
        return Arrays.asList(data);
    }


    /** @brief Test getter i setter nom d'usuari
     * <p>
     * Comprova que funciona correctament el getter i setter de nom d'usuari
     */
    @Test
    public void testSetNom() {
        usuari.setNom(nomusuari);
        assertEquals(nomusuari, usuari.getNom());
    }


    /** @brief Test getter i setter contrasenya
     * <p>
     * Comprova que funciona correctament el getter i setter de contrasenya
     */
    @Test
    public void testSetPassword() {
        usuari.setPassword(password);
        assertEquals(password, usuari.getPassword());
    }


    /** @brief Test afegeix partida guardada
     * <p>
     * Comprova que afegeix correctament una partida a la llista de partides guardades de l'usuari
     */
    @Test
    public void testAfegeixPartidaGuardada() {
        Partida partida = new Partida();
        usuari.afegeixPartidaGuardada(partida);
        List<Partida> partidesGuardades = usuari.getPartidesGuardades();
        assertTrue(partidesGuardades.contains(partida));
    }


    /** @brief Test getters stats usuari
     * <p>
     * Comprova que funciona correctament el getter dels stats i obté la llista dels stats de l'usuari correctament
     */
    @Test
    public void testGetListofStats() {
        Stats stats = new Stats();
        List<Integer> expectedStats = Arrays.asList(0, 0, 0, 0, 0);
        List<Integer> actualStats = usuari.getListofStats(stats);
        assertEquals(expectedStats, actualStats);
    }


    /** @brief Test getter partida de la llista de partides guardades
     * <p>
     * Comprova que funciona correctament el getter de la partida de la llista de partides guardades de l'usuari donat un Integer (identificador partida)
     */
    @Test
    public void testGetPartidafromList() {
        List<Partida> partidesGuardades = new ArrayList<>();
        usuari.setPartidesGuardades(partidesGuardades);

        Partida partida1 = new Partida();
        partida1.setIdPartida(1);
        usuari.afegeixPartidaGuardada(partida1);

        Partida partida2 = new Partida();
        partida2.setIdPartida(2);
        usuari.afegeixPartidaGuardada(partida2);

        Partida partida3 = new Partida();
        partida3.setIdPartida(3);
        usuari.afegeixPartidaGuardada(partida3);

        Partida partidaBuscada = usuari.getPartidafromList(3);
        assertEquals(partida3, partidaBuscada);
    }


    /** @brief Test getter partides guardades
     * <p>
     * Comprova que funciona correctament el getter de la llista de identificadors de partides guardades de l'usuari
     */
    @Test
    public void testGetPartidesGuardades() {
        Partida partida1 = new Partida();
        partida1.setIdPartida(1);
        Partida partida2 = new Partida();
        partida2.setIdPartida(2);
        usuari.setPartidesGuardades(Arrays.asList(partida1, partida2));
        List<Integer> expectedIds = Arrays.asList(1, 2);
        List<Integer> actualIds = usuari.getPartidesGuardades(usuari.getPartidesGuardades());
        assertEquals(expectedIds, actualIds);
    }

}