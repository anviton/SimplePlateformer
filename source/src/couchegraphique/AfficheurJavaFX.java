package couchegraphique;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modele.logique.Afficheur;
import modele.metier.Bloc;
import modele.metier.Niveau;
import modele.metier.Personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * AfficheurJavaFx permet d'afficher les élèments ainsi que de les mettre a jour.
  */

public class AfficheurJavaFX extends Afficheur {
    private final GraphicsContext gc;
    private final List<EntiteGraphique> listeEntitesGraphiques;
    private static final int TAILLE = 50;

    /**
     * AfficheurJavaFx permet de construire un AfficheurJavaFx
      * @param gc permet de mettre le niveau dans un graphicContext
     */

    public AfficheurJavaFX(GraphicsContext gc) {
        this.gc = gc;
        this.listeEntitesGraphiques = new ArrayList<>();
    }

    /**
     * mettreAjourLAffichageDuPersonnagePrincipal permet de mettre a jour le déplacement du personnage sur notre jeu
     * @param p prend le personnage a afficher et a mettre a jour
     * @param ancienPositionX garde l'ancienne position du personnage pour les X
     * @param ancienPositionY garde l'ancienne position du personnage pour les Y
     */

    @Override
    public void mettreAjourLAffichageDuPersonnagePrincipal(Personnage p, double ancienPositionX, double ancienPositionY){
        if (ancienPositionX != listeEntitesGraphiques.get(0).getEntite().getPositionX() ||
                ancienPositionY != listeEntitesGraphiques.get(0).getEntite().getPositionY()) {
            this.gc.drawImage(listeEntitesGraphiques.get(0).getImage(), listeEntitesGraphiques.get(0).getEntite().getPositionX()*TAILLE,
                    listeEntitesGraphiques.get(0).getEntite().getPositionY()*TAILLE, TAILLE, TAILLE);
            this.gc.clearRect(ancienPositionX * TAILLE, ancienPositionY * TAILLE, p.getHitBox().getLargeur(),
                    p.getHitBox().getHauteur());
        }

    }

    /**
     * afficherLeNiveau permet d'afficher le niveau avec son personnage
     * @param n le niveau a afficher
     * @param cheminImagesBlocs liste des chemeins de blocs a afficher dans le niveau
     * @param perso personnage a afficher dans le niveau
     */

    @Override
    public void afficherLeNiveau(Niveau n, List<String> cheminImagesBlocs, Personnage perso){
        FabriqueDeProduitGraphique fabrique=  new FabriqueDEntiteGraphique();
        listeEntitesGraphiques.add((EntiteGraphique) fabrique.fabrique(perso, "/personnage.png"));
        fabrique = new FabriqueDeBlocGrapqhique();
        for (Bloc bloc : n.getListeBlocs() ) {
            BlocGraphique blocGraphique = (BlocGraphique) fabrique.fabrique(bloc, cheminImagesBlocs.get(bloc.getType()));
            this.gc.drawImage(blocGraphique.getImage(), blocGraphique.getBloc().getPositionX()*TAILLE,
                    blocGraphique.getBloc().getPositionY()*TAILLE, TAILLE, TAILLE);
        }
        this.gc.drawImage(listeEntitesGraphiques.get(0).getImage(), listeEntitesGraphiques.get(0).getEntite().getPositionX()*TAILLE,
                listeEntitesGraphiques.get(0).getEntite().getPositionY()*TAILLE, TAILLE, TAILLE);
    }

    /**
     * mettreAJourLAffichageDuTemps met a jour le compteur sur le jeu
     * @param temps chrono du jeu
     */

    @Override
    public void mettreAJourLAffichageDuTemps(int temps){
        gc.setFont(new Font(20));
        gc.setFill(Color.WHITE);
        gc.fillRect(TAILLE, 12*TAILLE, TAILLE,TAILLE);
        gc.setFill(Color.RED);
        int tailleDiv2 = TAILLE/2;
        gc.fillText(temps + "s", TAILLE,(12*TAILLE)+tailleDiv2);
    }
}
