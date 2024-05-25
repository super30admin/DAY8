// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// start from last row, calculate min value of costs in second last row
// go backward calculating min value in each rows

class Solution{
    public int minCost(int[][] costs){
        if(costs == null || costs.length == 0){
            return 0;
        }

        int n = costs.length;
        int red = costs[n-1][0];
        int blue = costs[n-1][1];
        int green = costs[n-1][2];

        for(int i = n-2; i>=0; i--){
            tempRed = red;
            tempBlue = blue;
            red = costs[i-1][0] + Math.min(blue, green);
            blue = costs[i-1][1] + Math.min(tempRed, green);
            green = costs[i-1][2] + Math.min(tempBlue, tempRed);
        }

        return Math.min(red, Math.min(blue, green));
    }
}