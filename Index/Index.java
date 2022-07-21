import java.util.*;
public class Index {
    static public int Index(int a, int b, int c, int d){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(a);
        array.add(b);
        array.add(c);
        array.add(d);
        for (int i = 0; i < array.size(); i++){
            if( array.get(i) == i) {
                System.out.println(i);
                return i;
            }

        }
    return 0;
    }
}
