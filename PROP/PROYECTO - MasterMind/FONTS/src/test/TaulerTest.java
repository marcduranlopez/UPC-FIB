package test;

import main.domain.classes.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TaulerTest {

    /**
     * Instància de Tauler
     */
    private Tauler tauler;


    /** @brief setUp de la classe. Es crea una instància Record amb nBolas donat un Integer
     */
    @Before
    public void setUp() {
        tauler = new Tauler(4);
    }


    /** @brief Test de la creadora i getters
     * <p>
     * Comprova si es crea correctament utilitzants els getters
     */
    @Test
    public void testCreadoraAmbParametres() {
        assertNotNull(tauler.getBoard());
        assertEquals(new ArrayList<>(), tauler.getBoard());
        assertEquals(new ArrayList<>(), tauler.getCodiResoldre());
        assertEquals((Integer) 4, tauler.getNBolas());
        assertEquals((Integer) 0, tauler.getRonda());
    }


    /** @brief Test getter board
     * <p>
     * Comprova que funciona correctament el getter del tauler
     */
    @Test
    public void testGetBoard() {
        List<List<Integer>> expectedBoard = new ArrayList<>();
        assertEquals(expectedBoard, tauler.getBoard());
        
        List<Integer> codi1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> codi2 = Arrays.asList(4, 3, 2, 1);
        expectedBoard.add(codi1);
        expectedBoard.add(codi2);
        
        tauler.setBoard(expectedBoard);
        assertEquals(expectedBoard, tauler.getBoard());
    }


    /** @brief Test getter ronda
     * <p>
     * Comprova que funciona correctament el getter de ronda
     */
    @Test
    public void testGetRonda() {
        assertEquals((Integer)0, tauler.getRonda());
        
        tauler.setRonda(3);
        assertEquals((Integer)3, tauler.getRonda());
    }


    /** @brief Test getter codi actual
     * <p>
     * Comprova que funciona correctament el getter del codi actual donat un Integer com a ronda
     */
    @Test
    public void testGetCodiActual() {
        
        List<Integer> codi1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> codi2 = Arrays.asList(4, 3, 2, 1);
        tauler.setCodiActual(codi1);
        tauler.setCodiActual(codi2);
        
        assertEquals(codi1, tauler.getCodiActual(0));
        assertEquals(codi2, tauler.getCodiActual(1));
    }


    /** @brief Test getter codi a resoldre
     * <p>
     * Comprova que funciona correctament el getter del codi a resoldre
     */
    @Test
    public void testGetCodiResoldre() {
        List<Integer> codiResoldre = Arrays.asList(1, 2, 3, 4);
        tauler.setCodiResoldre(codiResoldre);
        
        assertEquals(codiResoldre, tauler.getCodiResoldre());
    }


    /** @brief Test getter nombre d'espais tauler
     * <p>
     * Comprova que funciona correctament el getter del nombre d'espais del tauler (NBolas)
     */
    @Test
    public void testGetNBolas() {
        assertEquals((Integer)4, tauler.getNBolas());
        
        tauler.setNBolas(6);
        assertEquals((Integer)6, tauler.getNBolas());
    }


    /** @brief Test setter codi actual
     * <p>
     * Comprova que funciona correctament el setter del codi actual donada una llista d'Integers
     */
    @Test
    public void testSetCodiActual() {
        List<Integer> codi = Arrays.asList(1, 2, 3, 4);
        tauler.setCodiActual(codi);
        
        assertEquals(codi, tauler.getCodiActual(0));
    }


    /** @brief Test setter board
     * <p>
     * Comprova que funciona correctament el setter del tauler donada una sèrie de llistes d'Integers
     */
    @Test
    public void testSetBoard() {
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1, 2, 3, 4));
        board.add(Arrays.asList(2, 3, 4, 1));
        tauler.setBoard(board);
        assertEquals(board, tauler.getBoard());
    }


    /** @brief Test setter ronda
     * <p>
     * Comprova que funciona correctament el setter de ronda donat un Integer
     */
    @Test
    public void testSetRonda() {
        tauler.setRonda(5);
        assertEquals((Integer)5, tauler.getRonda());
    }


    /** @brief Test setter nombre d'espais tauler
     * <p>
     * Comprova que funciona correctament el setter del nombre d'espais del tauler (NBolas) donat un Integer
     */
    @Test
    public void testSetNBolas() {
        tauler.setNBolas(6);
        assertEquals((Integer)6, tauler.getNBolas());
    }


    /** @brief Test setter codi a resoldre
     * <p>
     * Comprova que funciona correctament el setter del codi a resoldre donada una llista d'Integers
     */
    @Test
    public void testSetCodiResoldre() {
        List<Integer> codi = Arrays.asList(1, 2, 3, 4);
        tauler.setCodiResoldre(codi);
        assertEquals(codi, tauler.getCodiResoldre());
    }

}