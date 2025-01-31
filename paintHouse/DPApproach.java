package paintHouse;

import java.util.Arrays;

// Time Complexity :O(n)
// Space Complexity :O(n) extra array used can be done in O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

public class DPApproach {

    public static void main(String[] args) {

        int[][] costs = {{17,2,17}, {16,16,5},{14,3,19}};
//        int[][] costs = {{7,6,2}};

        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {

        int n = costs.length;
        if(costs == null ||costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i < costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2] );
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2] );
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1] );
        }

        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
