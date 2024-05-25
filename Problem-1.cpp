// Time Complexity : O(n*3)=>O(n) 
// Space Complexity : O(1) since we're not using any dp arrays and making use of variables
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        int redCost = costs[0][0];
        int blueCost = costs[0][1];
        int greenCost = costs[0][2];
        for(int i=1;i<costs.size();i++)
        {
            int tempRed = redCost;
            int tempBlue = blueCost;
            redCost = costs[i][0] + min(blueCost, greenCost);
            blueCost = costs[i][1] + min(tempRed, greenCost);
            greenCost = costs[i][2] + min(tempRed, tempBlue);
        }
        return min(redCost, min(blueCost, greenCost));
    }
};