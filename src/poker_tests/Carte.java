// /!\ Fichier en UTF-8 pour le traitement correct des symboles

package poker_tests;

public class Carte {
	
	private int valeur, couleur; // 0 pour non défini. Symboles valeur/couleur "??","E"
	private String symboleValeur;
	private String symboleCouleur;
	private String nomCourt;
	/* si besoin...
	public static String
			INDEFINI = "??",
			AS = "A",
			DEUX = "2",
			TROIS = "3",
			QUATRE = "4",
			CINQ = "5",
			SIX = "6",
			SEPT = "7",
			HUIT = "8",
			NEUF = "9",
			DIX = "10",
			VALET = "V",
			DAME = "D",
			ROI = "R",
			PIQUE = "♠",
			COEUR = "♥",
			CARREAU = "♦",
			TREFLE = "♣";
	*/
	public Carte() {
		valeur = 0;
		couleur = 0;
		this.setSymboleValeur();
		this.setSymboleCouleur();
		this.setNomCourt();
	}
	
	public Carte(int pValeur, int pCouleur) {
		valeur = pValeur;
		couleur = pCouleur;
		this.setSymboleValeur();
		this.setSymboleCouleur();
		this.setNomCourt();
		}


	public int getValeur() {
		return valeur;
	}


	public int getCouleur() {
		return couleur;
	}


	public String getSymboleValeur() {
		return symboleValeur;
	}


	public String getSymboleCouleur() {
		return symboleCouleur;
	}


	public String getNomCourt() {
		setNomCourt();
		return nomCourt;
	}


	public void setValeur(int valeur) {
		this.valeur = valeur;
		this.setSymboleValeur();
	}


	public void setCouleur(int couleur) {
		this.couleur = couleur;
		this.setSymboleCouleur();
	}


	private void setSymboleValeur() {
		String[] liste = {	"??","A","2","3","4","5","6","7","8","9","10","V","D","R"};
		this.symboleValeur = liste[valeur];
	}


	private void setSymboleCouleur() {
		String[] liste = {"??","♠","♥","♦","♣"};
		this.symboleCouleur = liste[couleur];
	}


	private void setNomCourt() {
		setSymboleCouleur();
		setSymboleValeur();
		this.nomCourt = symboleValeur + symboleCouleur;
	}


}
