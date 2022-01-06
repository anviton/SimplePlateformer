package modele;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Deplaceur {

    private Scene scene;
    private Niveau niveau;
    private boolean saut;
    private boolean gravite;

    public Deplaceur(Scene s) {
        this.scene = s;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void deplacer(Personnage perso) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            boolean collision = true;
            //System.out.println(niveau.getListeBlocAffichable().size());
                if (key.getCode() == KeyCode.RIGHT) {
                    //System.out.println("Droite");
                    for (int i = 0; i < niveau.getListeBlocAffichable().size(); i++) {
                        //System.out.println(i);
                        Bloc bloc = niveau.getListeBlocAffichable().get(i);
                        //System.out.println(bloc);
                        if (perso.getPositionX() + 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY() && bloc.getType() == 1) {
                            collision = false;
                            //System.out.println("Collision");
                            break;
                        }
                    }
                    //this.gravite(perso);
                    if(collision) {
                        perso.setPositionX(perso.getPositionX() + 1);
                        //System.out.println(perso.getPositionX());
                    }
                }
                if (key.getCode() == KeyCode.LEFT) {
                    for (int i = 0; i < niveau.getListeBlocAffichable().size(); i++) {
                        Bloc bloc = niveau.getListeBlocAffichable().get(i);
                        if (perso.getPositionX() - 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY() &&
                                bloc.getType() == 1) {
                            collision = false;
                            break;
                        }
                    }
                    if(collision) {
                        System.out.println("Gauche");
                        perso.setPositionX(perso.getPositionX() - 1);
                        System.out.println(perso.getPositionX());
                    }
                }
                if (key.getCode() == KeyCode.SPACE && saut) {
                    List<Boolean> collisionsSaut = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        collisionsSaut.add(true);
                    }
                    System.out.println("Sauter");
                    for (int i = 0; i < niveau.getListeBlocAffichable().size(); i++) {
                        Bloc bloc = niveau.getListeBlocAffichable().get(i);
                        if (perso.getPositionY() - 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                            collisionsSaut.set(0, false);
                            collisionsSaut.set(1, false);
                            collisionsSaut.set(2, false);
                            collisionsSaut.set(3, false);
                            //break;
                        }
                        if (perso.getPositionY() - 2 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                            collisionsSaut.set(1, false);
                            collisionsSaut.set(2, false);
                            collisionsSaut.set(3, false);
                            //break;
                        }
                        if (perso.getPositionY() - 3 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                            collisionsSaut.set(2, false);
                            collisionsSaut.set(3, false);
                            //break;
                        }
                        if (perso.getPositionY() - 4 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                            collisionsSaut.set(3, false);
                            //break;
                        }
                    }
                    int tailleSaut = 0;
                    for (int i = 0; i < 4; i++) {
                        if (collisionsSaut.get(i)) {
                            tailleSaut++;
                        }
                    }
                    System.out.println(tailleSaut);
                    this.sauter(perso, tailleSaut);
                }
        });
    }

    public boolean gravite(Personnage perso){
        gravite = true;
        saut = false;
        for (int i = 0; i < niveau.getListeBlocAffichable().size(); i++) {
            Bloc bloc = niveau.getListeBlocAffichable().get(i);
            if (perso.getPositionY() + 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                gravite = false;
                saut = true;
                break;
            }
        }
        return gravite;
    }

    private void sauter(Personnage perso, int taillesaut){
        if (saut) {
            perso.setPositionY(perso.getPositionY() - taillesaut);
            //System.out.println(perso.getPositionY());
            saut = false;
        }
    }
}
