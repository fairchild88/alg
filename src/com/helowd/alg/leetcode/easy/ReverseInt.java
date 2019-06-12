package com.helowd.alg.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by fei on 2018/10/25.
 */
public class ReverseInt {
    //TODO do not use stack
    int reverse(int s) {
        Stack<Integer> reverseStack = new Stack<>();
        while (s != 0) {
            reverseStack.push(s % 10);
            s = s / 10;
        }

        long reverseInt = 0;
        int len = reverseStack.size();
        for (long i = 0, step = 1; i < len; i++, step *= 10) {
            int digital = reverseStack.pop();
            reverseInt += digital * step;

            if (reverseInt > Integer.MAX_VALUE || reverseInt < Integer.MIN_VALUE) {
                reverseInt = 0;
                break;
            }
        }

        return (int)reverseInt;
    }

    @Test
    public void test() {
        Assert.assertEquals(321, reverse(123));
        Assert.assertEquals(1, reverse(1));
        Assert.assertEquals(-1, reverse(-1));
        Assert.assertEquals(0, reverse(Integer.MAX_VALUE));
        Assert.assertEquals(0, reverse(Integer.MAX_VALUE + 1));
        Assert.assertEquals(0, reverse(1534236469));
    }
}
