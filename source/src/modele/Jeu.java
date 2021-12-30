package modele;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu implements Runnable{

    private Thread threadInterne;
    private boolean jeuEncours;
    private GraphicsContext gc;
    private Deplaceur deplaceur;

    public void lancerBoucleDeJeu(){
        /*threadInterne = new Thread(this);
        threadInterne.start();*/
    }

    public void lancerBoucleDeJeu(GraphicsContext gc, Scene s){
        threadInterne = new Thread(this);
        threadInterne.start();
        this.gc = gc;
        this.deplaceur = new Deplaceur(s);
        //this.run();
    }


    @Override
    public void run() {
        int i = 0;
        jeuEncours = true;
        AfficheurJavaFX afficheur = new AfficheurJavaFX(gc);
        List<String> listeCheminImageBloc = new ArrayList<String>();
        listeCheminImageBloc.add("Blocs/blocVide.png");
        listeCheminImageBloc.add("Blocs/briqueBase.png");
        ChargeurNiveau chargeur =  new ChargeurNiveau(listeCheminImageBloc);
        String cheminACharger = "resources/Niveaux/niveau1";
        Niveau n = chargeur.chargerNiveau(cheminACharger);
        HitBox collision = new HitBox(50, 50);
        Personnage persoTest = new Personnage("Joueur", 1, 1, collision);
        afficheur.afficherLeNiveau(n, listeCheminImageBloc, persoTest);
        afficheur.mettreAjourLAffichageDuPersonnagePrincipal(persoTest, persoTest.getPositionX(), persoTest.getPositionY());
        deplaceur.setNiveau(n);
        deplaceur.deplacer(persoTest);
        boolean gravite;
        while (jeuEncours){
            double positionXAvant = persoTest.getPositionX();
            double positionYAvant = persoTest.getPositionY();
            //System.out.println("toto" + i);
            i++;
            if(i == 20000){
                jeuEncours = false;
            }

            try {
                threadInterne.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gravite = deplaceur.gravite(persoTest);
            if (gravite) {
                persoTest.setPositionY(persoTest.getPositionY() + 1);
            }
            afficheur.mettreAjourLAffichageDuPersonnagePrincipal(persoTest, positionXAvant, positionYAvant);
        }
        System.out.println("Le jeu est fini");
    }

    public boolean isJeuEncours() {
        return jeuEncours;
    }

    public void setJeuEncours(boolean jeuEncours) {
        this.jeuEncours = jeuEncours;
    }
}
