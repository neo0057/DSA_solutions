package practice.array;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int i = 0;
        while (i < arr.length) {
            while (i + 1 < arr.length && arr[i] > arr[i + 1]) i++;
            res++;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        int[] arr2 = {1, 0, 2, 3, 4};
        MaxChunksToMakeSorted maxChunksToMakeSorted = new MaxChunksToMakeSorted();
        System.out.println(maxChunksToMakeSorted.maxChunksToSorted(arr));
        System.out.println(maxChunksToMakeSorted.maxChunksToSorted(arr2));
    }
}
