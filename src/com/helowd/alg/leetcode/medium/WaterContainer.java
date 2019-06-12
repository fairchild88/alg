package com.helowd.alg.leetcode.medium;

import junit.framework.Assert;

/**
 * 描述：
 * <p>
 * Created by fei on 2019/6/12.
 */
public class WaterContainer {

    public void main(String[] args) {
        System.out.println(String.format("max %d", getMaxWaterContainer(new int[]{1, 8, 6, 2, 5, 4, 3, 8, 7})));
        System.out.println(String.format("max %d", getMaxWaterContainer(new int[]{1, 8, 60, 2, 5, 4, 30, 8, 3})));
        System.out.println(String.format("max %d", getMaxWaterContainer(new int[]{1, 8})));
        System.out.println(String.format("max %d", getMaxWaterContainer(new int[]{1})));
        System.out.println(String.format("max %d", getMaxWaterContainer(new int[]{})));
    }

    public int getMaxWaterContainer(int[] h) {
        if (h.length < 1) {
            return 0;
        }

        int start = 0;
        int end = h.length - 1;

        int left = start;
        int right = end;
        int curSize = size(left, right, h);

        while (left < right) {
            if (h[left] < h[right]) {
                left++;
            } else {
                right--;
            }
            if (h[right] > h[end] | h[left] > h[start]) {
                int newSize = size(left, right, h);
                if (newSize > curSize) {
                    start = left;
                    end = right;
                    curSize = newSize;
                }
            }
        }
        return curSize;
    }

    private static int size(int left, int right, int[] h) {
        return Math.min(h[left], h[right]) * (right - left);
    }
}
