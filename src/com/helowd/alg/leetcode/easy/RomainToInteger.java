package com.helowd.alg.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 描述：
 * <p>
 * Created by fei on 2019/6/13.
 */
public class RomainToInteger {
    @Test
    public void test() {
        Assert.assertEquals(1, getIntFromRoman("I"));
        Assert.assertEquals(4,  getIntFromRoman("IV"));
        Assert.assertEquals(5, getIntFromRoman("V"));
        Assert.assertEquals(7, getIntFromRoman("VII"));
        Assert.assertEquals(17, getIntFromRoman("XVII"));
        Assert.assertEquals(190, getIntFromRoman("CXC"));
    }

    public int getIntFromRoman(String s) {
        char[] label = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int res = 0;
        for (int i = 1000, start = -2, j = 0; i > 0; i /= 10, start += 2) {
            char sL = label[start + 2];
            char mL = ' ';
            char eL = ' ';
            if (start >= 0) {
                mL = label[start + 1];
                eL = label[start];
            }

            if (j + 1 < s.length() && s.charAt(j) == sL && s.charAt(j + 1) == mL) {
                res += 4 * i;
                j += 2;
            } else if (j < s.length() && s.charAt(j) == mL) {
                res += 5*i;
                j++;
                while (j < s.length() && s.charAt(j++) == sL) {
                    res += i;
                }
                j--;
            } else if (j + 1 < s.length() && s.charAt(j) == sL && s.charAt(j+1) == eL) {
                res += 9 * i;
                j += 2;
            } else if (j < s.length() && s.charAt(j) == sL) {
                while (j < s.length() && s.charAt(j++) == sL) {
                    res += i;
                }
                j--;
            }
        }
        return res;
    }
}
