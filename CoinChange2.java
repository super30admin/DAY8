// time complexity O(m*n) where m is number of coins and n is total amount
// space complexity O(n) where n is the total amount
// solved in leetcode : Yes
//Problems faced ; No

public class CoinChange2 {
        public int change(int amount, int[] coins) {
            // Create a 1D DP array to store the number of ways to make each amount from 0 to 'amount'
            int[] dp = new int[amount + 1];

            // There is 1 way to make amount 0, which is by choosing no coins
            dp[0] = 1;

            // Loop through each coin
            for (int coin : coins) {
                // For each coin, update the DP array from 'coin' to 'amount'
                for (int j = coin; j <= amount; j++) {
                    dp[j] += dp[j - coin];  // Add the number of ways to make 'j - coin' to dp[j]
                }
            }

            // The result will be the number of ways to make 'amount'
            return dp[amount];
        }

        public static void main(String[] args) {
            CoinChange2 solution = new CoinChange2();

            // Example input
            int amount = 5;
            int[] coins = {1, 2, 5};

            // Get the result
            int result = solution.change(amount, coins);

            // Output the result
            System.out.println("Number of ways to make amount " + amount + ": " + result);
        }
    }

