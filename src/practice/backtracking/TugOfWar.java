package practice.backtracking;

import java.util.Arrays;

public class TugOfWar {
    private int minimumDiff;

    public void printSet(int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        int size = arr.length;
        boolean[] currElements = new boolean[size];
        boolean[] solutions = new boolean[size];
        minimumDiff = Integer.MAX_VALUE;
        printSetRec(arr, size, totalSum, 0, 0, 0, currElements, solutions);
        System.out.print("printing 1st set: ");
        for (int i = 0; i < size; i++) {
            if (solutions[i]) System.out.print(arr[i] + " ");
        }
        System.out.print("\nprinting 2nd set: ");
        for (int i = 0; i < size; i++) {
            if (!solutions[i]) System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    private void printSetRec(int[] arr, int size, int totalSum, int currSum, int currIndex, int numberOfSelectedNumbers, boolean[] currElements, boolean[] solutions) {
        if (currIndex >= size) return;
        if ((size / 2 - numberOfSelectedNumbers) > size - currIndex) return;
        printSetRec(arr, size, totalSum, currSum, currIndex + 1, numberOfSelectedNumbers, currElements, solutions);
        numberOfSelectedNumbers++;
        currSum += arr[currIndex];
        currElements[currIndex] = true;
        if (numberOfSelectedNumbers == (size / 2)) {
            if (Math.abs(totalSum / 2 - currSum) < minimumDiff) {
                minimumDiff = Math.abs(totalSum / 2 - currSum);
                for (int i = 0; i < size; i++) solutions[i] = currElements[i];
            }
        } else {
            printSetRec(arr, size, totalSum, currSum, currIndex + 1, numberOfSelectedNumbers, currElements, solutions);
        }
        currElements[currIndex] = false;
    }

    public static void main(String[] args) {
        TugOfWar tugOfWar = new TugOfWar();
        int[] arr = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        tugOfWar.printSet(arr);
    }
}
