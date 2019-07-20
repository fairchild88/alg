package com.helowd.alg.leetcode.hard;

import com.helowd.alg.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static com.helowd.alg.utils.ListNode.buildList;
import static com.helowd.alg.utils.ListNode.isListMatched;

/**
 * 描述：
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6

 Created by fei on 2019/7/1.
 */
public class MergeKList {

    @Test
    public void test() {
        Assert.assertTrue(isListMatched(
                buildList(1, 1, 2, 3, 4, 4, 5, 6),
                mergeKLists(new ListNode[]{
                        buildList(1, 4, 5),
                        buildList(1, 3, 4),
                        buildList(2, 6),
                })));

        Assert.assertTrue(isListMatched(
                null,
                mergeKLists(new ListNode[]{})));

        Assert.assertTrue(isListMatched(
                null,
                mergeKLists(
                        new ListNode[]{
                                null,
                                null
                        })));

        Assert.assertTrue(isListMatched(
                buildList(-1, 2),
                mergeKLists(
                        new ListNode[]{
                                buildList(2),
                                null,
                                buildList(-1)
                        })));

        Assert.assertTrue(isListMatched(
                buildList(-1, 2),
                mergeKLists(
                        new ListNode[]{
                                null,
                                buildList(2),
                                buildList(-1)
                        })));


        Assert.assertTrue(isListMatched(
                buildList(-3, -2, -1, -1, 0, 1, 1, 2, 4),
                mergeKLists(
                        new ListNode[]{
                                buildList(-1, 1),
                                buildList(-3, 1, 4),
                                buildList(-2, -1, 0, 2),
                        })));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        buildHeap(lists);
        ListNode head = null;
        ListNode next = null;
        int len = lists.length;
        for (int i = 0; i <= len; ) {
            if (lists[i]  == null) {
                heapify(lists, i);
                len -= 1;
                continue;
            }

            if (head == null) {
                next = head = lists[i];
                lists[i] = next.next;
                continue;
            }

            heapify(lists, i);
            next = next.next = lists[i];
            lists[i] = lists[i].next;
        }

        return head;
    }

    private void buildHeap(ListNode[] lists) {
        int startIndex = lists.length / 2 - 1;
        for (int i = startIndex; i >= 0; i--) {
            heapify(lists, i);
        }
    }

    private void heapify(ListNode[] lists, int i) {
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;

        int min = i;
        if (c1 < lists.length ) {
            if (lists[min] == null || lists[c1] != null && lists[min].val > lists[c1].val) {
                min = c1;
            }
        }

        if (c2 < lists.length ) {
            if (lists[min] == null || lists[c2] != null && lists[min].val > lists[c2].val) {
                min = c2;
            }
        }

        if (min == i) {
            return;
        }

        swap(lists, i, min);
        heapify(lists, min);
    }

    private void swap(ListNode[] lists, int i, int j)  {
        ListNode tmp = lists[i];
        lists[i] = lists[j];
        lists[j] = tmp;
    }
}
