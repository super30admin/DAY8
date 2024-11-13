// Time Complexity: O(m), where m is the number of houses. We iterate through each house once, performing constant-time operations for each.
// Space Complexity: O(m * n), where m is the number of houses and n is the number of colors (in this case, 3). We use a 2D array to store the minimum cost for each house and each color.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

public class problem1 {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n= costs[0].length;

        int[][] dp= new int[m][n];
        dp[0][0]= costs[0][0];
        dp[0][1]= costs[0][1];
        dp[0][2]=costs[0][2];

        for(int i=1;i<m;i++)
        {
            dp[i][0]=costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=costs[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[m-1][0],Math.min(dp[m-1][1], dp[m-1][2]));
    }
}
