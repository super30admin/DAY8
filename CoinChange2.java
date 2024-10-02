//518. Coin Change II

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//TC- 2^n+m; SC- m+n
//exhaustive approach; in this case we dont need greedy because we want all possible ways
class CoinChange2 {
    //------------exhaustive approach---------------------------------------------------
    // int count = 0;
    // public int change(int amount, int[] coins) {
        
    //     helper(coins, 0, amount);
    //     return count;
        
    // }

    // private void helper(int[] coins, int i, int amount){

    //     if(amount<0|| i>=coins.length) return;

    //     if(amount == 0){
    //         count++;
    //         return;
    //     }

    //     helper(coins, i+1, amount);
    //     helper(coins, i, amount - coins[i]);
    // }

    //----------DP approach-----2D array----------------------------------------------
    // TC-  mn    SC- mn

    // public int change(int amount, int[] coins) {
        
    //     int n = coins.length;
    //     int m = amount;
   
    //     int dp[][] = new int[n+1][m+1];
    //     dp[0][0] = 1;
   
    //    //  for(int i = 1; i <= m; i++){
    //    //     dp[0][i] = 0;// no need to for this code its 0 by default
           
    //    //  }
   
    //     for(int i = 1; i <=n; i++ ){
    //        for(int j = 0; j<=m; j++){
    //            if(j<coins[i-1]){// only no choose case possible when invalid case
    //                dp[i][j] = dp[i-1][j];
    //            }
    //            else{
    //              dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];// chose case and not choose case
    //            }
   
    //        }
    //     }
    //     return dp[n][m];
   
    //    }

    //--------1D array------------------------------

    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int m = amount;
   
        int dp[] = new int[m+1];
        dp[0] = 1;
   
       //  for(int i = 1; i <= m; i++){
       //     dp[0][i] = 0;// no need to for this code its 0 by default
           
       //  }
   
        for(int i = 1; i <=n; i++ ){
           for(int j = 0; j<=m; j++){
               if(j<coins[i-1]){// only no choose case possible when invalid case
                   dp[j] = dp[j];
               }
               else{
                 dp[j] = dp[j] + dp[j-coins[i-1]];// chose case and not choose case
               }
   
           }
        }
        return dp[m];
   
       }

    public static void main(String args[]){
        CoinChange2 cc = new CoinChange2();
     
        int[] coins = {1,2,5}; 
        //int[] coins = {2}; 
         //int[] coins = {1}; 
        int amount = 5;
        //int amount = 3;
        //int amount = 0;
     
        int result = cc.change(amount, coins);
     
        System.out.println(result);
     
        }
}
