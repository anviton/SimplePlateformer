import modele.Bloc;
import modele.BlocAffichable;
import modele.HitBox;

import java.util.ArrayList;
import java.util.List;

public class TestCreationDeBLoc {
    public static void main(String[] args){
        //Bloc blocTest = new Bloc(1, 0,0);
        //System.out.println(blocTest);
        List<String> listeCheminImageBloc = new ArrayList<String>();
        listeCheminImageBloc.add("/personnage.png");
        int id = 0 ;
        BlocAffichable blocAffichableTest = new BlocAffichable(new Bloc(id, 0 , 0), listeCheminImageBloc.get(id));

        System.out.println(blocAffichableTest);
    }
}
