package couchegraphique;

import javafx.scene.image.Image;

/**
 * ProduitGraphique classe abstraite pour relier un produit graphique a son image
 */

public abstract class ProduitGraphique {
    Image image;

    /**
     * ProduitGraphique constructeur d'un produit graphique
     * @param cheminImg
     */

    public ProduitGraphique(String cheminImg) {
        this.image = new Image(String.valueOf(getClass().getResource(cheminImg)));
    }

    /**
     * getImage attrape une image
     * @return une image
     */

    public Image getImage() {
        return image;
    }
}
