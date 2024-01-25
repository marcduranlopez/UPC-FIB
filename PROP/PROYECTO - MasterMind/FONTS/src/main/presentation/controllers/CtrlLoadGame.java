package main.presentation.controllers;

import main.domain.controllers.CtrlDomain;
import main.domain.classes.Partida;

import java.util.*;

public class CtrlLoadGame {

	/**
	 * Instància de CtrlDomain
	 */
	private final CtrlDomain cd;


	/** @brief Creadora amb valors
	 *
	 * @param cd representa una instància de CtrlDomain
	 */
	public CtrlLoadGame(CtrlDomain cd) {
		this.cd = cd;
	}


	/** @brief Getter del CtrlDomain
	 *
	 * @return instància de CtrlDomain
	 */
	public CtrlDomain getCD() {
		
		return cd;
	}


	/**
	 * @brief Funció que permet obtenir la llista de partides guardades d'un usuari registrat
	 * <p>
	 * Crida la funció getPartidesGuardades de CtrlDomain
	 *
	 * @return La llista de partides guardades de l'usuari actual del sistema
	 */
	public List<Partida> getSavedGames() {
		return cd.getPartidesGuardades();
	}
}

