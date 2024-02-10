package assignments.apr29.task4;

import java.util.ArrayList;
import java.util.Arrays;

public class COLLEC_main {
    public ArrayList<Integer> createStarterList(int[] a) {
        ArrayList<Integer> result = new ArrayList<>(a.length);
        // iterate over int array and push into in result arraylist
        for (int num : a) {
            result.add(num + 1);
        }
        return result;
    }

    public ArrayList<Integer> makeSum(ArrayList<Integer> myList, int start) {
        while (true) {
            int sum = 0;
            for (Integer num : myList) {
                // if number is greater than start, then add it in sum variable
                if (num > start) {
                    sum += num;
                }
            }
            // increment by 1
            sum += 1;
            // check if sum is less than or equal 140, if yes, then add into myList
            if (sum <= 140) myList.add(sum);
            // break from while loop if sum is greater than 140
            else break;
        }
        return myList;
    }

    public static void main(String[] args) {

        COLLEC_main collec_main = new COLLEC_main();

        ArrayList<Integer> myList1 = new ArrayList<>(Arrays.asList(3, 5, 68, 14));
        System.out.println(collec_main.makeSum(myList1, 14));
        System.out.println(collec_main.createStarterList(new int[]{2, 8, 7, 7}));

    }
}
