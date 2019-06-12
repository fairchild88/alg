package com.helowd.alg.leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fei on 2018/10/25.
 */
public class RegularMatch {

    public boolean isMatch(String p, String r) {
        int m = r.length() + 1;
        int n = p.length() + 1;
        boolean t[][] = new boolean[m][n];

        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = true;
                } else if (j == 0) {
                    if (r.charAt(i - 1) == '*') {
                        if (i > 1) {
                            t[i][j] = t[i - 2][j];
                        } else {
                            t[i][j] = false;
                        }
                    } else {
                        t[i][j] = false;
                    }
                } else if ( i == 0) {
                    t[i][j] = false;
                } else {
                    if (r.charAt(i - 1) == '.' || r.charAt(i - 1) == p.charAt( j - 1)) {
                        t[i][j] = t[i - 1][j - 1];
                    } else {
                        if ( r.charAt(i - 1) == '*' ) {
                            if (i < 2) {
                                t[i][j] = false;
                            } else {
                                if( r.charAt(i - 2) == '.' || r.charAt(i - 2) == p.charAt( j - 1)) {
                                    t[i][j] = t[i][j - 1] ||
                                            t[i - 2][j] ||
                                            t[i - 2][j];
                                } else {
                                    t[i][j] = t[i - 2][j];
                                }
                            }
                        } else {
                            t[i][j] = false;
                        }
                    }
                }
            }
        }

        return t[m - 1][n - 1];
    }

    @Test
    public void test() {
        Assert.assertFalse(isMatch("aa", "aaa")); //false
        Assert.assertFalse(isMatch("aa", "a")); //false
        Assert.assertTrue(isMatch("aa", "a*")); //true
        Assert.assertTrue(isMatch("aa", "a*a")); //true

        Assert.assertTrue(isMatch("ab", ".*")); //true
        Assert.assertTrue(isMatch("ab", ".*b")); //true
        Assert.assertTrue(isMatch("ab", "a.*b")); //true
        Assert.assertTrue(isMatch("ab", "a.*")); //true
        Assert.assertTrue(isMatch("abbab", "a.*b")); //true

        Assert.assertTrue(isMatch("aab", "c*a*b")); //true
        Assert.assertFalse(isMatch("mississippi", "mis*is*p*.")); //false
        Assert.assertTrue(isMatch("mississippi", "mis*is*ip*.")); //true
        Assert.assertFalse(isMatch("abcd", "d*")); //false
    }
}
