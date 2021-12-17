package modele;


public class  BlocGraphique {
    String img;
    Bloc bloc;

    public BlocGraphique(Bloc bloc, String img) {
        this.bloc = bloc;
        this.img = img;
    }


    public Bloc getBloc() {
        return bloc;
    }

    private void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    @Override
    public String toString() {
        return "BlocAffichable{" +
                "img='" + img + '\'' +
                ", bloc=" + bloc +
                '}';
    }
}
