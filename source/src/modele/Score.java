package modele;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Score{
    /*private final int temps;
    private final String nom;
    private final int numNiveau;*/
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


    public Score(int temps, String nom, int numNiveau) {
        this.temps.setValue(temps);
        this.numNiveau.setValue(numNiveau);
        this.nom.setValue(nom);
    }

    /*public int getTemps() {
        return temps;
    }

    public String getNom() {
        return nom;
    }

    public int getNumNiveau() {
        return numNiveau;
    }*/

}
