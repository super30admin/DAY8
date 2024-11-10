import java.util.Arrays;

class PaintHouseWithPathMatrix {
    public int minCost(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];
        int[][] path = new int[m][n];

        //filling last row
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i=m-2; i>=0; i--)
        {
            if(dp[i+1][1] < dp[i+1][2]) {
                path[i][0] = 1;
            }
            else {
                path[i][0] = 2;
            }

            if(dp[i+1][0] < dp[i+1][2]) {
                path[i][1] = 0;
            }
            else {
                path[i][1] = 2;
            }

            if(dp[i+1][0] < dp[i+1][1]) {
                path[i][2] = 0;
            }
            else {
                path[i][2] = 1;
            }

            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        System.out.println(Arrays.deepToString(path));

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}