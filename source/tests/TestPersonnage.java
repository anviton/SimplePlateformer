
import modele.Collision;
import modele.Personnage;

public class TestPersonnage {

    public static void main(String[] args){
        String cheminImage = "personnage.png";
        Collision collision = new Collision(10, 10);
        Personnage persoTest = new Personnage("Joueur",0, 0, cheminImage, collision);
        System.out.println(persoTest);
    }
}
