// Time Complexity : O(m*n) => As we are creating a 2D matrix and travesing through all the rows(m) and all the columns(n)
// Space Complexity : O(m*n) => As we are storing the result in the 2D matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Tried with Recursion but it was giving TLE. After identifying that there are same sub-problems in the 0-1 recursion, used dynamic programming.
Create a 2D matrix with rows storing all the coins and columns formed using amount. Then calculated value for each cell by checking with the given amount and coin there are how many ways.
 */

class Solution {
    public int change(int amount, int[] coins) {

        if(coins.length == 0 || coins == null)
            return 0;

        //We are adding row 0 and column 0, hence initialized to +1
        int[][] dp = new int[coins.length +1 ][amount+1];

        //Filling the column 0 with 1 as there is only 1 way to form amount 0 by not selecting it
        for(int i =0; i<=coins.length; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=coins.length; i++){
            for(int j =1; j<=amount; j++){

                //If j-coins[i-1] <0 then we simply take the cell value from the previous row
                if(j-coins[i-1] <0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]; //Adds the value from the previous row and the current row
                }
            }
        }

        return dp[coins.length][amount];
    }
}

//This is solved using 0-1 recursion
// class Solution {
//     public int change(int amount, int[] coins) {

//         if(coins.length == 0 || coins == null)
//             return 0;

//       return recurse(amount, coins, 0);
//     }

//     public int recurse(int amount, int[] coins, int index){

//         if(amount < 0 || index == coins.length){
//             return 0;
//         }

//         if(amount == 0){
//             return 1;
//         }

//         int case0 = recurse(amount, coins, index+1);
//         int case1 = recurse(amount - coins[index], coins, index);

//         return case0 + case1;
//     }
// }