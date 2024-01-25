package main.presentation.controllers;

import main.presentation.classes.VistaLogin;

import main.domain.controllers.CtrlDomain;
import main.domain.classes.Exceptions.*;

import java.io.*;


public class CtrlLogin {

	/**
	 * Instància de CtrlDomain
	 */
	private CtrlDomain cd;


	/** @brief Creadora per defecte. Crea una instància CtrlDomain
	 */
	public CtrlLogin() {
		cd = new CtrlDomain();
	}


	/** @brief Funció que inicialitza la VistaLogin i la fa visible
	 */
	public void run() {
		VistaLogin login = new VistaLogin(this);
		login.setVisible(true);
	}


	/** @brief Getter del CtrlDomain
	 *
	 * @return instància de CtrlDomain
	 */
	public CtrlDomain getCD() {
		
		return cd;
	}

	/** @brief Setter del CtrlDomain
	 *
	 * @param cd instància de CtrlDomain
	 */
	public void setCD(CtrlDomain cd) {
		
		this.cd = cd;
	}


	/** @brief Funció que comprova si existex ell'usuari amb el nom d'usuari passat per paràmetre
	 *
	 * @param UserName representa un nom d'usuari vàlid
	 * @return cert si existeix l'usuari, en cas contrari, retorna fals
	 */
	public Boolean existeixUsuari(String UserName) {
		
		return cd.existeixUsuari(UserName);
	}


	/**
	 * @brief Funció que permet carregar l'usuari (inicia sessio). Crida la funció carregarUsuari de CtrlDomain
	 * @param username representa el nom d'usuari
	 * @param pswd  representa la contraseña del usuari
	 * @throws FileNotFoundException en cas que l'usuari no existeixi
	 * @throws ContrasenyaIncorrecte en cas que la contraseña no sigui correcte
	 */
	public void login(String username, String pswd) throws FileNotFoundException, ContrasenyaIncorrecte{
		
		cd.carregarUsuari(username, pswd);
	}
}















