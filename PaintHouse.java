// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// logic: The code implements a dynamic programming solution to find the minimum cost of painting all houses such that
// no two adjacent houses have the same color. We iterate through the houses starting from the last second row to the first row,
// updating the minimum cost for painting each house with a specific color based on the minimum cost of painting the previous house
// with different colors. Finally, return the minimum cost among the last house's colors.

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int red = costs[n-1][0];
        int blue = costs[n-1][1];
        int green = costs[n-1][2];
        for(int i = n-2; i >= 0; i--){
            int tempred = red;
            red = costs[i][0] + Math.min(blue, green);
            int tempblue = blue;
            blue = costs[i][1] + Math.min(tempred, green);
            green = costs[i][2] + Math.min(tempred, tempblue);
        }

        return Math.min(red, Math.min(blue, green));
    }
}