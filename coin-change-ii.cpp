/*Recursion Approach:

In the helper function, it calculates the number of combinations to make the given amount using coins from the i-th index onward.
The base cases check if amount is negative or if all coins are considered (i == coins.size()). If amount is 0, it returns 1, indicating a valid combination.
The result is the sum of two cases: excluding the current coin (case0) and including the current coin (case1).

Time Complexity: Exponential, O(2^(m+n)), where m is the number of types of coins, and n is the target amount. The recursion tree has a large number of overlapping subproblems.
Space Complexity: O(m+n), as the maximum depth of the recursion tree is m + n.

DP Approach:

It creates a 2D vector dp to store solutions to subproblems. dp[i][j] represents the number of combinations to make amount j using the first i types of coins.
The base case is initialized as dp[0][0] = 1, indicating one way to make amount 0 (no coins).
The nested loops iterate over all types of coins and amounts, updating dp based on the recurrence relation.
The final result is stored in dp[m][n], where m is the number of types of coins, and n is the target amount.
Time and Space Complexity:

Time Complexity: O(m * n), where m is the number of types of coins, and n is the target amount. The algorithm fills up a table of size (m + 1) x (n + 1) in a nested loop.
Space Complexity: O(m * n), as the 2D vector dp is used to store solutions to subproblems.
*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
//recursion approach
    // int change(int amount, vector<int>& coins) {
    //     return helper(amount,coins,0);
    // }
    // int helper(int amount, vector<int>& coins, int i){
    //     if(amount<0||coins.size()==i)return 0;
    //     if(amount==0)return 1;
    //     int case0 =helper(amount,coins,i+1);
    //     int case1 =helper(amount-coins[i],coins,i);

    //     return case0+case1;
    // }

//dp
    int change(int n, vector<int>& coins) {
        int m=coins.size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        dp[0][0]=1;
    
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=(dp[i-1][j]+dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[m][n];
    }
};