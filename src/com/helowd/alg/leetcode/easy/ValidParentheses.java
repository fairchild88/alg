package com.helowd.alg.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * 描述：
 * <p>
 * Created by fei on 2019/6/23.
 */
public class ValidParentheses {

    @Test
    public void test() {
        Assert.assertTrue(isValid("()"));
        Assert.assertTrue(isValid(""));
        Assert.assertTrue(isValid("({{}})"));
        Assert.assertFalse(isValid("({}})"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid("(]"));
        Assert.assertFalse(isValid("([)]"));
        Assert.assertTrue(isValid("{[]}"));
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (stack.size() > 0) {
                Character top = stack.peek();
                if (top != null) {
                    if (map.get(top) == ch) {
                        stack.pop();
                        continue;
                    }
                }
            }

            if (map.get(ch) == null) {
                return false;
            }
            stack.push(ch);
        }

        return stack.size() == 0;
    }
}
