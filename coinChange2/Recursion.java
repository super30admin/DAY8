package coinChange2;

//top down approach
// non-dp approach

// Time Complexity : logrithmic Thus, the worst-case time complexity is **O(2 ^ M + N) ** (since each coin can be either included or excluded independently).
// Space Complexity : the space complexity is O(m) due to recursive stack usage.
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time limit exceeded exception

class Recursion {

    public static void main(String[] args) {

//        int amount = 5;
//        int[] coins = {1, 2, 5};

//        int amount = 3;
//        int[] coins = {2};

        int amount = 10;
        int[] coins = {10};

        System.out.println(change(amount, coins));

    }

    public static int change(int amount, int[] coins) {

        // TC 2^(m + n)
        int n = coins.length;

        if (coins == null || n == 0) {
            return 0;
        }

        return helper(coins, 0, amount);
    }

    private static int helper(int[] coins, int idx, int amount) {
        // base

        //  this is one of the way
        if (amount == 0) {
            return 1;
        }

        if (amount < 0 || idx == coins.length) {
            return 0;
        }

        // dont choose the coin
        int case1 = helper(coins, idx + 1, amount);

        // choose the coin
        //  we are reusing the coin
        int case2 = helper(coins, idx, amount - coins[idx]);

        return case1 + case2;
    }
}



