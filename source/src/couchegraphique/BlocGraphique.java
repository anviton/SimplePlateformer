package couchegraphique;


import javafx.scene.image.Image;
import modele.Bloc;

public class  BlocGraphique extends ProduitGraphique {
    Bloc bloc;

    public BlocGraphique(Bloc bloc, String cheminImg) {
        super(cheminImg);
        this.bloc = bloc;
    }

    public Bloc getBloc() {
        return bloc;
    }

    @Override
    public String toString() {
        return "BlocAffichable{" +
                "img='" + image + '\'' +
                ", bloc=" + bloc +
                '}';
    }

    public Image getImage() {
        return image;
    }
}
