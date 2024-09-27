// Time Complexity :brute force: O(2^(m*n)), dp: O(m*n), m=coins.length, n = amount
// Space Complexity : brute force:O(m*n) ,dp: O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


/**
 * https://leetcode.com/problems/coin-change-2/
 * 
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1


Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
 *
 */

class CoinChange2 {
	public int change(int amount, int[] coins) {
		//edge case
		if(amount == 0) return 1;
		if(coins == null || coins.length ==0) return 0;
		
		return dp(coins, amount);
	}

	//DP solution - time o(m*n), space o(m*n)
	private int dp(int[] coins, int amount){

		/*
         row for coins (including one row for coin 0)
         column for amounts (including one dummy column for amount 0)
		 */
		int[][] dp = new int[coins.length+1][amount+1];

		//using any coin, there is one way in which we can make amount 0
		//i.e. take nothing
		for(int i=0; i < coins.length+1; i++)
			dp[i][0] = 1;

		for(int i=1; i < coins.length+1; i++) {
			for(int j=1; j < amount+1; j++) {
				//if current amount is less than current coin, can not select that coin,
				// do not choose coin case
				if(j < coins[i - 1]) {
					dp[i][j] = dp[i-1][j];
				} else
				{
					//else we have both options choose or not choose, take sum from those
					dp[i][j] = dp[i-1][j] + dp[i][j- coins[i-1]] ;
				}
			}
		}

		return dp[coins.length][amount];
	}

	private int bruteForce(int[] coins, int amount, int index) {

		//base, derived from logic, what is changing in logic

		// amount 0, its a valid path
		if(amount == 0) return 1;

		//if amount goes negative or we run out of coins, that is invalid path
		if(amount < 0 || index == coins.length) return 0;

		//logic
		//each step we either chose coin or not chose coin

		//choose coin, amount reduces by current coin, index remains same 
		//
		int case1 = bruteForce(coins, amount - coins[index], index);

		//do not choose coin, only index increases as we move to next coin
		int case2 = bruteForce(coins, amount, index+1);

		//as we need all valid paths, sum both the cases
		return (case1 + case2);

	}
}