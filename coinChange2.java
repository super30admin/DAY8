//Time Complexity - O(m * n)
//Space Complexity - O(m * n)
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return 0;
        }
        int[][] dp = new int[coins.length +1][amount +1];
        //coins[] = 1,2,5 length = 3
        // we are having extra element which is 0 at the beginning. so coins.length + 1
        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
        
    }
}
