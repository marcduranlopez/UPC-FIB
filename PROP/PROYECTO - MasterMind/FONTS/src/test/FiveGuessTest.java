package test;

import main.domain.classes.FiveGuess;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FiveGuessTest {

    /** @brief Test de la creadora i de solve.
     * <p>
     * Comprova si es crea correctament la instància.
     * <p>
     * I es comprova que la funció solve, donada una seqüència a endevinar, retorni totes les seqüències propostes sent la darrera la seqüència a endevinar
     */
    @Test
    public void testSolve() {
        // Combinación objetivo
        List<Integer> code = Arrays.asList(1, 2, 3, 4);

        // Instanciamos un objeto FiveGuess
        FiveGuess maquina = new FiveGuess();

        // Invocamos el método solve con la combinación objetivo
        List<List<Integer>> guesses = maquina.solve(code);

        int index_combinacioCorrecte = guesses.size()- 1;
        assertEquals(code, guesses.get(index_combinacioCorrecte));
    }

}