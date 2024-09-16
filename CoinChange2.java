//Time: O(amount*coins.length)
//Space: O(amount)
//Ran on LC, No issues

class Solution {
    public int change(int amount, int[] coins) {
        //validation
        if(amount==0) return 1;
        if(coins==null || coins.length==0){ return 0;}
        
        //logic starts here
        int dp[] = new int[amount+1]; dp[0]=1;
            for(int j=0; j<coins.length; j++){
                int coin = coins[j];
                for(int i=coin; i<=amount; i++){
                    dp[i]+=dp[i-coin];
                }
        }
        return dp[amount];
    }
}
