package laby;

import java.util.ArrayList;

public class Entite {

	private int x;

	private int y;

	private int pv;


	//GETTER

	//CONSTRUCTEUR
	public Entite(int x, int y, int p) {
		this.x = x;
		this.y = y;
		this.pv = p;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}


	//MÉTHODES

	/**
	 * permet de savoir si le personnage est en x,y
	 *
	 * @param dx position testee
	 * @param dy position testee
	 * @return true si le personnage est bien en (dx,dy)
	 */
	public boolean etrePresent(int dx, int dy) {
		return (this.getX() == dx && this.getY() == dy);
	}

	public void attaquer(Entite e) {
		e.setPv(pv - 1);
	}

	public boolean detecterPresence(Entite e){
		ArrayList<String> portee = new ArrayList<>();
		String positionAutre = e.getX() + "-" + e.getY();

		for (int i = this.getX() - 1; i <= this.getX() + 1; i++){
			for (int j = this.getY() - 1; j <= this.getY() + 1; j++){
				String chemin = i + "-" + j;
				portee.add(chemin);
			}
		}

		return portee.contains(positionAutre);
	}


}
