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
    private Niveau niveau;

    public Jeu(Niveau niveau) {
        this.niveau = niveau;
    }

    public void lancerBoucleDeJeu(){
        /*threadInterne = new Thread(this);
        threadInterne.start();*/
    }

    public void lancerBoucleDeJeu(GraphicsContext gc, Scene s){
        if (niveau == null){
            return;
        }
        threadInterne = new Thread(this);
        threadInterne.start();
        this.gc = gc;
        this.deplaceur = new Deplaceur(s);
        //this.run();
    }


    @Override
    public void run() {
        int i = 0;
        int compt = 0;
        float vitesseChute = 8f;
        double tpsRaf = 1000.0/30;
        int chrono = 0;
        float chronoIndicateur = 0;
        jeuEncours = true;
        AfficheurJavaFX afficheur = new AfficheurJavaFX(gc);
        List<String> listeCheminImageBloc = new ArrayList<>();
        listeCheminImageBloc.add("Blocs/blocVide.png");
        listeCheminImageBloc.add("Blocs/briqueBase.png");
        HitBox collision = new HitBox(50, 50);
        Personnage persoTest = new Personnage("Joueur", 1, 1, collision);
        afficheur.afficherLeNiveau(niveau, listeCheminImageBloc, persoTest);
        afficheur.mettreAjourLAffichageDuPersonnagePrincipal(persoTest, persoTest.getPositionX(), persoTest.getPositionY());
        deplaceur.setNiveau(niveau);
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

            compt++;
            gravite = deplaceur.gravite(persoTest);
            if (gravite) {
                if(compt >= tpsRaf/vitesseChute) {
                    persoTest.setPositionY(persoTest.getPositionY() + 1);
                    compt = 0;
                }
            }
            if (chronoIndicateur == 30){
                chrono++;
                chronoIndicateur = 0;
                //System.out.println(chrono);
                afficheur.mettreAJourLAffichageDuTemps(chrono);
            }
            chronoIndicateur++;
            try {
                threadInterne.sleep((long)tpsRaf);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
