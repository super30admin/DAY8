// Time Complexity : O(2^n) --> where m is amount and n is length of array
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode (518): Yes
// Any problem you faced while coding this : No

// Explanation: In this 'Coin Change' problem, we are recursively iterating over each possible case to get the target amount. In each iteration we have 2 choices i.e. (1) to choice a coin and (2) to no choose a coin. If we consider choice 1 then the target amount will get reduced by the coin we chose but the number of available coins will remain same. And if we consider choice 2 then the available coins will get reduce by 1 but the amount will remain same. In the end, we are returning the sum of both the cases to get the total number of cases that make up the target amount. Going with this recurrsion approach, there will be multiple similar sub-cases that we will have to compute each and every time and so this is not a good approach to solve this kind of problems. Hence, its time complexity will be exponential.


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, amount, 0);
    }
    
    private int helper (int[] coins, int amount, int index) {
        // base case
        if (amount == 0) return 1;
        if (amount < 0 || index == coins.length) return 0;
        
        // logic
        // choose a coin
        int case1 = helper(coins, amount - coins[index], index);
        
        // not to choose a coin
        int case2 = helper(coins, amount, index + 1);
        
        return (case1 + case2);
    }
}