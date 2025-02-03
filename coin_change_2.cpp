// Time Complexity: O(n*m)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach: Dynamic Programming
// 1. We will create a dp 1 D array.
// 2. We will fill the dp array with 0 at the 0th index.
// 3. Then we will iterate over the coins array and fill the dp array with the number of ways to make the amount with the respective coin.
// 4. We will return the last element of the dp array.

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int>dp(amount+1, 0);
        dp[0] = 1;
        for(int i = 0; i<coins.size(); i++){
            for(int j = coins[i]; j<= amount; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
};
