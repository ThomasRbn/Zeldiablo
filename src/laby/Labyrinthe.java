package laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

	/**
	 * Constantes char
	 */
	public static final char MUR = 'X';
	public static final char HEROS = 'H';
	public static final char VIDE = '.';

	/**
	 * constantes actions possibles
	 */
	public static final String HAUT = "Haut";
	public static final String BAS = "Bas";
	public static final String GAUCHE = "Gauche";
	public static final String DROITE = "Droite";

	/**
	 * attribut du personnage
	 */
	public Heros heros;

	/**
	 * les murs du labyrinthe
	 */
	public boolean[][] murs;

	// ##################################
	// GETTER
	// ##################################

	/**
	 * charge le labyrinthe
	 *
	 * @param nom nom du fichier de labyrinthe
	 * @throws IOException probleme a la lecture / ouverture
	 */
	public Labyrinthe(String nom) throws IOException {
		// ouvrir fichier
		FileReader fichier = new FileReader(nom);
		BufferedReader bfRead = new BufferedReader(fichier);

		int nbLignes, nbColonnes;
		// lecture nblignes
		nbLignes = Integer.parseInt(bfRead.readLine());
		// lecture nbcolonnes
		nbColonnes = Integer.parseInt(bfRead.readLine());

		// creation labyrinthe vide
		this.murs = new boolean[nbColonnes][nbLignes];
		this.heros = null;

		// lecture des cases
		String ligne = bfRead.readLine();

		// stocke les indices courants
		int numeroLigne = 0;

		// parcours le fichier
		while (ligne != null) {

			// parcours de la ligne
			for (int colonne = 0; colonne < ligne.length(); colonne++) {
				char c = ligne.charAt(colonne);
				switch (c) {
					case MUR:
						this.murs[colonne][numeroLigne] = true;
						break;
					case VIDE:
						this.murs[colonne][numeroLigne] = false;
						break;
					case HEROS:
						this.murs[colonne][numeroLigne] = false;
						this.heros = new Heros(colonne, numeroLigne);
						break;

					default:
						throw new Error("caractere inconnu " + c);
				}
			}

			// lecture
			ligne = bfRead.readLine();
			numeroLigne++;
		}

		// ferme fichier
		bfRead.close();
	}

	/**
	 * retourne la case suivante selon une actions
	 *
	 * @param x      case depart
	 * @param y      case depart
	 * @param action action effectuee
	 * @return case suivante
	 */
	public static int[] getSuivant(int x, int y, String action) {
		switch (action) {
			case HAUT:
				y--;
				break;
			case BAS:
				y++;
				break;
			case DROITE:
				x++;
				break;
			case GAUCHE:
				x--;
				break;
			default:
				throw new Error("action inconnue");
		}
		return new int[]{x, y};
	}

	/**
	 * return taille selon Y
	 *
	 * @return nombre de lignes
	 */
	public int getLengthY() {
		return murs[0].length;
	}

	/**
	 * return taille selon X
	 *
	 * @return nombre de colonnes
	 */
	public int getLength() {
		return murs.length;
	}

	/**
	 * return mur en (i,j)
	 *
	 * @param x colonne
	 * @param y ligne
	 * @return vrai si c'est un mur, faux sinon
	 */
	public boolean getMur(int x, int y) {
		// utilise le tableau de boolean
		return this.murs[x][y];
	}

	public Heros getHeros() {
		return heros;
	}

	/**
	 * deplace le personnage en fonction de l'action.
	 * gere la collision avec les murs
	 *
	 * @param action une des actions possibles
	 */
	public void deplacerPerso(String action) {
		// case courante
		int[] courante = {this.heros.getX(), this.heros.getY()};

		// calcule case suivante
		int[] suivante = getSuivant(courante[0], courante[1], action);

		// si c'est pas un mur, on effectue le deplacement
		if (!this.murs[suivante[0]][suivante[1]]) {
			// on met a jour personnage
			this.heros.setX(suivante[0]);
			this.heros.setY(suivante[1]);
		}
	}
}
