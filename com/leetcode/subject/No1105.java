package com.leetcode.subject;

public class No1105 {
    public static void main(String[] args) {
        System.out.println(new No1105Solution().minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4));
    }
}

/**
 * 输入：books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4  <br/>
 * 输出：6  <br/>
 * 解释：  <br/>
 * 3 层书架的高度和为 1 + 3 + 2 = 6 。  <br/>
 * 第 2 本书不必放在第一层书架上。<br/>
 */
class No1105Solution {
    // [[1,1] , [2,3] , [2,3] , [1,1] , [1,1] , [1,1] , [1,2]]
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len + 1];
        dp[1] = books[0][1];
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + books[i - 1][1];
        }
        for (int i = 1; i < len; i++) {
            int width = 0, height = 0;
            for (int j = i; j >= 0; j--) {
                width += books[j][0];
                height = Math.max(height, books[j][1]);
                if (width > shelfWidth) {
                    break;
                }
                dp[i + 1] = Math.min(dp[j] + height, dp[i + 1]);
            }
        }
        return dp[len];
    }
}

