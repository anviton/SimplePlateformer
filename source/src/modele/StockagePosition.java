package modele;

import java.util.ArrayList;
import java.util.List;

public class StockagePosition {
    private final List<Position> listePositions;

    public StockagePosition() {
        this.listePositions = new ArrayList<>();
    }

    public void ajouterUnePosition(Position pos){
        listePositions.add(pos);
    }

    public Position getDernierePosition(){
        return listePositions.get(listePositions.size()-1);
    }
}
