// Time Complexity: For recursion, O(2 ^ n), For DP, O(mxn) where m= coins.length, n=amount
// Space Complexity: For recursion, O(2 ^ n), for DP = O(mxn), 2d array

public class CoinChange2 {

    public static void main(String[] args) {
        System.out.println(changeByExhaustive(11, new int[] { 1, 2, 5 }));
        System.out.println(changeBydp(11, new int[] { 1, 2, 5 }));
    }

    public static int changeByExhaustive(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0;

        return recurse(amount, coins, 0);
    }

    private static int recurse(int amount, int[] coins, int index) {
        // base case
        if (index == coins.length || amount < 0)
            return 0;
        if (amount == 0)
            return 1;

        // logic
        // No pick
        int case1 = recurse(amount, coins, index + 1);
        // pick
        int case2 = recurse(amount - coins[index], coins, index);

        return case1 + case2;
    }

    private static int changeBydp(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0;

        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int row = 0; row < coins.length + 1; row++) {
            dp[row][0] = 1;
        }
        for (int row = 1; row < coins.length + 1; row++) {
            for (int col = 1; col < amount + 1; col++) {
                if (coins[row - 1] > col) {
                    dp[row][col] = dp[row - 1][col];
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - coins[row - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
