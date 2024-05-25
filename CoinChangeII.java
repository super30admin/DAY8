/**
 L.C: 518 Coin Change II
 Approach: Dynamic Programming
 Working:
     we have amount and the coins array
     declare and dp matrix of row = coin array length+1 and column = amount+1, to accommodate dummy oth index columns
     for amount zero the number of way to get it with all coins ia one, i.e not choosing a coin

     iterate to each i,j i. problem in a matrix,
     compute the zero case ande 1 case sub-problem for each i,j
     return the m*nth index which is the possible number of ways to form the amount


 Time Complexity: O(m*n)
 Space Complexity: O(m*n)
 */

class CoinChangeII {
    public int change(int amount, int[] coins) {

        if(coins == null || coins.length == 0) {
            return 0;
        }

        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0;i<coins.length+1; i++) {
            dp[i][0] = 1;
        }

        for(int i=1;i<coins.length+1; i++) {
            for(int j=1;j<amount+1; j++) {

                if(j< coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j]+dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];
    }
}