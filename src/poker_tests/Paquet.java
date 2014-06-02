package poker_tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Paquet {//
	
	private List<Carte> deck;
	private int position;
	private String nom;

	public Paquet() {
		
		deck = new LinkedList<Carte>();
		position = 0;
		nom = "Inconnu";
		
	}
	
	public void init52(){
		if (this.deck.size() == 0){
			
			int valeur, couleur,i = 0;
			
			for (valeur = 1; valeur<=13; valeur++){
				for (couleur=1; couleur<=4; couleur++){
					
					Random r = new Random();
					if (deck.size() != 0) i = r.nextInt(this.deck.size());
					
					this.ajoute(new Carte(valeur,couleur),i);
				}
			}
			this.nom = "Paquet 52 cartes";
			
		}
		else System.out.println("Init52: Erreur, paquet non vide!");
		
	}
	
	public void ajoute (Carte carte){
		deck.add(carte);
	}
	
	public void ajoute (Carte carte, int i){
		deck.add(i, carte);
	}
	
	public void enleve (){
		
	}

	public List<Carte> getDeck() {
		return deck;
	}

	public String getNom() {
		return nom;
	}
	
	


}
