// Time Complexity : O(amount*n)
// Space Complexity : O(amount*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    // int helper(int amt, vector<int>& coins, int idx) {
    //     if (amt == 0) return 1;
    //     if (amt <0 || idx >= coins.size()) return 0;

    //     //pick
    //     int pick = helper(amt-coins[idx], coins, idx);
    //     //not pick
    //     int no_pi = helper(amt, coins, idx+1);
    //     return pick+no_pi;
    // }
    int change(int amount, vector<int>& coins) {
        if (coins.size() == 0) return 0;
        int m = coins.size();
        int n = amount;
        vector<vector<unsigned long long>> dp(m+1, vector<unsigned long long>(n+1,0));
        dp[0][0] = 1;
        for (int i=1; i<=m; i++) {
            for (int j=0; j<=n;j++) {
                if (coins[i-1] >j) dp[i][j] = dp[i-1][j];
                else
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[m][n];
    }
};