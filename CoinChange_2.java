// Time Complexity :O(amount×len(coins))
// Space Complexity :O(amount)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class CoinChange_2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
       dp[0] = 1; // Base case: There is one way to make amount 0, by using no coins

       // Iterate over each coin
       for (int coin : coins) {
           // Update the dp array for each amount >= coin
           for (int j = coin; j <= amount; j++) {
               dp[j] += dp[j - coin];
           }
       }

       return dp[amount];
       
   }
    
}
