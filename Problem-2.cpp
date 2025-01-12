// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution
{
public:
    int change(int amount, vector<int> &coins)
    {
        if (coins.empty())
        {
            return 0;
        }

        // dp vector to store the total # of ways the coins can be used
        vector<vector<double>> dp(coins.size() + 1, vector<double>((amount + 1), 0));

        // initialize column 1 to use 1 way to generate the amount
        for (int i = 0; i < dp.size(); i++)
        {
            dp[i][0] = 1;
        }

        // if the coin is selected add to the total to get maximum # of ways to get the amount
        for (int i = 1; i < dp.size(); i++)
        {
            for (int j = 1; j < dp[i].size(); j++)
            {
                // if the coin is not selected
                if (j < coins[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    // if the coin is selected
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[dp.size() - 1][amount];
    }
};