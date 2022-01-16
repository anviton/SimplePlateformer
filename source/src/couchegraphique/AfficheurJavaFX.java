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

public class AfficheurJavaFX extends Afficheur {
    private final GraphicsContext gc;
    private final List<EntiteGraphique> listeEntitesGraphiques;
    private static final int TAILLE = 50;

    public AfficheurJavaFX(GraphicsContext gc) {
        this.gc = gc;
        this.listeEntitesGraphiques = new ArrayList<>();
    }

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
