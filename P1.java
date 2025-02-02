// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] cost) {
        int n = cost.length;
        int dp[][] = new int[n][3];
        dp[n - 1][0] = cost[n - 1][0];
        dp[n - 1][1] = cost[n - 1][1];
        dp[n - 1][2] = cost[n - 1][2];

        for(int i = n - 2; i >= 0; i --) {
            dp[i][0] = cost[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i + 1][1], dp[i + 1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }   
}

//Space optimised sol 
class Solution2 {
    public int minCost(int[][] cost) {
        int n = cost.length;
        int dp[] = new int[3];
        int varR = cost[n - 1][0];
        int varB = cost[n - 1][1];
        int varG = cost[n - 1][2];

        for(int i = n - 2; i >= 0; i --) {
            int tempR = varR;
            varR = cost[i][0] + Math.min(varR, varG);
            int tempB = varB;
            varB = cost[i][1] + Math.min(tempB, varG);
            varG = cost[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(varR, Math.min(varB, varG));
    }   
}


