package controleurs;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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


    public void afficheNiveau(ActionEvent bouttonNiveau){
        Button b = (Button)bouttonNiveau.getSource();
        ChargeurNiveau chargeur =  new ChargeurNiveau();
        Niveau n = chargeur.chargerNiveau("resources/niveaux/niveau1.niv");

        this.stage = (Stage) b.getScene().getWindow();
        stage.setMaximized(true);
        Canvas c = new Canvas((n.getLargeurNiveau() + 1) * 50, (n.getHauteurNiveau() + 1) * 50);
        GraphicsContext gc = c.getGraphicsContext2D();
        Pane pane = new Pane();
        pane.getChildren().add(new ImageView(new Image(n.getCheminFond(), c.getWidth(), c.getHeight(), false, true)));
        pane.getChildren().add(c);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        Scene s = b.getScene();
        stage.setTitle("Niveau1");
        s.setRoot(scrollPane);
        jeu = new Jeu(n);
        jeu.lancerBoucleDeJeu(gc, s);
        jeu.attacher(this);

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
