package interviews.goldmansachs;

public class Round1 {

    /*
     Instructions to candidate.
      1) Your task is ultimately to implement a function that takes in an array of non-negative numbers and an integer.
       You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
       and -1 if no such sum exists.
      2) Run this code in the REPL to observe its behaviour. The
       execution entry point is main().
      3) Consider adding some additional tests in doTestsPass().
      4) Implement subArrayExceedsSum() correctly.
      5) If time permits, some possible follow-ups.
    */
    public static int subArrayExceedsSum(int[] arr, int target) {
        int i = 0, j = 0;
        int sum = 0, len = arr.length;
        int res = len + 1;
        while (j < len) {
            System.out.println(i + ":" + j);
            while (j < len && sum < target) {
                sum += arr[j];
                j++;
            }
            while (sum > target && i < len) {
                res = Math.min(res, j - i);
                sum -= arr[i];
                i++;
            }
        }
        System.out.println(res + "\n\n");
        return res;
    }

    public static boolean doTestsPass() {
        boolean result = true;
        int[] arr = {1, 2, 3, 4};
        int[] arr1 = {3, 1, 3, 1, 4, 2};
//        result = result && subArrayExceedsSum(arr, 6) == 2;
        result = result && subArrayExceedsSum(arr, 12) == -1;
//        result = result && subArrayExceedsSum(arr1, 7) == 3;
//        result = result && subArrayExceedsSum(arr1, 12) == 6;
        return result;
    }

    ;

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All tests pass\n");
        } else {
            System.out.println("There are test failures\n");
        }
    }
}
// Nikhil Tulsyan