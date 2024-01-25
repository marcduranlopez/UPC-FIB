package main.presentation.controllers;

import main.domain.controllers.CtrlDomain;

public class CtrlMainMenu {

	/**
	 * Instància de CtrlDomain
	 */
	private final CtrlDomain cd;


	/** @brief Creadora amb valors
	 *
	 * @param cd  representa una instància de CtrlDomain
	 */
	public CtrlMainMenu(CtrlDomain cd) {
		this.cd = cd;
	}


	/** @brief Getter del CtrlDomain
	 *
	 * @return instància de CtrlDomain
	 */
	public CtrlDomain getCD() {
		return cd;
	}
}
