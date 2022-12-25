package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "ababcdbca";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstringWithMap(str));
        System.out.println(lengthOfLongestSubstringWithSet(str));

    }

    public static int lengthOfLongestSubstring(String str) { // n^n
        // keep track of max length
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {
            StringBuilder currentSubstring = new StringBuilder(); // to build substring
            for (int j = i; j < str.length(); j++) {
                // check currentSubstring contains the character
                if (currentSubstring.indexOf(String.valueOf(str.charAt(j))) != -1) { // if character doesn't exist -> -1
                    break; // if character exists, break inner loop and start again building new substring
                }
                currentSubstring.append(str.charAt(j)); // if it doesn't exist, add character to currentSubstring
                maxLength = Math.max(maxLength, currentSubstring.length()); // update maxLength with max number
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringWithMap(String str) { // n
        int maxLength = 0;
        int start = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end); // current character
            if (map.containsKey(c) && start <= map.get(c)) {
                // set with new position that character appears at
                start = map.get(c) + 1; // adding 1 because new substring starts right after it
            }
            maxLength = Math.max(maxLength, end - start + 1); // if all of them is unique, length of substring is 1
            map.put(c, end);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringWithSet(String str) { // n
        // base
        if (str == null || str.length() == 0) {
            return 0;
        }
        int right = 0;
        int left = 0;
        int maxLength = 0;
        // to keep what unique character we have in window (left-right)
        Set<Character> set = new HashSet<>();

        while (right < str.length()) { // move right pointer forward
            char c = str.charAt(right);
            while (set.contains(c)) {
                set.remove(str.charAt(left)); // remove the character that left points at
                left++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }

}
/*
Given a string, find the length of the longest substring without repeating characters.
 */