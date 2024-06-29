// Time Complexity : O(m)
// Space Complexity : O(n*m) n-> num of colors
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


/* At each iteration we calculate the minimum cost if we choose the current color for the current house .
 * We start from bottom up and calculate costs for each color for the given house. We choose the minimum out of these.
 * Then we increase the house subset and calculate the minimum again till we cover all the houses.
 * the minimum cost in the final iteration gives the answer.
*/
public class PaintHouse  {
    public int minCost(int[][] costs) {

        int m =costs.length;  //num of houses
        int[][] dp = new int[m][3];

        //fill last row of matrix with actual cost
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];
        
        for(int i = m-2;i>=0;i--){
            int tempR = costs[i][0];
            int tempB = costs[i][1];
            dp[i][0] = tempR + Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1] = tempB + Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1],dp[i+1][0]);

        }

        return Math.min(dp[0][0],Math.min(dp[0][1], dp[0][2]));
    }
}