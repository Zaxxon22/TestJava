package poker_tests;

public abstract class Affichage {

	public static void affichePaquet(Paquet p){
		String trait = "-----------------------------";
		System.out.println(p.getNom() + (": ") + p.getDeck().size() + " carte(s)");
		System.out.println(trait);
		System.out.println();
		for (int i = 0; i<p.getDeck().size(); i++){
			System.out.print(p.getDeck().get(i).getNomCourt() + " ");
			if ((i+1) % 13 == 0) System.out.println(); 
		}
		System.out.println(trait + "\n");
	}

}
