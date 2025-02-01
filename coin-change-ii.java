// Time Complexity :2^m+n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: exhaustive approch i have used recursive method to itterate and we have choose and not choose of particular coin by doing this in which case we get amount 0 then we considered that as one possible case as returning 1 in final returning adding of both case1 and case2 to the result to get all possible cases of making amount



class Solution {
    public int change(int amount, int[] coins) {
        int result=helper(amount,coins,0);
            return result;
    }
    public int helper(int amount,int[] coins,int index){
        if( amount < 0 || index >= coins.length ){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        //choose
        int case1=helper(amount-coins[index],coins,index);
        //not choose
        int case2=helper(amount,coins,index+1);
        return case1+case2;
    }
   }

// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: i have observed that a similar subprobems in exhaustive soltuions so i came to use dp to avoid repeated calculation of repeated subproblems

   class Solution {
    public int change(int amount, int[] coins) {
       int m=coins.length;
       int n=amount;
       int[][] dp = new int[m+1][n+1];
       dp[0][0]=1;
       for(int i=0;i<=m;i++){
       dp[i][0] =1;
       }
       for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            
            if(j < coins[i-1]){
                dp[i][j] = dp[i-1][j];
            }else{
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
           

        }
       }
        return dp[m][n];
    }



   }