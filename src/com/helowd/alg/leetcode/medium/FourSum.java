package com.helowd.alg.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述：
 * <p>
 * Created by fei on 2019/6/20.
 */
public class FourSum {

    @Test
    public void test() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(-1,  0, 0, 1));
        result.add(Arrays.asList(-2, -1, 1, 2));
        result.add(Arrays.asList(-2,  0, 0, 2));
        Assert.assertTrue(Zero3Sum.isEqual(result, fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)));

        result = new ArrayList<>();
        result.add(Arrays.asList(-4,  0, 2, 1));
        result.add(Arrays.asList(0, -1, -1, 1));
        Assert.assertTrue(Zero3Sum.isEqual(result, fourSum(new int[]{-1,0,1,2,-1,-4}, -1)));

        result = new ArrayList<>();
        result.add(Arrays.asList(-3,-2,2,3));
        result.add(Arrays.asList(-3,-1,1,3));
        result.add(Arrays.asList(-3,0,0,3));
        result.add(Arrays.asList(-3,0,1,2));
        result.add(Arrays.asList(-2,-1,0,3));
        result.add(Arrays.asList(-2,-1,1,2));
        result.add(Arrays.asList(-2,0,0,2));
        result.add(Arrays.asList(-1,0,0,1));
        Assert.assertTrue(Zero3Sum.isEqual(result, fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0)));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int m = nums.length - 1;

                while (k < m) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if ( sum == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[m], nums[k]));
                        k++;
                        m--;

                        while ( k < m) {
                            if (nums[k] == nums[k - 1]) {
                                k++;
                            } else {
                                break;
                            }
                        }

                        while ( k < m) {
                            if (nums[m] == nums[m + 1]) {
                                m--;
                            } else {
                                break;
                            }
                        }
                    }

                    if ( sum < target) {
                        k++;
                        while ( k < m) {
                            if (nums[k] == nums[k - 1]) {
                                k++;
                            } else {
                                break;
                            }
                        }
                    }

                    if (sum > target) {
                        m--;

                        while ( k < m) {
                            if (nums[m] == nums[m + 1]) {
                                m--;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}
