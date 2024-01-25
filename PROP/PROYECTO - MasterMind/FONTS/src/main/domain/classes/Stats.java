package main.domain.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    /** 
     * És la puntuacio del usuari quan és CodeMaker
    */
    @SerializedName("PuntuacioTotalCM")
    @Expose
    private Integer puntuacioCodeMaker;

    /** 
     * És la puntuacio del usuari quan és CodeBraker
    */
    @SerializedName("puntuacioTotalCB")
    @Expose
    private Integer puntuacioCodeBreaker;

    /** 
     * Són les partides acabades de l'usuari
    */
    @SerializedName("acabades")
    @Expose
    private Integer acabades;

    /** 
     * Són les partides iniciades de l'usuari
    */
    @SerializedName("iniciades")
    @Expose
    private Integer iniciades;

    /** 
     * Són les ajudes que ha demanat l'usuari(?)
    */
    @SerializedName("ajudesTotals")
    @Expose
    private Integer ajudes;


    /** @brief Creadora per defecte
     *
     * S'inicialitzen els stats a 0
     */
    public Stats() {
        this.puntuacioCodeMaker = 0;
        this.puntuacioCodeBreaker = 0;
        this.acabades = 0;
        this.iniciades = 0;
        this.ajudes = 0;    
    }


    /** @brief Getter de la puntuació quan l'usuari juga com a CodeMaker
     *
     * @return puntuació CodeMaker
     */
    public Integer getPuntuacioCodeMaker() {
        return puntuacioCodeMaker;
    }


    /** @brief Getter de la puntuació quan l'usuari juga com a CodeBreaker
     *
     * @return puntuació CodeBreaker
     */
    public Integer getPuntuacioCodeBreaker() {
        return puntuacioCodeBreaker;
    }


    /** @brief Getter de les partides iniciades per l'usuari
     *
     * @return partides iniciades
     */
    public Integer getIniciades() {
        return iniciades;
    }


    /** @brief Getter de le partides acabades per l'usuari
     *
     * @return partides acabades
     */
    public Integer getAcabades() {
        return acabades;
    }


    /** @brief Getter de les ajudes demanades per l'usuari
     *
     * @return ajudes demanades
     */
    public Integer getAjudes() {
        return ajudes;
    }


    /** @brief Afegeix una partida iniciada a les partides iniciades totals de l'usuari
     */
    public void afegirIniciadesStats() {

        ++iniciades;
    }


    /** @brief Afegeix una partida acabada a les partides acabades totals de l'usuari
     */
    public void afegirAcabadesStats() {
        
        ++acabades;
    }


    /** @brief Setter de la puntuació quan l'usuari juga com a CodeMaker
     *
     * @param puntuacioCodeMaker representa una puntuació
     */
    public void setPuntuacioCodeMaker(Integer puntuacioCodeMaker) {
        this.puntuacioCodeMaker += puntuacioCodeMaker;
    }


    /** @brief Setter de la puntuació quan l'usuari juga com a CodeBraker
     *
     * @param puntuacioCodeBreaker representa una puntuació
     */
    public void setPuntuacioCodeBreaker(Integer puntuacioCodeBreaker) {
        this.puntuacioCodeBreaker += puntuacioCodeBreaker;
    }


    /** @brief Setter de les partides iniciades per l'usuari
     *
     * @param iniciades representa el nombre de partides iniciades
     */
    public void setIniciades(Integer iniciades) {
        this.iniciades += iniciades;
    }


    /** @brief Setter de le partides acabades per l'usuari
     *
     * @param acabades representa el nombre de partides acabades
     */
    public void setAcabades(Integer acabades) {
        this.acabades += acabades;
    }


    /** @brief Afegeix una ajuda a les ajudes totals efectuades per l'usuari
     */
    public void setAjudes() {
        this.ajudes += 1;
    }

}

