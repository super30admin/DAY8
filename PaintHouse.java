class Solution {
    public int minCost(int[][] costs) {
        int m=costs.length;
        int n=costs[0].length;
        
        int[][] dp=new int[m][n];
        for(int j=0;j<n;j++){
            dp[m-1][j]=costs[m-1][j];
        }
        
        for(int i=m-2;i>=0;i--){
            dp[i][0]=costs[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i+1][0],dp[i+1][1]);
        }
        
        
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}



