package modele;


import javafx.scene.image.Image;

public class  BlocGraphique {
    Image image;
    Bloc bloc;

    public BlocGraphique(Bloc bloc, String cheminImg) {
        this.bloc = bloc;
        this.image = new Image(cheminImg);
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
