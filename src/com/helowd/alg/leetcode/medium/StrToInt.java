package com.helowd.alg.leetcode.medium;

/**
 * Created by fei on 2018/10/25.
 */
public class StrToInt {

        public int myAtoi(String str) {
            int negativeFlag = 0;
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    if (negativeFlag == 0) {
                        continue;
                    } else {
                        break;
                    }
                }

                if ('+' == str.charAt(i)) {
                    if (negativeFlag != 0) {
                        break;
                    }
                    negativeFlag = 1;
                } else if ('-' == str.charAt(i)) {
                    if (negativeFlag != 0) {
                        break;
                    }
                    negativeFlag = -1;
                } else if (isDigital(str.charAt(i))) {
                    if (negativeFlag == 0) {
                        negativeFlag = 1;
                    }
                    long newNum = num * 10 + (str.charAt(i) - '0');
                    if (newNum / 10 != num) {
                        if (negativeFlag == -1) {
                            num = Integer.MIN_VALUE;
                        } else {
                            num = Integer.MAX_VALUE;
                        }
                        negativeFlag = 0;
                        break;
                    }
                    num = (int)newNum;
                } else {
                    break;
                }

            }

            if (negativeFlag == 0) {
                return num;
            } else {
                return num * negativeFlag;
            }
        }

        boolean isDigital(char ch) {
            return ch >= '0' && ch <= '9';
        }

    public static void main(String[] args) {
        System.out.println(new StrToInt().myAtoi("   21"));
        System.out.println(new StrToInt().myAtoi("w   -21"));
        System.out.println(new StrToInt().myAtoi("4193 with words"));
        System.out.println(new StrToInt().myAtoi("words and 987"));
        System.out.println(new StrToInt().myAtoi("-91283472332"));
        System.out.println(new StrToInt().myAtoi("91283472332"));
        System.out.println(new StrToInt().myAtoi("+0 123"));
    }
}
