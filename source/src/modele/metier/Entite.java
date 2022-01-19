package modele.metier;

import modele.Position;

public abstract class Entite extends Composant{


    public Entite(int posX, int posY, HitBox hb){
        super(posX, posY, hb);
    }

    public Position creerMemento(){
        return new Position(this.getPositionX(), this.getPositionY());
    }

    public void setCoordonnees(Position position){
        this.setPositionX(position.getX());
        this.setPositionY(position.getY());
    }


}
