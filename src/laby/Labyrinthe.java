package laby;

import laby.ennemis.Monstre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
	public static final char MONSTRE = 'M';
	public static final char AMULETTE = 'A';

	/**
	 * constantes actions possibles
	 */
	public static final String HAUT = "Haut";
	public static final String BAS = "Bas";
	public static final String GAUCHE = "Gauche";
	public static final String DROITE = "Droite";

	public static final String[] DEPLACEMENT = new String[]{HAUT, BAS, GAUCHE, DROITE};

	public Heros heros;
	public boolean[][] murs;
	public ArrayList<Monstre> monstres;
	public Amulette joyau;


	// GETTER

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
		this.monstres = new ArrayList<>();

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

					case MONSTRE:
						this.murs[colonne][numeroLigne] = false;
						this.monstres.add(new Monstre(colonne, numeroLigne));
						break;

					case AMULETTE:
						this.murs[colonne][numeroLigne] = false;
						this.joyau = new Amulette(colonne, numeroLigne);
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
		return this.murs[x][y];
	}

	//CONSTRUCTEUR

	public ArrayList<Monstre> getMonstres() {
		return monstres;
	}

	//MÉTHODES

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

		boolean collision = false;
		for (Monstre m : monstres) {
			if (m.etrePresent(suivante[0], suivante[1])) {
				collision = true;
				break;
			}

		}

		// si c'est pas un mur, on effectue le deplacement
		if (!this.murs[suivante[0]][suivante[1]] && !collision) {
			this.heros.setX(suivante[0]);
			this.heros.setY(suivante[1]);
		}
	}

	/**
	 * Méthode qui déplace le monstre e dans une direction aléatoire
	 *
	 * @param e monstre à déplacer
	 */
	public void deplacerMonstre(Monstre e) {
		Random random = new Random();
		String direction = Labyrinthe.DEPLACEMENT[random.nextInt(4)];

		int[] suivante = Labyrinthe.getSuivant(e.getX(), e.getY(), direction);

		if (!this.murs[suivante[0]][suivante[1]] && !heros.etrePresent(suivante[0], suivante[1])) {
			e.setX(suivante[0]);
			e.setY(suivante[1]);
		}
	}

	public void deplacerMonstre(Monstre e, String direction) {

		int[] suivante = Labyrinthe.getSuivant(e.getX(), e.getY(), direction);

		if (!this.murs[suivante[0]][suivante[1]] && !heros.etrePresent(suivante[0], suivante[1])) {
			e.setX(suivante[0]);
			e.setY(suivante[1]);
		}
	}
}
