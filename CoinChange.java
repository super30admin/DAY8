
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :




public class CoinChange {
	    public int change(int amount, int[] coins) {
	        if(coins == null) return 0;

	        int[][] dp = new int[coins.length + 1][amount + 1];

	        for(int i = 0 ; i < dp.length ; i++) {
	            dp[i][0] = 1;
	        }

	        for(int i = 1 ; i < dp.length ; i++) {
	            for(int j = 1 ; j < dp[0].length ; j++) {
	                if(j < coins[i - 1]) {
	                    dp[i][j] = dp[i - 1][j];
	                } else {
	                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
	                }
	            }
	        }
	        return dp[dp.length - 1][dp[0].length - 1];
	        
	}
}
