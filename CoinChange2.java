// Time Complexity : O(mn), where n is amount, m is number of coins
// Space Complexity : O(mn), where n is the amount and m is the number of coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solved after class, couldnt come up with solution before class

// Approach: We will consider m*n matrix by creating all combinations of coins(i) giving the amt(j)
// There will be 2 deciding factors: i) amt and ii) no of combinations
// Here, we will be optimizing repeating  sub problems

class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        if(coins.length == 0) return 0;
        // we are considering 0 row combinations as well as extra
        int m = coins.length+1;
        int n = amount+1;
        //auxilary space -  dp matrix
        int[][] dp = new int[m][n];
        // values for 1st col as 1
        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //Case1) if the amount is less than coin denomination, copy the values from the above row(previous coin)
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                //Case2) else add the value from above row with element(going back to coins denominations places)  
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m-1][n-1]; // returning last element in dp array
    }
}

/* Approach 1: Recursive Brute force solution
// Time Complexity : O(2^n), where n is number of coins
// Space Complexity : O(m + n), where m is the amount and n is the number of coins
// Did this code successfully run on Leetcode : No, TLE
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

//We will consider the recursive tree by creating all the combinations of coins giving the amount
//There are two deciding factors: i)amount and ii)number of coins
//Here, we won't be optimizing repeating sub problems which results in TLE(time limit exceeded)
*/

class Solution {
    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }
    //Recursive solution
    //Intialize private helper function(OOPS-Abstraction concept)-member functions only accessible by this class
    private int helper(int amount, int[] coins, int index){
        //For recursive solution, first always write logic and then base case 
        //Base case: check what is decrementing and incrementing in logic
        //Amount is decreasing and Index is incrementing
        if(amount < 0) return 0;
        if(amount == 0) return 1;
        if(index >= coins.length) return 0;
        //Logic
        //Case1)- Not chosen index
        //If index is not chosen, iterate to the next index and the amount will remain same
        int case1 = helper(amount, coins, index + 1);
        //Case2)- Chosen index
        //If index is choosen, amount is decreased and number of coins remains same
        int case2 = helper(amount - coins[index], coins, index);
        return case1 + case2;
    }
}