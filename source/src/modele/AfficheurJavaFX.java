package modele;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class AfficheurJavaFX extends Afficheur{
    private GraphicsContext gc;
    private List<EntiteGraphique> listeEntites;

    public AfficheurJavaFX(GraphicsContext gc) {
        this.gc = gc;
        this.listeEntites = new ArrayList<>();
    }

    public AfficheurJavaFX() {
        Canvas c = new Canvas(1500, 1500);
        gc = c.getGraphicsContext2D();
    }

    public void mettreAjourLAffichageDuFond(String fond){
        gc.drawImage(new Image(fond), 0, 0, 3000, 2200);
    }

    public void mettreAjourLAffichageDuPersonnagePrincipal(Personnage p, double ancienPositionX, double ancienPositionY){
        //EntiteGraphique e = new EntiteGraphique(p, "/personnage.png");
        int taillePerso = 50;

        if (ancienPositionX != listeEntites.get(0).getEntite().getPositionX() || ancienPositionY != listeEntites.get(0).getEntite().getPositionY()) {
            this.gc.clearRect(ancienPositionX * taillePerso, ancienPositionY * taillePerso, p.getHitbox().getLargeur(),
                    p.getHitbox().getHauteur());
            this.gc.drawImage(new Image(listeEntites.get(0).getImg()), listeEntites.get(0).getEntite().getPositionX()*taillePerso,
                    listeEntites.get(0).getEntite().getPositionY()*taillePerso, taillePerso, taillePerso);
        }

    }

    public void afficherLeNiveau(Niveau n, List<String> cheminImagesBlocs, Personnage p){
        int largeurBloc = 50;
        listeEntites.add(new EntiteGraphique(p, "/personnage.png"));
        for (Bloc bloc : n.getListeBlocAffichable() ) {
            BlocGraphique blocGraphique = new BlocGraphique(bloc, cheminImagesBlocs.get(bloc.getType()));
            this.gc.drawImage(new Image(blocGraphique.getImg()), blocGraphique.getBloc().getPositionX()*largeurBloc, blocGraphique.getBloc().getPositionY()*largeurBloc, largeurBloc, largeurBloc);
        }
        this.gc.drawImage(new Image(listeEntites.get(0).getImg()), listeEntites.get(0).getEntite().getPositionX()*largeurBloc,
                listeEntites.get(0).getEntite().getPositionY()*largeurBloc, largeurBloc, largeurBloc);
    }
}
