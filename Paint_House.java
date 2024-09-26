class Solution{
    public int minCost(int[][] costs){
      if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
      
      int dp[][] = new int[costs.length][costs[0].length];
      
      for(int i = costs.length-1; i >= 0; i--){
         
              dp[i][0] = dp[i][0] + Math.min(dp[i+1][1], dp[i+1][2]); 
              dp[i][1] = dp[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
              dp[i][2] = dp[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
         
      
    }
      return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
}
  
//TC: O(mn)
//SC: O(mn)
