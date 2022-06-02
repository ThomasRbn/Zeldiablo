import laby.LabyJeu;
import laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLabyrintheV1 {

	//Test de la génération du labyrinthe
	@Test
	public void test01_generationlabyrinthe() throws Exception {
		LabyJeu laby = new LabyJeu("source/laby0.txt");

		//Verification de la taille du labyrinthe
		assertEquals(7, laby.getLength());
		assertEquals(5, laby.getLengthY());
	}

	//Test de la génération du héros
	@Test
	public void test02_generationHeros() throws Exception {

		LabyJeu laby = new LabyJeu("source/laby0.txt");

		//Vérification de la position du héros généré
		assertEquals(3, laby.getHeros().getX());
		assertEquals(2, laby.getHeros().getY());

	}

	//Test du déplacement du personnage vers le haut
	@Test
	public void test03_deplacerPerso_HAUT() throws Exception{

		LabyJeu laby = new LabyJeu("source/laby0.txt");

		laby.getLabyrinthe().deplacerPerso(Labyrinthe.HAUT);

		//Vérification de la position du héros déplacé
		assertEquals(3, laby.getHeros().getX());
		assertEquals(1, laby.getHeros().getY());

	}

	//Test du déplacement du personnage vers la droite
	@Test
	public void test04_deplacerPerso_DROITE() throws Exception{

		LabyJeu laby = new LabyJeu("source/laby0.txt");

		laby.getLabyrinthe().deplacerPerso(Labyrinthe.DROITE);

		//Vérification de la position du héros déplacé
		assertEquals(4, laby.getHeros().getX());
		assertEquals(2, laby.getHeros().getY());

	}

	//Test du déplacement du personnage vers le bas
	@Test
	public void test05_deplacerPerso_BAS() throws Exception{

		LabyJeu laby = new LabyJeu("source/laby0.txt");

		laby.getLabyrinthe().deplacerPerso(Labyrinthe.BAS);

		//Vérification de la position du héros déplacé
		assertEquals(3, laby.getHeros().getX());
		assertEquals(3, laby.getHeros().getY());

	}

	//Test du déplacement du personnage vers la gauche
	@Test
	public void test06_deplacerPerso_Gauche() throws Exception{

		LabyJeu laby = new LabyJeu("source/laby0.txt");

		laby.getLabyrinthe().deplacerPerso(Labyrinthe.GAUCHE);

		//Vérification de la position du héros déplacé
		assertEquals(2, laby.getHeros().getX());
		assertEquals(2, laby.getHeros().getY());

	}

}