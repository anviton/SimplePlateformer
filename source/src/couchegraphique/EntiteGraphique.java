package couchegraphique;

import modele.metier.Entite;

public class EntiteGraphique extends ProduitGraphique{
    private final Entite entite;

    public EntiteGraphique(Entite entite, String cheminImg) {
        super(cheminImg);
        this.entite = entite;
    }

    public Entite getEntite() {
        return entite;
    }

    @Override
    public String toString() {
        return "EntiteGrpahique{" +
                "img='" + image + '\'' +
                ", entité=" + entite +
                '}';
    }
}
