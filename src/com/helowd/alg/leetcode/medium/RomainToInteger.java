package com.helowd.alg.leetcode.medium;

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
        Assert.assertEquals("I", getRomainStr(1));
        Assert.assertEquals("IV", getRomainStr(4));
        Assert.assertEquals("V", getRomainStr(5));
        Assert.assertEquals("VII", getRomainStr(7));
        Assert.assertEquals("XVII", getRomainStr(17));
    }

    public String getRomainStr(int input) {
        if (input < 0 || input > 3999) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        char[] label = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        for (int i = 1000, start = -2; i > 0; i /= 10, start += 2) {
            int res = input / i;
            input -= res * i;

            char sL = ' ', mL = ' ', eL = ' ';
            if (i == 1000) {
                sL = label[start + 2];
            } else {
                sL = label[start + 2];
                mL = label[start + 1];
                eL = label[start];
            }
            if (res == 9) {
                builder.append(sL).append(eL);
            } else if (res >= 6) {
                builder.append(mL);
                while (res - 5 > 0) {
                    builder.append(sL);
                    res--;
                }
            } else if (res == 5) {
                builder.append(mL);
            } else if (res == 4) {
                builder.append(sL).append(mL);
            } else if (res > 0) {
                while (res > 0) {
                    builder.append(sL);
                    res--;
                }
            }
        }

        return builder.toString();
    }
}
