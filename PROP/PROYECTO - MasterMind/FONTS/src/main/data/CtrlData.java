package main.data;

import com.google.gson.stream.JsonReader;

import java.io.*;

public class CtrlData {

    /**
     * ctrlData és la instància de CtrlData
     */
    private static CtrlData ctrlData;


    /**
     * @return la instància
     * @brief Obté la instància de CtrlData
     * <p>
     * Si no existeix una instància singleton d'aquesta classe, en crea una i la retorna. En cas contrari, retorna la que ja existeix
     * */

    public static CtrlData getInstance() {
        if (ctrlData == null) {
            ctrlData = new CtrlData();
        }
            return ctrlData;
    }

    /** @brief Creadora por defecte
     *
     */
    public CtrlData() {
        boolean existsFile;
        File file = new File("DATA/usuaris/");
        existsFile = file.exists();
        if (!existsFile) {
            File folderSol = new File("DATA/usuaris/");
            folderSol.mkdirs();
        }
    }

    /**
     * @param nomusuari nom d'usuari del qual s'ha de retornar l'arxiu json
     * @return un json amb la informació de l'usuari corresponent
     * @throws FileNotFoundException en cas que no existeixi un usuari amb aquest nom d'usuari
     * @brief Aquesta funció retorna l'arxiu json de l'usuari corresponent
     */

    public JsonReader getUsuari(String nomusuari) throws FileNotFoundException {
        return new JsonReader(new FileReader("./DATA/usuaris/" + nomusuari + ".json"));
    }

    /**
     * @return un enter que representa el nombre de jugadors
     * @throws NullPointerException en cas que no hi hagi jugadors
     * @brief Aquesta funció retorna el nombre de jugadors
     */

    public int getNumeroDeJugadors() throws NullPointerException {
        File carpeta = new File("./DATA/usuaris");
        File[] llistaArxius = carpeta.listFiles();
        if (llistaArxius != null) {
            return  llistaArxius.length;
        }
        return 0;
    }

    /**
     * @return un vector amb tots els jugadors en format json
     * @throws NullPointerException en cas que no hi hagi jugadors
     * @brief Aquesta funció retorna una llista dels jugadors
     */

    public JsonReader[] getLlistaUsuaris() throws NullPointerException {
        File carpeta = new File("./DATA/usuaris");
        File[] listaArchivos = carpeta.listFiles();
        int numArchius = getNumeroDeJugadors();

        JsonReader[] usuaris = new JsonReader[numArchius]; // n or n/2 ???

        for (int i = 0; i < numArchius; ++i) {
            JsonReader readerUsuari = null;
            try {
                assert listaArchivos != null;
                readerUsuari = new JsonReader(new FileReader(listaArchivos[i]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            usuaris[i] = readerUsuari;
        }
        return usuaris;
    }

    /**
     * @param nomusuari nom d'usuari a comprovar si ja existeix
     * @return cert en cas que ja existeixi un usuari amb el nom d'usuari username, fals en cas contrari
     * @brief Aquesta funció ens indica si existeix un jugador amb el nom d'usuari passat per paràmetre
     */

    public boolean existeixUsuari(String nomusuari) {
        File archivo = new File("./DATA/usuaris/" + nomusuari + ".json");
        return archivo.exists();
    }

    /**
     * @param nomusuari nom d'usuari del jugador a guardar
     * @param usuariJSON contingut del ficher associat al jugador
     * @brief Guarda el jugador
     */

    public void guardarUsuari(String nomusuari, String usuariJSON) {
        try {
            FileWriter arxiu = new FileWriter("./DATA/usuaris/" + nomusuari + ".json");
            PrintWriter printSolucio = new PrintWriter(arxiu);
                
            printSolucio.print(usuariJSON);
            printSolucio.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
