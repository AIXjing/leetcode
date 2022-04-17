import java.util.Arrays;

/**
 * @Source: https://leetcode.com/problems/merge-sorted-array/
 */

public class MergeSortedArray {
    public static void merge0(int[] nums1, int m, int[] nums2, int n) {
        // replace all 0 numbers in nums1 with nums2
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        // sort nums1 in ascending order
        // runtime of Arrays.sort is O((m+n)log(m+n))
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    // a method only takes O(m+n) run time.
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // since both arrays are non-descending order, compare elements from the end of both arrays
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            // if the element in nums1 larger than that in nums2
            // put that element to the k position of nums1, and i--, k-- with j remained at the current position
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                // if element in nums2 larger than that in nums1
                // put that element to the k position of nums1, and j--, k-- whereas i is not changed.
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // when all the elements in nums1 have been compared, i.e., i < 0
        // put the rest of elements in nums2 to the rest of nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main (String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        merge1(nums1, 1, nums2, 5);
    }
}
