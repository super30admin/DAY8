// Time Complexity :O(n^2)
// Space Complexity :O(amount + coins.length)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Referred a solution on leetcode, made an error while drawing up my dp matrix


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null||coins.length==0)//Edge cases
        {
            if(amount==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        int[][] dp = new int[coins.length+1][amount+1];
        
        dp[0][0] = 1;//one way of taking 0 amount for zero coin
        
        for(int i = 1; i<dp.length;i++){
            dp[i][0] = 1;//by not taking any coin
        }
        
        for(int j = 1; j<dp[0].length;j++){
            dp[0][j] = 0;//0 ways of getting anything >=1 from zero coins
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                
                if(j>=coins[i-1]){
                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; 
                }
                else{
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}
