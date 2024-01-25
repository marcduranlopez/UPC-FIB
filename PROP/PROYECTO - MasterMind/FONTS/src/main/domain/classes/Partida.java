package main.domain.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.*;

public class Partida {

    /**
     * Representa l'identificador de la partida
     */
    @SerializedName("id")
    @Expose
    private Integer idPartida;

    /**
     * Representa el temps de la partida
     */
    @SerializedName("temps")
    @Expose
    public String tempsPartida;

    /**
     * Representa la dificultat de la partida
     */
    @SerializedName("dificultat")
    @Expose
    private Integer dificultatPartida;

    /**
     * Representa el rol assignat a la partida
     */
    @SerializedName("rol")
    @Expose
    private String rol;

    /**
     * Representa l'algorisme assignat a la partida
     */
    @SerializedName("algorisme")
    @Expose
    private Integer algorisme;

    /**
     * Puntuacio aconseguida pel CodeMaker a la partida
     */
    @SerializedName("puntuacioCM")
    @Expose
    private Integer puntuacioCM;

    /**
     * Puntuacio aconseguida pel CodeBreaker a la partida
     */
    @SerializedName("puntuacioCB")
    @Expose
    private Integer puntuacioCB;

    /**
     * Representa el numero d'ajudes efectuades a la partida
     */
    @SerializedName("numAjudes")
    @Expose
    private Integer numAjudes;

    /**
     * Instància del tauler assignat a la partida
     */
    @SerializedName("situacioTauler")
    @Expose
    private Tauler taulerPartida;
    
    /**
     * Representa l'estat de la partida en cada una de les rondes
     */
    @SerializedName("pegsSolucio")
    @Expose
    private List<String> pegsPartida;

    /**
     * Representa la llista de seqüències obtingudes per l'algorisme
     */
    @SerializedName("codsMaq")
    @Expose
    private List<List<Integer>> codsMaq;

    /**
     * Representa el feedback del procés que ha fet l'algorisme per endevinar la seqüència
     */
    @SerializedName("pegsMaq")
    @Expose
    private List<String> pegsMaq;


    /** @brief Creadora per defecte
     *
     * S'inicialitza una partida buida
     */
    public Partida() {

    }


    /** @brief Creadora amb valors
     *
     * @param idPartida representa l'identificador de la partida
     * @param dificultatPartida representa la dificultat de la partida
     * @param rol representa el rol que s'assigna a la partida
     * @param algorisme representa l'algorisme triat a la partida
     */
    public Partida(Integer idPartida, Integer dificultatPartida, String rol, Integer algorisme) {
        this.idPartida = idPartida;
        this.tempsPartida = "00:00:00";
        this.dificultatPartida = dificultatPartida;
        this.rol = rol;
        this.algorisme = algorisme;
        this.numAjudes = 0;
        this.puntuacioCB = 0;
        this.puntuacioCM = 0;
        if (dificultatPartida == 1) this.taulerPartida = new Tauler(4);
        else if (dificultatPartida == 2) this.taulerPartida = new Tauler(5);
        else if (dificultatPartida == 3) this.taulerPartida = new Tauler(6);
        this.pegsPartida = new ArrayList<>();
    }


    /** @brief Getter del IdPartida
     *
     * @return idPartida
     */
    public Integer getIdPartida() {
        return idPartida;
    }


    /** @brief Getter del temps de la partida
     *
     * @return Temps
     */
    public String getTemps() {
        return tempsPartida;
    }


    /** @brief Getter de la difiultat de la partida
     *
     * @return Dificultat
     */
    public Integer getDificultat() {
        return dificultatPartida;
    }


    /** @brief Getter del rol del jugador de la partida
     *
     * @return Rol del jugador
     */
    public String getRol() {
        return rol;
    }


    /** @brief Getter del algorisme de la partida
     *
     * @return Algorisme de la partida
     */
    public Integer getAlgorisme() {
        return algorisme;
    }


    /** @brief Getter de la puntuacio del CodeMaker
     *
     * @return Puntuacio CodeMaker
     */

    public Integer getPuntuacioCM() {
        return puntuacioCM;
    }


    /** @brief Getter de la puntuacio del CodeBreaker
     *
     * @return Puntuacio CodeBreaker
     */
    public Integer getPuntuacioCB() {
        return puntuacioCB;
    }


    /** @brief Getter del numero d'ajudes efectuades a la partida
     * 
     * @return Numero d'ajudes
     */
    public Integer getNumAjudes() {
        return numAjudes;
    }


    /** @brief Getter del Tauler assignat a la partida
     * 
     * @return Tauler
     */
    public Tauler getTauler() {
        return taulerPartida;
    }


    /** @brief Setter del IdPartida
     *
     * @param idPartida representa l'id de la partida
     */
    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }


    /** @brief etter del rol del jugador de la partida
     *
     * @param rol represent el rol del jugador
     */
    public void setRol(String rol) {
        this.rol = rol;
    }


    /** @brief Setter de la puntuacio del CodeMaker
     *
     * @param puntuacio representa la puntuacio del CodeMaker
     */
    public void setPuntuacioCM(Integer puntuacio) {
        this.puntuacioCM = puntuacio;
    }


    /** @brief Setter de la puntuacio del CodeBraker
     *
     * @param puntuacio representa la puntuacio del CodeBreaker
     */
    public void setPuntuacioCB(Integer puntuacio) {
        this.puntuacioCB = puntuacio;
    }


    /** @brief Suma del numero d'ajudes efectuades a la partida
     */
    public void sumaNumAjudes() {
        this.numAjudes = numAjudes + 1;
    }


    /** @brief Setter del feedback que es va obtenint de la partida
     *
     * @param peg representa el feedback d'una ronda
     */
    public void setPegPartida(String peg) {
        pegsPartida.add(peg);
    }


    /** @brief Setter d'una llista amb la informació (feedback) del procés d'endevinar la seqüència per part de l'algorisme
     *
     * @param pegs conjunt de feedback d'una partida
     */
    public void setPegsMaq(List<String> pegs) {
        this.pegsMaq = pegs;
    }


    /** @brief Setter d'una llista de seqüències que representen les seqüències obtingudes per l'algorisme fins a arribar a la seqüència a resoldre
     *
     * @param cods representa un conjunt seqüències que formen la partida
     */
    public void setCodsMaq(List<List<Integer>> cods) {
        this.codsMaq = cods;
    }


    /** @brief Getter del feedback de la partida
     * @return pegsPartida
     */
    public List<String> getPegsPartida() {
    	return pegsPartida;
    }


    /** @brief Getter del feedback del procés d'endevinar la seqüència per part de l'algorisme
     * @return pegsMaq
     */
    public List<String> getPegsPartidaMaq() {
        return pegsMaq;
    }


    /** @brief Getter de les seqüències obtingudes per l'algorisme fins a arribar a la seqüència a resoldre
     * @return codsMaq
     */
    public List<List<Integer>> getCodsPartida() {
        return codsMaq;
    }
}