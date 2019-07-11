package com.helowd.alg.basic.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 描述： 堆排序
 *
 * Heapify 操作定义：分支稳定堆，
 * buildHeap 操作定义：从倒数第 2 层级从下往上，从右到左执行 heapify 操作
 * HeapSorf 操作定义：将堆顶元素与堆末尾元素互换，末尾元素已排序，对新堆顶元素执行 heapify 操作
 *
 * 空间复杂度：O(0)
 * 堆排序复杂度：O(nlog(n))
 * 构建堆时间复杂度：O(n) 计算比较次数
 *
 * <p>
 * Created by fei on 2019/7/5.
 */
public class HeapSort {

    @Test
    public void test() {
        Assert.assertTrue(isMatch( new int[] {1, 1, 2, 3, 5, 10}, heapsort(new int[] {1, 2, 5, 3, 1, 10})));;
    }

    private boolean isMatch(int[] a1, int[] a2) {
        if (a1 == null || a2 == null) {
            return false;
        }

        if (a1.length != a2.length) {
            return false;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }

        return true;
    }

    public int[] heapsort(int [] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        return arr;
    }

    public void buildHeap(int[] arr) {
        int lastIndex = (arr.length - 1) / 2;
        for (int i = lastIndex; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    public void heapify(int[] arr, int len, int i) {
        if (i > len) {
            return;
        }

        int c1 = 2*i + 1;
        int c2 = 2*i + 2;
        int max = i;

        if (c1 < len && arr[max] < arr[c1]) {
            max = c1;
        }

        if (c2 < len && arr[max] < arr[c2]) {
            max = c2;
        }

        if (max == i) {
            return;
        }

        swap(arr, i, max);
        heapify(arr, len, max);
    }

    private void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
