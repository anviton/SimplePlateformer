package couchegraphique;

import javafx.scene.image.Image;

public abstract class ProduitGraphique {
    Image image;


    public ProduitGraphique(String cheminImg) {
        this.image = new Image(String.valueOf(getClass().getResource(cheminImg)));
    }

    public Image getImage() {
        return image;
    }
}
