
import modele.HitBox;
import modele.Personnage;
import modele.Objet;

public class TestPersonnage {

    public static void main(String[] args){
        String cheminImage = "personnage.png";
        HitBox collision = new HitBox(10, 10);
        Personnage persoTest = new Personnage("Joueur", cheminImage, collision);
        Objet banane = new Objet("Banane", "Attaque tout le monde", cheminImage, collision);
        Objet poire = new Objet("Poire", "Attaque pas tout le monde", cheminImage, collision);
        persoTest.prendreObjet(banane);
        persoTest.prendreObjet(poire);
        System.out.println(persoTest);
        persoTest.utiliserObjet();
        persoTest.utiliserObjet();
        persoTest.utiliserObjet();
        System.out.println(persoTest);
    }
}
