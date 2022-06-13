package practice.array;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int r = n - 2;
        while (r >= 0 && arr[r] >= arr[r + 1]) r--;
        if (r < 0) {
            Arrays.sort(arr);
            return;
        }
        int i = n - 1;
        while (i >= 0 && arr[r] >= arr[i]) i--;
        swap(arr, r, i);
        Arrays.sort(arr, r + 1, n);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String biggerIsGreater(String word) {
        char[] words = word.toCharArray();
        int n = words.length;
        int r = n - 2;
        while (r >= 0 && words[r] >= words[r + 1]) r--;
        if (r < 0) return "no answer";
        int i = n - 1;
        while (i >= 0 && words[r] >= words[i]) i--;
        swap(words, r, i);
        Arrays.sort(words, r + 1, n);
        return new String(words);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        System.out.println(biggerIsGreater("ab"));
        System.out.println(biggerIsGreater("bb"));
        System.out.println(biggerIsGreater("hefg"));
        System.out.println(biggerIsGreater("dhck"));
        System.out.println(biggerIsGreater("dkhc"));
    }
}
