import java.util.HashMap;

/**
 * @ Source: https://leetcode.com/problems/first-unique-character-in-a-string/
 * @ Description:
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 * key information: Hashmap is built based on array, so it will be never faster than array.
 */
public class FirstUniqueChar {

    public static int firstUniqueChar(String s) {
        // put all char in a map with frequency as value
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        // check char in s from the start and return the index of the first char showing the value is 1.
        for (int i = 0; i < s.length() ; i++) {
            if (map.get(s.charAt(i)) == 1) return s.indexOf(s.charAt(i));
        }
        return -1;
    }

    // a faster method by comparing O(n)
    public static int firstUniqChar2(String s) {
        char[] a = s.toCharArray();

        for(int i=0; i<a.length;i++){
            if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
        }
        return -1;
    }

    // Using array
    public static int firstUniqChar3(String s) {
        int[] arr = new int[26];
        char[] a = s.toCharArray();
        int len = a.length;
        // count the frequency of each char in the string s and store the frequency in an array
        // the index of the array indicates the order of each char in alphabet
        for (int i = 0; i < len; i++) {
            arr[a[i] - 'a']++;
        }
        // check the frequency of each char in the string
        for (int i = 0; i < len; i++) {
            // return the index of this char in the string once found its frequency equals to 1
            if ((arr[a[i] - 'a']) == 1) return s.indexOf(a[i]);
        }
        return -1;
    }

    public static void main (String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar3(s));
    }

}
