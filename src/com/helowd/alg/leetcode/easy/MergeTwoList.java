package com.helowd.alg.leetcode.easy;

import com.helowd.alg.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static com.helowd.alg.utils.ListNode.buildList;
import static com.helowd.alg.utils.ListNode.isListMatched;

/**
 * 描述：
 * <p>
 * Created by fei on 2019/7/21.
 */
public class MergeTwoList {

    @Test
    public void test () {

        Assert.assertTrue(isListMatched(
                buildList(1, 3, 4),
                mergeTwoLists(
                        null,
                        buildList(1, 3, 4)
                )));

        Assert.assertTrue(isListMatched(
                buildList(1, 1, 2, 3, 4, 4),
                mergeTwoLists(
                        buildList(1, 2, 4),
                        buildList(1, 3, 4)
                )));

        Assert.assertTrue(isListMatched(
                null,
                mergeTwoLists(
                       null,
                       null
                )));

        Assert.assertTrue(isListMatched(
                buildList(1, 1, 3, 4, 5),
                mergeTwoLists(
                        buildList(1),
                        buildList(1, 3, 4, 5)
                )));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode tail = null;
        ListNode s1 = l1;
        ListNode s2 = l2;
        while ( s1 != null && s2 != null) {
            ListNode min;
            if (s1.val < s2.val) {
                min = s1;
                s1 = s1.next;
            } else {
                min = s2;
                s2 = s2.next;
            }

            if (head == null) {
                tail = head = min;
            } else {
                tail.next = min;
                tail = min;
            }
        }

        if (s1 == null) {
            tail.next = s2;
        } else {
            tail.next = s1;
        }

        return head;
    }
}
