package laby;

public class Heros extends Entite{

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Heros(int dx, int dy) {
        super(dx, dy);
    }

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
