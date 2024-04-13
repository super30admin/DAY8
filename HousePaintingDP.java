// Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, i had to go through the lecture once again.

/*
 * Approach: the base case is at the bottom row (n-1)
 * from there calculate the min for each house at n-2 -> notice the next row is n-1 : if n-2 = i; n-1= i+1
 * find the min of each color at each row - local min
 * find the global min
 */
public class HousePaintingDP{
        /*
     * this is a bottom up approach too
     */
    public int minCost(int[][] costs) {
        int m = costs.length;
        int[][] dp = new int[m][3];

        // the last index would be our base
        for (int j = 0; j < 3; j++) {
            dp[m - 1][j] = costs[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

}