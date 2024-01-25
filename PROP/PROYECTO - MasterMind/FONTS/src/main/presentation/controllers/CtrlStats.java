package main.presentation.controllers;

import main.domain.controllers.CtrlDomain;

	public class CtrlStats {

		/**
		 * Instància de CtrlDomain
		 */
		private final CtrlDomain cd;


		/** @brief Creadora amb valors
		 *
		 * @param cd  representa una instància de CtrlDomain
		 */
		public CtrlStats(CtrlDomain cd) {
			this.cd = cd;
		}

		/** @brief Getter de les partides iniciades per l'usuari. Crida la funció getPartidesIniciades de CtrlDomain
		 *
		 * @return partides iniciades
		 */
		public Integer getStarted() {
			
			return cd.getPartidesIniciades();
		}


		/** @brief Getter de le partides acabades per l'usuari. Crida la funció getPartidesAcabades de CtrlDomain
		 *
		 * @return partides acabades
		 */
		public Integer getPartidesAcabades() {
				
			return cd.getPartidesAcabades();
		}


		/** @brief Getter de la puntuació quan l'usuari juga com a CodeMaker. Crida la funció getPuntuacioCM de CtrlDomain
		 *
		 * @return puntuació CodeMaker
		 */
		public Integer getPuntsCM() {
			
			return cd.getPuntuacioCM();
		}


		/** @brief Getter de la puntuació quan l'usuari juga com a CodeBreaker. Crida la funció getPuntuacioCB de CtrlDomain
		 *
		 * @return puntuació CodeBreaker
		 */
		public Integer getPuntsCB() {
			
			return cd.getPuntuacioCB();
		}


		/** @brief Getter de les ajudes demanades per l'usuari. Crida la funció getAjuts de CtrlDomain
		 *
		 * @return ajudes demanades
		 */
		public Integer getAjuts() {
			
			return cd.getAjuts();
		}
	}
