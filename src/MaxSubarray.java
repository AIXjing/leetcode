/**
 * @Source: https://leetcode.com/problems/maximum-subarray/
 */


import java.util.HashMap;

public class MaxSubarray {
    // calculate all the sums O(n2)
    public static int maxSubArray0 (int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> maxSubarray = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = nums[i];
            int maxSum = key;
            int tmpSum = key;
            for (int j = i + 1;j < len; j++) {
                tmpSum = tmpSum + nums[j];
                if (tmpSum >= maxSum) {
                    maxSum = tmpSum;
                }
            }
            if (maxSubarray.containsKey(key) && maxSubarray.get(key) >= maxSum) {
                continue;
            } else {
                maxSubarray.put(key, maxSum);
            }
        }
        int max = maxSubarray.get(nums[0]);
        for (int n : nums) {
            if (maxSubarray.get(n) > max) {
                max = maxSubarray.get(n);
            }
        }
        return max;
    }

    public static int maxSubArray1 (int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }


    public static void main (String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("two for loops: " + maxSubArray0(nums));
        System.out.println("one for loops: " + maxSubArray1(nums));
    }
}
