

class Solution {

    // Time Complexity : O(2^n)
    // Space Complexity : O(n) 
    // Did this code successfully run on Leetcode : No : Time Limit Exceeded
    // Any problem you faced while coding this : No dp solution


    // Paint house solution

    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0)
            return 0;
        
        return Math.min(helper(costs, 0, 0), Math.min(helper(costs, 0, 1), helper(costs, 0, 2)));
    }
    
    private int helper(int[][] costs, int i, int j) {
        
        int price = costs[i][j];
        if(i < costs.length-1) {
            if(j == 0) {
                price += Math.min(helper(costs, i+1, 1), helper(costs, i+1, 2));
            } 
            else if(j == 1) {
                price += Math.min(helper(costs, i+1, 0), helper(costs, i+1, 2));
            }
            else {
                price += Math.min(helper(costs, i+1, 0), helper(costs, i+1, 1));
            }
        }
        
        return price;
    }

    // Time Complexity : O(2^n)
    // Space Complexity : O(n+m) n is number of coins and m is amount.
    // Did this code successfully run on Leetcode : No : Time Limit Exceeded
    // Any problem you faced while coding this : No dp solution


    // Coin change 2 solution
    public int change(int amount, int[] coins) {
        
        if(coins == null || coins.length == 0) {
            return -1;
        }
        
        return helper(coins, amount, 0, 0);
    }
    
    private int helper(int[] coins, int amount, int i, int count) {
        
        if(amount == 0)
            return count+1;
        
        if(i >= coins.length || amount < 0)
            return count;
        
        
        int case1 = helper(coins, amount - coins[i], i, count);
        
        int case2 = helper(coins, amount, i+1, count);
        
        
        return case1 + case2;
    }
}