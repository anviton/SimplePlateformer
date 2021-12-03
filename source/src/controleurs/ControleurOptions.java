package controleurs;

import javafx.scene.input.MouseEvent;

public class ControleurOptions {
    private boolean theme = false;


    public void actionTheme(MouseEvent mouseEvent) {
        if (theme == false){
            theme = true;
        }
        else {
            theme =false;
        }
    }
}
