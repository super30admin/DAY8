# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
## Solution 1:
## Time Complexity:O(m*n) Space Complexity:O(m*n)
## Here we use a 2x2 dp array to store the atarting row costs then in every next row iteration we compare with other two columns and store
## the minimum cost for that row and in the end we get the final minimum cost of each column.

public class Solution {
    public static int minCost(int[][] cost) {
        // Write your code here.
        int m=cost.length;
        int n=cost[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=cost[0][0];
        dp[0][1]=cost[0][1];
        dp[0][2]=cost[0][2];

        for(int i=1;i<m;i++)
        {
            dp[i][0]=cost[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=cost[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=cost[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        int min=Math.min(dp[m-1][0],Math.min(dp[m-1][1],dp[m-1][2]));
        return min;

    }   
   
}

             

## Problem2 (https://leetcode.com/problems/coin-change-2/)
## Time complexity:O(mxn) Space Complexity:O(n)
## A single array is used to store the amount for each iteration, in the next iteration if its a no choose case we select the previous value
## else we match it with the new value as the updated count of total number of ways.

class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length;
        int n=amount;
        int[]arr= new int[n+1];

        arr[0]=1;

        for(int i=1;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(j<coins[i-1]) arr[j]=arr[j];
                else
                arr[j]=arr[j]+arr[j-coins[i-1]];
            }
        }
        return arr[n];
        
    
    
    }
   
    
}
