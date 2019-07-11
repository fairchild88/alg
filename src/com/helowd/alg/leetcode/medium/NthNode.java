package com.helowd.alg.leetcode.medium;

import com.helowd.alg.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 描述： Nth Node
 * <p>
 * Created by fei on 2019/6/23.
 */
public class NthNode {

    @Test
    public void test() {
        Assert.assertTrue(ListNode.isListMatched(ListNode.buildList(1, 2, 3), ListNode.buildList(1, 2, 3)));
        Assert.assertFalse(ListNode.isListMatched(ListNode.buildList(1, 2, 3), ListNode.buildList(1, 2)));
        Assert.assertFalse(ListNode.isListMatched(ListNode.buildList(1, 2, 3), ListNode.buildList(1, 2, 4)));

        Assert.assertTrue(ListNode.isListMatched(ListNode.buildList(1, 2), removeNthFromEnd(ListNode.buildList(1, 2, 4), 1)));
        Assert.assertTrue(ListNode.isListMatched(ListNode.buildList(1, 4), removeNthFromEnd(ListNode.buildList(1, 2, 4), 2)));
        Assert.assertTrue(ListNode.isListMatched(ListNode.buildList(2, 4), removeNthFromEnd(ListNode.buildList(1, 2, 4), 3)));
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

}
