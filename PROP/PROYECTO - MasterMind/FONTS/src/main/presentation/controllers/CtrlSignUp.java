package main.presentation.controllers;

import main.domain.controllers.CtrlDomain;
import main.domain.classes.Exceptions.*;

public class CtrlSignUp {

	/**
	 * Instància de CtrlDomain
	 */
	private final CtrlDomain cd;


	/** @brief Creadora per defecte. Obté una instància CtrlDomain
	 */
	public CtrlSignUp() {
		cd = CtrlDomain.getInstance();
	}


	/** @brief Creadora amb valors
	 *
	 * @param cd  representa una instància de CtrlDomain
	 */
	public CtrlSignUp(CtrlDomain cd) {
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


	/**@brief Funció que permet a l'usuari registrarse. Crida la funció registrarUsuari de CtrlDomain
	 * @param username representa el nom d'usuari
	 * @param pswd  representa la contraseña del usuari
	 * @throws UsuariJaExisteix en cas que ja existeixi un usuari amb el mateix nom usuari
	 * @throws ContrasenyaIncorrecte en cas que la contraseña no sigui correcte
	 */
	public void signUp(String username, String pswd) throws UsuariJaExisteix, ContrasenyaIncorrecte{
		
		cd.registrarUsuari(username, pswd);
	}


	/** @brief Getter del CtrlDomain
	 *
	 * @return instància de CtrlDomain
	 */
	public CtrlDomain getCD() {
		return cd;
	}
}
