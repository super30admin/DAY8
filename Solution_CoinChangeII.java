//TC: O(m x n)
//SC: O(m x n)
//Did it run on leetcode: Yes
public class Solution_CoinChangeII {
    // public int findWays(int amount, int[] coins, int ind){
    //     if(amount == 0)
    //         return 1;
    //     if(amount < 0 || ind == coins.length)
    //         return 0;
    //     int case1 = findWays(amount, coins, ind+1);
    //     int case2 = findWays(amount - coins[ind], coins, ind);
    //     return case1 + case2;
    // }

    public int change(int amount, int[] coins) {
        // int ans = findWays(amount, coins, 0);
        // return ans;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int r = 1; r <= m; r++){
            for(int c = 0; c <= n; c++){
                if(coins[r-1] > c)
                    dp[r][c] = dp[r-1][c];
                else
                    dp[r][c] = dp[r-1][c] + dp[r][c - coins[r-1]];
            }
        }
        return dp[m][n];
    }
}
