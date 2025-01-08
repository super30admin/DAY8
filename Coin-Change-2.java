// Problem : (https://leetcode.com/problems/coin-change-2/)

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

 

// Example 1:

// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
// Example 2:

// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.
// Example 3:

// Input: amount = 10, coins = [10]
// Output: 1
 

// Constraints:

// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// All the values of coins are unique.
// 0 <= amount <= 5000

//Solution:
// 1. Exhaustive Approach:
// In this approach we are exhaistively recursing over each element of coins array. Here we are using 0-1 recusrsion approach. 0 means we are not taking that coin and 1 means we are taking that coin.
// At the end we are adding the result from both 0 & 1 call as we want the all different ways. In previous problem we have to give the minimum no of coins required to form the target total

// Time Complexity : Exponential Time complexity
// Space Complexity :
// Did this code successfully run on Leetcode : yes but it gave time limit exceeded so I tried it using Dynamic Programming
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int change(int amount, int[] coins) {
        //Base condition check
        if(coins==null || coins.length==0){
            return 0;
        }
        //we are returning the output of recurse function
        return recurse(coins,amount,0);
    }

    private int recurse(int[] coins, int amount, int index){
        //Base case to stop the recursion further
        if(index==coins.length || amount<0){
            return 0;
        }
        //If the amount becomes 0 we will not go ahead and perform recursion
        if(amount==0){
            return 1;
        }
        //0 recursion call. In this as we are not considering the index will be incremented by 1
        int left = recurse(coins, amount,index+1);
        //1 recursion call. In this the index will stay at the same position as there are infinite supply of the coin and amount will get reduced by the coin used
        int right = recurse(coins,amount-coins[index],index);
        // we will return the addition of both the cases output
        return left+right;
    }
}

//Approach 2
// In this approach we are storing the output of subp[roblrm in 2-D array in which the rows represent the coins and columns represent the a,ount
// Also, I have added a dummy row & column to maintain the consistency for the calculation of first row
// Time Complexity : O(n2) - n square
// Space Complexity : 0(n2) - n square
)
// Did this code successfully run on Leetcode : yes but it gave time limit exceeded so I tried it using Dynamic Programming
// Any problem you faced while coding this :

class Solution {
    public int change(int amount, int[] coins) {
        //Initialized DP array
        int dp[][] = new int[coins.length+1][amount+1];
        //Storing 1st column as 1 because if we have 1,2,5 coins and we want to make 0 value it is possible by one way i.e not picking a coin
        for(int i=0;i<coins.length+1;i++){
            dp[i][0]=1;
        }
        // Iterating the loop from row 1 and column 1 as others are already filled
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                //Here there are two conditions if j < coins[i-1] then we will as it is copy the i-1 value of same row
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                //If not then we will add 0 call and 1 call value because those will be the ways we can achieve that value
                else{
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
            }
        }
        //Maximum ways to achieve that value will be in last row & column so we will directly return that
        return dp[coins.length][amount];
        
    }
}