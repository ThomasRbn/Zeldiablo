package laby;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

	public final static int TAILLE = 35;

	@Override
	public void dessinerJeu(Jeu jeu, Canvas canvas) {
		LabyJeu laby = (LabyJeu) jeu;

		final GraphicsContext ghc = canvas.getGraphicsContext2D();
		ghc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		//Génération des murs
		ghc.setFill(Color.BLACK);
		for(int colonne = 0; colonne < laby.getLength(); colonne++){
			for (int ligne = 0; ligne < laby.getLengthY(); ligne++){
				if (laby.getMur(colonne, ligne))
					ghc.fillRect(colonne* TAILLE, ligne * TAILLE, TAILLE, TAILLE);
			}
		}

		//Génération Héros
		ghc.setFill(Color.BLUE);
		ghc.fillOval(laby.getHeros().getX() * TAILLE, laby.getHeros().getY() * TAILLE, TAILLE, TAILLE);


	}
}
