//The approach here is to start at the bottom of the matrix and build to top by adding the cost to the minimum of the below row costs excluding the one in the same column.
//Time Complexity: O(n) where n is the no. of houses
//Space Complexity: O(n) where n is the no. of houses
public class PaintHouse {
    public static int minCost(int[][] cost) {
        // Write your code here.
        int n = cost.length;
        int[][] dp = new int[n][3];
        dp[n-1][0] = cost[n-1][0];
        dp[n-1][1] = cost[n-1][1];
        dp[n-1][2] = cost[n-1][2];

        for(int i = n-2; i>=0; i--){
            dp[i][0] = cost[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
