package modele;


public class BlocAffichable {
    String img;
    Bloc bloc;

    public BlocAffichable(Bloc bloc, String img) {
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
