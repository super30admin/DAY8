/*
TC --> O(n*3)
SC --> O(n*3)

 */
import java.util.*;

class Solution {

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);

            //System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]);
        }//for

        int min_val = 99999;
        for (int i = 0; i < 3; i++) {
            min_val = Math.min(min_val, dp[n - 1][i]);
            //System.out.print(min_val+" ");
        }

        return min_val;

    }

}
