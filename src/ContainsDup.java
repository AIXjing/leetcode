/**
 * @Source: https://leetcode.com/problems/contains-duplicate/
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDup {
    public boolean isContainsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i : nums) {
            if (!numsSet.contains(i)) {
                numsSet.add(i);
            } else {
                return true;
            }
        }
        return false;
    }
}
