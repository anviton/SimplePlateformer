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

public class ControleurNiveaux extends ControleurObservateur{

    private Jeu jeu;
    private Stage stage;
    private LesScores lesScores = null;

    public ControleurNiveaux() {
        super();
    }

    public void toNiveau(ActionEvent event) throws IOException{
        /*Parent root = FXMLLoader.load(Objects.requireNonNull(AfficheurJavaFX.class.getResource("/vues/niveaux.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 1000);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();*/
        URL vue = getClass().getResource("/vues/niveaux.fxml");
        Parent parent = FXMLLoader.load(vue);
        Scene scene = new Scene(parent);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void afficheNiveau1(ActionEvent bouttonNiveau){
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

    public void afficheNiveau2(ActionEvent bouttonNiveau){
        Button b = (Button)bouttonNiveau.getSource();
        ChargeurNiveau chargeur =  new ChargeurNiveau();
        Niveau n = chargeur.chargerNiveau("resources/niveaux/niveau2.niv");

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

    public void afficheNiveau3(ActionEvent bouttonNiveau){
        Button b = (Button)bouttonNiveau.getSource();
        ChargeurNiveau chargeur =  new ChargeurNiveau();
        Niveau n = chargeur.chargerNiveau("resources/niveaux/niveau3.niv");

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
