//TC = O(n)
//SC = O(1)
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n ==0) return 0;
        int[] dp = new int [n];
        int costR = costs[n-1][0];
        int costG = costs[n-1][1];
        int costB = costs[n-1][2];
        for(int i = n-2; i >=0 ; i--)
        {
                    int tempR = costR;
                    costR = costs[i][0] + Math.min(costG, costB);
                    int tempG = costG;
                    costG = costs[i][1] + Math.min(tempR, costB);
                    costB = costs[i][2] + Math.min(tempR, tempG);
            
        }
        return Math.min(costR,  Math.min(costG, costB));
    }
}
