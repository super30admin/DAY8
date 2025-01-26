// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// 1. first create a matrix for storing repeated sub problems ans.
// 2. keep the first row dummy.
// 3. use answers calculated previously to find the current prob;em answer.
// 4. keep in mind what are we asked and fill in valused accouring to the asked output.
// 5. also remeber what inputs we have, ddepending on that the intermediate dp data structure should be decided

class Solution {
    int result;
    public int change(int amount, int[] coins) {
        if(coins==null||coins.length==0) return 0;
        // return helper(coins,amount,0);
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        dp[0][0]=1;
        for(int i =1; i<m+1; i++){
            for(int j = 0; j<n+1; j++){
                if(j<coins[i-1]) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[m][n];

    }
    // private int helper(int[] coins, int amount, int index){
    //     //base
    //     if(amount == 0) return 1;
    //     if(amount<0 || index ==coins.length) return 0;
    //     //use
    //     int case1 = helper(coins, amount-coins[index], index);
    //     //notUse
    //     int case2 = helper(coins, amount, index+1);
    //     return case1+case2;
    // }
}