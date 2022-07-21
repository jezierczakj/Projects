import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Denominator {
    public static int denominator(int a, int b, int c){
        List<Integer> array = new ArrayList<>();
        array.add(a);
        array.add(b);
        array.add(c);
        Collections.sort(array);
        int pom = 0;
        for (int i = 1; ; i ++){
            if( array.get(0) % i == 0)
                if( array.get(1) % i == 0)
                    if( array.get(2) % i == 0){
                        if (i > pom) pom = i;
                    }
            if ( i >= array.get(0)) break;
        }
            System.out.println(pom);
            return pom;

        }
    }

