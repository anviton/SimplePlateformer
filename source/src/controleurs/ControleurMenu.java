package controleurs;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import modele.LesScores;


import java.io.IOException;
import java.net.URL;

/**
 * ControleurMenu permet de contrôler la vue du menu
 */
public class ControleurMenu{

    private final LesScores lesScores;

    /**
     * Constructeur du ControleurMenu
     * @param lesScores vient setter l'attribut les scores
     */
    public ControleurMenu(LesScores lesScores) {
        this.lesScores = lesScores;
    }

    /**
     * Permet de fermer l'application
     * @param buttonquitter boutton qui a appelé la méthode
     */
    public void quitter(ActionEvent buttonquitter) {
        Button b = (Button)buttonquitter.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }

    /**
     * Permet d'afficher les scores
     * @param bouttonScore boutton qui a appelé la méthode
     */
    public void afficheScores(ActionEvent bouttonScore) {
        Stage fenetreScores = new Stage();
        BorderPane a;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/listeScores.fxml"));
        fxmlLoader.setController(new ControleurListeScores(lesScores));
        try {
            a = fxmlLoader.load();
            Scene s = new Scene(a, 500, 500);
            fenetreScores.setTitle("Scores");
            s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
            fenetreScores.setScene(s);
            fenetreScores.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet d'afficher la sélection d'un niveau
     * @param event
     */
    public void toNiveau(ActionEvent event) {
        URL vue = getClass().getResource("/vues/niveaux.fxml");
        FXMLLoader chargeur = new FXMLLoader();
        chargeur.setController(new ControleurNiveaux(lesScores));
        chargeur.setLocation(vue);
        Parent parent = null;
        try {
            parent = chargeur.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent,1000,1000);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
