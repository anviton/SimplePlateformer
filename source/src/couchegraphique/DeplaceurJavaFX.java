package couchegraphique;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.logique.Collisionneur;
import modele.logique.CollisionneurClassique;
import modele.logique.CollisionneurDeBombe;
import modele.logique.Deplaceur;
import modele.metier.Personnage;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

/**
 * DeplaceurJavaFX permet le déplacement du personnage
 */

public class DeplaceurJavaFX extends Deplaceur {

    private final Scene scene;
    private final List<Collisionneur> collisionneurs;
    private final CollisionneurClassique collisionneurClassique;
    private boolean saut;

    /**
     * DeplaceurJavaFX constructeur du déplaceur
     * @param s scene
     */

    public DeplaceurJavaFX(Scene s) {
        this.scene = s;
        this.collisionneurs = new ArrayList<>();
        this.collisionneurClassique = new CollisionneurClassique();
        this.collisionneurs.add(new CollisionneurClassique());
        this.collisionneurs.add(new CollisionneurDeBombe());
    }

    /**
     * deplacerPersonnagePrincipal récupère les touches pour déplacer les personnages
     * @param perso personnage a déplacer
     */

    @Override
    public void deplacerPersonnagePrincipal(Personnage perso) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                if (key.getCode() == KeyCode.RIGHT) {
                    this.seDeplacerADroite(perso);
                }
                if (key.getCode() == KeyCode.LEFT) {
                    this.seDeplacerAGauche(perso);
                }
                if (key.getCode() == KeyCode.SPACE && saut) {
                    this.sauter(perso);
                }
        });
    }

    /**
     * gererLaGravite gère la gravité du personnage
     * @param perso personnage a regarder pour la gravité
     * @return la collision si elle a lieu ou non
     */

    @Override
    public boolean gererLaGravite(Personnage perso){
        List<Boolean>collisions = new ArrayList<>();
        for(Collisionneur collisionneur : collisionneurs){
            collisions.add(collisionneur.verifCollisionEnDessous(perso, niveau));
        }
        if (collisions.get(1)){
            if (!collisions.get(0)){
                saut = true;
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
        return collisions.get(0);
    }

    /**
     * sauter gère le saut d'un personnage
     * @param perso personnage a regarder pour sauter
     */
    private void sauter(Personnage perso){
        List<Boolean> collisionsSaut = collisionneurs.get(0).verifcollisionSaut(perso, niveau);
        int tailleSaut = 0;
        for (int i = 0; i < 4; i++) {
            if (collisionsSaut.get(i)){
                tailleSaut++;
            }
        }
        if (saut) {
            perso.setPositionY(perso.getPositionY() - tailleSaut);
            saut = false;
        }
    }

    /**
     * seDeplacerAGauche gère le déplacement du perso a gauche
     * @param perso personnage a regarder pour le déplacer a gauche
     */
    private void seDeplacerAGauche(Personnage perso){
        List<Boolean>collisions = new ArrayList<>();
        for(Collisionneur collisionneur : collisionneurs){
            collisions.add(collisionneur.verifCollisionAGauche(perso, niveau));
        }
        if(collisions.get(1)){
            if(collisions.get(0)){
                perso.setPositionX(perso.getPositionX() - 1);
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
    }

    /**
     * seDeplacerADroite gère le déplacement du perso a droite
     * @param perso personnage a regarder pour le déplacer a droite
     */

    private void seDeplacerADroite(Personnage perso){
        List<Boolean>collisions = new ArrayList<>();
        for(Collisionneur collisionneur : collisionneurs){
            collisions.add(collisionneur.verifCollisionADroite(perso, niveau));
        }
        if(collisions.get(1)){
            if(collisions.get(0)){
                perso.setPositionX(perso.getPositionX() + 1);
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
    }
}
