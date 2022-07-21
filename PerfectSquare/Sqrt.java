import java.util.*;
public class Sqrt {
    public static List<Integer> sqrt(double n){
    List<Integer> array;

        array = new ArrayList<>();


        double rest = 0;
        double square;
        int i;
        int pom = 0;
        square = Math.sqrt(n);
        while (n > 0){
            for ( i = 0; i < n ;i ++){
                 if ( i > square) {
                     pom = i-1;
                     break;
                 }
            }
            array.add(pom);
            n -= pom*pom;
            if ( n == 1){
                array.add(1);
                break;
            }
            else square = Math.sqrt(n);
            rest = Math.sqrt(square);
        }
        System.out.println(array);
        return array;

        }

    }

