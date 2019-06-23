package com.helowd.alg.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * 描述： Nth Node
 * <p>
 * Created by fei on 2019/6/23.
 */
public class NthNode {

    @Test
    public void test() {
        Assert.assertTrue(isListMatched(buildList(1, 2, 3), buildList(1, 2, 3)));
        Assert.assertFalse(isListMatched(buildList(1, 2, 3), buildList(1, 2)));
        Assert.assertFalse(isListMatched(buildList(1, 2, 3), buildList(1, 2, 4)));

        Assert.assertTrue(isListMatched(buildList(1, 2), removeNthFromEnd(buildList(1, 2, 4), 1)));
        Assert.assertTrue(isListMatched(buildList(1, 4), removeNthFromEnd(buildList(1, 2, 4), 2)));
        Assert.assertTrue(isListMatched(buildList(2, 4), removeNthFromEnd(buildList(1, 2, 4), 3)));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;

        ListNode curNode = head;
        ListNode preNode = null;

        while (head != null) {
            len++;
            head = head.next;
        }

        head = curNode;
        int j = len - n;
        for (int i = 0; i < len; i++) {
            if (j == i) {
                if (preNode != null) {
                    preNode.next = curNode.next;
                } else {
                    head = curNode.next;
                }
                break;
            }

            preNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isListMatched(ListNode list1, ListNode list2) {

        while (list1 != null && list2 != null) {
            if (list1.val != list2.val ) {
                return false;
            }

            list1 = list1.next;
            list2 = list2.next;
        }

        return list1 == null && list2 == null;
    }

    public ListNode buildList(int ... nodes) {
        if (nodes.length == 0) {
            return null;
        }

        ListNode head = null;
        ListNode preNode = null;
        for (int node : nodes) {
            ListNode curNode = new ListNode(node);
            if (head == null) {
                preNode = head = curNode;
            } else {
                preNode.next = curNode;
                preNode = curNode;
            }
        }
        return head;
    }
}
