//time Complexity  - O(mn) m=number of coins, n = amount
// space complexity - O(mn) with space optimization O(n)

public class Solution
{
    public int Change(int amount, int[] coins)
    {
        int m = coins.Length;
        int n = amount;
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (coins[i - 1] <= j)
                {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
                // if(coins[i-1] > j)
                // {
                //     //case 1
                //     dp[i,j] = dp[i-1,j];
                // }
                // else
                // {
                //     //case 2
                //     dp[i,j] = dp[i-1,j] + dp[i,j-coins[i-1]];
                // }
            }
        }
        return dp[n];
    }
}