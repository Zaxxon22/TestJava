package poker_tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Temporaire {
	public static void tmp() {

		List<Carte> paquet = new LinkedList<Carte>();
		List<Carte> paquet2 = new LinkedList<Carte>();
		
		int i,v,c;
		//paquet 52 cartes
		for (c=1;((c>=1) && (c<=4));c++){
			for (v=1;((v>=1) && (v<=13));v++){
				Carte carte = new Carte(v,c);
				paquet.add(carte);
			}
		}
		System.out.println("Taille de paquet: " + paquet.size());
		for (i=0;i<paquet.size();i++){
			System.out.print(paquet.get(i).getNomCourt() + " ");
		}
		System.out.println();

		Random r = new Random();
		Carte cartetmp=new Carte();
		int n;
		for (i=1;i<=5;i++){
			System.out.println("Pioche une carte au pif...");
			n = r.nextInt(paquet.size());
			System.out.println(n);
			cartetmp = paquet.remove(n);
			paquet2.add(cartetmp);
	
		}

		for (i=0;i<paquet.size();i++){
			System.out.print(paquet.get(i).getNomCourt() + " ");
		}
		System.out.println();

		for (i=0;i<paquet2.size();i++){
			System.out.print(paquet2.get(i).getNomCourt() + " ");
		}
		System.out.println();
		System.out.print("Paquet2 --> "+paquet2.size());
		if (paquet2.size()==0) {System.out.print(" c'est vide!");}
		System.out.println();
		
	}

}
