// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution
{
public:
    int minCost(vector<vector<int>> &costs)
    {
        if (costs.empty() || costs.size() == 0)
        {
            return 0;
        }

        // find tthe total # of houses
        int n = costs.size();

        // bottom up approach to find the minimum cost which is not adjacent to use different colors
        for (int i = n - 2; i >= 0; i--)
        {
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] = costs[i][2] + min(costs[i + 1][1], costs[i + 1][0]);
        }

        // return the minimum cost incurred to paint the houses
        return min(costs[0][0], min(costs[0][1], costs[0][2]));
    }
};