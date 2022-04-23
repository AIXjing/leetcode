import java.util.HashMap;

/**
 * @Source: https://leetcode.com/problems/ransom-note/
 */

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        // put all chars in magazine to a map based on the frequency of each char
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        // to check whether all the chars in ransom can be found in map
        for (int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            // when found one, then value - 1;
            if (!map.containsKey(ch)) return false;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) map.remove(ch);
        }
        return true;
    }

    // store frequency in an array
    public static boolean canConstruct1(String ransomNote, String magazine) {
        // put all chars in magazine to an array based on the frequency of each char
        int[] arr = new int[26];
        char[] magArr = magazine.toCharArray();
        char[] ranArr = ransomNote.toCharArray();
        for (int i = 0; i < magazine.length(); i++) {
            arr[magArr[i] - 'a']++ ;
        }
        // to check whether all the chars in ransom can be found in map
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ranArr[i] - 'a']--;
            if (arr[ranArr[i] - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main (String[] args) {
        String a = "";
        String b = "a";
        System.out.println(canConstruct(a,b));
    }
}
