/*
    LC - 256. Paint House
    TC - O(mn)
    SC - O(mn)
    Approach - 
        Using bottom up matrix calculation,
        calculation from n-2 row to find the minimum cost
*/

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int costRed = recurse(costs, 0, 0 , 0);
        int costBlue = recurse(costs, 0, 1, 0);
        int costGreen = recurse(costs, 0, 2, 0);
        return Math.min(costRed, Math.min(costBlue, costGreen));
    }
    public int recurse(int[][] costs, int row, int color, int costIncurred) {
        if(row == costs.length) {
            return costIncurred;
        }

        if(color == 0) {
            return Math.min(recurse(costs, row+1, 1, costIncurred + cost[row][color]), recurse(costs, row+1, 2, costIncurred + cost[row][color]));
        } else if(color == 1) {
            return Math.min(recurse(costs, row+1, 0, costIncurred + cost[row][color]), recurse(costs, row+1, 2, costIncurred + cost[row][color]));
        } else if(color == 2) {
            return Math.min(recurse(costs, row+1, 0, costIncurred + cost[row][color]), recurse(costs, row+1, 1, costIncurred + cost[row][color]));
        }
    }
}

/*
    LC - 256. Paint House
    TC - O(n)
    SC - O(n)
*/
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];
        for(int i=0; i < 3; i++) {
            dp[n-1][i] = costs[n-1][j];
        }
        for(int i = n-2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

/*
    LC - 256. Paint House
    TC - O(n)
    SC - O(1)
*/
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int red = costs[n-1][0], blue = costs[n-1][1], green = costs[n-1][2];
        for(int i = n-2; i >= 0; i--) {
            int tempRed = red;
            red = costs[i][0] + Math.min(blue, green);
            int tempBlue = blue;
            blue = costs[i][1] + Math.min(tempRed, green);
            green = costs[i][2] + Math.min(tempRed, tempBlue);
        }
        return Math.min(red, Math.min(blue, green));
    }
}