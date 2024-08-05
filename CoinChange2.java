//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i =1; i<=m;i++){
            for(int j=0; j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        int amount = 5;
        int[] coins = new int[]{1,2,5};
        int result = change(amount, coins);
        System.out.println(result);
    }
}
