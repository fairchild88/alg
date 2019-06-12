package com.helowd.alg.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fei on 2018/10/25.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        return x >= 0 && reverse(x) == x;
    }

    public int reverse(int x) {
        int reverseNum = 0;
        while (x != 0) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum;
    }

    @Test
    public void test() {
        Assert.assertEquals(-1, reverse(-1));
        Assert.assertEquals(-121, reverse(-121));
        Assert.assertEquals(122, reverse(221));

        Assert.assertEquals(false, isPalindrome(122));
        Assert.assertEquals(true, isPalindrome(121));
        Assert.assertEquals(false, isPalindrome(-121));
        Assert.assertEquals(false, isPalindrome(10));
    }
}
