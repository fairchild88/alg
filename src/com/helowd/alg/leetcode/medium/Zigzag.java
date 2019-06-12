package com.helowd.alg.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei on 2018/10/24.
 */
public class Zigzag {

    public String covert(String s, int rows) {
        if (rows == 1) {
            return s;
        }

        List<StringBuilder> stringRowsList = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            stringRowsList.add(new StringBuilder());
        }

        int row = 0, column = 0;
        for (int i = 0 ; i < s.length(); i++) {
            stringRowsList.get(row).append(s.charAt(i));
            if (column %(rows - 1) == 0) { // on vertical bar
                if (row == rows - 1) { //move to
                    row--;
                    column++;
                } else {
                    row++;
                }
            } else {
                row--;
                column++;
            }
        }
        StringBuilder builder = stringRowsList.get(0);
        for (int i = 1; i < stringRowsList.size(); i++) {
            builder.append(stringRowsList.get(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new Zigzag().covert(s, 3));
        System.out.println(new Zigzag().covert(s, 4));
        System.out.println(new Zigzag().covert(s, 1));
    }
}
