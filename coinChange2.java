//Time Complexity - O(m * n)
//Space Complexity - O(m * n)
//Here we fill the j  == 0 column completely with 1. There is always 1 way to have a coin of some value to make the amount 0. ( we simply do not include that coin). 
// for coin of value 0, to make any sum using it , 0 ways are to do it. 
// Find Case0 and case1. Add them up. if amount < coins[i-1] , return case0 only. 
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
