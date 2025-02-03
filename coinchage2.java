// Time Complexity : O(nm)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

public class coinchage2 {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int [] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(coins[i-1]<=j){
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}
