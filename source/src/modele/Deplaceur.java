package modele;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Deplaceur {

    private Scene scene;
    private Niveau niveau;
    private int saut;

    public Deplaceur(Scene s) {
        this.scene = s;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void deplacer(Personnage perso) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            boolean collision = true;
            System.out.println(niveau.getListeBlocAffichable().size());
                if (key.getCode() == KeyCode.RIGHT) {
                    System.out.println("Droite");
                    for (int i = 0; i < niveau.getListeBlocAffichable().size(); i++) {
                        System.out.println(i);
                        Bloc bloc = niveau.getListeBlocAffichable().get(i);
                        System.out.println(bloc);
                        if (perso.getPositionX() + 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY() && bloc.getType() == 1) {
                            collision = false;
                            System.out.println("Collision");
                            break;
                        }
                    }
                    //this.gravite(perso);
                    if(collision) {
                        perso.setPositionX(perso.getPositionX() + 1);
                        System.out.println(perso.getPositionX());
                    }
                }
                if (key.getCode() == KeyCode.LEFT) {
                    for (int i = 0; i < niveau.getListeBlocAffichable().size(); i++) {
                        System.out.println(i);
                        Bloc bloc = niveau.getListeBlocAffichable().get(i);
                        System.out.println(bloc);
                        if (perso.getPositionX() - 1 == bloc.getPositionX() && perso.getPositionY() == bloc.getPositionY() && bloc.getType() == 1) {
                            collision = false;
                            System.out.println("Collision");
                            break;
                        }
                    }
                    //this.gravite(perso);
                    if(collision) {
                        System.out.println("Gauche");
                        perso.setPositionX(perso.getPositionX() - 1);
                        System.out.println(perso.getPositionX());
                    }
                }
                if (key.getCode() == KeyCode.SPACE) {
                    System.out.println("Sauter");
                    for (int i = 0; i < niveau.getListeBlocAffichable().size(); i++) {
                        System.out.println(i);
                        Bloc bloc = niveau.getListeBlocAffichable().get(i);
                        //System.out.println(bloc);
                        if (perso.getPositionY() - 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                            collision = false;
                            break;
                        }
                        if (perso.getPositionY() - 2 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                            collision = false;
                            break;
                        }
                        if (perso.getPositionY() - 3 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                            collision = false;
                            break;
                        }
                        if (perso.getPositionY() - 4 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                            collision = false;
                            break;
                        }
                    }
                    this.sauter(perso, collision);
                    /*if (collision && saut == 0) {
                        perso.setPositionY(perso.getPositionY() - 4);
                        System.out.println(perso.getPositionY());
                        saut = 1;
                    }*/
                }
                if (key.getCode() == KeyCode.DOWN) {
                    //System.out.println("descendre");
                    perso.setPositionY(perso.getPositionY() + 1);
                    //System.out.println(perso.getPositionY());
                }

                if (key.getCode() == KeyCode.ENTER) {
                    System.out.println("entrer");
                }

                System.out.println("Position X : " + perso.getPositionX() + "Position Y : " + perso.getPositionY());
        });
    }

    public boolean gravite(Personnage perso){
        boolean gravite = true;
        //while (gravite) {
            for (int i = 0; i < niveau.getListeBlocAffichable().size(); i++) {
                System.out.println(i);
                Bloc bloc = niveau.getListeBlocAffichable().get(i);
                System.out.println(bloc);
                if (perso.getPositionY() + 1 == bloc.getPositionY() && perso.getPositionX() == bloc.getPositionX() && bloc.getType() == 1) {
                    gravite = false;
                    System.out.println("Gravite");
                    saut = 0;
                    break;
                }
            }
            /*if (gravite) {
                perso.setPositionY(perso.getPositionY() + 1);
            }*/
            return gravite;
        //}
    }

    private void sauter(Personnage perso, boolean collision){
        if (collision && saut == 0) {
            perso.setPositionY(perso.getPositionY() - 4);
            System.out.println(perso.getPositionY());
            saut = 1;
        }
    }
}
