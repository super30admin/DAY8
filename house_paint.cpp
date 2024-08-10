// Recursion approach
// Time complexity : 2^n where n is number of houses
// Space complexity : O(1) not counting stack space

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {

        int costR = helper(costs, 0, 0);
        int costB = helper(costs, 0, 1);
        int costG = helper(costs, 0, 2);

        // cout << " final : " << costR << " , " << costB << " , " << costG << "\n";

        return min(costR, min(costB, costG));
        
    }

    int helper(vector<vector<int>>& costs, int house_idx, int color_idx)
    {
        int cost = 0;

        // base
        if(house_idx >= costs.size())
        {
            return cost;
        }

            // case 0, current house = 0 Red
            if(color_idx == 0)
            {
                cost = costs[house_idx][color_idx] + min( helper(costs, house_idx+1, color_idx +1),
                                                              helper(costs, house_idx+1, color_idx +2));}
            // case 1, current house = 1 Blue
            if(color_idx == 1)
            {
                cost = costs[house_idx][color_idx] + min( helper(costs, house_idx+1, color_idx -1),
                                                              helper(costs, house_idx+1, color_idx +1));}
            // case 2, current house = 2 Green
            if(color_idx == 2)
            {
                cost = costs[house_idx][color_idx] + min( helper(costs, house_idx+1, color_idx -1),
                                                              helper(costs, house_idx+1, color_idx -2));}
        // cout << " house idx, color idx, cost : " << house_idx << " , " << color_idx << " , " << cost << "\n";
        return cost;
        

    }
};

// DP approach  - 2d vector
// Time complexity : O(n2) where n is number of houses
// Space complexity : O(n2)
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        vector<vector<int>> dp(costs.size(), vector<int>(3));

        dp[costs.size() - 1][0] = costs[costs.size() - 1][0];
        dp[costs.size() - 1][1] = costs[costs.size() - 1][1];
        dp[costs.size() - 1][2] = costs[costs.size() - 1][2];

        
        for(int house = costs.size() - 2; house >= 0; house-- )
        {
            for(int color = 0; color <= 2; color++)
            {
                int c1 = 0; 
                int c2 = 0;
                if(color == 0)
                {
                    c1 = color + 1;
                    c2 = color + 2;
                }
                else if(color == 1)
                {
                    c1 = color + 1;
                    c2 = color - 1;
                }
                else
                {
                    c1 = color -1;
                    c2 = color -2;
                }
                dp[house][color] = costs[house][color] + min(dp[house+1][c1], dp[house+1][c2]);

            }
        }
        return min(dp[0][0], min(dp[0][1],dp[0][2]));
    }
};

// DP - using 1D vector (3 variables)
// Time complexity : o(n2) where n is number of houses
// Space complexity : O(1) 

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int R = costs[costs.size() - 1][0];
        int B = costs[costs.size() - 1][1];
        int G = costs[costs.size() - 1][2];

        for(int house = costs.size() - 2; house >= 0; house-- )
        {
            int tempB = B;
            int tempR = R;
            for(int color = 0; color <= 2; color++)
            {
                
                if(color == 0)
                {
                    R = costs[house][color] + min(B, G);
                }
                else if(color == 1)
                {
                    B = costs[house][color] + min(G, tempR);
                }
                else
                {
                    G = costs[house][color] + min(tempR, tempB);
                }
            }
        }
        return min(R, min(B,G));
    }
};