package com.leetcode.test;

//欧科云链
public class OKYLTest01 {
    public static void main(String[] args) {
        System.out.println();
    }
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode start = p, e = p;
        for (;n-- != 0;) start = start.next;
        while (start.next != null) {
            start = start.next;
            e = e.next;
        }
        e.next = e.next.next;
        return p.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}