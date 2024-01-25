package main.domain.classes;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import main.domain.controllers.CtrlDomain;

import java.util.*;

public class Ranking {
    
    /**
     * Usuaris registrats al sistema
     */
    public List<Usuari> usuarisRegistrats;

    /**
     * Gson amb la informació dels usuaris
     */
    private final Gson usuarisJSON;

    /**
     * Instància del controlador de domini
     */
    private final CtrlDomain domini;


    /** @brief Creadora de Ranking
     *
     * @param ctrlDomain representa el controlador de domini
     */
    public Ranking(CtrlDomain ctrlDomain) {
        domini = ctrlDomain;
        usuarisJSON = new Gson();
        llistaUsuaris();

    }

    /**
     * @brief Aquesta funció obté tots els usuaris guardats al sistema i els afegeix a usuarisRegistrats
     */
    public void llistaUsuaris()  {
        JsonReader[] read = domini.getLlistaUsuarisJSON();
        usuarisRegistrats = new ArrayList<>();
        for (JsonReader jsonReader : read) {
            usuarisRegistrats.add(usuarisJSON.fromJson(jsonReader, Usuari.class));
        }

    }

    /**
     * @brief Funció que ordena els jugadors a partir de la puntuació més alta
     *
     * @param rol representa el rol de l'usuari a la partida
     */
    public void ordena(String rol) {
        usuarisRegistrats.sort((u1, u2) -> {
            if (rol.equals("CodeMaker")) return u2.getRecord().getPuntuacioMaxCM() - u1.getRecord().getPuntuacioMaxCM();
            else return u2.getRecord().getPuntuacioMaxCB() - u1.getRecord().getPuntuacioMaxCB();
        });
    }


    /** @brief Funció que retorna una llista de jugadors (núm. en el ranking, nom i punts) ordenada per puntuació
     *
     * @param rol representa el rol de l'usuari a la partida
     * @return el jugadors ordenats formant el ranking
     */
    public String[][] getList(String rol) {
        ordena(rol);
        int n = usuarisRegistrats.size();
        String[][] rank = new String[n][3];
        for(int i = 0; i < n; ++i) {
            String num = String.valueOf(i + 1);
            Usuari u = usuarisRegistrats.get(i);
            rank[i][0] = num;
            rank[i][1] = u.getNom();
            String p = "";
            if(rol.equals("CodeMaker")) p = String.valueOf(u.getRecord().getPuntuacioMaxCM());
            else if(rol.equals("CodeBreaker")) p = String.valueOf(u.getRecord().getPuntuacioMaxCB());
            rank[i][2] = p;
        }
        return rank;
    }

}
