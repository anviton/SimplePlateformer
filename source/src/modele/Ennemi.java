package modele;

public class Ennemi extends Personnage{
    public Ennemi(String nom, String image, HitBox collision) {
        super(nom, image, collision);
    }

    public String toString(){
        return "test";
    }

    public int mourir(){
        setNombreDeVies(getNombreDeVies() - 1);
        return getNombreDeVies();
    }
}
