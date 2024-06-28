// Time Complexity :O(coins.length * amount)
// Space Complexity :(coins.length * amount) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Helper function to recursively find the number of ways to make the given amount
    private int helperFunction(int[] coins, int idx, int amount, int[][] memoDp) {
        // Base case: If amount is 0, there is 1 way to make the amount (using no coins)
        if (amount == 0) return 1;
        
        // Base case: If we've considered all coins or the amount is negative, there are 0 ways
        if (idx == coins.length || amount < 0) return 0;
        
        // If the result for the current state (idx, amount) is already computed, return the memoized value
        if (memoDp[idx][amount] != -1) return memoDp[idx][amount];

        // Option 1: Not pick the current coin (move to the next coin)
        int notPick = helperFunction(coins, idx + 1, amount, memoDp);
        
        // Option 2: Pick the current coin (subtract its value from the amount)
        int pick = helperFunction(coins, idx, amount - coins[idx], memoDp);
        
        // Store the sum of both options in the memoization table and return it
        return memoDp[idx][amount] = notPick + pick;
    }

    public int change(int amount, int[] coins) {
        // Create a memoization table initialized to -1
        int[][] memoDp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memoDp[i], -1);
        }

        // Call the helper function to find the number of ways to make the given amount
        return helperFunction(coins, 0, amount, memoDp);
    }
}
