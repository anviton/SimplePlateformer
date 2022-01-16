package couchegraphique;

import javafx.scene.image.Image;
import modele.Entite;

public class EntiteGraphique extends ProduitGraphique{
    private Entite entite;

    public EntiteGraphique(Entite entite, String cheminImg) {
        super(cheminImg);
        this.entite = entite;
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
