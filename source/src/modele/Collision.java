package modele;

public class Collision {
    private int hauteur;
    private int largeur;

    public Collision(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }


    public int getHauteur() {
        return hauteur;
    }

    private void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    private void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    @Override
    public String toString() {
        return "Collision{" +
                "hauteur=" + hauteur +
                ", largeur=" + largeur +
                '}';
    }
}
