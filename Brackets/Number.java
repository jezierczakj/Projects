import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Number {
    int tab[] = new int[]{ 1, 2, 3, 3, -3, 4, 5, 6, 3, 0, -1};
    List<Integer> plus;
Number(){
    plus = new ArrayList<>();
}
public void Number() {
    for (int i = 0; i < tab.length; i++) {
        if (tab[i] > 0) {
            plus.add(tab[i]);
        }
    }
    Collections.sort(plus);
    for ( int j = 1; j < plus.size()+1; j++) {
        if(j < plus.size()-1){
    if (plus.get(j) == plus.get(j+1)) {
        plus.remove(plus.get(j + 1));
        j--;
    }
    }
    }
    Collections.sort(plus);
    int a = (1+plus.get(plus.size()-1));
    for ( int j = 1; j < plus.size()+1; j++) {
        if (plus.get(j-1) != j){
            System.out.println("Brakująca liczba to: " + j);
            break;
        }
        else if (j == plus.size()) {
            System.out.println("Brakująca liczba to: " + a);
            break;
        }

    }
}
}