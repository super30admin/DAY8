//MEMOIZATION
/* Time Complexity: O(N*3) - O(N)
 * Space Complexity: as we store the answers of all the subproblems O(3 * N).
 * Leetcode: yes
 * Any Problems: no
 */

 //TABULATION
/* Time Complexity: O(N*3) - O(N)
 * Space Complexity: as we store the answers of all the subproblems O(3 * N), can be optimized to O(1) as we are just using three indices at any time.
 * Leetcode: yes
 * Any Problems: no
 */
import java.util.Arrays;

class PaintHouses
{
        //MEMOIZATION
        /* once a sub problem is solved it is stored in N*3 matrix, if the subproblem appears again we just return it.*/
        private int helper(int i, int j, int[][] costs, int[][] dp)
        {
            if(i == costs.length)
                return 0;
            if(dp[i][j] != Integer.MAX_VALUE)
                return dp[i][j];
            int result = Integer.MAX_VALUE;
            for(int color=0; color<3; color++)
            {
                if(color == j) continue;
                result = Math.min(result, helper(i+1, color, costs, dp));
            }
            dp[i][j] = costs[i][j] + result;
            return dp[i][j];
        }
        public int minCostMemoization(int[][] costs) {
            int[][] dp = new int[costs.length][costs[0].length];
            for(int i=0; i<costs.length; i++)
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            return Math.min(helper(0, 0, costs, dp), Math.min(helper(0, 1, costs, dp), helper(0, 2, costs, dp)));
        }
    

        //TABULATION (Bottom Up)
        /* we start from the base cases and build towards the target*/
        public int minCostTabulation(int[][] costs) {
            int[][] dp = new int[costs.length][costs[0].length];
            
            for(int i=0; i<costs[0].length; i++)
               dp[0][i] = costs[0][i];
    
            for(int i=1; i<costs.length; i++)
            {
                for(int j=0; j<costs[0].length; j++)
                {
                    int result = Integer.MAX_VALUE;
                    for(int k=0; k<costs[0].length; k++)
                    {
                        if(k==j) continue;
                        result = Math.min(result, dp[i-1][k]);
                    }
                    dp[i][j] = costs[i][j] + result;
                }
            }
            return Math.min(dp[costs.length-1][0], Math.min(dp[costs.length-1][1], dp[costs.length-1][2] ));
        }
    
}