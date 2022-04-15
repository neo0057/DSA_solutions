package practice.backtracking;

public class EqualPartitioning {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        if (len < k) return false;
        int sum = 0;
        for (int i = 0; i < len; i++) sum += nums[i];
        if (sum % k > 0) return false;
        boolean[] used = new boolean[len];
        return partition(k, sum/k, 0, nums, used, 0);
    }
    private boolean partition(int k, int sum, int cs, int[] nums, boolean[] used, int start) {
        if (k == 1) return true;
        if (cs == sum) return partition(k - 1, sum, 0, nums, used, 0);
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cs + nums[i] <= sum) {
                used[i] = true;
                if (partition(k, sum, cs + nums[i], nums, used, i + 1)) return true;
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2};
        EqualPartitioning equalPartitioning = new EqualPartitioning();
        System.out.println(equalPartitioning.canPartitionKSubsets(arr, 4));
    }
}
