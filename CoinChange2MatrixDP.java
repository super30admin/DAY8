/*
Time Complexity: O(m*n)

Space Complexity: O(m*n)

Did this code successfully run on Leetcode: Yes

*/

public class CoinChange2MatrixDP
{
    public int change(int amount, int[] coins) {

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1; //[]^0 when amount is zero we return 1 in exhaustive

        /*
        We don't use a for loop for filling the 0th row like previous problem as previously 0th row was filled
        with max value, in this problem 0th row other than [0,0] is by default 0
        */

        //For loop for filling dp matrix
        for(int i=1; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                //Check if choose case if available
                if(j < coins[i-1]) //0<2 so fill from the above row
                {
                    dp[i][j] =  dp[i-1][j];
                }

                //both choose case and no choose case available
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}

