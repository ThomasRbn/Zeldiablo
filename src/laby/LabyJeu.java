package laby;

import laby.ennemis.Monstre;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.ArrayList;

import static laby.Constantes.CYCLE;

public class LabyJeu implements Jeu {
	private final Labyrinthe labyrinthe;

	public LabyJeu(String cheminFichier) throws IOException {
		this.labyrinthe = new Labyrinthe(cheminFichier);
	}

	//GETTER

	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}

	public int getLengthY() {
		return labyrinthe.getLengthY();
	}

	public int getLength() {
		return labyrinthe.getLength();
	}

	public boolean getMur(int x, int y) {
		return labyrinthe.getMur(x, y);
	}

	public Heros getHeros() {
		return labyrinthe.getHeros();
	}

	public ArrayList<Monstre> getMonstres() {
		return labyrinthe.getMonstres();
	}

	public Amulette getAmulette() {
		return labyrinthe.getAmulette();
	}

	public int[] getSortie(){
		return labyrinthe.getSortie();
	}

	public boolean getSortieOuverte() {
		return labyrinthe.getSortieOuverte();
	}

	@Override
	public void update(double secondes, Clavier clavier) {
		if (labyrinthe.jeuTermine())
			return;

		if (clavier.haut) {
			labyrinthe.deplacerPerso(Labyrinthe.HAUT);
		}

		if (clavier.bas) {
			labyrinthe.deplacerPerso(Labyrinthe.BAS);
		}

		if (clavier.droite) {
			labyrinthe.deplacerPerso(Labyrinthe.DROITE);
		}

		if (clavier.gauche) {
			labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);
		}

		//Ralentissement du monstre
		if (CYCLE % 5 == 0) {
			for (Monstre m : labyrinthe.getMonstres()) {
				labyrinthe.deplacerMonstre(m);
			}
		}
		CYCLE++;

		//Gestion ouverture sortie
		if (labyrinthe.getHeros().etrePresent(labyrinthe.getAmulette().getX(), labyrinthe.getAmulette().getY())) {
			labyrinthe.getHeros().setPossedeAmulette(true);
			labyrinthe.setSortieOuverte(true);
		}

		//Gestion de l'attaque du monstre
		for(Monstre m : labyrinthe.getMonstres()){
			if (m.detecterPresence(labyrinthe.getHeros())){
				m.attaquer(labyrinthe.getHeros());
			}
		}
	}


	@Override
	public void init() {

	}
}
