package coinChange2;

// Time Complexity : O(m*amount) m is the size of the input coins array
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DPApproach {

    public static void main(String[] args)
    {
                int amount = 5;
                int[] coins = {1, 2, 5};

//                int amount = 3;
//                int[] coins = {2};

//        int amount = 10;
//        int[] coins = {10};

        System.out.println(change(amount, coins));
    }

    private static int change(int amount, int[] coins) {

        // n is the number of coins
        // TC: O(n * amount)
        // space O(n)

        int n = amount;

        int[] dp = new int[amount + 1];

        // there is only 1 distinct way to generate amount 0
        dp[0] = 1;

        // starting from 1 as the 0 case is already filled

        for (int coin : coins) {

            for (int j = coin; j <= amount; j++) {

                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
