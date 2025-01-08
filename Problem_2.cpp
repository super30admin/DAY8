// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 518: Coin Change II
// Approach: Dynamic Programming
// Time Complexity: O(m x n)

class Solution
{
public:
    int change(int amount, vector<int> &coins)
    {

        // Base case to check if no coins present
        if (coins.empty())
        {
            return 0;
        }

        vector<vector<double>> dp(coins.size() + 1,
                                  vector<double>(amount + 1, 0));

        // Init the DP Table
        for (int i = 0; i <= coins.size(); i++)
        {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.size(); i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j < coins[i - 1])
                {
                    // Case 0 - Don't Pick
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    // Case 1- Pick
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        // Number of ways to make 'amount' with coins
        return dp[coins.size()][amount];
    }
};
