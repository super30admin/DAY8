// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int MinCost(int[][] costs) {
        int m = costs.Length;
        int n = costs[0].Length;

        int costR = costs[m-1][0];
        int costB = costs[m-1][1];
        int costG = costs[m-1][2];

        for(int i=m-2; i>=0; i--) {
            int tempR = costR;
            int tempB = costB;

            costR = costs[i][0] + Math.Min(costB, costG);
            costB = costs[i][1] + Math.Min(tempR, costG);
            costG = costs[i][2] + Math.Min(tempR, tempB);
        }

        return Math.Min(costR, Math.Min(costB, costG));
        
    }
}