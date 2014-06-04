package poker_tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Paquet {
	
	private List<Carte> deck;
	private String nom;
	private int valeurFigure;
	
	public Paquet() {
		
		deck = new LinkedList<Carte>();
		nom = "Inconnu";		
	}
	
	public Paquet(String nom) {
		
		deck = new LinkedList<Carte>();
		this.nom = nom;
		
	}
	
	public void init52(){
		
			int valeur, couleur,i = 0;
			
			if (deck.size() != 0) deck.removeAll(deck);
			
			for (valeur = 1; valeur<=13; valeur++){
				for (couleur=1; couleur<=4; couleur++){
					
					Random r = new Random();
					if (deck.size() != 0) i = r.nextInt(this.deck.size());
					
					this.ajoute(new Carte(valeur,couleur),i);
				}
			}
			this.nom = "Paquet";
			
		
		
	}
	
	public void efface(){
		this.deck.clear();
	}
	
	public void donne (Paquet Cible){
		//Paquet pseudo mélangé, on prend quand même une carte au hasard du paquet

		Cible.deck.add(this.deck.remove(0));
	}
	public void donne (Paquet Cible, short i){
		for (short n=1; n<=i;n++)	Cible.deck.add(this.deck.remove(deck.size()/2));
	}
	
	public void ajoute (Carte carte){
		deck.add(carte);
	}
	
	public void ajoute (Carte carte, int i){
		deck.add(i, carte);
	}
	
	public void vidage (){
		deck.removeAll(deck);
		
	}

	public List<Carte> getDeck() {
		return deck;
	}

	public String getNom() {
		return nom;
	}
	
	public int getValeurFigure(){
		this.setValeurFigure();
		return valeurFigure;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	private void setValeurFigure(){
		boolean rien = false,
				paire= false,
				deuxPaires= false,
				brelan= false,
				suite= false,
				couleur= false,
				foule= false,
				carre= false,
				quinteFlush = false,
				quinteFlushRoyale = false;
		int[] tC, tV;
		
		valeurFigure = -1; //Par defaut au cas où taille du deck différente de 5
		
		if (deck.size() == 5){
			tV = tabValeur();
			tC = tabCouleur();

			
			boolean[] ecartNul = new boolean[4];
			boolean[] ecartUn = new boolean[4];
			
			//écarts entre 2 cartes adjacentes
			for (int i=0; i<=3;i++){
				ecartNul[i]=false;
				ecartUn[i]=false;
				if (tV[i] == tV[i+1]) ecartNul[i]=true;
				if (tV[i] - tV[i+1] == 1) ecartUn[i]=true;
			}
			
			//------------
			paire	= ecartNul[0] & !ecartNul[1] & !ecartNul[2] & !ecartNul[3] |
					 !ecartNul[0] &  ecartNul[1] & !ecartNul[2] & !ecartNul[3] |
					 !ecartNul[0] & !ecartNul[1] &  ecartNul[2] & !ecartNul[3] |
					 !ecartNul[0] & !ecartNul[1] & !ecartNul[2] &  ecartNul[3];
			deuxPaires
					= ecartNul[0] & !ecartNul[1] &  ecartNul[2] & !ecartNul[3] |
					  ecartNul[0] & !ecartNul[1] & !ecartNul[2] &  ecartNul[3] |
					 !ecartNul[0] &  ecartNul[1] & !ecartNul[2] &  ecartNul[3];
					
			
			brelan	= ecartNul[0] &  ecartNul[1] & !ecartNul[2] & !ecartNul[3] |
					 !ecartNul[0] &  ecartNul[1] &  ecartNul[2] & !ecartNul[3] |
					 !ecartNul[0] & !ecartNul[1] &  ecartNul[2] &  ecartNul[3];
			
			carre	= ecartNul[0] &  ecartNul[1] &  ecartNul[2] & !ecartNul[3] |
					 !ecartNul[0] &  ecartNul[1] &  ecartNul[2] &  ecartNul[3];

			foule	= ecartNul[0] & !ecartNul[1] &  ecartNul[2] &  ecartNul[3] |
					  ecartNul[0] &  ecartNul[1] &  !ecartNul[2] &  ecartNul[3];
			
			suite	= ecartUn[0] & ecartUn[1] & ecartUn[2] & ecartUn[3];
			
			
			//couleur?
			if (tC[0] == tC[4]) couleur = true;
			
			quinteFlush = suite & couleur;
			
			quinteFlushRoyale = suite & couleur & (tV[0]==14);
			
			rien 	=!ecartNul[0] & !ecartNul[1] & !ecartNul[2] & !ecartNul[3];
			
		}
		
		
		if (rien) valeurFigure = 0;
		if (paire) valeurFigure = 1;
		if (deuxPaires) valeurFigure = 2;
		if (brelan) valeurFigure = 3;
		if (suite) valeurFigure = 4;
		if (couleur) valeurFigure = 5;
		if (foule) valeurFigure = 6;
		if (carre) valeurFigure = 7;
		if (quinteFlush) valeurFigure = 8;
		if (quinteFlushRoyale) valeurFigure = 9;
	}
	private int[] tabValeur(){ //valeurs de deck triées...
		int[] t = new int[5];
		int i;
		
		//incription des valeurs dans le tableau
		for (i=0; i<=4; i++) t[i] = this.deck.get(i).getValeur();

				
		//tri du tableau par ordre décroissant.
		t = tri(t);
		
		//si RXXXA l'As prend 13 de valeur
		if ((t[0]==13) && (t[4]==1)){
			for (i=0;i<=4;i++){
				if (t[i]==1) t[i]=14;
			}
			//on retrie...
			t = tri(t);
		}
		return t;
	}
	
	private int[] tabCouleur(){//triées
		int[] t = new int[5];
		//incription des couleurs dans le tableau
		for (int i=0; i<=4; i++) t[i] = deck.get(i).getCouleur();
		//tri couleurs...
		t = tri(t);
		return t;
	}
	
	private int[] tri(int[] t){
		int i,j,temp;
		for (i=0; i<4;i++){
			for (j=4;j>=i+1;j--){
				if (t[i]< t[j]){
					temp=t[i];
					t[i]=t[j];
					t[j]=temp;
				}
				
			}
		}
		return t;
	}


}
