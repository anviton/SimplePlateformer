package couchegraphique;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.logique.CollisionneurClassique;
import modele.logique.Deplaceur;
import modele.metier.Personnage;

//import java.util.ArrayList;
import java.util.List;

public class DeplaceurJavaFX extends Deplaceur {

    private final Scene scene;
    private final CollisionneurClassique collisionneurClassique;
    private boolean saut;

    public DeplaceurJavaFX(Scene s) {
        this.scene = s;
        this.collisionneurClassique = new CollisionneurClassique();
    }

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

    @Override
    public boolean gererLaGravite(Personnage perso){
        boolean collision = collisionneurClassique.verifCollisionEnDessous(perso, niveau);
        boolean collisionBombe = collisionneurClassique.verifCollisionBombeEnDessous(perso, niveau);
        if (collisionBombe){
            if (!collision){
                saut = true;
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
        return collision;
    }

    private void sauter(Personnage perso){
        List<Boolean> collisionsSaut = collisionneurClassique.verifcollisionSaut(perso, niveau);
        //List<Boolean> collisionsBombeSaut = collisionneurClassique.verifcollisionBombeSaut(perso, niveau);
        int tailleSaut = 0;
        for (int i = 0; i < 4; i++) {
            /*if (collisionsBombeSaut.get(i)){
                if (collisionsSaut.get(i)){
                    tailleSaut++;
                }
            }
            else {
                perso.setPositionX(niveau.getPositionXDepart());
                perso.setPositionY(niveau.getPositionYDepart());
            }*/
            if (collisionsSaut.get(i)){
                tailleSaut++;
            }
        }
        if (saut) {
            perso.setPositionY(perso.getPositionY() - tailleSaut);
            saut = false;
        }
    }

    private void seDeplacerAGauche(Personnage perso){
        if(collisionneurClassique.verifCollisionBombeAGauche(perso, niveau)){
            if(collisionneurClassique.verifCollisionAGauche(perso, niveau)){
                perso.setPositionX(perso.getPositionX() - 1);
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
    }

    private void seDeplacerADroite(Personnage perso){
        if(collisionneurClassique.verifCollisionBombeADroite(perso, niveau)){
            if(collisionneurClassique.verifCollisionADroite(perso, niveau)){
                perso.setPositionX(perso.getPositionX() + 1);
            }
        }
        else {
            perso.setPositionX(niveau.getPositionXDepart());
            perso.setPositionY(niveau.getPositionYDepart());
        }
    }
}
