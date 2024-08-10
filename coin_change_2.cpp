// Recursion
// time complexity : 2^n where n is number of coins 
// space complexity: constant.not counting stack space

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        return helper(coins, 0+1, amount) + helper(coins, 0, amount - coins[0]);
    }

    int helper(vector<int>& coins, int idx, int amount)
    {
        // base
        if(amount == 0 )
        {
            return 1;
        }

        if(amount < 0 || idx >= coins.size())
        {
            return 0;
        }

        // choose

        int c1 = helper(coins, idx, amount - coins[idx]);

        // not choose
        int c2 = helper(coins, idx+1, amount);

        return c1+c2;
    }
};


// DP - 2d vector 
// time: o(n*amount)
// space: o(n*amount)
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1, 0));

        for(int i =1; i<= coins.size(); i++)
        {
            dp[i][0] = 1;
        }

        for(int coin_idx = 1; coin_idx <= coins.size(); coin_idx++)
        {
            // cout << " coin  " << coin_idx << "\n";
            for(int amt_idx = 1; amt_idx <= amount; amt_idx++)
            {
                // cout << " coin , amt " << coin_idx << " , " << amt_idx << "\n ";

                int index_to_look_for = amt_idx - coins[coin_idx-1];
                if(index_to_look_for < 0)
                {
                    dp[coin_idx][amt_idx] = dp[coin_idx-1][amt_idx];
                }
                else{
                dp[coin_idx][amt_idx] = dp[coin_idx-1][amt_idx] + dp[coin_idx][index_to_look_for];
                    
                }
            }
        }

        return dp[coins.size()][amount];
    }
};

// DP - 1d vector 
// time: o(n*amount)
// space: o(amount)

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> dp(amount+1,0);
        dp[0] = 1; // 1 way to make amount 0 from 0 coins


        for(int coin_idx = 1; coin_idx <= coins.size(); coin_idx++)
        {
            for(int amt_idx = 1; amt_idx <= amount; amt_idx++)
            {
                int index_to_look_for = amt_idx - coins[coin_idx-1];
                if(index_to_look_for < 0)
                {
                    dp[amt_idx] = dp[amt_idx];
                }
                else{
                dp[amt_idx] = dp[amt_idx] + dp[index_to_look_for];
                    
                }
            }
        }

        return dp[amount];
    }
};