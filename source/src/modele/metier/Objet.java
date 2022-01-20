package modele.metier;



public class Objet extends Entite {
    private final String nomObj;
    private final String description;

    public Objet(String nom, String description, int posX, int posY, HitBox hitbox){
        super(posX, posY, hitbox);
        this.nomObj = nom;
        this.description = description;
    }

    public String getNomObj() {
        return nomObj;
    }

    public String getDescription() {
        return description;
    }
}