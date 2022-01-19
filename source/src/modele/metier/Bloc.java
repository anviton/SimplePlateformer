package modele.metier;

public class Bloc extends Composant {

    private final int type;

    public Bloc(int type, int positionX, int positionY, HitBox hitBox) {
        super(positionX, positionY, hitBox);
        this.type = type;
    }

    public int getType() {
        return type;
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
