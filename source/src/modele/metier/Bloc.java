package modele.metier;

public class Bloc extends Composant {

    private int type;


    /*public Bloc(int type, int positionX, int positionY) {
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;
        this.hitBox = new HitBox(300, 300);
    }*/

    public Bloc(int type, int positionX, int positionY, HitBox hitBox) {
        super(positionX, positionY, hitBox);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Bloc{" +
                "type=" + type +
                ", positionY=" + this.getPositionY() +
                ", positionX=" + this.getPositionX() +
                ", hitBox=" + this.getHitBox() +
                '}';
    }
}
