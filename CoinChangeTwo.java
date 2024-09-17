// Time Complexity : O(n*m) n=number of coins +1 and m = amount+1. 
// Space Complexity : O(m) m = amount+1. 
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// using DP with one array calculating previon Do not calculated fron top plus calculated 
//going back in the array to the calculated values using array[current index- coin used at current iteration]

//Runtime: 4 ms, faster than 41.73% of Java online submissions for Coin Change 2.
//Memory Usage: 37.3 MB, less than 30.23% of Java online submissions for Coin Change 2.

  public int change(int amount, int[] coins) {
      // edge case
      if (coins == null) return 0;
      // initialize dp array
      int [] dp= new int[amount+1];
      dp[0] = 1;
      // do calculation on the dp array
      int pDc=0; //previous dc on top of matrix
      for (int i = 1; i < coins.length+1; i++) {
          for (int j = 0; j < dp.length; j++) {
              // get coin
              pDc=dp[j];
              int coin = coins[i - 1];
              if (j < coin) { // check if we need to pull from the top
                  dp[j] = pDc;
              } else { // check if we need to add c(chose) + dc(do not chose)
                  // chose
                  int c = dp[j - coin];
                  // don't chose
                  int dc = pDc;
                  dp[j] = c + dc;
              }
          }
      }
      return dp[amount];
  }