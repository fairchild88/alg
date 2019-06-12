package com.helowd.alg.leetcode.medium;

/**
 * Created by fei on 2018/10/19.
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            ListNode nextNode = this;
            do {
                if (nextNode != this) {
                    builder.append("->").append(nextNode.val);
                } else {
                    builder.append(val);
                }

                nextNode = nextNode.next;
            }
            while (nextNode != null);
            return builder.toString();
        }
    }

    //考察列表遍历，不需要反向列表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curDigitalNode = null;
        ListNode headNode = null;

        while (l1 != null || l2 != null) {
            if (curDigitalNode == null) {
                headNode = curDigitalNode = new ListNode(0);
            } else if (curDigitalNode.next == null){
                curDigitalNode.next = new ListNode(0);
                curDigitalNode = curDigitalNode.next;
            } else {
                curDigitalNode = curDigitalNode.next;
            }

            int digital1 = l1 != null ? l1.val : 0;
            int digital2 = l2 != null ? l2.val : 0;
            int sumDigital = digital1 + digital2 + curDigitalNode.val;

            if (sumDigital > 9) {
                curDigitalNode.val = sumDigital - 10;
                curDigitalNode.next = new ListNode(1);
            } else {
                curDigitalNode.val = sumDigital;
            }

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return headNode;
    }

    private ListNode reverseListNode(ListNode listNode) {
        ListNode previousNode = null;
        while (listNode != null) {
            ListNode nextNode = listNode.next;
            listNode.next = previousNode;
            previousNode = listNode;
            listNode = nextNode;
        }
        return previousNode;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node4 = node2.next = new ListNode(4);
        node4.next = new ListNode(3);
        System.out.println(node2);

        ListNode node5 = new ListNode(5);
        ListNode node6 = node5.next = new ListNode(6);
        node6.next = new ListNode(4);
        System.out.println(node5);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        ListNode node2Reverse = addTwoNumbers.reverseListNode(node2);
//        System.out.println(node2Reverse);
//        ListNode node5Reverse = addTwoNumbers.reverseListNode(node5);
//        System.out.println(node5Reverse);

        System.out.println(addTwoNumbers.addTwoNumbers(node2, node5));
    }
}
