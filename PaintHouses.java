// approach followed bottom-up.
// min(cost[0][0], cost[0][1], cost[0][2]) will yeild the right answer.
// using 3 variables
// Space complexity = O(1)
// Time complexity = O(n)
public class PaintHouses {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int costA = costs[n-1][0];
        int costB = costs[n-1][1];
        int costC = costs[n-1][2];
        for(int i=n-2;i>=0;i--) {
            int tempA = costA;
            int tempB = costB;
            int tempC = costC;
            costA = costs[i][0] + Math.min(tempB, tempC);
            costB = costs[i][1] + Math.min(tempA, tempC);
            costC = costs[i][2] + Math.min(tempA, tempB);
        }
        return Math.min(costA, Math.min(costB, costC));
    }
}


// using dp without 3 variables.
/**
class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        dp[costs.length-1][0] = costs[costs.length-1][0];
        dp[costs.length-1][1] = costs[costs.length-1][1];
        dp[costs.length-1][2] = costs[costs.length-1][2];
        for(int i=costs.length-2;i>=0;i--) {
            for(int j=0;j<=2;j++) {
                if(j==0) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i+1][j+1], dp[i+1][j+2]);
                } else if(j== 2) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i+1][j-2], dp[i+1][j-1]);        
                } else {
                        dp[i][j] = costs[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j+1]);        
                }
            }
            
            
            
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

**/