package com.helowd.alg.leetcode.hard;

/**
 * Created by fei on 2018/10/21.
 */
public class MedianNumber {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double medianIndices = (nums1.length + nums2.length - 1) / 2.0;
        int indices1 = 0, indices2 = 0;
        int mergeIndices = 0;
        double median = 0, previousMedian = 0;
        while ( indices1 < nums1.length || indices2 < nums2.length) {

            previousMedian = median;
            if (indices1 >= nums1.length) {
                median = nums2[indices2++];
            } else if (indices2 >= nums2.length) {
                median = nums1[indices1++];
            } else {
                if (nums1[indices1] < nums2[indices2]) {
                    median = nums1[indices1++];
                } else {
                    median = nums2[indices2++];
                }
            }

            if (medianIndices == mergeIndices) {
                return median;
            } else if (medianIndices < mergeIndices) {
                return (median + previousMedian ) / 2;
            }
            mergeIndices++;
        }
        throw new IllegalArgumentException("wrong paramter");
    }

    public String toString(int[] nums1, int[] nums2) {
        StringBuilder builder = new StringBuilder();
        int indices1 = 0, indices2 = 0;
        while ( indices1 < nums1.length || indices2 < nums2.length) {
            if (indices1 != 0 || indices2 != 0) {
                builder.append("->");
            }

            if (indices1 >= nums1.length) {
                builder.append(nums2[indices2++]);
                continue;
            } else if (indices2 >= nums2.length) {
                builder.append(nums1[indices1++]);
                continue;
            }


            if (nums1[indices1] < nums2[indices2]) {
                builder.append(nums1[indices1++]);
            } else {
                builder.append(nums2[indices2++]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        MedianNumber medianNumber = new MedianNumber();
        int[] num1 = new int[] {1, 3, 5};
        int[] num2 = new int[] {2};
        System.out.println(medianNumber.findMedianSortedArrays(num1, num2));
        System.out.println(medianNumber.toString(num1, num2));
        num1 = new int[] {1, 2};
        num2 = new int[] {3, 4};
        System.out.println(medianNumber.findMedianSortedArrays(num1, num2));
        System.out.println(medianNumber.toString(num1, num2));
        num1 = new int[] {1, 3};
        num2 = new int[] {};
        System.out.println(medianNumber.findMedianSortedArrays(num1, num2));
        System.out.println(medianNumber.toString(num1, num2));
    }
}
