

class Main {
    public static int minCosts(int[][] costs) {
       int row = costs.length;
       int col = costs[0].length;
       int[][] dp = new int[row][col];
       for(int i = 0; i<col; i++) {
           dp[row-1][i] = costs[row-1][i];
       }
       for(int i= row-2; i>=0; i--) {
           for (int j =0; j< col; j++) {
               if(j==0) {
               dp[i][j] = costs[i][j] + Math.min(dp[i+1][1], dp[i+1][2]);
               }
               if(j==1) {
                   dp[i][j] = costs[i][j] + Math.min(dp[i+1][0], dp[i+1][2]);
               }
               if(j==2) {
                   dp[i][j] = costs[i][j] + Math.min(dp[i+1][0], dp[i+1][1]);
               }
           }
            
       }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    } 
    
     public static void main(String[] args)
  {
 
    int costs[][] = { { 14, 2, 11 },
                     { 11, 14, 5 },
                     { 14, 3, 10 } };
 
    int minCost = minCosts(costs);
    System.out.println(minCost);

  }
}