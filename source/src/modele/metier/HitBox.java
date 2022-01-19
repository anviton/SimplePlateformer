package modele.metier;

public class HitBox {
    private final int hauteur;
    private final int largeur;

    public HitBox(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }


    public int getHauteur() {
        return hauteur;
    }


    public int getLargeur() { return largeur; }


    @Override
    public String toString() {
        return "HitBox{" +
                "hauteur=" + hauteur +
                ", largeur=" + largeur +
                '}';
    }
}
