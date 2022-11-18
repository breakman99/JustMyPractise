package com.leetcode.test;
import java.util.*;
public class Main {
            public static void main(String[] args) {
                // Scanner input=new Scanner(System.in);
                // String str=input.next();
                ListNode test = new ListNode(0);
                ListNode b = test;
                for (int i = 1; i <= 8; i++) {
                    b.next = new ListNode(i);
                    b = b.next;
                }
                ListNode result = new Main().test(3, test.next);
                ListNode c = result;
                for (int i = 1; i <= 8; i++) {
                    System.out.println(c.val);
                    c = c.next;
                }
                System.out.println("hello world");
            }
            public ListNode test(int k, ListNode head) {
                // pre
                ListNode a = new ListNode(0);
                a.next = head;
                ListNode pre = a;
                ListNode end = a;
                while (end.next != null) {
                    for (int i = 0; i < k && end.next != null; i++) {
                        end = end.next;
                    }
                    if (end == null) {
                        break;
                    }
                    ListNode left = pre.next;
                    ListNode right = end.next;
                    end.next = null;
                    // reverse
                    pre.next = reverse(left);
                    left.next = right;
                    pre = left;
                    end = pre;
                }
                return a.next;
            }

            public ListNode reverse(ListNode head) {
                // reverse
                ListNode pre = null;
                ListNode node = head;
                while (node != null) {
                    ListNode next = node.next;
                    node.next = pre;
                    pre = node;
                    node = next;
                }
                return pre;
            }
        }
//
//class ListNode {
//            int val;
//            ListNode next;
//
//            public ListNode() {
//                val = 0;
//                next = null;
//            }
//
//            public ListNode(int val) {
//                this.val = val;
//                next = null;
//            }
//        }