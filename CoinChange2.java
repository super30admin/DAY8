//TC: O(coins.length*amount)
//SC: O(coins.length*amount)
//approach: dynamic programming
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        if(coins.length == 1){
            return amount % coins[0] == 0 ? 1 : 0;
        }
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=1;i<=coins.length;i++){
            dp[i][0] =1;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{

                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
