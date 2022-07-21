import java.util.*;
public class Digits {
    static ArrayList<Integer> digits(int x, int y, int z, int q) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(x);
        numbers.add(y);
        numbers.add(z);
        numbers.add(q);

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            for (number = number; number > 0; number /= 10) {
                list.add(number % 10);


            }
        }
        Collections.sort(list);
        System.out.println(list);
        return (list);
    }
}
