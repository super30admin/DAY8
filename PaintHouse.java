class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        // int costRed = recurse(costs, 0, 0, 0);
        // int costGreen = recurse(costs, 0, 1, 0);
        // int costBlue = recurse(costs, 0, 2, 0);
        // return Math.min(costRed, Math.min(costBlue, costGreen));

        // DP solution
        // int n = costs.length;
        // System.out.println(n);
        // for(int i = n - 2; i >= 0; i--) {
        //     costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1],
        //     costs[i + 1][2]);
        //     costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0],
        //     costs[i + 1][2]);
        //     costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0],
        //     costs[i + 1][1]);
        // }

        // return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));

        // DP solution with new matrix
        // int n = costs.length;
        // int[][] dp = new int[n][3];
        // for(int j = 0; j < 3; j++) {
        //     dp[n - 1][j] = costs[n - 1][j];
        // }
        // for(int i = n - 2; i >= 0; i--) {
        //     dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
        //     dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
        //     dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        // }
        // return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));

        // DP solution with temp variable
        int n = costs.length;
        int red = costs[n - 1][0];
        int blue = costs[n - 1][1];
        int green = costs[n - 1][2];

        for(int i = n - 2; i >= 0; i--) {
            int tempRed = red;
            red = costs[i][0] + Math.min(blue, green);
            int tempBlue = blue;
            blue = costs[i][1] + Math.min(tempRed, green);
            
            green = costs[i][2] + Math.min(tempRed, tempBlue);
        }
        return Math.min(red, Math.min(blue, green));
    }

    private int recurse(int[][] costs, int row, int color, 
    int costIncurred) {
        // base
        if(row == costs.length) {
            return costIncurred;
        }

        //logic
        if(color == 0) {
            return Math.min(recurse(costs, row + 1, 1, costIncurred 
            + costs[row][color]), recurse(costs, row + 1, 2, costIncurred 
            + costs[row][color]));
        } else if(color == 1) {
            return Math.min(recurse(costs, row + 1, 0, costIncurred 
            + costs[row][color]), recurse(costs, row + 1, 2, costIncurred 
            + costs[row][color]));
        } else {
            return Math.min(recurse(costs, row + 1, 0, costIncurred 
            + costs[row][color]), recurse(costs, row + 1, 1, costIncurred 
            + costs[row][color]));
        }
    }
}
