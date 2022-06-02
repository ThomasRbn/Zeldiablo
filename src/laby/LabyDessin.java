package laby;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import laby.ennemis.Monstre;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import static laby.Constantes.TAILLE;

public class LabyDessin implements DessinJeu {

	@Override
	public void dessinerJeu(Jeu jeu, Canvas canvas) {
		LabyJeu laby = (LabyJeu) jeu;

		final GraphicsContext ghc = canvas.getGraphicsContext2D();
		ghc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		//Génération des murs
		ghc.setFill(Color.BLACK);
		for (int colonne = 0; colonne < laby.getLength(); colonne++) {
			for (int ligne = 0; ligne < laby.getLengthY(); ligne++) {
				if (laby.getMur(colonne, ligne))
					ghc.fillRect(colonne * TAILLE, ligne * TAILLE, TAILLE, TAILLE);
			}
		}

		//Génération Amulette
		ghc.setFill(Color.YELLOW);
		ghc.fillOval(laby.getAmulette().getX() * TAILLE, laby.getAmulette().getY() * TAILLE, TAILLE, TAILLE);

		//Génération Héros
		ghc.setFill(Color.BLUE);
		ghc.fillOval(laby.getHeros().getX() * TAILLE, laby.getHeros().getY() * TAILLE, TAILLE, TAILLE);

		//Génération Monstre
		ghc.setFill(Color.RED);
		for (Monstre m : laby.getMonstres()) {
			ghc.fillOval(m.getX() * TAILLE, m.getY() * TAILLE, TAILLE, TAILLE);
		}

		if (laby.getHeros().getPossedeAmulette()){
			//Disparition de l'amulette
			ghc.clearRect(laby.getAmulette().getX() * TAILLE, laby.getAmulette().getY() * TAILLE, TAILLE, TAILLE);

			//Création héros
			ghc.setFill(Color.BLUE);
			ghc.fillOval(laby.getHeros().getX() * TAILLE, laby.getHeros().getY() * TAILLE, TAILLE, TAILLE);

			//Création petite amulette
			ghc.setFill(Color.YELLOW);
			ghc.fillOval(laby.getHeros().getX() * TAILLE, laby.getHeros().getY() * TAILLE, TAILLE/4., TAILLE/4.);

			//Bordure amulette
			ghc.setFill(Color.BLACK);
			ghc.strokeOval(laby.getHeros().getX() * TAILLE, laby.getHeros().getY() * TAILLE, TAILLE/4., TAILLE/4.);
		}


	}
}
