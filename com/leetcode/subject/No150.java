package com.leetcode.subject;

import java.util.Deque;
import java.util.LinkedList;

public class No150 {
    Deque<Integer> deque;
    public int evalRPN(String[] tokens) {
        deque = new LinkedList<>();
        for (String i : tokens) {
            switch (i) {
                case "+":
                    deque.addFirst(deque.removeFirst() + deque.removeFirst());
                    break;
                case "-":
                    deque.addFirst(-(deque.removeFirst() - deque.removeFirst()));
                    break;
                case "*":
                    deque.addFirst(deque.removeFirst() * deque.removeFirst());
                    break;
                case "/":
                    int a = deque.removeFirst();
                    int b = deque.removeFirst();
                    deque.addFirst(b / a);
                    break;
                default:
                    deque.addFirst(Integer.valueOf(i));
            }
        }
        return deque.removeFirst();
    }
}
