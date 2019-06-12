package com.helowd.alg.leetcode.medium;

/**
 * Created by fei on 2018/10/21.
 */
public class Palindromic {

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i + 1; j++) {
                String subString = s.substring(j, s.length() - i + j);
                if (isPalindrome(subString)) {
                    return subString;
                }
            }
        }
        return "";
    }

    public boolean isPalindrome(String s) {
        if (s == null ) {
            return false;
        }

        if (s.length() == 1) {
            return true;
        }

        double median = (s.length() - 1) / 2.0;
        for (int i = 0 ; i < median; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Palindromic palindromic = new Palindromic();
        System.out.println(palindromic.isPalindrome("a"));
        System.out.println(palindromic.isPalindrome("ac"));
        System.out.println(palindromic.isPalindrome("aba"));
        System.out.println(palindromic.isPalindrome(" "));
        System.out.println(palindromic.isPalindrome(""));
        System.out.println(palindromic.isPalindrome("abbbbc"));
        System.out.println(palindromic.isPalindrome("abbbba"));

        System.out.println(palindromic.longestPalindrome("abbbc"));
        System.out.println(palindromic.longestPalindrome("babad"));
        System.out.println(palindromic.longestPalindrome("cbbd"));
        System.out.println(palindromic.longestPalindrome("a"));
        System.out.println(palindromic.longestPalindrome("ac"));
        System.out.println(palindromic.longestPalindrome("abb"));
    }
}
