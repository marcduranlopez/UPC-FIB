package test;

import main.domain.classes.Record;
import main.domain.classes.Partida;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class RecordTest {

    /**
     * Instància de Record
     */
    private Record record;


    /** @brief setUp de la classe. Es crea una instància Record
     */
    @Before
    public void setUp() {
        record = new Record();
    }


    /** @brief Test getter i setter puntuació màxima CodeMaker
     * <p>
     * Comprova que funciona correctament el getter i setter de puntuació màxima CodeMaker
     */
    @Test
    public void testSetAndGetPuntuacioMaxCM() {
        Integer puntuacioMaxCM = 50;
        record.setPuntuacioMaxCM(puntuacioMaxCM);
        assertEquals(puntuacioMaxCM, record.getPuntuacioMaxCM());
    }


    /** @brief Test getter i setter puntuació màxima CodeBreaker
     * <p>
     * Comprova que funciona correctament el getter i setter de puntuació màxima CodeBreaker
     */
    @Test
    public void testSetAndGetPuntuacioMaxCB() {
        Integer puntuacioMaxCB = 30;
        record.setPuntuacioMaxCB(puntuacioMaxCB);
        assertEquals(puntuacioMaxCB, record.getPuntuacioMaxCB());
    }


    /** @brief Test guarda record CodeMaker
     * <p>
     * Comprova que guarda correctament el record de la partida quan el rol és CodeMaker
     */
    @Test
    public void testGuardarRecordCuandoPartidaActualEsCodeMaker() {
        Partida partidaActual = new Partida(1, 1, "CodeMaker",1);
        Record recordActual = new Record();
        recordActual.setPuntuacioMaxCM(50);
        Integer puntuacioCM = 70;
        partidaActual.setPuntuacioCM(puntuacioCM);
        record.guardarRecord(partidaActual);
        assertEquals(puntuacioCM, record.getPuntuacioMaxCM());
    }


    /** @brief Test guarda record CodeBreaker
     * <p>
     * Comprova que guarda correctament el record de la partida quan el rol és CodeBreaker
     */
    @Test
    public void testGuardarRecordCuandoPartidaActualEsCodeBraker() {
        Partida partidaActual = new Partida(1, 1, "CodeBraker",2);
        Record recordActual = new Record();
        recordActual.setPuntuacioMaxCB(20);
        Integer puntuacioCB = 40;
        partidaActual.setPuntuacioCB(puntuacioCB);
        record.guardarRecord(partidaActual);
        assertEquals(puntuacioCB, record.getPuntuacioMaxCB());
    }
}