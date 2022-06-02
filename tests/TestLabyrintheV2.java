import laby.LabyJeu;
import laby.Labyrinthe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLabyrintheV2 {

	@Test
	public void test01_generationMonstre() throws Exception {

		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstre.txt");

		//Vérification génération du monstre
		assertEquals(14, laby.getMonstres().get(0).getX());
		assertEquals(9, laby.getMonstres().get(0).getY());
	}

	@Test
	public void test02_deplacementMonstre_HAUT() throws Exception {
		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstreLibre.txt");

		laby.getLabyrinthe().deplacerMonstre(laby.getMonstres().get(0), Labyrinthe.HAUT);

		//Vérification génération du monstre
		assertEquals(14, laby.getMonstres().get(0).getX());
		assertEquals(8, laby.getMonstres().get(0).getY());
	}

	@Test
	public void test03_deplacementMonstre_DROITE() throws Exception {
		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstreLibre.txt");

		laby.getLabyrinthe().deplacerMonstre(laby.getMonstres().get(0), Labyrinthe.DROITE);

		//Vérification génération du monstre
		assertEquals(15, laby.getMonstres().get(0).getX());
		assertEquals(9, laby.getMonstres().get(0).getY());
	}

	@Test
	public void test04_deplacementMonstre_BAS() throws Exception {
		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstreLibre.txt");

		laby.getLabyrinthe().deplacerMonstre(laby.getMonstres().get(0), Labyrinthe.BAS);

		//Vérification génération du monstre
		assertEquals(14, laby.getMonstres().get(0).getX());
		assertEquals(10, laby.getMonstres().get(0).getY());
	}

	@Test
	public void test05_deplacementMonstre_GAUCHE() throws Exception {
		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstreLibre.txt");

		laby.getLabyrinthe().deplacerMonstre(laby.getMonstres().get(0), Labyrinthe.GAUCHE);

		//Vérification génération du monstre
		assertEquals(13, laby.getMonstres().get(0).getX());
		assertEquals(9, laby.getMonstres().get(0).getY());
	}

	@Test
	public void test06_collisionMonstre_HAUT() throws Exception {
		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstreCollision.txt");

		laby.getLabyrinthe().deplacerMonstre(laby.getMonstres().get(0), Labyrinthe.HAUT);

		//Vérification génération du monstre
		assertEquals(14, laby.getMonstres().get(0).getX());
		assertEquals(9, laby.getMonstres().get(0).getY());
	}

	@Test
	public void test07_collisionMonstre_DROITE() throws Exception {
		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstreCollision.txt");

		laby.getLabyrinthe().deplacerMonstre(laby.getMonstres().get(0), Labyrinthe.DROITE);

		//Vérification génération du monstre
		assertEquals(14, laby.getMonstres().get(0).getX());
		assertEquals(9, laby.getMonstres().get(0).getY());
	}

	@Test
	public void test08_collisionMonstre_BAS() throws Exception {
		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstreCollision.txt");

		laby.getLabyrinthe().deplacerMonstre(laby.getMonstres().get(0), Labyrinthe.BAS);

		//Vérification génération du monstre
		assertEquals(14, laby.getMonstres().get(0).getX());
		assertEquals(9, laby.getMonstres().get(0).getY());
	}

	@Test
	public void test09_collisionMonstre_GAUCHE() throws Exception {
		LabyJeu laby = new LabyJeu("source/V2/testLabyMonstreCollision.txt");

		laby.getLabyrinthe().deplacerMonstre(laby.getMonstres().get(0), Labyrinthe.GAUCHE);

		//Vérification génération du monstre
		assertEquals(14, laby.getMonstres().get(0).getX());
		assertEquals(9, laby.getMonstres().get(0).getY());
	}



}
