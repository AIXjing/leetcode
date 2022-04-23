/**
 * @Source: https://leetcode.com/problems/valid-anagram/
 * @Description:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if (lens != lent) return false;
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < lens; i++) {
            arr[chars[i] - 'a']++;
        }
        for (int i = 0; i < lent; i++) {
            arr[chart[i] - 'a']--;
            if (arr[chart[i] - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main (String[] args) {
        String s = "rat";
        String t = "cat";
        System.out.println(isAnagram(s,t));
    }
}
