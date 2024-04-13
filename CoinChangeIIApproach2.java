// Time Complexity : O(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * DP Approach:
 * basecase = dp[0][0]is 1
 * lets start with i=row=1 and j=column=0
 * if amount is less than the current denomiation- bring above row value [i-1][j]
 * if amount is greater than the current denomiation -> dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]]
 * 
 * return dp[r-1][c-1]
 */
public class CoinChangeIIApproach2{

    public int change(int amount, int[] coins) {
            int r = coins+1;
            int c = amount+1;

            int[][] dp = new int[r][c];

            dp[0][0]=1;

            for(int i=1; i<r; i++){
                for(int j=0; j<c; j++){ // why 0
                    if(j<coins[i-1]){// amount less than coins[i]
                            dp[i][j]= dp[i-1][j];
                    }else{
                        dp[i][j]= dp[i-1][j]+ dp[j-coins[i-1]]; // coin above + j- coint
                    }
                }
            }
            
            return dp[r-1][c-1];

    }

}