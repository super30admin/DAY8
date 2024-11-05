// Time Complexity :O(m*n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class Problem2 {
    public int minCost(int[][] costs) {
        int m = costs.length;

        int[] dp= new int[m];

        dp[0]= costs[0][0];
        dp[0]= costs[0][1];
        dp[0]= costs[0][2];

        for(int i=1; i<m; i++){
            int tempr= dp[0];
            int tempb= dp[1];
            dp[0]= costs[i][0] + Math.min(dp[1], dp[2]);
            dp[1]= costs[i][1] + Math.min(tempr, dp[2]);
            dp[2]= costs[i][2] + Math.min(tempr, tempb);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String args[]) {
            Problem2 prob2 = new Problem2();
        int[][] costs={{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("Output "+prob2.minCost(costs));

    }
}
