// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn how to corelate with the Recursion solution

// Your code here along with comments explaining your approach
public class CoinChangeIIApproach1 {
    // Approach-1 with recursion
    public int change(int amount, int[] coins) {
        int index = 0; // intital
        return helper(coins, index, amount);
    }

    private int helper(int[] coins, int i, int amount) {
        // base case
        if (amount == 0)
            return 1;
        if (amount < 0 || i >= coins.length)
            return 0; // don't forget >= for coins.length there is no coin at coins[coins.length]

        // logic
        int case0 = helper(coins, i, amount - coins[i]); // consider taking coin[i]

        int case1 = helper(coins, i + 1, amount); // ignore i and move on; amount doesnt change since we ignored i

        return case0 + case1;
    }

}