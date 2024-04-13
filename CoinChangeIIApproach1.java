// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Approach:
 * Logic
 *  create a helper with coins, current index, and amount (since amount is already given lets track if we can make it to zero)
 * - case0 -> if you don't choose to take a coin at index-i ; index would be i+1 and move on
 * - case1 -> if you choose to pick the coin at index-1 ; reduce the number of by the coin value and move on
 * 
 * Base case::
 * in a recursive approach - we would get to the base case when amount ==0 i.e., we return 1
 * if amount <0 or index overflow return 0
 */
public class CoinChangeIIApproach1{

    public int change(int amount, int[] coins) {

       return helper(coins, i, amount);
    }

    private int helper(int[] coins, int i, int amount){
        //base case
        if(amount==0) return 1;

        if(amount <0 || i >=coins.length) return 0;


        //logic
        int case0 = helper(coins, i+1, amount); // ignore this index and move on
        int case1 = helper(coins, i, amount-coins[i]); // consider taking this coin

        return case0+case1;
    }

}