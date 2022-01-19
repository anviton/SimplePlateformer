package modele.metier;

public abstract class Composant {
    private int positionY;
    private int positionX;
    private final HitBox hitBox;

    public Composant(int positionX, int positionY, HitBox hitBox) {
        this.positionY = positionY;
        this.positionX = positionX;
        this.hitBox = hitBox;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

}
