import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        GridPane a = FXMLLoader.load(getClass().getResource("/Vues/menu.fxml"));
        Scene s = new Scene(a, 500, 500);
        s.getStylesheets().add(getClass().getResource("/Vues/style.css").toExternalForm());
        stage.setTitle("Menu Principal");
        stage.setScene(s);
        stage.show();
    }
}
