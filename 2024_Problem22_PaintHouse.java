//256. Paint House - https://leetcode.com/problems/paint-house/description/
//Time Complexity: Exponential Time Complexity O(3 * 2^(n)) where 'n' is number of colors

//Recurrsion Approach
class Solution {

    public int minCost(int[][] costs) {
        int colorR = helper(costs,0,0,0);
        int colorB = helper(costs,0,1,0);
        int colorG = helper(costs,0,2,0);

        return Math.min(colorB, Math.min(colorR, colorG));
    }

    private int helper(int[][] costs, int i, int color, int totalCost){
        //base case
        if(i == costs.length)
            return totalCost;

        if(color == 0){ //for RED
            return Math.min(helper(costs, i+1, 1, totalCost+costs[i][color]),
                    helper(costs, i+1, 2, totalCost+costs[i][color]));
        }
        if(color == 1){ //for BLUE
            return Math.min(helper(costs, i+1, 0, totalCost+costs[i][color]),
                    helper(costs, i+1, 2, totalCost+costs[i][color]));
        }
        if(color == 2){ //for GREEN
            return Math.min(helper(costs, i+1, 0, totalCost+costs[i][color]),
                    helper(costs, i+1, 1, totalCost+costs[i][color]));
        }
        return 324; //this will never be executed
    }
}

//If more than 3 colors are given in the question, loop through each color
//Same logic as before
class Solution {
    public int minCost(int[][] costs) {
        int colorR = helper(costs,0,0,0);
        int colorB = helper(costs,0,1,0);
        int colorG = helper(costs,0,2,0);

        return Math.min(colorB, Math.min(colorR, colorG));
    }

    private int helper(int[][] costs, int i, int color, int totalCost){
        //base case
        if(i == costs.length){
            return totalCost;
        }

        int min = Integer.MAX_VALUE;
        for(int c=0; c<costs[0].length; c++){
            if(c != color){
                min = Math.min(min, helper(costs, i+1, c, totalCost + costs[i][color]));
            }
        }
        return min;
    }
}

//DP Approach
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i=m-2; i>=0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

//DP Approach (Optimizing Space using int colors to manipulate the same array)
//Time Complexity: O(m*n)
//Space Complexity: O(1)
class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        int colorR = costs[m-1][0];
        int colorB = costs[m-1][1];
        int colorG = costs[m-1][2];

        for(int i=m-2; i>=0; i--){
            //preserving old values in the 1D dp Array before manipulating it
            int tempR = colorR;
            int tempB = colorB;
            colorR = costs[i][0] + Math.min(colorB, colorG);
            colorB = costs[i][1] + Math.min(tempR, colorG);
            colorG = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(colorR, Math.min(colorB, colorG));
    }
}