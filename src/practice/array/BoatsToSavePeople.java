package practice.array;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l < r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            res++;
        }
        if (l == r) res++;
        return res;
    }

    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        int[] people2 = {3, 2, 2, 1};
        BoatsToSavePeople boats = new BoatsToSavePeople();
        System.out.println(boats.numRescueBoats(people, 5));
        System.out.println(boats.numRescueBoats(people2, 3));
    }
}
