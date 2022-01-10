package modele;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class DeplaceurJavaFX extends Deplaceur {

    private final Scene scene;
    private final Collisionneur collisionneur;
    private boolean saut;

    public DeplaceurJavaFX(Scene s) {
        this.scene = s;
        this.collisionneur = new Collisionneur();
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
        boolean collision = collisionneur.verifCollisionEnDessous(perso, niveau);
        if (!collision){
            saut = true;
        }
        return collision;
    }

    private void sauter(Personnage perso){
        List<Boolean> collisionsSaut = collisionneur.verifcollisionSaut(perso, niveau);
        int tailleSaut = 0;
        for (int i = 0; i < 4; i++) {
            if (collisionsSaut.get(i)) {
                tailleSaut++;
            }
        }
        if (saut) {
            perso.setPositionY(perso.getPositionY() - tailleSaut);
            saut = false;
        }
    }

    private void seDeplacerAGauche(Personnage perso){
        if(collisionneur.verifCollisionAGauche(perso, niveau)) {
            perso.setPositionX(perso.getPositionX() - 1);
        }
    }

    private void seDeplacerADroite(Personnage perso){
        if(collisionneur.verifCollisionADroite(perso, niveau)) {
            perso.setPositionX(perso.getPositionX() + 1);
        }
    }
}
