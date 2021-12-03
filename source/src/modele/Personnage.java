package modele;

public class Personnage extends Affichable{
    private String nom;
    private int postionX;
    private int positionY;


    public Personnage(String nom, int postionX, int positionY, String image, HitBox collision) {
        super(image, collision);
        this.nom=nom;
        this.postionX = postionX;
        this.positionY = positionY;
    }

    public int getPostionX() {
        return postionX;
    }

    private void setPostionX(int postionX) {
        this.postionX = postionX;
    }

    public int getPositionY() {
        return positionY;
    }

    private void setPositionY(int positionY) {
        this.positionY = positionY;
    }


    @Override
    public String toString() {
        return "Personnage{" + super.toString() +
                ", postionX=" + postionX +
                ", positionY=" + positionY +
                '}';
    }
}
