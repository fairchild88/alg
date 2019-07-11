package com.helowd.alg.utils;

/**
 * 描述：列表 Node 定义
 * <p>
 * Created by fei on 2019/7/11.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode buildList(int ... nodes) {
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

    public static boolean isListMatched(ListNode list1, ListNode list2) {

        while (list1 != null && list2 != null) {
            if (list1.val != list2.val ) {
                return false;
            }

            list1 = list1.next;
            list2 = list2.next;
        }

        return list1 == null && list2 == null;
    }
}
