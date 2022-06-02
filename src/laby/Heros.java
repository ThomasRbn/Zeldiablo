package laby;

public class Heros extends Entite{

    private boolean possedeAmulette;

    public boolean getPossedeAmulette() {
        return possedeAmulette;
    }

    public void setPossedeAmulette(boolean possedeAmulette) {
        this.possedeAmulette = possedeAmulette;
    }

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Heros(int dx, int dy) {
        super(dx, dy);
        this.possedeAmulette = false;
    }



}
