// https://leetcode.com/problems/coin-change-ii/description/
// Time Complexity : O(n*m) where m is the length of coins and n is the amount+1
// Space Complexity : O(n) where is the amount+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// For each coin and for each value from 1 to amount, calculate number of ways to make the amount using coins.

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<unsigned long long> dp(amount+1, 0);
        dp[0] = 1;
        for(auto c:coins){
            for(int i=c; i<=amount; i++){
                dp[i] += dp[i-c];
            }
        }
        return dp[amount];
    }
};