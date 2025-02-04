class CoinChange2Paths {
    public int change(int amount, int[] coins) {
        int m=coins.length;
        int n=amount;

        if(n==0 && m>0) return 1;
        if(n==0 ||coins==null) return 0;

        int[]dp=new int[n+1];
        dp[0]=1;


        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(coins[i-1]<=j){

                    dp[j]=dp[j]+dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}
/* recursion
  public int change(int amount, int[] coins) {
       int n = coins.length;
       if(n==0 ||coins==null) return 0;
       return (helper(coins,0,amount));
    }
    private int helper(int[] coins,int idx,int amount){
        if(amount==0) return 1;
        if(amount<0 || idx==coins.length) return 0;

        int case1=helper(coins,idx+1,amount);
        int case2=helper(coins,idx,amount-coins[idx]);
        return (case1+case2);
    }

 */

 /*
  public int change(int amount, int[] coins) {
       int m=coins.length;
       int n=amount;
       int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;
       if(n==0 ||coins==null) return 0;
      for(int i=1;i<=m;i++){
        for(int j=0;j<=n;j++){
           if(coins[i-1]>j){
            dp[i][j]=dp[i-1][j];
           } else{
            dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
           }
        }
      }
     return dp[m][n];
   }

  */