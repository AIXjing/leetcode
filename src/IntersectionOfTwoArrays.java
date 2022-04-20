import java.util.*;
import java.util.stream.Collectors;

/**
 * @Source: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArrays {
    // This solution is O(N + M) time complexity
    // O(N) for iterate one of the array to create a hashmap and O(M) to iterate the other array.
    // O(N) space to store such hashmap.
    public static int[] intersect(int[] nums1, int[] nums2) {
        // create a hashmap in which key is the element and value is the frequency of the element in num1
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i,map.get(i) + 1);
            }
        }
        ArrayList<Integer> intersects = new ArrayList<>();
        for (int j : nums2) {
            if (map.containsKey(j)) {
                intersects.add(j);
                map.put(j, map.get(j) - 1);
                if (map.get(j) == 0) {
                    map.remove(j);
                }
            }
        }
        int[] a = new int[intersects.size()];
        for (int i = 0; i < intersects.size(); i++) {
            a[i] = intersects.get(i);
        }
        return a;
    }

    // What if the given array is already sorted?
    public static int[] intersectsForSortedArrays (int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> intersects = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersects.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] a = new int[intersects.size()];
        for (int k = 0; k < intersects.size(); k++) {
            a[k] = intersects.get(k);
        }
        return a;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));
//        System.out.println(Arrays.toString(intersect(nums1,nums2)));

        int[] sorted_a = {0,1,3,3,6};
        int[] sorted_b = {1,3,6,9,9};
        System.out.println(Arrays.toString(sorted_a));
        System.out.println(Arrays.toString(sorted_b));
        System.out.println(Arrays.toString(intersectsForSortedArrays(sorted_a, sorted_b)));
    }
}
