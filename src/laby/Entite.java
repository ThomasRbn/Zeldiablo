package laby;

public class Entite {

	private int x;

	private  int y;


	//GETTER

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

	//CONSTRUCTEUR
	public Entite(int x, int y) {
		this.x = x;
		this.y = y;
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



}
