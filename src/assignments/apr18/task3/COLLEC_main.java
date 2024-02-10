package assignments.apr18.task3;

import java.util.ArrayList;
import java.util.Scanner;

public class COLLEC_main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int n = sc.nextInt();
        while (n > 0) {
            list.add(n / 2);
            n /= 2;
        }
        System.out.print("ArrayList contents: ");
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
