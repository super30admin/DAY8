import java.util.Arrays;

// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Coin_Change_2 {
	public static int change(int amount, int[] coins) {
		/*
		 * dp array is created length of row = 1+coins.length length of column =
		 * 1+amount
		 */
		int dp[][] = new int[coins.length + 1][amount + 1];

		/*
		 * In this loop we assign 0th index of each row to 1 and rest of indices to 0
		 */
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0)
					dp[i][j] = 1;
			}
		}
		/*
		 * We calculate the number of ways to make a change in each index of the 2D
		 * matrix
		 */
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		/*
		 * In the end we return the value present at the last row, last column of the dp
		 * array
		 */
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		int amount = 5;
		int coins[] = { 1, 2, 5 };
		int total_combinations = change(amount, coins);
		System.out.println("Coins: " + Arrays.toString(coins));
		System.out.println("Amount: " + amount);
		System.out.println("Number of ways to generate a change: " + total_combinations);
	}
}