package couchegraphique;

import modele.logique.Afficheur;
import modele.metier.Entite;
import modele.metier.HitBox;

public class ObjetGraphique extends Entite {
    public ObjetGraphique(int posX, int posY, HitBox hitbox){
        super(posX, posY, hitbox);
    };

    public void attacher(Afficheur a){

    }

    public void detacher(Afficheur a){

    }

    public void notifier(){

    }
}
