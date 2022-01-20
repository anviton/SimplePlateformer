package controleurs;

import couchegraphique.AfficheurJavaFX;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modele.*;
import modele.logique.ChargeurNiveau;
import modele.LesScores;
import modele.metier.Niveau;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ControleurMenu extends ControleurObservateur{

    private Jeu jeu;
    private Stage stage;
    private LesScores lesScores = null;

    public ControleurMenu(LesScores lesScores) {
        super();
        this.lesScores = lesScores;
    }

    public void quitter(ActionEvent buttonquitter) {
        Button b = (Button)buttonquitter.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }

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

    /*public void afficheNiveaux(ActionEvent bouttonScore) {
        Stage fenetreNiveaux = new Stage();
        BorderPane a;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/niveaux.fxml"));
        fxmlLoader.setController(new ControleurNiveaux(lesScores));
        try {
            a = fxmlLoader.load();
            Scene s = new Scene(a, 500, 500);
            fenetreNiveaux.setTitle("Niveaux");
            s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
            fenetreNiveaux.setScene(s);
            fenetreNiveaux.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void toNiveau(ActionEvent event) throws IOException {
        URL vue = getClass().getResource("/vues/niveaux.fxml");
        FXMLLoader chargeur = new FXMLLoader();
        chargeur.setController(new ControleurNiveaux());
        chargeur.setLocation(vue);
        Parent parent = chargeur.load();
        Scene scene = new Scene(parent,1000,1000);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void mettreAJour(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                stage.setMaximized(false);
                GridPane a;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/nouveauScore.fxml"));
                fxmlLoader.setController(new ControleurNouveauScore(lesScores, new Score(jeu.getChrono(), "anonyme", 1)));
                try {
                    a = fxmlLoader.load();
                    Scene s = new Scene(a, 1000, 1000);
                    s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
                    stage.setTitle("Score");
                    stage.setScene(s);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
