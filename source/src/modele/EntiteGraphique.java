package modele;

import javafx.scene.image.Image;

public class EntiteGraphique {
    Image image;
    Entite entite;

    public EntiteGraphique(Entite entite, String cheminImg) {
        this.entite = entite;
        this.image = new Image(cheminImg);
    }

    public Image getImage() {
        return image;
    }

    public Entite getEntite() {
        return entite;
    }

    private void setEntite(Entite entite) {
        this.entite = entite;
    }

    @Override
    public String toString() {
        return "EntiteGrpahique{" +
                "img='" + image + '\'' +
                ", entité=" + entite +
                '}';
    }
}
