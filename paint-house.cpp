/*Recursion Approach:

In the helper function, it calculates the minimum cost of painting houses from the row-th row onward with the given color for the current row.
The base case checks if row is equal to the number of rows in costs. If true, it returns the totalAmount. Otherwise, it recursively calculates the minimum cost for the next row and color.

Time Complexity: Exponential, O(3^n), where n is the number of rows in costs. The recursion tree has a large number of overlapping subproblems.
Space Complexity: O(n), as the maximum depth of the recursion tree is n.

DP Approach:

It creates a 2D vector dp to store solutions to subproblems. dp[i][j] represents the minimum cost of painting houses from the i-th row onward with color j.
The base case initializes the last row of dp with the costs of the last row in the costs matrix.
The nested loop iterates backward over the rows, calculating the minimum cost for each cell based on the costs of the next row.
The final result is the minimum cost of painting houses from the first row with any color.

Time Complexity: O(n), where n is the number of rows in costs. The algorithm fills up a table of size (m + 1) x 3 in a nested loop.
Space Complexity: O(m), as the 2D vector dp is used to store solutions to subproblems.
*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
//recursion approach
    // int minCost(vector<vector<int>>& costs) {
    //     int colorR=helper(costs,0,0,0);
    //     int colorB=helper(costs,0,1,0);
    //     int colorG=helper(costs,0,2,0);
    //     return min(colorR,min(colorB,colorG));
    // }
    // int helper(vector<vector<int>>& costs, int row, int color, int totalAmount){
    //     if(row==costs.size())return totalAmount;
    //     if(color==0){
    //         return min(helper(costs,row+1,1,totalAmount+costs[row][0]),helper(costs,row+1,2,totalAmount+costs[row][0]));
    //     }
    //     if(color==1){
    //         return min(helper(costs,row+1,0,totalAmount+costs[row][1]),helper(costs,row+1,2,totalAmount+costs[row][1]));
    //     }
    //     if(color==2){
    //         return min(helper(costs,row+1,0,totalAmount+costs[row][2]),helper(costs,row+1,1,totalAmount+costs[row][2]));
    //     }
    //     return 89890;
    // }

//dp
    int minCost(vector<vector<int>>& costs) {
        int m=costs.size();
        if(m==0)return 0;
        vector<vector<int>> dp(m + 1, vector<int>(3, 0));
        dp[m-1][0]=costs[m-1][0];
        dp[m-1][1]=costs[m-1][1];
        dp[m-1][2]=costs[m-1][2];
        for(int i=m-2;i>=0;i--){
            dp[i][0]=costs[i][0]+min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]=costs[i][1]+min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]=costs[i][2]+min(dp[i+1][0],dp[i+1][1]);
        }
        return min(dp[0][0],min(dp[0][1],dp[0][2]));
    }
};