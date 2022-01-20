package couchegraphique;


import javafx.scene.image.Image;
import modele.metier.Bloc;

/**
 * BlocGraphique est la base de nos blocs avec leurs chemins pour les images
 */

public class  BlocGraphique extends ProduitGraphique {
    Bloc bloc;

    /**
     * BlocGraphique constructeur d'un bloc
     * @param bloc bloc a associer a l'image
     * @param cheminImg chemin de l'image du bloc
     */

    public BlocGraphique(Bloc bloc, String cheminImg) {
        super(cheminImg);
        this.bloc = bloc;
    }

    /**
     * getBloc attrape un bloc
     * @return le bloc
     */

    public Bloc getBloc() {
        return bloc;
    }

    /**
     * toString écrit la description d'un bloc affichable
     * @return un texte pour tester les chemins des blocs
     */

    @Override
    public String toString() {
        return "BlocAffichable{" +
                "img='" + image + '\'' +
                ", bloc=" + bloc +
                '}';
    }

    /**
     * getImage attrape une image
     * @return une image
     */

    public Image getImage() {
        return image;
    }
}
