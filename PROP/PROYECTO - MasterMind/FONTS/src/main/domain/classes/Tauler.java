package main.domain.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.*;


public class Tauler {
   
    @SerializedName("espaisSequencia")
    @Expose
    private Integer nBolas;

    @SerializedName("board")
    @Expose
    private List<List<Integer>> board = new ArrayList<>();

    @SerializedName("sequenciaSolucio")
    @Expose
    private List<Integer> codiResoldre = new ArrayList<>();

    @SerializedName("rondaActual")
    @Expose
    private Integer ronda = 0;


    /** @brief Creadora per defecte
     *
     * S'inicialitza tauler buit
     */
    public Tauler() {

    }

    /** @brief Creadora amb valors
     *
     * @param nBolas la quantitat d'espais que té la partida
     */
    public Tauler(Integer nBolas) {
        this.nBolas = nBolas;
        this.ronda = 0;
        this.board = new ArrayList<>();
        this.codiResoldre = new ArrayList<>();
    }


    /** @brief Getter board
     *
     * @return board de la partida actual
     */
    public List<List<Integer>> getBoard() {     
       return board;
    }

    /** @brief Getter ronda
     *
     * @return ronda actual de la partida
     */
    public Integer getRonda() {
        return ronda;
    }

    /** @brief Getter codi actual donada una ronda
     *
     * @param  ronda representa una ronda de la partida
     * @return la seqüència de la ronda
     */
    public List<Integer> getCodiActual(Integer ronda) {
       return board.get(ronda);
    }

    /** @brief Getter codi a resoldre
     *
     * @return la seqüència a resoldre de la partida
     */
    public List<Integer> getCodiResoldre() {      
       return codiResoldre;
    }

    // Getter numero de boles
    /** @brief Getter numero de boles
     *
     * @return la quantitat d'espais que té la partida
     */
    public Integer getNBolas() {
        return nBolas;
    }


    /** @brief Setter board
     *
     * @param board representa un board passat per paràmetre de la situació de la partida
     */
    public void setBoard(List<List<Integer>> board) {     
       this.board = board;
    }

    /** @brief Setter ronda
     *
     * @param ronda representa la ronda de la partida
     */
    public void setRonda(Integer ronda) {
        this.ronda = ronda;
    }

    /** @brief Setter del numero de boles
     *
     * @param nBolas representa la quantitat d'espais que tindra la seqüència a completar
     */
    public void setNBolas(Integer nBolas) {
        this.nBolas = nBolas;
    }

    /** @brief Setter del codi actual al tauler
     *
     * @param codi representa la seqüència introduida per l'usuari
     */
    public void setCodiActual(List<Integer> codi) {    
        board.add(codi);
    }

    /** @brief Setter del codi actual al tauler
     *
     * @param codiResoldre representa la seqüència a endevinar
     */
    public void setCodiResoldre(List<Integer> codiResoldre) {       
        this.codiResoldre = codiResoldre;
    }
} 
