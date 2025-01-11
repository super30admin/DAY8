// Approach 1:
// TC: O(m*n), where m = number of coins and n = amount
// SC: O(m*n)

// Approach 2:
// TC: O(m*n)
// SC: O(n)


// Approach 1: Tabulation with 2D Array
public class LC518 {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0){
            return 0;
        }
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0) dp[0][j] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int total = 0;
                if(j>=coins[i]) total += dp[i][j-coins[i]];
                total += dp[i-1][j];
                dp[i][j] = total;
            }
        }
        return dp[n-1][amount];
    }
}

// Approach 1: Tabulation with 1D Array
class Solution2 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int n = coins.length;
        int prev[] = new int[amount + 1];
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0)
                prev[j] = 1;
        }
        for (int i = 1; i < n; i++) {
            int dp[] = new int[amount + 1];
            dp[0] = 1;
            for (int j = 1; j <= amount; j++) {
                int total = 0;
                if (j >= coins[i])
                    total += dp[j - coins[i]];
                total += prev[j];
                dp[j] = total;
            }
            prev = dp;
        }
        return prev[amount];
    }
}