package controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Score;
import modele.LesScores;


public class ControleurListeScores {
    @FXML
    private TableView<Score> table;

    private LesScores lesScores;

    private final TableColumn<Score, String> columnNom = new TableColumn<>("Nom");
    private final TableColumn<Score, Integer> colonneNiveau = new TableColumn<>("Niveau");
    private final TableColumn<Score, Integer> colonneTemps = new TableColumn<>("Temps");

    public ControleurListeScores(LesScores lesScores) {
        this.lesScores = lesScores;
    }

    public void initialize() {
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        table.getColumns().add(columnNom);

        colonneNiveau.setCellValueFactory(new PropertyValueFactory<>("numNiveau"));
        table.getColumns().add(colonneNiveau);

        colonneTemps.setCellValueFactory(new PropertyValueFactory<>("temps"));
        table.getColumns().add(colonneTemps);

        table.itemsProperty().bind(lesScores.lesScoresProperty());

    }
}
