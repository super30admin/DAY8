/*
    Time Complexity : O(m*n). m = number of houses, n = no of colors

    Space Complexity : O(m*n)

    Did this code successfully run on Leetcode : Yes

    Refer notebook for matrix

    Here we started filling the matrix from last row to top, we can also do reverse.
 */

public class PaintHouseDPMatrix
{
    public int minCost(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];

        //filling last row
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i=m-2; i>=0; i--)
        {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}