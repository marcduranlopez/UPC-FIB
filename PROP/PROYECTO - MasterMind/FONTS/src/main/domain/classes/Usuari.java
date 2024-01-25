package main.domain.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Usuari {
	
    /**
     * Nom del usuari
     */
    @SerializedName("nomusuari")
    @Expose
    private String nomusuari;

    /**
     * Password de l'usuari
     */
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * Les partides guardades de les que disposa l'usuari
     */
    @SerializedName("paridesGuardades")
    @Expose
    private List<Partida> partidesGuardades;

    /**
     * Les estadístiques de l'usuari
     */
    @SerializedName("stats")
    @Expose
    private Stats stats;

    /**
     * El record de l'usuari quan juga com a CodeMaker i quan juga com a CodeBraker
     */
    @SerializedName("records")
    @Expose
    private Record record;


    /** @brief Creadora per defecte
     *
     * S'inicialitza un usuari buit
     */
    public Usuari() {
    }

    /** @brief Creadora amb valors
     *<p>
     * Crea un usuari amb un nom d'usuari i una contrasenya
     *
     * @param nomusuari representa el nom d'usuari
     * @param password  representa la contraseña del usuari
     */
    public Usuari(String nomusuari, String password) {
        this.nomusuari = nomusuari;
        this.password = password;
        this.partidesGuardades = new ArrayList<>();
        this.stats = new Stats();
        this.record = new Record();
    }

    /** @brief Creadora amb valors
     *<p>
     * Crea un usuari amb un nom d'usuari, una contrasenya, una puntuacioMaxCM i una puntuacioMaxCB
     *
     * @param nomusuari representa el nom d'usuari
     * @param password  representa la contraseña del usuari
     * @param puntuacioMaxCM representa la puntuació màxima com CodeMaker
     * @param puntuacioMaxCB  representa la puntuació màxima com CodeBreaker
     */
    public Usuari(String nomusuari, String password, Integer puntuacioMaxCM, Integer puntuacioMaxCB) {
        this.nomusuari = nomusuari;
        this.password = password;
        this.partidesGuardades = new ArrayList<>();
        this.stats = new Stats();
        this.record = new Record(puntuacioMaxCM, puntuacioMaxCB);
    }


    /** @brief Getter del nom de l'usuari
     *
     * @return nom
     */
    public String getNom() {
        return nomusuari;
    }

    /** @brief Getter del password de l'usuari
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /** @brief Getter de la llista de les partides guardades de l'usuari
     *
     * @return llista de partides guardades
     */
    public List<Partida> getPartidesGuardades() {
        return partidesGuardades;
    }
    
    //Getter de les estadístiques de l'usuari
    /** @brief Getter de les estadístiques de l'usuari
     *
     * @return estadístiques
     */
    public Stats getStats() {
        return stats;
    }

    /** @brief Getter dels Records de l'usuari
     *
     * @return record
     */
    public Record getRecord() {
        return record;
    }


    /** @brief Setter del nom de l'usuari
     *
     * @param nomusuari representa un nom d'usuari vàlid
     */
    public void setNom(String nomusuari) {
        this.nomusuari = nomusuari;
    }

    /** @brief Setter del password de l'usuari
     *
     * @param password representa una contrasenya vàlida
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** @brief Setter de la llista de les partides guardades de l'usuari
     *
     * @param partidesGuardades representa partides guardades
     */
    public void setPartidesGuardades(List<Partida> partidesGuardades) {
        this.partidesGuardades = partidesGuardades;
    }

    /** @brief Setter de les estadístiques de l'usuari
     *
     * @param stats representa estadístiques d'un usuari
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }


    /**
     * @brief Funció que afegeix la partida actual a la llista de partides guardades
     */
    public void afegeixPartidaGuardada(Partida p) {
        partidesGuardades.add(p);
    }
    
    /**
     * @return La llista amb les estadístiques de l'usuari
     * @brief Funció que retorna una llista d'enters amb les estadístiques de l'usuari
     */
    public List<Integer> getListofStats(Stats stats) {
        List<Integer> st = new ArrayList<>();
        st.add(stats.getPuntuacioCodeMaker());
        st.add(stats.getPuntuacioCodeBreaker());
        st.add(stats.getIniciades());
        st.add(stats.getAcabades());
        st.add(stats.getAjudes());
        return st;
    }

    /**
     * @return la partida pasada per paràmetre de l'usuari
     * @brief Funció que retorna una partida de la llista de partides guardades de l'usuari
     */
    public Partida getPartidafromList(Integer partida) {
        for (int i = 0; i < partidesGuardades.size(); ++i) {
            if (partidesGuardades.get(i).getIdPartida().equals(partida)) {
                Partida carregaPartida = partidesGuardades.get(i);
                partidesGuardades.remove(i);
                return carregaPartida;
            }
        }
        return null;
    }

    /**
     * @return una llista amb els identificadors de partida de les partides guardades
     * @brief //Funció que retorna una llista d'enters amb els ids de les partides guardades de l'usuari
     */
    public List<Integer> getPartidesGuardades(List<Partida> partidesGuardades) {
        List<Integer> idPartides = new ArrayList<>();
        for (int i = 0; i < partidesGuardades.size(); ++i) {
            idPartides.add(partidesGuardades.get(i).getIdPartida());
        }
        return idPartides;
    }
    
}
