package Day9;

public class CoinChange2 {

    public int change(int amount, int[] coins){

        if(coins == null) return 0;

        int m = coins.length + 1;
        int n = amount + 1;

        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String args[]){
        CoinChange2 ob = new CoinChange2();

        int[] nums = new int[]{1,2,5};

        System.out.println("The number of combinations of denominations to achieve target amount: "+ ob.change(5,nums));
    }
}
