import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    static List<String> permutation(String a, String b, String c, String d){
        List<String> pom;
        pom = new ArrayList<>();
        int P[] = new int[] {3, 1, 2, 0};
        List<String> array  = (Arrays.asList(a, b, c, d));
    for ( int i = 0; i < array.size(); i++) {
        System.out.println(array.get(P[i]));
        pom.add(array.get(P[i]));
    }
    return pom;
    }
}