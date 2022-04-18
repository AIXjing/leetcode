import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Source: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        ArrayList<Integer> intersects = new ArrayList<>();
        if(len1 < len2) {
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2;j++) {
                    if (nums1[i] == nums2[j]) {
                        intersects.add(nums1[i]);
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < len2; i++) {
                for (int j = 0; j < len1;j++) {
                    if (nums2[i] == nums1[j]) {
                        intersects.add(nums2[i]);
                        break;
                    }
                }
            }
        }

        int len = intersects.size();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = intersects.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1};
        int[] nums2 = {1,2};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
}
