package modele;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class AfficheurJavaFX extends Afficheur{
    private GraphicsContext gc;
    private List<EntiteGraphique> listeEntitesGraphiques;

    public AfficheurJavaFX(GraphicsContext gc) {
        this.gc = gc;
        this.listeEntitesGraphiques = new ArrayList<>();
    }

    public AfficheurJavaFX() {
        Canvas c = new Canvas(1500, 1500);
        gc = c.getGraphicsContext2D();
    }

    @Override
    public void mettreAjourLAffichageDuPersonnagePrincipal(Personnage p, double ancienPositionX, double ancienPositionY){
        //EntiteGraphique e = new EntiteGraphique(p, "/personnage.png");
        int taillePerso = 50;

        if (ancienPositionX != listeEntitesGraphiques.get(0).getEntite().getPositionX() || ancienPositionY != listeEntitesGraphiques.get(0).getEntite().getPositionY()) {
            this.gc.drawImage(new Image(listeEntitesGraphiques.get(0).getImg()), listeEntitesGraphiques.get(0).getEntite().getPositionX()*taillePerso,
                    listeEntitesGraphiques.get(0).getEntite().getPositionY()*taillePerso, taillePerso, taillePerso);
            this.gc.clearRect(ancienPositionX * taillePerso, ancienPositionY * taillePerso, p.getHitbox().getLargeur(),
                    p.getHitbox().getHauteur());
        }

    }

    @Override
    public void afficherLeNiveau(Niveau n, List<String> cheminImagesBlocs, Personnage peso){
        int largeurBloc = 50;
        listeEntitesGraphiques.add(new EntiteGraphique(peso, "/personnage.png"));
        for (Bloc bloc : n.getListeBlocs() ) {
            BlocGraphique blocGraphique = new BlocGraphique(bloc, cheminImagesBlocs.get(bloc.getType()));
            this.gc.drawImage(new Image(blocGraphique.getImg()), blocGraphique.getBloc().getPositionX()*largeurBloc, blocGraphique.getBloc().getPositionY()*largeurBloc, largeurBloc, largeurBloc);
        }
        this.gc.drawImage(new Image(listeEntitesGraphiques.get(0).getImg()), listeEntitesGraphiques.get(0).getEntite().getPositionX()*largeurBloc,
                listeEntitesGraphiques.get(0).getEntite().getPositionY()*largeurBloc, largeurBloc, largeurBloc);
    }

    @Override
    public void mettreAJourLAffichageDuTemps(int temps){
        gc.setFont(new Font(20));
        gc.setFill(Color.WHITE);
        gc.fillRect(1*50, 12*50, 50,50);
        gc.setFill(Color.RED);
        gc.fillText(temps + "s",1*50,(12*50)+25);
    }
}
