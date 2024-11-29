// Time Complexity : O(m*n).m is the length of the coins. n is the amount
// Space Complexity O(n). n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length+1][amount+1];
        
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                   dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[coins.length][amount];
       
    }
}
