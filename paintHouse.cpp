
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*Precomputing intermediate minimum costs from botton up to save time and repeated computations
Also done it using recursion and gives TLE due to repeated computations*/
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();

        for(int i=n-2; i>=0; i--){
            costs[i][0]+= min(costs[i+1][1], costs[i+1][2]);
            costs[i][1]+= min(costs[i+1][0], costs[i+1][2]);
            costs[i][2]+= min(costs[i+1][0], costs[i+1][1]);
        }
        return min(costs[0][0], min(costs[0][1], costs[0][2]));
    }
};