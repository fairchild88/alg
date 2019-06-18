package com.helowd.alg.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * <p>
 * Created by fei on 2019/6/17.
 */
public class LetterCombinations {
    @Test
    public void test() {
        Assert.assertEquals(9, letterCombinations("23").size());
        Assert.assertEquals(12, letterCombinations("27").size());
        Assert.assertEquals(48, letterCombinations("279").size());
        Assert.assertEquals(48*3, letterCombinations("2793").size());
        Assert.assertEquals(0, letterCombinations("").size());
    }

    public List<String> letterCombinations(String digits) {
        int strCount = 1;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '7' && digits.charAt(i) != '9') {
                strCount *= 3;
            } else {
                strCount *= 4;
            }
        }

        char[][] map = {
                {'a', 'b', 'c'}, //2
                {'d', 'e', 'f'}, //3
                {'g', 'h', 'i'}, //4
                {'j', 'k', 'l'}, //5
                {'m', 'n', 'o'}, //6
                {'p', 'q', 'r', 's'}, //7
                {'t', 'u', 'v'}, //8
                {'w', 'x', 'y', 'z'} //9
        };

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < strCount; i++) {
            StringBuilder builder = new StringBuilder();
            int loop = 1;
            for (int j = 0; j < digits.length(); j++) {
                int digitCount;
                if (digits.charAt(j) != '7' && digits.charAt(j) != '9') {
                    digitCount = 3;
                } else {
                    digitCount = 4;
                }

                builder.append(map[digits.charAt(j) - '2'][i / loop % digitCount]);
                loop *= digitCount;
            }
            if (!builder.toString().equals("")) {
                strings.add(builder.toString());
            }
        }

        return strings;
    }
}
