class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int[][] dp=new int[costs.length][3];
        for(int i=0;i<=2;i++)
        {
            dp[0][i]=costs[0][i];
        }
        for(int i=1;i<costs.length;i++)
        {
            dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]= costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);   
        }
        return Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
        
    }
}