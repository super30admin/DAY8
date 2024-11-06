// Approach : DP
// Time : o(nT) # T - Target
// Space: o(nT) # T - Target
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1]; // coin denominations vs target

        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1; // To fill first column
        };

        for(int j=1;j<=amount;j++){
            dp[0][j]=0; // To fill first row
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                } else{
                    dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        int result = dp[coins.length][amount];
        return result;
    }
}