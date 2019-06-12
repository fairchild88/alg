package com.helowd.alg.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by fei on 2018/10/19.
 */
public class TwoSum {
    // 时间复杂度：O(n)
    // 空间复杂度 O(n)

    // 考察点 array HashMap 通过 HashMap 保存数值获取 O(1) 查询速度

    // API  array.length, HashMap.containsKey(), HashMap.put()

    // 新建数组 new TYPE[] {}
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (indicesMap.containsKey(pair)) {
                return new int[]{indicesMap.get(pair), i};
            }
            //{3， 3}, 循环最后构建 HashMap
            indicesMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("no result");
    }

    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{3, 3}, 6));
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
