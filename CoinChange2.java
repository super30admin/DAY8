/**
 * Time Complexity: O(m*n) where m is the coins.length and n is the amount
 * Space complexity: O(m*n)
 * Ran on leetcode? Yes
 * Any problems faced?: No
 *
 * The solution is using `zero one recursion` way of Dynamic programming and
 * stores number of ways an amount can be formed
 *
 * Example - [1,2,5] and amount 11
 *
 * Representation of 2D array
 * --------------------------------------------------------------
 *   | 0 | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | 11
 * -------------------------------------------------------------
 * 0 | 1 | 0  | 0  | 0  | 0  | 0  | 0  | 0  | 0  | 0  | 0  | 0
 * --------------------------------------------------------------
 * 1 | 1 | 1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  | 1  | 1
 * --------------------------------------------------------------
 * 2 | 1 | 1  | 2  | 2  | 3  | 3  | 4  | 4  | 5  | 5  | 6  | 6
 * --------------------------------------------------------------
 * 5 | 1 | 1  | 2  | 2  | 3  | 4  | 5  | 7  | 7  | 8  | 10 | 11
 * --------------------------------------------------------------
 *
 * Therefore, in this example last index of 2D array is the number of ways that amount can be formed
 */
public class CoinChange2 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < coins.length + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                int currentDenomination = coins[i - 1];
                // if the amount is less than the denomination itself, use the value at row above
                if (j < currentDenomination) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - currentDenomination];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange2 obj = new CoinChange2();
        int[] denominations = {1,2,5};
        int amount = 11;
        int result = obj.coinChange(denominations, amount);
        System.out.println("Result: " + result);
        assert (result == 11);

        denominations = new int[]{2,5};
        amount = 1;
        result = obj.coinChange(denominations, amount);
        System.out.println("Result: " + result);
        assert (result == 0);
    }
}
