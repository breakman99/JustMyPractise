package com.leetcode.OfferTwo;

public class No19 {
    public static void main(String[] args) {
        System.out.println();
    }
}


class No19_Solution {
    public boolean validPalindrome(String s) {
        int count = 0;
        int len = s.length();
        int i = 0, j = len - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (count < 1){
                if (s.charAt(i+1) == s.charAt(j)) {
                    i++;
                    count++;
                } else if (s.charAt(i) == s.charAt(j-1)) {
                    j--;
                    count++;
                } else return false;
            }
        }
        return count <= 1;
    }
}