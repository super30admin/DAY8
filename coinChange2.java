// Time Complexity : O(n*k) where n is the different number of coins available and k is is the amount 
// Space Complexity : O(n*k) where n is the different number of coins available and k is is the amount 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't code the recursive solution successfully 


// Your code here along with comments explaining your approach

class coinChange2 {

    public static int change(int amount, int[] coins) {
    	if (coins.length == 0 && amount != 0) return 0;
        if (amount == 0) return 1;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= coins[i-1]) { // if amount >= denomination
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];    
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];   
    }
    public static void main(String[] args) {
    	int[] coins = {1,2,5};
    	System.out.println(change(5, coins));	
    }
}