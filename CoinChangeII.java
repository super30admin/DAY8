// Time Complexity :O(n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode :Yes, on the first try without any error
// Any problem you faced while coding this :No
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        if(coins==null||coins.length==0)
            return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            dp[i][0] = 1;
        }
       
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                dp[i][j] = dp[i-1][j] + ( j-coins[i-1] >= 0 ? dp[i][j-coins[i-1]]:0 );
            }
        }
        return dp[coins.length][amount];
    }
}
