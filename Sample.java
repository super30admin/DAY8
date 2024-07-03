// Time Complexity : O(n) where n is number of houses we have to paint
// Space Complexity : O(n) where n is number of houses we have to paint and 3 colors is a constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : after solving this problem in the class then only I was able to solve this.


// Your code here along with comments explaining your approach
// In this solution we are going from last house to the first one. The last row we will store the origial costs of red blue and green paints. Then, when we will 
// go to the above row we will check the minimum value from below row with other two colors except the current one and add it to the current cost of the color.
// For example we are in the second last row red color column and checking the cost we will check the minimum cost between blue and green of the next row and 
// add it to the cost of red color. If we go like this till the top row then in the top row we will get the costs of all the paths and we will choose the 
// minimum cost.
class Solution {
    public int minCost(int[][] costs) {
        
        if (costs == null) {
            return 0;
        }

        int n = costs.length;
        // int[][] dp = new int[n][3];

        // dp[n-1][0] = costs[n-1][0];
        // dp[n-1][1] = costs[n-1][1];
        // dp[n-1][2] = costs[n-1][2];

        int resultR = costs[n-1][0];
        int resultB = costs[n-1][1];
        int resultG = costs[n-1][2];

        for(int i = n-2; i >= 0; i--) {
            // dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            // dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            // dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);

            int tempR = resultR;
            resultR = costs[i][0] + Math.min(resultB, resultG);

            int tempB = resultB;
            resultB = costs[i][1] + Math.min(tempR, resultG);

            int tempG = resultG;
            resultG = costs[i][2] + Math.min(tempR, tempB);
        }

        // return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
        return Math.min(resultR, Math.min(resultB, resultG));
    }
}


// Time Complexity : O(m*n) where m is number of coins present in the array and n is target amount.
// Space Complexity : O(m*n) to store the dp matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Having hard time solving DP problems but understanding it in the class.


// Your code here along with comments explaining your approach
// Here we are going to use same approach we used in Coin Change 1 but here instead of amount we will store number of ways to achieve given amount.
// In this first we will initialize all the elements in the 0th row matrix of the dp to 1. Then we will use a nested for loop and for each element if the current 
// amount is less than the coin which we are using we will assign i-1 row number as it is as there is no way to make that amount with lesser number of coin. 
// In the else block we will get the existing number of ways from i-1 row and add it with the number of ways which we could use from the same row and amount-current
// coin index. So, basically we are checking if we subtract current coin from current amount then the remaining amount can be achieved using same coin.
// At the end we will return the last element of dp which will have total number of ways.
class Solution {
    public int change(int amount, int[] coins) {
        
        int m = coins.length;
        int n = amount;

        // int[][] dp = new int[m+1][n+1];
        int[] dp = new int[n+1];

        // dp[0][0] = 1;
        dp[0] = 1;

        // for(int i = 0; i <= m; i++) {
        //     dp[i][0] = 1;
        // }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (j < coins[i-1]) {
                    // dp[i][j] = dp[i-1][j];
                    dp[j] = dp[j];
                } else {
                    // dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }

        // return dp[m][n];
        return dp[n];
    }
}