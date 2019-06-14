package com.helowd.alg.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 描述：
 * <p>
 * Created by fei on 2019/6/14.
 */
public class LoggestCommonPrefix {
    @Test
    public void test() {
        Assert.assertTrue("fl".equals(logestCommonPrefix(new String[]{"flower","flow","flight"})));
        Assert.assertTrue("".equals(logestCommonPrefix(new String[]{"dog", "racecar", "car"})));
        Assert.assertTrue("".equals(logestCommonPrefix(new String[]{})));
    }

    public String logestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        int strIndex = 0;
        char curChar = ' ';

        while (true) {

            for (int i = 0; i < strs.length; i++) {
                if (strIndex >= strs[i].length()) {
                   return stringBuilder.toString();
                }

                if (i == 0) {
                    curChar = strs[i].charAt(strIndex);
                }
                if (curChar != strs[i].charAt(strIndex)) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(curChar);
            strIndex++;
        }
    }
}
