// PROBLEM 2: Coin Change - 2
/*
Time Complexity : Exponential| O(2^N)
Space Complexity : O(N) [Call stack/ Height of Tree]
Did this code successfully run on Leetcode : Did run on testcases but TLE on submission (14/29 cases passed).
Any problem you faced while coding this : No
*/


/* Exhaustive Approach
class Problem2 {
    public int change(int amount, int[] coins) {
        // null case
        if(coins == null || coins.length == 0) return 0;

        int noOfWays = helper(coins, amount, 0);
        return noOfWays;
    }
    private int helper(int[] coins, int remaining, int currIdx){
        // Base
        if(remaining == 0) return 1;
        if(remaining < 0 || currIdx > coins.length - 1) return 0;
        // Logic
        int notChoose = helper(coins, remaining, currIdx + 1);
        int choose = helper(coins, remaining - coins[currIdx], currIdx);

        return choose + notChoose;
    }

}*/
//---------------------------------------Solution 1 ENDS HERE-----------------------------------------------

/*
Time Complexity : O(N*M)
Space Complexity : O(N*M)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No, the whiteboard explanation sufficed
*/

/*class Problem2 {
    // My DP approach before viewing video solution
    public int change(int amount, int[] coins) {
        // null case
        if(coins == null || coins.length == 0) return 0;

        int denomsAsRows = coins.length + 1;
        int amountsAsCols = amount + 1;
        int[][] dp = new int[denomsAsRows][amountsAsCols];

        // Fill dummy values for first row with denomination = 0.
        dp[0][0] = 1; // when denom = 0 & amtRemaining = 0 -> Degenerate, already solved hence 1.
        *//* Rest of the values in the array are
        auto-initialized to zeroes so no loop needed here.
        *//*
        for(int i = 1; i < denomsAsRows; i++){
            for(int j = 0; j < amountsAsCols; j++){
                // If amt < denomination then only not-choose case right above
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
//                       above(NotChoose) ||  denom steps back
                }
            }
        }
        return dp[denomsAsRows - 1][amountsAsCols - 1];
    }
}*/

//--------------------------------------Solution 2 ENDS HERE-----------------------------------------------

/*
Time Complexity : O(N*M)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No, I got the idea of treating in-place value as the value of
                                          one row above and tried updating it. Same time but space improves.
                                          (After solving, I found Ishika solves it in later in the lecture. XD )
*/

class Problem2 {
    // My DP approach before viewing video solution
    public int change(int amount, int[] coins) {
        // null case
        if(coins == null || coins.length == 0) return 0;

        int amounts = amount + 1;
        int[] dp = new int[amounts];

        // Fill dummy values for first row with denomination = 0.
        dp[0] = 1; // denom = 0 & amtRemaining = 0 -> Degenerate, already solved hence 1.
        /* Rest of the values in the array are
        auto-initialized to zeroes so no loop needed here.
        */
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j < amounts; j++){
                if(j < coins[i]){
                    // No need to change the value as it is
                    // what was a row above value in 2D solution
                    continue;
                }
                else{
                    dp[j] += dp[j-coins[i]];
//              in-place => above and denom steps back just need to be added.
                }
            }
        }
        return dp[amounts - 1];
    }
}

//--------------------------------------Solution 3 ENDS HERE-----------------------------------------------
