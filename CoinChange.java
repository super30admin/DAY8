// Time Complexity : O(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach : since there are 2 decision making
//parameters we are using a dp matrix here. Then are each point if the current total is less than
// the coins then we just take the one above, else we are adding the one above and the coins remaining
// in the dp


/**
 * CoinChange : CoinChange
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Nov 04, 2024)
 * @since : 1.0 (Nov 04, 2024)
 */
public class CoinChange {

    public int change(int target, int[] coins) {
        int m = coins.length, n = target;
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}
