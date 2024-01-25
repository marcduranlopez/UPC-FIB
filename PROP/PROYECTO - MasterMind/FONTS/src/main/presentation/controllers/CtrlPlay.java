package main.presentation.controllers;

import main.domain.controllers.CtrlDomain;

import java.util.*;


public class CtrlPlay {

	/**
	 * Instància de CtrlDomain
	 */
	private final CtrlDomain cd;


	/** @brief Creadora per defecte. Obté una instància CtrlDomain
	 */
	public CtrlPlay() {
		cd = CtrlDomain.getInstance();
	}


	/** @brief Creadora amb valors
	 *
	 * @param cd representa una instància de CtrlDomain
	 */
	public CtrlPlay(CtrlDomain cd) {
		this.cd = cd;
	}


	/** @brief Getter del CtrlDomain
	 *
	 * @return instància de CtrlDomain
	 */
	public CtrlDomain getCD() {
		return cd;
	}


	/** @brief Funcio que obte la dificultat de la partida actual.
	 * <p> Crida la funció getDificultatPartida de CtrlDomain
	 * @return la dificultat
	 */
	public Integer getDificultat() {
		return cd.getDificultatPartida();
	}


	/** @brief Funcio que obte el temps de la partida actual.
	 * <p> Crida la funció getTempsPartida de CtrlDomain
	 * @return el temps
	 */
	public String getTempsPartida() {
        return cd.getTempsPartida();
    }


	/** @brief Funcio que obte el rol de la partida actual.
	 * <p> Crida la funció getRol de CtrlDomain
	 * @return el rol
	 */
	public String getRol() {
		return cd.getRol();
	}


	/** @brief Getter de ronda de partidaActual.
	 * <p> Crida la funció getRondaPartida de CtrlDomain
	 * @return la ronda de la partida
	 */
	public Integer getRonda() {
		
		return cd.getRondaPartida();
	}


	/** @brief Getter i setter de la ronda de partidaActual per actualitzar la ronda.
	 * <p> Crida la funció getRondaPartida i setRondaPartida de CtrlDomain
	 */
	public void actualitzaRonda() {
		
		cd.setRondaPartida(cd.getRondaPartida()+1);
	}


	/** @brief Setter de ronda de partidaActual.
	 * <p> Crida la funció setRondaPartida de CtrlDomain
	 *
	 * @param n ronda de la partida
	 */
	public void resetRonda(Integer n) {
		
		cd.setRondaPartida(n);
	}


	/** @brief Setter de la seqüència actual proposada al conjunt de sequüències que formen el tauler.
	 * <p> Crida la funció taulerSetCodiActual de CtrlDomain
	 *
	 * @param coAux seqüència proposada
	 */
	public void actualitzaTauler(List<Integer> coAux) {
		
		cd.taulerSetCodiActual(coAux);
	}


	/** @brief Setter de temps de la partida actual.
	 * <p> Crida la funció setTempsPartida de CtrlDomain
	 *
	 * @param temps representa el temps de partida
	 */
	public void setTempsPartida(String temps) {
        cd.setTempsPartida(temps);
    }


	/** @brief Getter de la puntuacio del CodeMaker
	 * <p> Crida la funció getPuntuacioCM de CtrlDomain
	 *
	 * @return Puntuacio CodeMaker
	 */
	public Integer getPuntsCM() {
		return cd.partidaActual.getPuntuacioCM();
    }


	/** @brief Getter de la puntuacio del CodeBreaker
	 * <p> Crida la funció getPuntuacioCM de CtrlDomain
	 *
	 * @return Puntuacio CodeBreaker
	 */
	public Integer getPuntsCB() {
		return cd.partidaActual.getPuntuacioCB();
    }


	/** @brief Acaba la partida actual del sistema i es realitzen tots els processos necesaris
	 * <p> Crida la funció acabarPartida de CtrlDomain
	 *
	 * @param rol representa el rol assignat a la partida
	 */
	public void acabarPartida(String rol) {
		cd.acabarPartida(rol);
	}


	/** @brief Surt de la partida sense acabar i es borra del sistema
	 * <p> Crida la funció acabarClosePartida de CtrlDomain
	 */
	public void acabarClosePartida() {
		cd.acabarClosePartida();
	}


	/**
	 * @brief Guarda la partida actual que s'està jugant.
	 * <p> Crida la funció guardarPartida de CtrlDomain
	 */
	public void guardarPartida() {
		cd.guardarPartida();
	}


	/**
	 * @brief Assigna una sequencia a la sequencia a resoldre a la partida actual del sistema
	 * <p> Crida la funció asignaCodiCodeMaker de CtrlDomain
	 *
	 * @param codi representa la seqüència a resoldre pel codeBreaker
	 */
	public void asignaCodiCodeMaker(List<Integer> codi) {
		cd.asignaCodiCodeMaker(codi);
	}


	/** @brief Aquesta funció fa actualitzar el ranking per tal d'actualitzar-lo al final de cada partida. També quan es crea un nou usuari
	 * <p> Crida la funció actualitzaRanking de CtrlDomain
	 */
	public void actualitzaRanking() {
		cd.actualitzaRanking();
	}


	/** @brief Mostra un color de la sequencia a resoldre que no té la seqüència introduida pel CodeBreaker.
	 * <p> També suma en un el nombre d'ajudes efectuades per l'usuari
	 *
	 * @return Un Integer que representa un color de la seqüència a resoldre que no esta present a la sequencia introduida pel CodeBreaker. En el cas que hi siguin tots els colors a la sequencia retorna -1
	 */
	public Integer ajutUsuari() {
		Integer aux = cd.mostraColorExistent();
		if (aux != -1) {
			cd.partidaActual.sumaNumAjudes();
			cd.usuariActual.getStats().setAjudes();
		}
		return aux;
	}


	/** @brief Obté la seqüència a resoldre
	 * @return una llista d'enters que representa la seqüència a resoldre a la partida
	 */
	public List<Integer> getCodiResoldre() {
		return cd.partidaActual.getTauler().getCodiResoldre();
	}


	/** @brief Funció que compara la seqüència introduïda amb la seqüència a resoldre
	 * <p> Crida la funció checkCode de CtrlDomain
	 *
	 * @return la situació actual de la seqüència introduïda (feedback)
	 */
	public String checkCode() {
		return cd.checkCode();
	}


	/** @brief Funció que obté una llista amb el feedback de totes les seqüències de la partida jugada per l'algorisme
	 * <p> Crida la funció getPegsMaq de CtrlDomain
	 *
	 * @return una llista de String que representa el feedback obtingut
	 */
	public List<String> getPegsMaq() {
		return cd.getPegsMaq();
	}


	/** @brief Funció que obté totes les seqüències que fa l'algorisme fins a arribar al codi a resoldre de la partida
	 * <p> Crida la funció SequenciaMaq de CtrlDomain
	 *
	 * @return una llista de seqüències d'enters que representen el board
	 */
	public List<List<Integer>> getSeqSolve() {
		return cd.SequenciaMaq();
	}


	/** @brief Funció que obté una llista amb el feedback de totes les seqüències de la partida jugada per l'usuari
	 * <p> Crida la funció getPegsPartida de CtrlDomain
	 *
	 * @return una llista de String que representa el feedback obtingut
	 */
	public List<String> getPegsPartida() {
		return cd.getPegsPartida();
	}


	/** @brief Funció que obte el board de la partida
	 * <p> Crida la funció getBoardPartida de CtrlDomain
	 *
	 * @return Una llista de llistes d'enters que representen el board actual amb les seqüències que va proposant l'usuari
	 */
	public List<List<Integer>> getCodsPartida() {
		return cd.getBoardPartida();
	}


	/** @brief Getter de les seqüències obtingudes per l'algorisme fins a arribar a la seqüència a resoldre guardades a DATA en cas de Load Game
	 * <p> Crida la funció getCodsMaq de CtrlDomain
	 *
	 * @return llista de seqüències obtingudes per l'algorisme
	 */
	public List<List<Integer>> getCodsPartidaMaq() {
		return cd.getCodsMaq();
	}


	/** @brief Getter del feedback del procés d'endevinar la seqüència per part de l'algorisme guardat a DATA en cas de Load Game
	 * <p> Crida la funció getPegsPartidaMaq de CtrlDomain
	 *
	 * @return feedback del procés d'endevinar la seqüència
	 */
	public List<String> getPegsPartidaMaq() {
		return cd.getPegsPartidaMaq();
	}

}