package practice.array;

import java.util.Arrays;

public class RearrangeArray {

    public int[] rearrangeArray(int[] nums) {
        int id = 0, pId = 0, nId = 0;
        int len = nums.length;
        int[] res = new int[len];
        boolean isPositive = true;
        if (nums[0] > 0) {
            id = 1;
            pId = 1;
            nId = 1;
            res[0] = nums[0];
            isPositive = false;
        }
        while (id < len) {
            if (isPositive) {
                while (pId < len && nums[pId] < 0) pId++;
                res[id++] = nums[pId++];
            } else {
                while (nId < len && nums[nId] > 0) nId++;
                res[id++] = nums[nId++];
            }
            isPositive = !isPositive;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] nums2 = {-1,1};
        RearrangeArray rearrangeArray = new RearrangeArray();
        System.out.println(Arrays.toString(rearrangeArray.rearrangeArray(nums2)));
    }
}
