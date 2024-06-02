//Problem 1
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        int red= costs[0][0];
        int blue= costs[0][1];
        int green=costs[0][2];
        for( int i=1;i<costs.length;i++)
        {
            int tempred=red;
            int tempblue=blue;
            red= costs[i][0]+ Math.min(blue,green);
            blue= costs[i][1]+ Math.min(tempred,green);
            green= costs[i][2]+Math.min(tempred,tempblue);
        }
        return Math.min(red, Math.min(green,blue));
    }
}
//Problem 2
// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
       int dp[][]= new int[coins.length+1][amount+1];
       for(int i=0;i<coins.length+1;i++)
       {
        dp[i][0]=1;
       } 
       for(int i=1;i<coins.length+1;i++)
       {
        for(int j=0;j<amount+1;j++)
        {
if(j<coins[i-1])
{
    dp[i][j]=dp[i-1][j];
}
else{
    // j-coins= amount -coin[i]
    // we are not adding one because we already have 1 in col 0
    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
}
        }
       }
       return dp[coins.length][amount];
    }
}