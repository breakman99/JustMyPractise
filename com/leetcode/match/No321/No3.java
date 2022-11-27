package com.leetcode.match.No321;

import java.util.Deque;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class No3 {
    // 单调栈
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        deque.addLast(head);
        ListNode node = head;
        while (node != null) {
            while (!deque.isEmpty() && deque.getLast().val < node.val) deque.removeLast();
            deque.addLast(node);
            node = node.next;
        }
        ListNode nhead = new ListNode(-1);
        ListNode nnode = nhead;
        while (!deque.isEmpty()) {
            nnode.next = deque.removeFirst();
            nnode = nnode.next;
        }
        nnode.next = null;
        return nhead.next;
    }
}
