package poker_tests;

import java.util.LinkedList;
import java.util.List;

public class Figures { //resortir paire, 2paires, brelan etc.

	private String nomFigure;
	private int valeurFigure;
	private Paquet paquetDe5; //main de 5 cartes à déterminer
	private final int RIEN=0,
			PAIRE=1,
			DEUXPAIRES=2,
			BRELAN=3,
			QUINTE=4,
			COULEUR=5,
			FOULE=6,
			CARRE=7,
			QUINTEFLUSH=8;	
	
	public Figures(){
		
		this.nomFigure="Inconnu";
		this.valeurFigure=-1;
		this.paquetDe5 = new Paquet();
	
	}
	
	

	public Figures(Paquet paquetDe5) {
		this.paquetDe5 = paquetDe5;
		this.setValeurFigure(paquetDe5);
		this.setNomFigure(valeurFigure);
	}

	public String getNomFigure() {
		return nomFigure;
	}



	public int getValeurFigure() {
		return valeurFigure;
	}

	// A FAIRE
	
	private void setValeurFigure(Paquet paquetDe5){
		int resultat = RIEN;
		int[][] tabPaquet5 = triPaquet5(paquetDe5,true);
		
		
		this.valeurFigure = resultat;
		
	}
	
	// A FAIRE
	
	private int[][] triPaquet5(Paquet paquetDe5,boolean asFort){
		int[][] t = new int[5][2];
		
		//recherche et changement de la force d'un AS
		
		for (int i = 0;i<=4;i++){
			
		}
		
		
		
		return t;
	}

	private void setNomFigure(int valeur) {
		String nomFigure = new String();
		switch (valeur) {
		case -1:
			nomFigure = "Détermination non effectuée";
			break;
		case RIEN:
			nomFigure = "Carte la plus forte (rien)";
			break;
		case PAIRE:
			nomFigure = "1 paire";
			break;
		case DEUXPAIRES:
			nomFigure = "2 paires";
			break;
		case BRELAN:
			nomFigure = "Brelan";
			break;
		case QUINTE:
			nomFigure = "Quinte";
			break;
		case COULEUR:
			nomFigure = "Couleur";
			break;
		case FOULE:
			nomFigure = "Foule";
			break;
		case CARRE:
			nomFigure = "Carré";
			break;
		case QUINTEFLUSH:
			nomFigure = "QuinteFlush";
			break;
		}
		this.nomFigure = nomFigure;
	}

	public void setPaquetDe5(Paquet paquetDe5) {
		this.paquetDe5 = paquetDe5;
	}
	

	



	





	
}
