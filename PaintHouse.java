// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: at each point we can either choose 0, 1, 2
// so if we take 1 we are doing dp for 0 and 2 and taking the min from them.


/**
 *  PaintHouse : PaintHouse
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Nov 04, 2024)
 * @since : 1.0 (Nov 04, 2024)
 *
 */
 public class PaintHouse {
    public int minCost(int[][] costs) {
        int m = costs.length, n = costs[0].length;
        int dp[][] = new int[m][n];
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];
        for(int i = m-2 ; i >= 0; i--){
         dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
         dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
         dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
