// Time Complexity : O(m*n) where n is cost to paint and m is number of colors(m=3) So here it is O(n) because m is constant
// Space Complexity : O(1) since we arent using any auxiliary space(for mutation approach) and constant space for non-mutation approach
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solved after class, couldnt come up with solution before class


// Your code here along with comments explaining your approach
// Top down approach - mutation
// Approach: We will use top down DP approach  - we will calculate the cost by finding
// the min cost of painting adjacent houses with either of the other colors and coloring
// the current house with 3rd remaining color, thenn we will find the min of resultant of 3 
// possibilities and return it

class PaintHouses {
    public int minCost(int[][] costs) {
        int n = costs.length-1;
        //edge case
        if(costs == null || n ==0) return 0;
        //No auxilary space
        for(int i=1;i<costs.length;i++){
            costs[i][0] = costs[i][0]+Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] = costs[i][1]+Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] = costs[i][2]+Math.min(costs[i-1][1],costs[i-1][0]);
        }
        return Math.min(Math.min(costs[n][0],costs[n][1]),costs[n][2]);
    }
}

//Top down apprach - Non mutation

class PaintHouses {
    public int minCost(int[][] costs) {
        int n = costs.length;
        //edge case
        if(costs == null || n ==0) return 0;
        //Non mutation - use dp matrix
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i=1;i<n;i++){
            dp[i][0] = costs[i][0]+Math.min(costs[i-1][1],costs[i-1][2]);
            dp[i][1] = costs[i][1]+Math.min(costs[i-1][0],costs[i-1][2]);
            dp[i][2] = costs[i][2]+Math.min(costs[i-1][1],costs[i-1][0]);
        }
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}