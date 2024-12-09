import java.util.Random;

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int countTimes = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                countTimes++;
            }
        }
        return countTimes;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        // Case: Input Error
        if (str1 == null || str2 == null) {
            return false;
        }
        // Convert both strings to lowercase for case-insensitive comparison
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        // Frequency arrays for characters (assuming lowercase English letters)
        int[] letterTimes1 = new int[26];
        int[] letterTimes2 = new int[26];
        // Count character frequencies in str1
        for (char c : str1.toCharArray()) {
            letterTimes1[c - 'a']++;
        }
        // Count character frequencies in str2
        for (char c : str2.toCharArray()) {
            letterTimes2[c - 'a']++;
        } 
        // Compare frequencies
        for (int i = 0; i < 26; i++) {
            if (letterTimes1[i] > letterTimes2[i]) {
                return false; // str2 doesn't have enough occurrences of character i
            }
        }
        return true; // All characters in str1 are accounted for in str2
    } 

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String collectString = "";
        for (int i = 0; i < str.length(); i++) {
            collectString = collectString + str.charAt(i);
            if (i < str.length() - 1) {
                collectString = collectString + " ";
            }
        }
        return collectString;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        Random random = new Random();
        String outputString = "";
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(26) + 97; // 97 = 'a', 122 = 'z'.
            char randomChar = (char) randomNumber;
            outputString += randomChar;
        }
        return outputString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        // Logic: 97 = 'a', 122 = 'z'.
        int [] countTimes = new int[26];
        for (char c : str1.toCharArray()) {
            int i = (int) c - 97;
            countTimes[i]++;
        }
        for (char c : str2.toCharArray()) {
            countTimes[c - 97]--;
        }
        String collectString = "";
        for (char c : str1.toCharArray()) {
            if (countTimes[c - 97] > 0) {
                collectString += c;
                countTimes[c - 97]--;
            }
        }
        return collectString;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
