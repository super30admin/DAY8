// using dp.
// 1-D array
// Time complexity = O(n^2)
// Space Complexity = O(n)
class CoinChange {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        dp[0]=1 ;
        for(int i=1;i<coins.length+1;i++) {
            for(int j=1;j< amount+1;j++) {
                if(j< coins[i-1]) {
                        dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j-coins[i-1]];    
                }
            }
        }
        return dp[amount];
    }

}

// // using dp.
// 2-D array
// class Solution {
//     public int change(int amount, int[] coins) {
//         int dp[][] = new int[coins.length+1][amount+1];
//         for(int i=1;i< amount+1;i++) {
//             dp[0][i] = 0;
//         }
//         for(int i=0;i< coins.length+1;i++) {
//             dp[i][0] = 1;
//         }
//         for(int i=1;i<coins.length+1;i++) {
//             for(int j=1;j< amount+1;j++) {
//                 if(j< coins[i-1]) {
//                     dp[i][j] = dp[i-1][j];
//                 } else {
//                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];    
//                 }
                
//             }
//         }
//         return dp[coins.length][amount];
//     }

// }


// Recursion
/**
class Solution {
    public int change(int amount, int[] coins) {
        return recursion(coins, 0, amount);
    }
    
    private int recursion(int[] coins, int idx, int amount) {
        if(amount ==0) {
            return 1;
        }
        if(amount<0 || idx >= coins.length) {
            return 0;
        }
        return recursion(coins, idx+1, amount) + recursion(coins, idx, amount-coins[idx]);
    }
}
**/