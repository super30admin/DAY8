//TC: O(n) -> n is number of houses to paint
// SC: O(1)
// Approach: Each costR,G,B represents minimum cost when the first house is painted R,G,B respectively. In each iterations minimum cost required to proceed with the next house is calculated by taking the remaining 2 color cost. Same step is done for all the houses.

public class PaintHouse {

    public static int minCostOptimized(int[][] costs) {
        int costR = 0; int costG = 0; int costB = 0;

        for (int[] cost: costs){
            int cR = costR; int cG = costG; int cB = costB; //store prev values
            costR = cost[0] + Math.min(cG,cB);
            costG = cost[1] + Math.min(cR,cB);
            costB = cost[2] + Math.min(cR,cG);
        }

        return Math.min(costR, Math.min(costG, costB));
    }

    public static int minCost(int[][] costs) {
        int m = costs.length; int n = 3;
        int[][] dp = new int[m][n];

        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for (int i =m-2;i>=0;i--){
            for(int j = 0; j<n; j++){
                if(j==0) dp[i][j] = costs[i][j] + Math.min(dp[i+1][j+1],dp[i+1][j+2]);
                else if(j==1) dp[i][j] = costs[i][j] + Math.min(dp[i+1][j-1],dp[i+1][j+1]);
                else dp[i][j] = costs[i][j] + Math.min(dp[i+1][j-1],dp[i+1][j-2]);
            }
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs));
        System.out.println(minCostOptimized(costs));
    }
}
