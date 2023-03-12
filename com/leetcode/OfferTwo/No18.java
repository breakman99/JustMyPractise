package com.leetcode.OfferTwo;

public class No18 {
    public static void main(String[] args) {
        System.out.println(new No18_Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new No18_Solution().isPalindrome("0P"));
    }
}

class No18_Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z' || i >= '0' && i <= '9') {
                if (i >= 'A' && i <= 'Z') {
                    i -= ('A' - 'a');
                }
                builder.append(i);
            }
        }
        System.out.println(builder.toString());
        System.out.println(builder.reverse());
        return (builder.toString()).equals(builder.reverse().toString());
    }
}