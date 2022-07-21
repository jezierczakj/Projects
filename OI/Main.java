import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n, postersCount = 0, d, w;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> listW = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        for (int i = 0; i < n; i++){
            d = scan.nextInt();
            w = scan.nextInt();
            listW.add(w);
        }
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && stack.getLast() > listW.get(i)){
                stack.removeLast();
            }
            if(stack.isEmpty() || stack.getLast() < listW.get(i)){
                stack.add(listW.get(i));
                postersCount++;
            }
        }
        System.out.println(postersCount);
    }
}
