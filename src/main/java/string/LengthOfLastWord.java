package string;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "   fly me   to   the moon  ";
        String str3 =  "luffy is still joyboy ";
        String str4 = "  ";

        System.out.println(findLengthOfLastWord(str2));
        System.out.println(lengthOfLastWord(str2));
        System.out.println(lengthOfLastWordWithTrim(str2));

    }

    public static int findLengthOfLastWord(String str) { // Time Complexity: O(n), Space Complexity: O(1)
        int i = str.length()-1; // to start from last index
        int length = 0;

        while (i>=0 && str.charAt(i)==' ') { // trim the trailing spaces
            i--;
        }
        while (i>=0) { // compute the length of last word
            if (str.charAt(i)==' ') {
                break;
            }
            i--;
            length++;
        }
        return length;
    }

    public static int lengthOfLastWord(String str) { // Time Complexity: O(n), Space Complexity: O(1)
        int i = str.length()-1;
        int length = 0;

        while (i > 0) { // combined two loops into one
            if (str.charAt(i) != ' ') {
                length++;
            }
            else if (length > 0) {
                return length;
            }
            i--; // trimming here (if it's space, go to the next index)
        }
        return length;
    }

    public static int lengthOfLastWordWithTrim(String str) { // Time Complexity: O(n), Space Complexity: O(n)
        str = str.trim();  // trim the trailing spaces in the string
        return str.length() - str.lastIndexOf(" ") - 1;
    }

}
/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.
 */
