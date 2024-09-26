// Time Complexity : O(n) - number of rows of houses.
// Space Complexity : O(1) - Did not use extra space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size()==0) return 0;
        if(costs.size() == 1) return *min_element(costs[0].begin(), costs[0].end());
        for(int i = 1; i < costs.size(); ++i){ 
            costs[i][0] = min((costs[i][0]+costs[i-1][1]), (costs[i][0]+costs[i-1][2]));
            costs[i][1] = min((costs[i][1]+costs[i-1][0]), (costs[i][1]+costs[i-1][2]));
            costs[i][2] = min((costs[i][2]+costs[i-1][0]), (costs[i][2]+costs[i-1][1]));
        }
        return *min_element(costs[costs.size() - 1].begin(), costs[costs.size() - 1].end());
    }
};