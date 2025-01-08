// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 256: Paint House
// Approach: Dynamic Programming
// Time Complexity: O(n)

class Solution
{
public:
    int minCost(vector<vector<int>> &costs)
    {

        // Base case if costs is not present
        if (costs.empty())
        {
            return 0;
        }

        int n = costs.size();

        for (int i = n - 2; i >= 0; i--)
        {
            // For each house the cost for painting would be the sum of the minimum cost of painting the adjacent house with a different color
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] = costs[i][2] + min(costs[i + 1][0], costs[i + 1][1]);
        }

        // Return the minimum total stored in first column for all houses
        return min(costs[0][0], min(costs[0][1], costs[0][2]));
    }
};
