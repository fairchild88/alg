package com.helowd.alg.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fei on 2018/10/19.
 */
public class LongestSubStr {

    public int lengthOfLongestSubstring_bruteforce(String s) {
        if ("".equals(s)) {
            return 0;
        }

        Set<Character> subStringChar = new HashSet<>();
        int maxLen= 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            subStringChar.clear();
            subStringChar.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (subStringChar.contains(chars[j])) {
                    break;
                }
                subStringChar.add(chars[j]);
            }
            if (subStringChar.size() > maxLen) {
                maxLen = subStringChar.size();
            }
        }

        if (subStringChar.size() > maxLen) {
            maxLen = subStringChar.size();
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> subStringChar = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!subStringChar.contains(s.charAt(j))) {
                subStringChar.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                subStringChar.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //TODO: use HashMap

    //TODO: use ascii table instead of Map

    public static void main(String[] args) {
        System.out.println(new LongestSubStr().lengthOfLongestSubstring(""));
        System.out.println(new LongestSubStr().lengthOfLongestSubstring(" "));
        System.out.println(new LongestSubStr().lengthOfLongestSubstring("au"));
        System.out.println(new LongestSubStr().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubStr().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubStr().lengthOfLongestSubstring("pwwkew"));
    }
}
