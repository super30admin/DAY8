/*
Time Complexity: O(m*n)

Space Complexity: O(n)

Did this code successfully run on Leetcode: Yes

*/

public class CoinChange2ArrayDP
{
        public int change(int amount, int[] coins) {

            int m = coins.length;
            int n = amount;

            int[] dp = new int[n+1];
            dp[0] = 1; //[]^0 when amount is zero we return 1 in exhaustive

            //For loop for filling dp array
            for(int i=1; i<=m; i++)
            {
                for(int j=0; j<=n; j++)
                {
                    //Check if choose case if available
                    if(j < coins[i-1]) //0<2
                    {
                        dp[j] =  dp[j]; //no choose case is available in same place
                    }

                    //both choose case and no choose case available
                    else {
                        dp[j] = dp[j] + dp[j-coins[i-1]];
                    }
                }
            }

            return dp[n];
        }
}