// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class PaintHouse {

    //Time complexity - O(n)
    //Space complexity - O(1)
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];

        for(int j=0;j<3;j++) {
            dp[j] = costs[n-1][j];
        }

        for(int i=n-2;i>=0;i--) {
            int temp1 = dp[0];
            dp[0] = costs[i][0] + Math.min(dp[1], dp[2]);
            int temp2 = dp[1];
            dp[1] = costs[i][1] + Math.min(temp1, dp[2]);
            dp[2] = costs[i][2] + Math.min(temp1,temp2);
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }


    //Time complexity - O(n)
    //Space complexity - O(n)
    /*public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        for(int j=0;j<3;j++) {
            dp[n-1][j] = costs[n-1][j];
        }

        for(int i=n-2;i>=0;i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }*/

    // recursive approach
    // Time complexity: 2^n
   /* public int minCost(int[][] costs) {
        int costR =  helper(costs,0,0,0);
        int costB =  helper(costs,0,1,0);
        int costG =  helper(costs,0,2,0);

        return Math.min(costR,Math.min(costB,costG));
    }

    public int helper(int[][] costs, int i, int color, int totalCost) {
        //base case
        if(i == costs.length){
            return totalCost;
        }

        //logic
        if(color == 0) {
            return Math.min(helper(costs, i+1,1, totalCost+costs[i][0]),
                    helper(costs, i+1,2, totalCost+costs[i][0]));
        }else if(color == 1) {
            return Math.min(helper(costs, i+1,0, totalCost+costs[i][1]),
                    helper(costs, i+1,2,totalCost+costs[i][1]));
        }else if(color == 2) {
            return Math.min(helper(costs, i+1, 0, totalCost+costs[i][2]),
                    helper(costs, i+1, 1, totalCost+costs[i][2]));
        }

        return 3535;
    }*/
}