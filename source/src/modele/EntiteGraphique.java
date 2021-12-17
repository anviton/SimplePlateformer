package modele;

public class EntiteGraphique {
    String img;
    Entite entite;

    public EntiteGraphique(Entite entite, String img) {
        this.entite = entite;
        this.img = img;
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
                "img='" + img + '\'' +
                ", entité=" + entite +
                '}';
    }
}
