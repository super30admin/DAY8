//Time complexity: O(m x n)
//Space complexity: O(m x n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return 0;
        }

        //dp array to store the number of ways to make the amount using the coins
        int[][] dp = new int[coins.length + 1][amount + 1];

        //fill the first column with 1 as there is only 1 way to make the amount 0
        for(int i=0; i<coins.length+1; i++){
            dp[i][0] = 1; 
        }

        
        for(int i = 1; i< coins.length + 1; i++){
            for(int j = 1; j<amount+1; j++){
                //if the amount is less than the denomination of the coin, then we cannot include the coin and 
                //the number of ways to make the amount will be the same as the number of ways to make the amount using the previous coin
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }

                //else we can add the number of ways to make the amount using the previous coin and the number of ways to make the amount - the denomination of the coin
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        //return the number of ways to make the amount using all the coins by returning the last element of the dp array
        return dp[coins.length][amount];
    }
}