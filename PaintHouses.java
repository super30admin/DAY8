package Day9;

public class PaintHouses {

    public int minCost(int[][] costs){
        int m = costs.length;

        if(costs == null || costs.length == 0) return 0;

        //number of houses  = m; number of colors = 3
        int[][] dp = new int[m][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i=1; i<m; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        return Math.min(Math.min(dp[m-1][0], dp[m-1][1]), dp[m-1][2]);
    }

    public static void main(String args[]){
        PaintHouses obj = new PaintHouses();

        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};

        System.out.println("The min cost at which the given houses can be painted with adjacent houses not having the same color is: "+ obj.minCost(costs));
    }
}
