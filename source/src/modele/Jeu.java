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

/**
 * Classe jeu permet de jouer à un niveau
 * @author anviton khloichet
 */

public class Jeu implements Runnable{

    private Thread threadInterne;
    private List<ControleurObservateur> observateurs;
    private int chrono = 0;
    private boolean jeuEnCours;
    private Deplaceur deplaceur;
    private final Niveau niveauLance;
    private Afficheur afficheur;
    private static final double TPSRAFF = 1000.0/30;

    /**
     * Constructeur de Jeu
     * @param niveauLance niveau qui devra être lancé
     */
    public Jeu(Niveau niveauLance) {
        this.niveauLance = niveauLance;
        this.observateurs = new ArrayList<>();
    }

    /**
     * Permet de lancer le jeu
     */
    public void lancerBoucleDeJeu(){
        threadInterne = new Thread(this);
        threadInterne.start();
    }

    /**
     * Permet de lancer le jeu en spécifiant un contexte graphique, et une Scene
     * @param gc GrpahicContext du jeu
     * @param s Scene du jeu
     */
    public void lancerBoucleDeJeu(GraphicsContext gc, Scene s){
        if (niveauLance == null){
            return;
        }
        threadInterne = new Thread(this);
        this.deplaceur = new DeplaceurJavaFX(s);
        this.afficheur = new AfficheurJavaFX(gc);
        threadInterne.start();
    }

    /**
     * Lance la boucle de jeu
     */
    @Override
    public void run() {
        int compt = 0;
        float vitesseChute = 8f;
        float chronoIndicateur = 0;
        boolean gravite;
        Personnage perso = initialiserLeJeu();
        while (jeuEnCours){
            double positionXAvant = perso.getPositionX();
            double positionYAvant = perso.getPositionY();
            compt++;
            gravite = deplaceur.gererLaGravite(perso);
            if (gravite) {
                if(compt >= TPSRAFF/vitesseChute) {
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
    }

    /**
     * Permet d'initialiser le jeu en créant le personnage et en donnant
     * à l'afficheur et au déplaceur ce qu'ils ont besoin
     * @return le personnage créé
     */
    private Personnage initialiserLeJeu(){
        List<String> listeCheminImageBloc = new ArrayList<>();
        listeCheminImageBloc.add("/blocs/blocVide.png");
        listeCheminImageBloc.add("/blocs/briqueBase.png");
        listeCheminImageBloc.add("/blocs/bombe.png");
        listeCheminImageBloc.add("/blocs/drapeau.png");
        HitBox collision = new HitBox(50, 50);
        Personnage perso = new Personnage("Joueur", niveauLance.getPositionXDepart(),
                niveauLance.getPositionYDepart(), collision);
        afficheur.afficherLeNiveau(niveauLance, listeCheminImageBloc, perso);
        deplaceur.setNiveau(niveauLance);
        deplaceur.deplacerPersonnagePrincipal(perso);
        jeuEnCours = true;
        return perso;
    }

    /**
     * Vérifie que la position du perso est la même que celle de l'arrivée du niveau
     * @param perso personnage dont la position doit être vérifiée
     * @return true si postion personnage ègale à celle de l'arrivée, false sinon
     */
    private boolean verificationVictoire(Personnage perso){
        return niveauLance.getPositionXArrivee() != perso.getPositionX() ||
                niveauLance.getPositionYArrivee() != perso.getPositionY();
    }

    /**
     * Notifie les ControleurObservateurs
     */
    public void nottifier(){
        for(ControleurObservateur o : observateurs){
            o.mettreAJour();
        }
    }

    /**
     * Attache un observateur
     * @param observateur l'observateur à attacher
     */
    public void attacher(ControleurObservateur observateur){
        observateurs.add(observateur);
    }

    /**
     * Détache un observateur
     * @param observateur l'observateur à détacher
     */
    public void detacher(ControleurObservateur observateur){
        observateurs.remove(observateur);
    }

    /**
     * Getter du chrono
     * @return le chrono (temps mis pour finir le jeu)
     */
    public int getChrono() {
        return chrono;
    }
}
