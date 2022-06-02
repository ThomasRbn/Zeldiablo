package laby;

import moteurJeu.MoteurJeu;

import static laby.Constantes.TAILLE;

public class MainLaby {
	public static void main(String[] args) throws Exception {


		// creation des objets
//		LabyJeu jeuLaby = new LabyJeu("source/laby0.txt");
		LabyJeu jeuLaby = new LabyJeu("source/V3/labyAmulette.txt");
		LabyDessin dessinLaby = new LabyDessin();

		int width = jeuLaby.getLength() * TAILLE;
		int height = jeuLaby.getLengthY() * TAILLE + 15;
		int pFPS = 5;

		// parametrage du moteur de jeu
		MoteurJeu.setTaille(width, height);
		MoteurJeu.setFPS(pFPS);

		// lancement du jeu
		MoteurJeu.launch(jeuLaby, dessinLaby);
	}
}
