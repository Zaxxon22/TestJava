// /!\ Fichier en UTF-8 pour l'affichage correct des symboles

package poker_tests;

public class Principale {

	public static void main(String[] args) {

		//Temporaire.tmp();
		Paquet paquet = new Paquet();
		Paquet mainjoueur = new Paquet();
		
		paquet.init52();
		
		Affichage.affichePaquet(paquet);
		Affichage.affichePaquet(mainjoueur);
	}

}
