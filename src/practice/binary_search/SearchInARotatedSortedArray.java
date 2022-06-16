package practice.binary_search;

public class SearchInARotatedSortedArray {
    public int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) return m;
            if (arr[m] >= arr[l]) {
                if (target < arr[m] && target >= arr[l]) r = m - 1;
                else l = m + 1;
            } else {
                if (target > arr[m] && target <= arr[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInARotatedSortedArray search = new SearchInARotatedSortedArray();
        System.out.println(search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
