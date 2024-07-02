/*
    1. Time Complexity : O(n) - n - number of house
    2. Space Complexity : Memoization - O(n), Tabulation - O(1)    
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

import java.util.Arrays;
class Solution {
    static int[][] dp;
    public static int helper(int[][] costs, int i, int j) {
        if (i == costs.length) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        dp[i][j] = costs[i][j];
        if (j == 0)
            dp[i][j] += Math.min(helper(costs, i+1, 1), helper(costs, i+1, 2));
        else if (j==1)
            dp[i][j] += Math.min(helper(costs, i+1, 0), helper(costs, i+1, 2));
        else
            dp[i][j] += Math.min(helper(costs, i+1, 0), helper(costs, i+1, 1));
        return dp[i][j];
    }    
    public static int minCost(int[][] costs) {
        dp = new int[costs.length][3];
        return Math.min(Math.min(helper(costs, 0, 0), helper(costs, 0, 1)), helper(costs, 0, 2));
    }

    public static int minCost2(int[][] costs) {
        int houses = costs.length;
        int[][] dp = new int[houses + 1][3];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= houses; ++i) {
            dp[i][0] = costs[i-1][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i-1][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i-1][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(Math.min(dp[houses][0], dp[houses][1]), dp[houses][2]);
    }
    public static int minCost3(int[][] costs) {
        int houses = costs.length;
        int[] dp = new int[3];
        int rVal=0, bVal=0, gVal;
        for (int i = 1; i <= houses; ++i) {
            rVal = dp[0];
            bVal = dp[1];
            gVal = dp[2];
            dp[0] = costs[i-1][0] + Math.min(bVal, gVal);
            dp[1] = costs[i-1][1] + Math.min(rVal, gVal);
            dp[2] = costs[i-1][2] + Math.min(rVal, bVal);
        }
        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }
    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("Using Memoization -- Min cost to paint houses is:"+minCost(costs));
        System.out.println("Using Tabulation with O(n) space -- Min cost to paint houses is:"+minCost2(costs));
        System.out.println("Using Tabulation with O(1) space -- Min cost to paint houses is:"+minCost3(costs));
    }
}