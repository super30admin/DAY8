class Solution{
    public int minCost(int[][] costs){
        // time complexity o(n)
        // space complexity o(n)

        // int n = costs.length;
        // int [][] dp = new int [n][3];

        // dp[n-1][0] = costs[n-1][0];
        // dp[n-1][1] = costs[n-1][1];
        // dp[n-1][2] = costs[n-1][2];

        // for(int i= n-2; i>=0;i--){
        //     dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
        //     dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
        //     dp[i][2] = costs[i][0] + Math.min(dp[i+1][0], dp[i+1][1]);
        // }

        // return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));


        //o(n) time complexity
        // o(1) space complexity
        //---------------------------------------------------//
        int n = costs.length;

        int varR =costs[n-1][0];
        int varB =costs[n-1][1];
        int varG = costs[n-1][2];

        for(int i= n-2; i>=0;i--){
            int tempR = varR;
            varR = costs[i][0] + Math.min(varB, varG);
            int tempB = varB;
            varB = costs[i][1] + Math.min(tempR, varG);
            varG = costs[i][1] + Math.min(tempR, tempB);
        }
        return Math.min(varR, Math.min(varG, varB));
    }
}