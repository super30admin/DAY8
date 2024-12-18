/*
    Leetcode problem 518: Coin Change II 
    T.C: O(n * m) :: S.C: O(n * m)

    Solved using dp approach: First we go exhaustive by recursively choosing
    all possibilities that return the given amount. This is done using the 
    recursive tree 0 or 1 case. Then identify that the sub-problems are repeating
    So, use a dp array where the dimensions are decided based on the number of 
    base case parameters (which are if amount <= 0 or index goes out of bounds)
    Refer to the comments in the solution for storing values in the dp array.
*/

class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return 0;
        
        int n = coins.length;
        //Create an array with first row as 0 coin and first column as 0 value    
        int[][] dp = new int[n + 1][amount + 1]; //row -> coin: col -> amount

        //The first col 0 can be made by 1 combination (i.e not selecing any coin)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                //If the amount (represented as col) is less than the current value of the coin 
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // then just copy the no. of ways it can be formed from above row
                } else {
                    // add the amount can be formed in other ways previously calculated in the same row
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }                
            }
        }
        //Return the max number of ways that the amount can be formed with the given coins - combinaion
        return dp[n][amount];
    }
}