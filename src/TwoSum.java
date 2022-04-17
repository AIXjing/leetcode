import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Source: https://leetcode.com/problems/two-sum/
 */

public class TwoSum {

    // a method using nested for loops: O(n2)
    public static int[] twoSum0(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // using HashMap
    public static int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        // pass each number in the array to a HashMap
        // with the value of number as key, and index as the value
        for (int i = 0; i < len; i++) {
            // before put into the HashMap, check whether the (target - currently passed value) exists in HashMap
            if (numsMap.containsKey(target - nums[i])) {
                // if exists, store the indices into the result
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            // else add this pair to the HashMap
            numsMap.put(nums[i],i);
        }
        return null;
    }

    public static void main (String[] args) {
        int[] nums = {3,3};
        int[] indices0 = twoSum0(nums,6);
        int[] indices1 = twoSum1(nums,6);
        assert indices0 != null;
        assert indices1 != null;
        System.out.println(Arrays.toString(Arrays.stream(indices0).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(indices1).toArray()));
    }
}
