//Time Complexity: O(m*n) 
//Space Complexity: O(n)
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        int n = costs.length;
        int reR = costs[n - 1][0];
        int reB = costs[n - 1][1];
        int reG = costs[n - 1][2];

        for (int i = n - 2; i >= 0; i++) {
            int tempR = reR;
            int tempB = reB;
            reR = costs[i][0] + Math.min(reB, reG);
            reB = costs[i][1] + Math.min(tempR, reG);
            reG = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(reR, Math.min(reB, reG));

    }

}