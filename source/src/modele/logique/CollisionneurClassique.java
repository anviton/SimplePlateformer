package modele.logique;

import modele.metier.Bloc;
import modele.metier.Musique;
import modele.metier.Niveau;
import modele.metier.Personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe CollisionneurClassique permet de gérer les collisions avec les blocs en vérifiant les HitBox
 * @author anviton
 */
public class CollisionneurClassique extends Collisionneur{
    public static Musique musique = new Musique();

    @Override
    public boolean verifCollisionAGauche(Personnage perso, Niveau niveau){
        boolean collision = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionX() - 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY()
                    && bloc.getHitBox() != null) {
                collision = false;
                break;
            }
        }
        return collision;
    }

    public boolean verifCollisionBombeAGauche(Personnage perso, Niveau niveau){
        boolean collisionBombe = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionX() - 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY()
                    && bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionBombe = false;
                musique.playSound();
                break;
            }
        }
        return collisionBombe;
    }

    @Override
    public boolean verifCollisionADroite(Personnage perso, Niveau niveau){
        boolean collision = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionX() + 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY()
                    && bloc.getHitBox() != null) {
                collision = false;
                break;
            }
        }
        return collision;
    }

    public boolean verifCollisionBombeADroite(Personnage perso, Niveau niveau){
        boolean collisionBombe = true;

        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionX() + 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY()
                    && bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionBombe = false;
                musique.playSound();

                break;
            }
        }

        return collisionBombe;
    }

    @Override
    public boolean verifCollisionEnDessous(Personnage perso, Niveau niveau){
        boolean gravite = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionY() + 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() &&
                    bloc.getHitBox() != null) {
                gravite = false;
                break;
            }
        }
        return gravite;
    }

    public boolean verifCollisionBombeEnDessous(Personnage perso, Niveau niveau){
        boolean collisionBombe = true;
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionY() + 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() &&
                    bloc.getHitBox() != null && bloc.getType() == 2) {
                collisionBombe = false;
                musique.playSound();
                break;
            }
        }
        return collisionBombe;
    }

    @Override
    public List<Boolean> verifcollisionSaut(Personnage perso, Niveau niveau){
        List<Boolean> collisionsSaut = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            collisionsSaut.add(true);
        }
        for (int i = 0; i < niveau.getListeBlocs().size(); i++) {
            Bloc bloc = niveau.getListeBlocs().get(i);
            if (perso.getPositionY() - 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null) {
                collisionsSaut.set(0, false);
                collisionsSaut.set(1, false);
                collisionsSaut.set(2, false);
                collisionsSaut.set(3, false);
            }
            if (perso.getPositionY() - 2 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null) {
                collisionsSaut.set(1, false);
                collisionsSaut.set(2, false);
                collisionsSaut.set(3, false);
            }
            if (perso.getPositionY() - 3 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null) {
                collisionsSaut.set(2, false);
                collisionsSaut.set(3, false);
            }
            if (perso.getPositionY() - 4 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX()
                    && bloc.getHitBox() != null) {
                collisionsSaut.set(3, false);
            }
        }
        return collisionsSaut;
    }

}
