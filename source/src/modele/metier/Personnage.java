package modele.metier;

public class Personnage extends Entite {
    private final String nom;
    private int nombreDeVies;
    private final Objet[] listObjets = new Objet[3]; // le personnage peut posséder 3 objets simultanément maximum
    private int nbObjets;

    public Personnage(String nom, int posX, int posY, HitBox hitbox) {
        super(posX, posY, hitbox);
        this.nom=nom;
        this.nombreDeVies = 3;
        this.nbObjets = 0;
    }

    public String getNom() { return nom; }

    public int getNombreDeVies() {
        return nombreDeVies;
    }

    public void setNombreDeVies(int nombreDeVies) {
        this.nombreDeVies = nombreDeVies;
    }

    public Objet[] getListObjets() { return listObjets; }

    public int getNbObjets() { return nbObjets; }

    public void setNbObjets(int nbObjets) { this.nbObjets = nbObjets; }


    @Override
    public String toString() {
        StringBuilder message;
        message = new StringBuilder("Personnage{" + super.toString() +
                ", nom=" + nom +
                ", nombre de vies=" + nombreDeVies +
                ", liste d'objet : " + nbObjets + " ");
        for (Objet listObjet : listObjets) {
            if (listObjet == null) {
                return message.toString();
            }
            message.append(listObjet.getNomObj()).append(" --> ").append(listObjet.getDescription()).append(" / ");
        }
        return message.toString();
    }

    public int mourir(){
        setNombreDeVies(this.nombreDeVies - 1);
        return nombreDeVies;
    }

    public Objet[] prendreObjet(Objet item){
        if(nbObjets == 3){
            System.out.println("Inventaire plein");
        }
        else{
            listObjets[nbObjets] = item;
            setNbObjets(this.nbObjets + 1);
        }
        return listObjets;
    }

    public Objet[] utiliserObjet(){
        if(nbObjets == 0){
            System.out.println("Inventaire vide");
        }
        else{
            listObjets[nbObjets-1] = null;
            setNbObjets(this.nbObjets - 1);
        }
        return listObjets;
    }
}
