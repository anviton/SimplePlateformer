package modele;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class AfficheurJavaFX extends Afficheur{
    private GraphicsContext gc;
    private List<EntiteGraphique> listeEntitesGraphiques;
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
            this.gc.clearRect(ancienPositionX * TAILLE, ancienPositionY * TAILLE, p.getHitbox().getLargeur(),
                    p.getHitbox().getHauteur());
        }

    }

    @Override
    public void afficherLeNiveau(Niveau n, List<String> cheminImagesBlocs, Personnage perso){
        listeEntitesGraphiques.add(new EntiteGraphique(perso, "/personnage.png"));
        for (Bloc bloc : n.getListeBlocs() ) {
            BlocGraphique blocGraphique = new BlocGraphique(bloc, cheminImagesBlocs.get(bloc.getType()));
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
        gc.fillText(temps + "s", TAILLE,(12*TAILLE)+TAILLE/2);
    }
}
