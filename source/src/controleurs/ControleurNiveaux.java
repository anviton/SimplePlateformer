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

/**
 * ControleurNiveau permet de controler la vue des niveaux
 * @author anviton khloichet
 */
public class ControleurNiveaux extends ControleurObservateur{

    private Jeu jeu;
    private Stage stage;
    private final LesScores lesScores;
    private int numNiveau;

    /**
     * Constructeur du ControleurNiveaux
     * @param lesScores vient setter l'attribut lesScores
     */
    public ControleurNiveaux(LesScores lesScores) {
        this.lesScores = lesScores;
    }

    /**
     * Permet de mettre en place les paramètres du niveau1
     * @param bouttonNiveau événement qui a appelé la méthode
     */
    public void afficheNiveau1(ActionEvent bouttonNiveau){
        Button b = (Button)bouttonNiveau.getSource();
        String chemin = "resources/niveaux/niveau1.niv";
        String nomNiveau = "Niveau 1";
        numNiveau = 1;
        this.lancerNiveau(b, chemin, nomNiveau);

    }

    /**
     * Permet de mettre en place les paramètres du niveau2
     * @param bouttonNiveau événement qui a appelé la méthode
     */
    public void afficheNiveau2(ActionEvent bouttonNiveau){
        Button b = (Button)bouttonNiveau.getSource();
        String chemin = "resources/niveaux/niveau2.niv";
        String nomNiveau = "Niveau 2";
        numNiveau = 2;
        this.lancerNiveau(b, chemin, nomNiveau);

    }

    /**
     * Permet de mettre en place les paramètres du niveau2
     * @param bouttonNiveau événement qui a appelé la méthode
     */
    public void afficheNiveau3(ActionEvent bouttonNiveau){
        Button b = (Button)bouttonNiveau.getSource();
        String chemin = "resources/niveaux/niveau3.niv";
        String nomNiveau = "Niveau 3";
        numNiveau = 3;
        this.lancerNiveau(b, chemin, nomNiveau);
    }

    /**
     * Permet d'afficher la vue d'enregistrement du score
     */
    @Override
    public void mettreAJour(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                stage.setMaximized(false);
                GridPane a;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/nouveauScore.fxml"));
                fxmlLoader.setController(new ControleurNouveauScore(lesScores,
                        new Score(jeu.getChrono(), "Anonyme", numNiveau)));
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

    /**
     * Permet de lancer un niveau
     * @param b bouton qui génère l'appel
     * @param chemin chemin du niveau a lancé
     * @param nomNiveau nom du niveau a lancé
     */
    private void lancerNiveau(Button b, String chemin, String nomNiveau){
        ChargeurNiveau chargeur =  new ChargeurNiveau();
        Niveau n = chargeur.chargerNiveau(chemin);

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
        stage.setTitle(nomNiveau);
        s.setRoot(scrollPane);
        jeu = new Jeu(n);
        jeu.lancerBoucleDeJeu(gc, s);
        jeu.attacher(this);

    }
}
