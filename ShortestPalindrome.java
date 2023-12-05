package javacode;

public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        // Create a new string by concatenating s with its reverse
        String combined = s + "#" + new StringBuilder(s).reverse().toString();

        // Build the KMP table for the combined string
        int[] kmpTable = new int[combined.length()];
        for (int i = 1, j = 0; i < combined.length(); ) {
            if (combined.charAt(i) == combined.charAt(j)) {
                kmpTable[i++] = ++j;
            } else {
                if (j != 0) {
                    j = kmpTable[j - 1];
                } else {
                    kmpTable[i++] = 0;
                }
            }
        }

        // The length of the longest palindrome prefix in the combined string
        int palindromeLength = kmpTable[combined.length() - 1];

        // Construct the shortest palindrome by adding characters in front of s
        String prefix = new StringBuilder(s.substring(palindromeLength)).reverse().toString();
        return prefix + s;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String result = shortestPalindrome(s);

        // Print the result
        System.out.println(result);
    }
}
