package modele.metier;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Musique {

    private Thread musiqueThread;

    public void playSound(){
        /*String musicFile = "resources/musique/drm64_wario4.wav";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        musiqueThread  = new Thread(() -> {
            while (true){
                mediaPlayer.play();
            }
        });
        musiqueThread.start();*/
    }

    /*public void stopMusique(){
        musiqueThread.stop();
    }*/
}
