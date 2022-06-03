import laby.LabyJeu;
import laby.Labyrinthe;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class TestLabyrintheV3 {

	@Test
	public void test01_generationAmulette() throws Exception {

		LabyJeu laby = new LabyJeu("source/V3/testLabyAmulette.txt");

		assertEquals(4, laby.getAmulette().getX());
		assertEquals(2, laby.getAmulette().getY());
	}

	@Test
	public void test02_porteAmuletteDepart() throws Exception {
		LabyJeu laby = new LabyJeu("source/V3/testLabyAmulette.txt");

		assertFalse(laby.getHeros().getPossedeAmulette());
	}

	@Test
	public void test03_sortieDepart() throws Exception {
		LabyJeu laby = new LabyJeu("source/V3/testLabyAmulette.txt");

		assertFalse(laby.getSortieOuverte());
	}

	@Test
	public void test04_porteAmulette() throws Exception {
		LabyJeu laby = new LabyJeu("source/V3/testLabyAmulette.txt");

		laby.getLabyrinthe().deplacerPerso(Labyrinthe.HAUT);
		laby.update(0, new Clavier());

		assertTrue(laby.getSortieOuverte());
		assertTrue(laby.getHeros().getPossedeAmulette());
	}
}
