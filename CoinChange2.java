//Time Complexity: O(mn) m - amount
//Space COmplexity: O (mn)
//LeetCode : No



class Solution {
    public int coinChange(int amount, int[] coins) {
        if(coins == null)return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        
        
        for(int i =0;i<coins.length; i++){
            dp[i][0] = 1;
        }
        
        for(int i =1; i< dp.length; i++){
            for(int j =1; j< dp[0].length +1; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]+1;
                     }
                
        }
    }
        return dp[dp.length-1][dp[0].length-1];
}
}