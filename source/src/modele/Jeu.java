package modele;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Jeu implements Runnable{

    private Thread threadInterne;
    private boolean jeuEnCours;
    private Deplaceur deplaceur;
    private final Niveau niveauLance;
    private Afficheur afficheur;

    public Jeu(Niveau niveauLance) {
        this.niveauLance = niveauLance;
    }

    public void lancerBoucleDeJeu(){
        /*threadInterne = new Thread(this);
        threadInterne.start();*/
    }

    public void lancerBoucleDeJeu(GraphicsContext gc, Scene s){
        if (niveauLance == null){
            return;
        }
        threadInterne = new Thread(this);
        this.deplaceur = new Deplaceur(s);
        this.afficheur = new AfficheurJavaFX(gc);
        threadInterne.start();
        //this.run();
    }


    @Override
    public void run() {
        int compt = 0;
        float vitesseChute = 8f;
        double tpsRaf = 1000.0/30;
        int chrono = 0;
        float chronoIndicateur = 0;
        Personnage persoTest = initialiserLeJeu();
        boolean gravite;
        while (jeuEnCours){
            double positionXAvant = persoTest.getPositionX();
            double positionYAvant = persoTest.getPositionY();
            compt++;
            gravite = deplaceur.gererLaGravite(persoTest);
            if (gravite) {
                if(compt >= tpsRaf/vitesseChute) {
                    persoTest.setPositionY(persoTest.getPositionY() + 1);
                    compt = 0;
                }
            }
            if (chronoIndicateur == 30){
                chrono++;
                chronoIndicateur = 0;
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
    }

    private Personnage initialiserLeJeu(){
        List<String> listeCheminImageBloc = new ArrayList<>();
        listeCheminImageBloc.add("blocs/blocVide.png");
        listeCheminImageBloc.add("blocs/briqueBase.png");
        HitBox collision = new HitBox(50, 50);
        Personnage persoTest = new Personnage("Joueur", 36, 1, collision);
        afficheur.afficherLeNiveau(niveauLance, listeCheminImageBloc, persoTest);
        deplaceur.setNiveau(niveauLance);
        deplaceur.deplacerPersonnagePrincipal(persoTest);
        jeuEnCours = true;
        return persoTest;
    }

}
