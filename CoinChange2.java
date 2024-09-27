//o(n*m) time and space complexities
//passed all leetcode cases
// used approach discussed in class

class Solution {
    public int change(int amount, int[] coins) {
        //edge
        if(coins == null) return 0;
        int [][] dp = new int [coins.length+1][amount+1];
        int m = coins.length;
        int n = amount;
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}