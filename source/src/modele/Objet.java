package modele;

public class Objet extends Affichable{
    private String nomObj;
    private String description;

    public Objet(String nom, String description, String image, HitBox collision){
        super(image, collision);
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
