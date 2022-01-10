package modele;

public abstract class Deplaceur {
    protected Niveau niveau;

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public abstract void deplacerPersonnagePrincipal(Personnage perso);
    public abstract boolean gererLaGravite(Personnage perso);
}
