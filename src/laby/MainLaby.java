package laby;

import moteurJeu.MoteurJeu;

public class MainLaby {
	public static void main(String[] args) throws Exception {

		int width = 800;
		int height = 600;
		int pFPS = 10;

		// creation des objets
//		LabyJeu jeuLaby = new LabyJeu("source/laby0.txt");
		LabyJeu jeuLaby = new LabyJeu("source/V2/labyMonstre.txt");

		LabyDessin dessinLaby = new LabyDessin();

		// parametrage du moteur de jeu
		MoteurJeu.setTaille(width, height);
		MoteurJeu.setFPS(pFPS);

		// lancement du jeu
		MoteurJeu.launch(jeuLaby, dessinLaby);
	}
}
