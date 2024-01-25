package main.domain.classes;

public class Record {

    /**
     * Puntuació màxima de l'usuari quan juga com a CodeMaker
     */
    private Integer puntuacioMaxCM;

    /**
     * Puntuació màxima de l'usuari quan juga com a CodeBraker
     */
    private Integer puntuacioMaxCB;


    /** @brief Creadora per defecte
     *
     * S'inicialitza un Record amb valors a 0
     */
    public Record() {
        this.puntuacioMaxCM = 0;
        this.puntuacioMaxCB = 0;
    }

    /** @brief Creadora amb valors
     *<p>
     * Crea un Record amb la puntuacioMaxCM i la puntuacioMaxCB
     *
     * @param puntuacioMaxCM representa la puntuació màxima com CodeMaker
     * @param puntuacioMaxCB representa la puntuació màxima com CodeBreaker
     */
    public Record(Integer puntuacioMaxCM, Integer puntuacioMaxCB) {
        this.puntuacioMaxCM = puntuacioMaxCM;
        this.puntuacioMaxCB = puntuacioMaxCB;
    }


    /** @brief Getter de la puntuació màxima de l'usuari quan juga com a CodeMaker
     *
     * @return puntuacioMaxCM
     */
    public Integer getPuntuacioMaxCM() {
        return puntuacioMaxCM;
    }

    /** @brief Getter de la puntuació màxima de l'usuari quan juga com a CodeBraker
     *
     * @return puntuacioMaxCB
     */
    public Integer getPuntuacioMaxCB() {
        return puntuacioMaxCB;
    }


    /** @brief Setter de la puntuació màxima de l'usuari quan juga com a CodeMaker
     *
     * @param puntuacioMax representa la puntuació màxima com CodeMaker
     */
    public void setPuntuacioMaxCM(Integer puntuacioMax) {
        this.puntuacioMaxCM = puntuacioMax;
    }

    /** @brief Setter de la puntuació màxima de l'usuari quan juga com a CodeBraker
     *
     * @param puntuacioMax representa la puntuació màxima com CodeBreaker
     */
    public void setPuntuacioMaxCB(Integer puntuacioMax) {
        this.puntuacioMaxCB = puntuacioMax;
    }


    /**
     * @brief Compara la puntuació segons el rol de la partida actual amb la màxima i si s'escau, la sobreescriu
     *
     * @param partidaActual representa la partida actual
     */
    public void guardarRecord(Partida partidaActual) {
        if (partidaActual.getRol().equals("CodeMaker")) {
            if (partidaActual.getPuntuacioCM() > puntuacioMaxCM) {
            puntuacioMaxCM = partidaActual.getPuntuacioCM();
            }
        }
        else {
            if (partidaActual.getPuntuacioCB() > puntuacioMaxCB) {
                puntuacioMaxCB = partidaActual.getPuntuacioCB();
            }
        }
    }
}
