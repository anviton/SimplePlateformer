package modele;

public abstract class Entite extends Composant implements Runnable{


    public Entite(int posX, int posY, HitBox hb){
        super(posX, posX, hb);
    }

    @Override
    public void run() { System.out.println("Coucou"); }

    public Position creerMemento(){
        return new Position(this.getPositionX(), this.getPositionY());
    }

    public void setCoordonnees(Position position){
        this.setPositionX(position.getX());
        this.setPositionY(position.getY());
    }


}
