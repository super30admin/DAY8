// Time Complexity: O(m * n), where m is the number of coins and n is the amount. We iterate through each coin and for each coin, we iterate through all amounts up to n.
// Space Complexity: O(n), where n is the amount. We use a 1D dp array of size n + 1 to store the number of ways to make each amount.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Your code here along with comments explaining your approach

/*
Approach:
1. We use dynamic programming to solve this problem. The dp array is used to store the number of ways to make each amount.
2. Initialize dp[0] to 1 because there is one way to make the amount 0: by using no coins.
3. We iterate over each coin and update the dp array. For each coin, we iterate through all amounts from 0 to n.
4. If the current amount (j) is less than the coin value, we simply retain the existing value of dp[j].
5. If the current amount (j) is greater than or equal to the coin value, we update dp[j] to include the number of ways to make the amount using the current coin. This is done by adding dp[j - coins[i - 1]] to dp[j].
6. Finally, return dp[n], which gives the total number of ways to make the given amount using the coins.
*/

public class problem2 {

    public int change(int amount, int[] coins) {
        int m= coins.length;
        int n= amount;
        int[] dp= new int[n+1];
        dp[0]=1;
        for(int i=1;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(j<coins[i-1])
                {
                    dp[j]=dp[j];
                }
                else
                {
                    dp[j]=dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}
