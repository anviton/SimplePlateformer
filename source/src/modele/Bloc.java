package modele;

public class Bloc {

    private int type;
    private int positionY;
    private int positionX;
    private HitBox hitBox;


    public Bloc(int type, int positionX, int positionY) {
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;
        this.hitBox = new HitBox(10, 10);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPositionY() {
        return positionY;
    }

    private void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    private void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    private void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }


    @Override
    public String toString() {
        return "Bloc{" +
                "type=" + type +
                ", positionY=" + positionY +
                ", positionX=" + positionX +
                ", hitBox=" + hitBox +
                '}';
    }
}
