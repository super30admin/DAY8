class Solution {
    public int change(int amount, int[] coins) {
        int m = amount+1;
        int n = coins.length+1;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(j<coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                }
                else
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[n-1][m-1];
    }
}

//TC:O(n*m)
//SC:O(n*m)
