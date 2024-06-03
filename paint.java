// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : I do not have a premium account
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int red = costs[n - 1][0]; // last row and red
        int blue = costs[n - 1][1]; // last row and blue 
        int green = costs[n - 1][2]; // last row and green
        for (int i = n - 2; i >= 0; i--) {
            int tempRed = red; // storing tempRed as we are changing it and using it for blue and green
            int tempBlue = blue; // storing tempBlue as we are changing and using it for green
            // No need to store tempGreen as we are not using it after changing it.
            red = red + Math.min(tempBlue, green);
            blue = blue + Math.min(tempRed, green);
            green = green + Math.min(tempRed, tempBlue);
        }

        return Math.min(red, Math.min(blue, green)); // return minimum of three
    }
}