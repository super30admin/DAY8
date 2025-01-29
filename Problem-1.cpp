// https://leetcode.com/problems/paint-house/description/
// Time Complexity : O(n) where n is the length of the costs matrix/ number of rows in costs matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Store the minimum value of painting upto the current house.
// The first house (first row) will have the values as it is as there is not previous house.
// For the next house(row), calculate the min cost by adding the cost of painting current with a color and min cost of painting until 
// previous house with other colors.

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        for(int i=1; i<n; i++){
            costs[i][0] = costs[i][0] + min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] = costs[i][1] + min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] = costs[i][2] + min(costs[i-1][0],costs[i-1][1]);
        }
        return min(costs[n-1][0], min(costs[n-1][1], costs[n-1][2]));

    }
};
