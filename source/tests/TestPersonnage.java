
import modele.metier.HitBox;
import modele.metier.Personnage;

public class TestPersonnage {

    public static void main(String[] args){
        String cheminImage = "personnage.png";
        HitBox collision = new HitBox(50, 50);
        Personnage persoTest = new Personnage("Joueur", 10, 10, collision);
        System.out.println(persoTest);
        System.out.println(persoTest);
    }
}
