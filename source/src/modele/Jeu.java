package modele;

public class Jeu implements Runnable{

    private Thread threadInterne;
    private boolean jeuEncours;

    public void lancerBoucleDeJeu(){
        threadInterne = new Thread(this);
        threadInterne.start();
    }

    @Override
    public void run() {
        int i = 0;
        jeuEncours = true;
        while (jeuEncours){
            System.out.println("toto" + i);
            i++;
            if(i == 8){
                jeuEncours = false;
            }
            try {
                threadInterne.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Le jeu est fini");

    }

    public boolean isJeuEncours() {
        return jeuEncours;
    }

    public void setJeuEncours(boolean jeuEncours) {
        this.jeuEncours = jeuEncours;
    }
}
