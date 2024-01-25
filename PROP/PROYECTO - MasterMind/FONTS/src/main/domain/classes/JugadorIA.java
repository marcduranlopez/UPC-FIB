package main.domain.classes;

import java.util.*;

public class JugadorIA {

    /**
     * Instància de la màquina utilitzada (algorisme)
     */
    private Maquina maquina;

    /**
     * Instància de la partida actual
     */
    private final Partida partidaActual;


    /** @brief Creadora amb valors
     *<p>
     * Crea un jugadorIA amb una partida
     *
     * @param partida representa una partida del sistema
     */
    public JugadorIA(Partida partida) {
        this.partidaActual = partida;
    }


    /** @brief Setter de l'estrategia de la partida
     *
     * @param algorisme representa l'algorisme triat per la partida
     */
    public void setStrategy(Integer algorisme) {
        if (algorisme == 1) this.maquina = new FiveGuess();
        else this.maquina = new Genetic();

    }


    /** @brief Crida a la funció solve de la interfície Maquina de l'algorisme triat
     *
     * @param sol representa la seqüència a resoldre a la partida
     * @return retorna una llista de llistes que representa el board amb les seqüències obtingudes fins a arribar a la solució
     */
    public List<List<Integer>> executeMaquina(List<Integer> sol) {
        List<List<Integer>> codsMaq = maquina.solve(sol);
        partidaActual.setCodsMaq(codsMaq);
        return codsMaq;
    }


    /** @brief Aquesta funció retorna una llista amb la informació (feedback) del procés d'endevinar la seqüència per part de l'algorisme
     *
     * @return feedback del procés d'endevinar la seqüència
     */
    public List<String> getPegsMaq() {
        List<String> pegsMaq = maquina.getPegsResult();
        partidaActual.setPegsMaq(pegsMaq);
        return  pegsMaq;
    }


    /** @brief Aquesta funció retorna la llista de codis emmagatzemats a la clase de l'algorisme utilitzat per utilitzar-los de nou en carregar partida.
     *
     * @return llista de seqüències obtingudes per l'algorisme
     */
    public List<List<Integer>> getCodsMaq() {
        return maquina.getCodsResult();
    }


    /** @brief Aquesta funció retorna una la informació de la situació actual de la seqüència de l'usuari
     *
     * @param codiActual representa la seqüència introduïda per l'usuari
     * @param codiResoldre representa la seqüència a endevinar a la partida
     * @return el feedback donades les dos seqüències
     */
    public String checkCode(List<Integer> codiActual, List<Integer> codiResoldre) {
        String peg = maquina.checkCode(codiActual, codiResoldre);
        partidaActual.setPegPartida(peg);
        return peg;
    }
    
}
