package modele;

import controleurs.ControleurObservateur;
import couchegraphique.AfficheurJavaFX;
import couchegraphique.DeplaceurJavaFX;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import modele.logique.Afficheur;
import modele.logique.Deplaceur;
import modele.metier.HitBox;
import modele.metier.Niveau;
import modele.metier.Personnage;

import java.util.ArrayList;
import java.util.List;

public class Jeu implements Runnable{

    private Thread threadInterne;
    private List<ControleurObservateur> observateurs;
    private int chrono = 0;
    private boolean jeuEnCours;
    private Deplaceur deplaceur;
    private final Niveau niveauLance;
    private Afficheur afficheur;
    private StockagePosition stockagePosition;
    private static final double TPSRAFF = 1000.0/30;

    public Jeu(Niveau niveauLance) {
        this.niveauLance = niveauLance;
        this.observateurs = new ArrayList<>();
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
        this.deplaceur = new DeplaceurJavaFX(s);
        this.afficheur = new AfficheurJavaFX(gc);
        threadInterne.start();
    }


    @Override
    public void run() {
        int compt = 0;
        float vitesseChute = 8f;
        double tpsRaf = 1000.0/30;
        float chronoIndicateur = 0;
        Personnage perso = initialiserLeJeu();
        boolean gravite;
        while (jeuEnCours){
            double positionXAvant = perso.getPositionX();
            double positionYAvant = perso.getPositionY();
            compt++;
            gravite = deplaceur.gererLaGravite(perso);
            if (gravite) {
                if(compt >= tpsRaf/vitesseChute) {
                    perso.setPositionY(perso.getPositionY() + 1);
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
                threadInterne.sleep((long)TPSRAFF);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            afficheur.mettreAjourLAffichageDuPersonnagePrincipal(perso, positionXAvant, positionYAvant);
            jeuEnCours = verificationVictoire(perso);
        }
        this.nottifier();
        //threadInterne.stop();
    }

    private Personnage initialiserLeJeu(){
        List<String> listeCheminImageBloc = new ArrayList<>();
        listeCheminImageBloc.add("/blocs/blocVide.png");
        listeCheminImageBloc.add("/blocs/briqueBase.png");
        listeCheminImageBloc.add("/blocs/bombe.png");
        HitBox collision = new HitBox(50, 50);
        Personnage perso = new Personnage("Joueur", niveauLance.getPositionXDepart(),
                niveauLance.getPositionYDepart(), collision);
        afficheur.afficherLeNiveau(niveauLance, listeCheminImageBloc, perso);
        deplaceur.setNiveau(niveauLance);
        deplaceur.deplacerPersonnagePrincipal(perso);
        //stockagePosition = new StockagePosition();
        //stockagePosition.ajouterUnePosition(perso.creerMemento());
        jeuEnCours = true;
        return perso;
    }

    private boolean verificationVictoire(Personnage perso){
        return niveauLance.getPositionXArrivee() != perso.getPositionX() ||
                niveauLance.getPositionYArrivee() != perso.getPositionY();
    }

    public void nottifier(){
        for(ControleurObservateur o : observateurs){
            o.mettreAJour();
        }
    }

    public void attacher(ControleurObservateur observateur){
        observateurs.add(observateur);
    }

    public void detacher(ControleurObservateur observateur){
        observateurs.remove(observateur);
    }

    public boolean isJeuEnCours() {
        return jeuEnCours;
    }

    public Thread getThreadInterne() {
        return threadInterne;
    }

    public int getChrono() {
        return chrono;
    }
}
