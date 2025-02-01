// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    // int helper(vector<vector<int>>& costs, int idx, int color) {
    //     if (idx == costs.size()) return 0;
    //     if (color == 0) {
    //         return costs[idx][color] + min (helper(costs, idx+1, 1), helper(costs, idx+1, 2));
    //     }
    //     if (color == 1) {
    //         return costs[idx][color] + min (helper(costs, idx+1, 0), helper(costs, idx+1, 2));
    //     }
    //     if (color == 2) {
    //         return costs[idx][color] + min (helper(costs, idx+1, 1), helper(costs, idx+1, 0));
    //     }
    //     return -21;
    // }
    int minCost(vector<vector<int>>& costs) {
        // return min (helper(costs, 0, 0), min(helper(costs, 0, 1), helper(costs, 0, 2)));
        int n = costs.size();
        vector<int> dp(3,0);
        dp[0] = costs[n-1][0];
        dp[1] = costs[n-1][1];
        dp[2] = costs[n-1][2];
        for (int i=n-2; i>=0;i--) {
            int t1 = dp[0];
            int t2 = dp[1];
            dp[0] = costs[i][0] + min(dp[1], dp[2]);
            dp[1] = costs[i][1] + min(t1, dp[2]);
            dp[2] = costs[i][2] + min(t2, t1);
        }
        return min(dp[0], min(dp[1], dp[2]));
    }
};