package main.domain.controllers;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import main.data.CtrlData;
import main.domain.classes.Exceptions.ContrasenyaIncorrecte;
import main.domain.classes.Exceptions.DificultatNoExisteix;
import main.domain.classes.Exceptions.UsuariJaExisteix;
import main.domain.classes.*;
import main.domain.classes.Record;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/* @file CtrlDomain.java
@brief Clase <em>CtrlDomain</em>.
*/

/**
* @author Marc Duran López
*/

public class CtrlDomain {

	/**
	 * Instància de l'usuari actual
	 */
	public Usuari usuariActual;
	/**
	 * Instància de la partida actual
	 */
	public Partida partidaActual;

	/**
	 * Instància del Ranking
	 */
	private Ranking ranking;

	/**
	 * Instància del JugadorIA
	 */
	private JugadorIA jugadorIA;

	/**
	 * Instància del controlador de persistencia
	 */
	private final CtrlData dades;

	/**
	 * Gson amb la informació dels usuaris
	 */
	private final Gson usuarisJSON;

	/**
	 * Instància del controlador de domini
	 */
	private static CtrlDomain ctrlDomain;
	
	/**
	 * @brief Creadora per defecte
	 * <p>
	 * S'inicialitza el contrlador de domini. S'obte la instància singleton del controlador de persistencia
	 */

	public CtrlDomain() {
		dades = CtrlData.getInstance();
		usuarisJSON = new Gson();
		ranking = new Ranking(this);
	}

	/**
	 * @return la instància CtrlDomain
	 * @brief Obté una instància de CtrlDomain
	 * <p>
	 * Si no existeix cap instància singleton d'aquesta classe, crea una i la retorna. En cas contrari retorna l'existent
	 */

    public static CtrlDomain getInstance() {
        if (ctrlDomain == null) {
            ctrlDomain = new CtrlDomain();
        }
            return ctrlDomain;
    }

	/**
	 * @param nomusuari representa el nom d'usuari d'un usuari existent del sistema
	 * @throws FileNotFoundException en cas que no existeixi cap usuari amb aquest nomusuari
	 * @return L'usuari que correspon al nom d'usuari pasat com a parametre
	 * @brief Funcio que permet obtenir un usuari guardat al sistema
	 */

	public JsonReader getUsuari(String nomusuari) throws FileNotFoundException {
		return dades.getUsuari(nomusuari);
	}

	/**
	 * @param username representa el nom d'usuari a comprovar si existeix
	 * @return cert en cas que ja existeixi un usuari amb nom d'usuari username. En cas contrari retorna fals
	 * @brief Aquesta funció ens indica si existeix un usuari amb el nom d'usuari passat per paràmetre
	 */

	public Boolean existeixUsuari(String username) {
		
		return dades.existeixUsuari(username);
	}

	/**
	 * @brief Aquesta funció fa actualitzar el ranking per tal d'actualitzar-lo al final de cada partida
	 */

	public void actualitzaRanking() {
		ranking = new Ranking(this);
	}

	/**
	 * @param nomusuari representa el nom d'usuari
	 * @param password  representa la contraseña del usuari
	 * @throws ContrasenyaIncorrecte en cas que la contraseña no sigui correcte
	 * @throws FileNotFoundException en cas que l'usuari no existeixi
	 * @brief Funció que permet carregar l'usuari (inicia sessio)
	 * <p>
	 ** Actualiza l'usuari actual del sistema amb l'usuari que correspon al nom d'usuari i contraseña, en cas que existeixi i l'usuari i contrasenya siguin correctes.
	 */

	public void carregarUsuari(String nomusuari, String password) throws FileNotFoundException, ContrasenyaIncorrecte {
		JsonReader usuariSel = getUsuari(nomusuari);
		usuariActual = usuarisJSON.fromJson(usuariSel, Usuari.class);
		if (!password.equals(usuariActual.getPassword())) {
			usuariActual = null;
			throw new ContrasenyaIncorrecte();
		}
	}


	/**
	 * @brief Funció que permet a l'usuari tancar sessio
	 * <p>
	 * Actualiza los parámetros asociados al jugador a nulo
	 */

	public void tancarSesioUsuari() {
		usuariActual = null;
		partidaActual = null;
	}

	/**
	 * @param nomusuari representa el nom d'usuari
	 * @param password  representa la contraseña del usuari
	 * @throws UsuariJaExisteix en cas que ja existeixi un usuari amb el mateix nom usuari
	 * @throws ContrasenyaIncorrecte en cas que la contraseña no sigui correcte
	 * @brief Funció que permet a l'usuari registrarse
	 *<p>
	 *En cas que l'usuari es pugui registrar, crea un usuari amb el nom i contraseña i carrega sessio
	 */

	public void registrarUsuari(String nomusuari, String password) throws UsuariJaExisteix, ContrasenyaIncorrecte {
		usuariActual = new Usuari(nomusuari, password);
		if (password.equals(" ")) throw new ContrasenyaIncorrecte();
		String usuariJSON = usuarisJSON.toJson(usuariActual);
		guardarNouUsuari(nomusuari, usuariJSON);
		actualitzaRanking();
	}

	/**
	 * @return La llista de partides guardades de l'usuari actual del sistema
	 * @brief Funció que permet obtenir la llista de partides guardades d'un usuari
	 */

	public List<Partida> getPartidesGuardades() {
		return usuariActual.getPartidesGuardades();
	}

	/**
	 * @brief Guarda la partida
	 */
	public void guardarPartida() {
		usuariActual.afegeixPartidaGuardada(partidaActual);
		guardarUsuari();
	}

	/**
	 * @brief Guarda l'usuari
	 */
	public void guardarUsuari() {
		String playerJSON = usuarisJSON.toJson(usuariActual);
		dades.guardarUsuari(usuariActual.getNom(), playerJSON);
	}

	/**
	 * @throws UsuariJaExisteix en cas que ja existeixi un usuari amb el mateix nom usuari
	 * @brief Crea i guarda un nou usuari.
	 */

	public void guardarNouUsuari(String nomusuari, String usuariJSON) throws UsuariJaExisteix {
		if (dades.existeixUsuari(nomusuari)) throw new UsuariJaExisteix();

		dades.guardarUsuari(nomusuari, usuariJSON);
	}

	/**
	 * @param min representa el número més petit que pot surtir a la sequencia
	 * @param max representa el numero mes gran que pot surtir a la sequencia
	 * @return Una llista de Integer amb la sequencia generada (cada numero s'assoicia a un color)
	 * @brief Funció que permet generar la sequencia a resoldre pel CodeBreaker de manera random
	 */

	public List<Integer> generadorCodiResoldre(Integer min, Integer max) {
		List<Integer> codiResoldre = partidaActual.getTauler().getCodiResoldre();
		for (int i = min; i < max; ++i) {
			Random rand = new Random();
			Integer randomNum = rand.nextInt(6);
			codiResoldre.add(randomNum);
		}
		return codiResoldre;
	}

	/**
	 * @param dificultat representa la dificultat asignada a la partida (determina el numero de bolas a jugar)
	 * @param rol representa el rol assignat a la partida
	 * @param algorisme representa l'algorisme triat per a la partida
	 * @throws DificultatNoExisteix en el cas que la dificultat no sigui cap de les donades
	 * @brief Funció que permet crear una nova partida.
	 * <p>
	 * Es crea una nova partida per l'usuari actual del sistema. A més es crea un tauler buit
	 */

	public void creaNovaPartida(Integer dificultat, String rol, Integer algorisme) throws DificultatNoExisteix {
		List<Partida> partidesGuardades = getPartidesGuardades();
		int idPartida;
		if (partidesGuardades.size() == 0) idPartida = 0;
		else idPartida = partidesGuardades.get(partidesGuardades.size() - 1).getIdPartida() + 1;

		partidaActual = new Partida(idPartida, dificultat, rol, algorisme);
		usuariActual.getStats().afegirIniciadesStats();
		jugadorIA = new JugadorIA(partidaActual);
		jugadorIA.setStrategy(algorisme);

		int numBolas;
		if (dificultat == 1) numBolas = 4;
		else if (dificultat == 2) numBolas = 5;
		else if (dificultat == 3) numBolas = 6;
		else throw new DificultatNoExisteix();

		if (rol.equals("CodeBreaker")) {
			partidaActual.getTauler().setCodiResoldre(generadorCodiResoldre(0, numBolas));
		}
	}

	/**
	 * @param idPartida identificador de la partida que es vol continuar
	 * @brief Continua una partida existent
	 */

	public void continuaPartida(Integer idPartida) {
		partidaActual = usuariActual.getPartidafromList(idPartida);
		if (partidaActual == null) System.out.println("Partida no guardada");

		jugadorIA = new JugadorIA(partidaActual);
		jugadorIA.setStrategy(partidaActual.getAlgorisme());
	}

	/**
	 * @param codi representa la llista amb la sequencia a resoldre pel codeBreaker
	 * @brief Assigna una sequencia a la sequencia a resoldre a la partida actual del sistema
	 */

	public void asignaCodiCodeMaker(List<Integer> codi) {
		partidaActual.getTauler().setCodiResoldre(codi);
	}

	/**
	 * @return una llista d'enters amb la seqüència a resoldre a la partida
	 * @brief Obté la seqüència a resoldre
	 */

	public List<Integer> getCodiResoldre() {
		return partidaActual.getTauler().getCodiResoldre();
	}

	/**
	 * @return una llista de llistes d'enters que representa el board amb les seqüències donades
	 * @brief Funció que obté totes les seqüències que fa l'algorisme fins a arribar al codi a resoldre de la partida
	 */
	public List<List<Integer>> SequenciaMaq() {
		return jugadorIA.executeMaquina(getCodiResoldre());
	}

	/**
	 * @return una llista de String que representa el feedback obtingut
	 * @brief Funció que obté una llista amb el feedback de totes les seqüències de la partida jugada per l'algorisme
	 */
	public List<String> getPegsMaq() {
		return jugadorIA.getPegsMaq();
	}

	/**
	 * @return True si la sequencia introduida utilitza colors valida. En cas contrari, retorna false
	 * @brief funcio que permet comprovar que la sequencia introduida utilitza colors valids.
	 */
	public boolean checkValida(List<Integer> codi) {
		for (Integer integer : codi) {
			if (integer < 0 || integer > 5) {
				System.out.println("Sequencia incorrecte: Valors 0~5");
				return false;
			}
		}
		return true;
	}


	/**
	 * @return Un Integer que representa un color de la seqüència a resoldre que no esta present a la sequencia introduida pel CodeBreaker. En el cas que hi siguin tots els colors a la sequencia retorna -1
	 * @brief Mostra un color de la sequencia a resoldre que no te la seqüència introduida pel CodeBreaker
	 */

	public Integer mostraColorExistent() {
		Integer ronda = partidaActual.getTauler().getRonda();
		List<Integer> codiResoldre = partidaActual.getTauler().getCodiResoldre();

		if (ronda == 0) {
			Random rand = new Random();
			int aux;
			if (codiResoldre.size() == 4) aux = rand.nextInt(3);
			else if (codiResoldre.size() == 5) aux = rand.nextInt(4);
			else aux = rand.nextInt(5);

			return codiResoldre.get(aux);
		} else {
			boolean found;
			List<Integer> codiSolucio = partidaActual.getTauler().getCodiActual(ronda - 1);
			for (int i = 0; i < partidaActual.getTauler().getNBolas(); ++i) {
				found = !codiSolucio.contains(codiResoldre.get(i));
				if (found) return codiResoldre.get(i);
			}
		}
		return -1;
	}

	/**
	 * @brief Imprimeix un color de la sequencia a resoldre que no te la sequencia introduida pel CodeBreaker
	 * <p>
	 * Imprimeix el color que no es troba a la sequencia proposada i contabilitza les ajudes fetes a la partida.
	 */

	public void ajutUsuari() {
		Integer ajuda = mostraColorExistent();
		if (ajuda != -1) {
			partidaActual.sumaNumAjudes();
			usuariActual.getStats().setAjudes();
			System.out.println("Pista: existeix el " + ajuda);
		}
	}


	/**
	 * @return True si ha guanyat la partida. En cas contrari, retorna fals
	 * @param rol representa el rol assignat a la partida
	 * @brief Comprova si el CodeBreaker ha resolt la sequencia proposada pel CodeMaker
	 */

	public boolean partidaGuanyada(String rol) {
		int ronda = partidaActual.getTauler().getRonda();

		List<Integer> codiSolucio = partidaActual.getTauler().getCodiActual(ronda);
		List<Integer> codiResoldre = partidaActual.getTauler().getCodiResoldre();

		if (rol.equals("CodeMaker")) {
			for (int i = 0; i < partidaActual.getTauler().getNBolas(); ++i) {
				if (!codiSolucio.get(i).equals(codiResoldre.get(i))) return true;
			}
		} else {
			for (int i = 0; i < partidaActual.getTauler().getNBolas(); ++i) {
				if (codiSolucio.get(i).equals(codiResoldre.get(i))) return true;
			}
		}
		return false;
	}

	/**
	 * @param puntuacioCM representa la puntuacio feta pel CodeMaker a la partida actual
	 * @param puntuacioCB representa la puntuacio feta pel CodeBreaker a la partida actual
	 *
	 * @brief Funció que actualitza la puntuacio del CodeMaker i CodeBreaker de la partida actual del sistema
	 * <p>
	 * Assigna les puntuacions pasades per parametre a les puntuacions del CodeMaker i CodeBreaker. A més s'aplica la penalitzacio a la puntuacio del CodeBreaker segons el nombre d'ajudes que ha utilitzat
	 */

	public void actualitzaPuntuacio(Integer puntuacioCM, Integer puntuacioCB) {
		Integer ajudes = partidaActual.getNumAjudes();
		Integer penalitzacioAjudes = ajudes * 10;
		partidaActual.setPuntuacioCM(puntuacioCM);

		if (puntuacioCB > penalitzacioAjudes) partidaActual.setPuntuacioCB(puntuacioCB - penalitzacioAjudes);
		else partidaActual.setPuntuacioCB(0);
	}

	/**
	 * @return la puntuació total com a CodeMaker
	 * @brief Funció que obté la puntuació total feta com a CodeMaker per l'usuari actual
	 */
	public int getPuntuacioCM() {

		return usuariActual.getStats().getPuntuacioCodeMaker();
	}

	/**
	 * @return la puntuacio total com a CodeBreaker
	 * @brief Funció que obté la puntuació total feta com a CodeBreaker per l'usuari actual
	 */
	public int getPuntuacioCB() {

		return usuariActual.getStats().getPuntuacioCodeBreaker();
	}

	/**
	 * @return les partides totals acabades
	 * @brief Funció que obté les partides totals acabades per l'usuari actual
	 */
	public int getPartidesAcabades() {

		return usuariActual.getStats().getAcabades();
	}

	/**
	 * @return les partides totals iniciades
	 * @brief Funció que obté les partides totals iniciades per l'usuari actual
	 */
	public int getPartidesIniciades() {

		return usuariActual.getStats().getIniciades();
	}

	/**
	 * @return les ajudes totals
	 * @brief Funció que obté les ajudes totals demanades per l'usuari actual
	 */
	public int getAjuts() {

		return usuariActual.getStats().getAjudes();
	}

	/**
	 * @brief Funció que suma en un les partides acabades de l'usuari actual
	 */
	public void afegirAcabadesStats() {

		usuariActual.getStats().afegirAcabadesStats();
	}


	/**
	 * @brief Funcio que obte el rol de la partida actual.
	 * @return el rol
	 */
	public String getRol() {
		return partidaActual.getRol();
		
	}

	/**
	 * @brief Funció que fa uns procediments a l'hora d'acabar la partida actual
	 * <p>
	 * Si era una partida que estaba guardada a la llista de partides guardades s'esborra, també s'actualitza partides acabades els stats de l'usuari
	 */

	public void procedimentsFinalPartida() {
		List<Partida> partidesGuardades = usuariActual.getPartidesGuardades();
		int i = partidesGuardades.indexOf(partidaActual);
		if (i != -1) partidesGuardades.remove(i);

		afegirAcabadesStats();
		guardarUsuari();
	}


	/**
	 * @brief Funció que fa uns procediments a l'hora d'acabar la partida actual de forma manual (botó close)
	 * <p>
	 * Si era una partida que estaba guardada a la llista de partides guardades s'esborra, també s'actualitza partides acabades els stats de l'usuari
	 */
	public void procedimentsFinalClose() {
		List<Partida> partidesGuardades = usuariActual.getPartidesGuardades();
		int i = partidesGuardades.indexOf(partidaActual);
		if (i != -1) partidesGuardades.remove(i);

		guardarUsuari();
	}


	/**
	 * @param ignoredRol representa el rol assignat a la partida
	 * @brief Acaba la partida actual del sistema
	 */
	public void acabarPartida(String ignoredRol) {
		int puntuacio;

		Integer dif = partidaActual.getDificultat();
		Integer ronda = partidaActual.getTauler().getRonda();
		String tempsPartida = partidaActual.getTemps();

		boolean guanyada = partidaGuanyada(partidaActual.getRol());

		if (!guanyada) {
			partidaActual.setPuntuacioCM(0);
			partidaActual.setPuntuacioCB(0);
		} else {
			if (partidaActual.getRol().equals("CodeMaker")) {

				puntuacio = ronda * dif * 5;
				actualitzaPuntuacio(puntuacio, 0);
				System.out.println("puntuacio: " + puntuacio);
				usuariActual.getStats().setPuntuacioCodeMaker(puntuacio);
			} else {
				
				puntuacio = dif * 10000 / (tempsASegons(tempsPartida) * ronda+1);
				actualitzaPuntuacio(0, puntuacio);
				usuariActual.getStats().setPuntuacioCodeBreaker(partidaActual.getPuntuacioCB());
			}
		}

		Record record = usuariActual.getRecord();
		record.guardarRecord(partidaActual);

		procedimentsFinalPartida();
	}


	/** @brief Surt de la partida sense acabar i es borra del sistema
	 */
	public void acabarClosePartida() {
		procedimentsFinalClose();
	}
	
	
	/**
	 * @return el temps en segons
	 * @brief funció que retorna el temps de la partida en segons
	 */
	
	private Integer tempsASegons(String tempsPartida) {
		
		return Integer.parseInt(tempsPartida.substring(0, 2)) * 3600 + 
			   Integer.parseInt(tempsPartida.substring(3, 5)) * 60 + 
			   Integer.parseInt(tempsPartida.substring(6, 8));
	}

	/**
	 * @return la situació actual de la seqüència introduïda (feedback)
	 * @brief Funció que compara la seqüència introduïda amb la seqüència a resoldre
	 */

	public String checkCode() {
		Integer ronda = getRondaPartida();
		List<Integer> codiActual = partidaActual.getTauler().getCodiActual(ronda);
		List<Integer> codiResoldre = partidaActual.getTauler().getCodiResoldre();
		return jugadorIA.checkCode(codiActual, codiResoldre);

	}


	/**
	 * @brief Funció que assigna la seqüència passada per paràmetre amb el codi actual del tauler
	 */

	public void taulerSetCodiActual(List<Integer> codi) {
		partidaActual.getTauler().setCodiActual(codi);
	}


	/**
	 * @param rol representa el ranking que es vol mostrar, ranking CodeMaker o CodeBreaker
	 * @return Una matriu amb el núm. de ranking, nom d'usuari i puntuacio. És ordenada per puntuació.
	 * @brief Funció que obte el ranking segons el rol
	 */

	public String[][] consultarRanking(String rol) {
		return ranking.getList(rol);
	}


	/**
	 * @return Una llista de llistes d'enters que representen el board actual
	 * @brief Funció que obte el board de la partida
	 */

	public List<List<Integer>> getBoardPartida() {
		return partidaActual.getTauler().getBoard();
	}


	/**
	 * @return la dificultat
	 * @brief Funció que obte la dificultat de la partida actual
	 */
	public Integer getDificultatPartida() {
		return partidaActual.getDificultat();
	}


	/**
	 * @return el temps
	 * @brief Funció que obte el temps de la partida actual
	 */

	public String getTempsPartida() {
		return partidaActual.getTemps();
	}

	/**
	 * @return partida actual
	 * @brief Getter de partidaActual
	 */

	public Partida getPartidaActual() {
		return partidaActual;
	}


	/**
	 * @return la ronda de la partida
	 * @brief Getter de ronda de partidaActual
	 */

	public Integer getRondaPartida() {
		return partidaActual.getTauler().getRonda();
	}


	/**
	 * @return La llista d'usuaris registrats al sistema
	 * @brief Getter d'usuaris
	 */

	public ArrayList<Usuari> getLlistaUsuaris() throws NullPointerException {
		JsonReader[] llistaUsuarisJSON = dades.getLlistaUsuaris();
		ArrayList<Usuari> llistaUsuaris = new ArrayList<>();

		for (JsonReader jsonReader : llistaUsuarisJSON) {
			llistaUsuaris.add(usuarisJSON.fromJson(jsonReader, Usuari.class));
		}
		return llistaUsuaris;
	}


	/**
	 * @return La llista d'usuaris registrats al sistema
	 * @brief Getter d'usuaris format JSON
	 */

	public JsonReader[] getLlistaUsuarisJSON() throws NullPointerException {
		return dades.getLlistaUsuaris();

	}


	/**
	 * @return una llista de String que representa el feedback obtingut
	 * @brief Funció que obté una llista amb el feedback de totes les seqüències de la partida jugada per l'usuari
	 */

	public List<String> getPegsPartida() {
		return partidaActual.getPegsPartida();
	}


	/**
	 * @return feedback del procés d'endevinar la seqüència
	 * @brief Getter del feedback del procés d'endevinar la seqüència per part de l'algorisme
	 */
	public List<String> getPegsPartidaMaq() {
		return partidaActual.getPegsPartidaMaq();
	}


	/**
	 * @return llista de seqüències obtingudes per l'algorisme
	 * @brief Getter de les seqüències obtingudes per l'algorisme fins a arribar a la seqüència a resoldre
	 */
	public List<List<Integer>> getCodsMaq(){
		return partidaActual.getCodsPartida();
	}


	/**
	 * @return jugadorIA
	 * @brief Getter de jugadorIA (la maquina)
	 */

	public JugadorIA getJugadorIA() {
		return jugadorIA;
	}


	/**
	 * @param ronda representa una ronda de la partida
	 * @brief Setter de ronda de partidaActual
	 */
	public void setRondaPartida(Integer ronda) {
		partidaActual.getTauler().setRonda(ronda);
	}
	
	/**
	 * @param temps representa el temps de partida
	 * @brief Setter de temps de partidaActual
	 */
	public void setTempsPartida(String temps) {
		partidaActual.tempsPartida = temps;
	}

}
