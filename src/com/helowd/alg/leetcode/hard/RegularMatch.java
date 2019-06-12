package com.helowd.alg.leetcode.hard;

/**
 * Created by fei on 2018/10/25.
 */
public class RegularMatch {

    public boolean isMatch(String s, String p) {

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RegularMatch().isMatch("aa", "aaa")); //false
        System.out.println(new RegularMatch().isMatch("aa", "a")); //false
        System.out.println(new RegularMatch().isMatch("aa", "a*")); //true
        System.out.println(new RegularMatch().isMatch("aa", "a*a")); //true

        System.out.println(new RegularMatch().isMatch("ab", ".*")); //true
        System.out.println(new RegularMatch().isMatch("ab", ".*b")); //true
        System.out.println(new RegularMatch().isMatch("ab", "a.*b")); //true
        System.out.println(new RegularMatch().isMatch("ab", "a.*")); //true
        System.out.println(new RegularMatch().isMatch("abbab", "a.*b")); //true

        System.out.println(new RegularMatch().isMatch("aab", "c*a*b")); //true
        System.out.println(new RegularMatch().isMatch("mississippi", "mis*is*p*.")); //false
        System.out.println(new RegularMatch().isMatch("mississippi", "mis*is*ip*.")); //true
        System.out.println(new RegularMatch().isMatch("abcd", "d*")); //false
    }
}
