package modele.metier;

public class Ennemi extends Personnage {
    public Ennemi(String nom, int posX, int posY, HitBox collision) {
        super(nom, posX, posY, collision);
    }

    public String toString(){
        return "test";
    }

    public int mourir(){
        setNombreDeVies(getNombreDeVies() - 1);
        return getNombreDeVies();
    }
}
