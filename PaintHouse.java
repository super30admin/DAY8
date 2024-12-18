/*
    Leetcode problem : 
    T.C: O(n) :: S.C: O(n) - No. of colors are 3: R,G,B

    Solved using dp approach: Calculate the min from bottom-up
    add the min of the two adjacent house to the second last row
    for each element and return the min from the first row of dp.
*/

class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
                
        int n = costs.length;
        int m = costs[0].length; //here m == 3 - R,G,B
        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = costs[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j + 1], dp[i + 1][j + 2]);
                } else if (j == 1) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j - 2], dp[i + 1][j - 1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}