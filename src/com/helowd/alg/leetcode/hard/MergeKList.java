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
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return null;
    }
}
