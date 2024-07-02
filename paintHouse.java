// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * using a bottom-up dynamic programming approach.
 *  We iterate through each house starting from the second last to the first (i = n-2 to i = 0).
 *  For each house, We then calculates the minimum cost to paint that house with each color (R, B, G),
 *  considering the minimum cost of painting the previous house with the other two colors (Math.min(B, G) for R, etc.).
 *  Finally, return the minimum cost to paint all houses, which is stored in Math.min(R, Math.min(B, G)).
 */
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int R = costs[n-1][0];
        int B = costs[n-1][1];
        int G = costs[n-1][2];
        for(int i = n-2; i >=0; i--) {
            int tempR = R;
            R = costs[i][0] + Math.min(B, G);
            int tempB = B;
            B = costs[i][1] + Math.min(tempR, G);
            G = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(R, Math.min(B,G));
    }
}