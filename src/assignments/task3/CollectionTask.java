package assignments.task3;

import java.util.ArrayList;

public class CollectionTask {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = 25;
        while (n > 0) {
            list.add(n/2);
            n /= 2;
        }
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
