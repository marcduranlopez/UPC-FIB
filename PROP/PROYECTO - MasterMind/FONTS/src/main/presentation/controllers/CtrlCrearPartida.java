package main.presentation.controllers;

import main.domain.controllers.CtrlDomain;
import main.domain.classes.Exceptions.*;

public class CtrlCrearPartida {

	/**
	 * Instància de CtrlDomain
	 */
	private final CtrlDomain cd;


	/** @brief Creadora per defecte. Obté una instància CtrlDomain
	 */
	public CtrlCrearPartida() {
		cd = CtrlDomain.getInstance();
	}

	/** @brief Creadora amb valors
	 *
	 * @param cd representa una instància de CtrlDomain
	 */
	public CtrlCrearPartida(CtrlDomain cd) {
		this.cd = cd;
	}


	/** @brief Getter del CtrlDomain
	 *
	 * @return instància de CtrlDomain
	 */
	public CtrlDomain getCD() {
		
		return cd;
	}


	/** @brief Funció que permet crear una nova partida. Crida la funció crearPartida de CtrlDomain
	 *
	 * @param Dificultat representa la dificultat asignada a la partida (determina el numero de bolas a jugar)
	 * @param Rol representa el rol assignat a la partida
	 * @param Algorithm representa l'algorisme triat per a la partida
	 * @throws DificultatNoExisteix en el cas que la dificultat no sigui cap de les donades
	 */
	public void crearNovaPartida(Integer Dificultat, String Rol, Integer Algorithm) throws DificultatNoExisteix {
		
		cd.creaNovaPartida(Dificultat, Rol, Algorithm);
	}


	/**
	 * @brief Funció que imprimeix la informació de la partida creada
	 */
	public void mostraInfo() {
		System.out.println(cd.getPartidaActual().getRol());
		System.out.println(cd.getPartidaActual().getDificultat());
		System.out.println(cd.getPartidaActual().getAlgorisme());
		System.out.println(cd.getPartidaActual().getTauler().getCodiResoldre());
	}
}