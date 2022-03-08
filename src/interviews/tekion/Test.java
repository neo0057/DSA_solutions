package interviews.tekion;

/**
 * One array of integers is given as an input ,which is initially increasing and then decreasing or it can be only increasing or decreasing ,
you need to find the maximum value in the array in O(Log n)

 4 8 9 10 35 50 48 20 12 2

 4 8 9 10 35 50 55 56 48 42

1. increasing and then decreasing
 2. increasing
 3. decreasing
 */
public class Test {

    public static int findMaxElement(int[] arr) {
        int mid, n = arr.length;
        if (n == 1) return arr[0];
        int left = 0, right = n - 1;
        while(left < right) {
            mid = (left + right)/2;
            int ele = arr[mid];
            if ((mid - 1 >= 0 && ele > arr[mid - 1]) && ele > arr[mid + 1]) return ele;
            if ((mid - 1 >= 0 && ele > arr[mid - 1]) && (mid + 1 < n && ele < arr[mid + 1])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int arr[] = {4, 8, 9, 10, 35, 50, 48, 20, 12, 2};
        int arr[] = {4, 8, 9, 10, 35, 50, 55, 56, 58};
//        int arr[] = {1,3,4,6,7};
//        int arr[] = {5,4,3,2,1};
        int n = arr.length;
        int ele = findMaxElement(arr);
        int res =Math.max((ele >= 0) ? ele : -1, Math.max(arr[0], arr[n - 1]));
        System.out.println(res);
    }
}
