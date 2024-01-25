package main.presentation.controllers;

import main.domain.controllers.CtrlDomain;


public class CtrlRankings {

	/**
	 * Instància de CtrlDomain
	 */
	private final CtrlDomain cd;


	/** @brief Creadora amb valors
	 *
	 * @param cd  representa una instància de CtrlDomain
	 */
	public CtrlRankings(CtrlDomain cd) {
		this.cd = cd;
	}


	/**@brief Funcio que obte el ranking segons el rol. Crida la funció consultarRanking de CtrlDomain
	 *
	 * @param rol representa el ranking que es vol mostrar, ranking CodeMaker o CodeBreaker
	 * @return Una matriu amb el núm. de ranking, nom d'usuari i puntuacio. És ordenada per puntuació.
	 */
	public String[][] getRanking(String rol) {
		return cd.consultarRanking(rol);
	}
}
