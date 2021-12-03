
import modele.HitBox;
import modele.Personnage;

public class TestPersonnage {

    public static void main(String[] args){
        String cheminImage = "personnage.png";
        HitBox collision = new HitBox(10, 10);
        Personnage persoTest = new Personnage("Joueur",0, 0, cheminImage, collision);
        System.out.println(persoTest);
    }
}
