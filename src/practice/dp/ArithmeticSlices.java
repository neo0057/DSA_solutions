package practice.dp;

public class ArithmeticSlices {
    // O(n^2)
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 2; j < n; j++) {
                if (nums[j] - nums[j - 1] == diff) res++;
                else break;
            }
        }
        return res;
    }

    // O(n)
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int res = 0, c = 0;
        int prvDiff = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (prvDiff == diff) c++;
            else {
                prvDiff = diff;
                c = 0;
            }
            res += c;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
        System.out.println(arithmeticSlices.numberOfArithmeticSlices2(nums));
    }
}
