package modele.metier;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Musique {

    private Thread musiqueThread;

    public void playSound(){
        String musicFile = "C:\\Users\\khris\\Documents\\2A\\Projet_Java2\\projet_conception_prog_obj\\source\\resources\\musique\\drm64_wario4.wav";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        musiqueThread  = new Thread(() -> {
            while (true){
                mediaPlayer.play();
            }
        });
        musiqueThread.start();
    }

    /*public void stopMusique(){
        musiqueThread.stop();
    }*/
}
