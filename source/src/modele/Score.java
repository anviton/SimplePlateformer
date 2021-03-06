package modele;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Score stocke les information d'un score
 * @author anviton khloichet
 */
public class Score implements Comparable{

    private final StringProperty nom = new SimpleStringProperty();
    public String getNom() {return nom.get();}
    public void setNom(String value) {nom.set(value);}
    public StringProperty nomProperty() {return nom;}

    private final ObjectProperty<Integer> numNiveau = new SimpleObjectProperty<>();
    public int getNumNiveau() {return numNiveau.get();}
    public void setNumNiveau(int value) {numNiveau.set(value);}
    public ObjectProperty<Integer> numNiveauProperty() {return numNiveau;}

    private final ObjectProperty<Integer> temps = new SimpleObjectProperty<>();
    public int getTemps() {return temps.get();}
    public void setTemps(int value) {temps.set(value);}
    public ObjectProperty<Integer> tempsProperty() {return temps;}

    /**
     * Constructeur de la classe Score
     * @param temps temps mis pour le niveau
     * @param nom nom du joueur
     * @param numNiveau numéro du niveau
     */
    public Score(int temps, String nom, int numNiveau) {
        this.temps.setValue(temps);
        this.numNiveau.setValue(numNiveau);
        this.nom.setValue(nom);
    }

    @Override
    public int compareTo(Object o) {
        if (this.getTemps() > ((Score)o).getTemps()){
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Score{" +
                "nom=" + nom +
                ", numNiveau=" + numNiveau +
                ", temps=" + temps +
                '}';
    }

}
