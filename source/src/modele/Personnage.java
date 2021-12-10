package modele;

public class Personnage extends Affichable{
    private String nom;
    private int nombreDeVies;
    private boolean vivant;
    private Objet[] listObjets = new Objet[3]; // le personnage peut posséder 3 objets simultanément maximum
    private int nbObjets;

    public Personnage(String nom, String image, HitBox collision) {
        super(image, collision);
        this.nom=nom;
        this.nombreDeVies = 3;
        this.vivant = true;
        this.nbObjets = 0;
    }

    public String getNom() { return nom; }

    public int getNombreDeVies() {
        return nombreDeVies;
    }

    private void setNombreDeVies(int nombreDeVies) {
        this.nombreDeVies = nombreDeVies;
    }

    public boolean getVivant() {
        return vivant;
    }

    private void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public Objet[] getListObjets() { return listObjets; }

    public int getNbObjets() { return nbObjets; }

    public void setNbObjets(int nbObjets) { this.nbObjets = nbObjets; }

    @Override
    public String toString() {
        String message;
        message = "Personnage{" + super.toString() +
                ", nom=" + nom +
                ", nombre de vies=" + nombreDeVies +
                ", liste d'objet : " + nbObjets + " ";
                for (int i=0; i < listObjets.length; i++) {
                    if(listObjets[i] == null){
                        return message;
                    }
                    message = message + listObjets[i].getNomObj() + " --> " + listObjets[i].getDescription() + " / ";
                }
        return message;
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
