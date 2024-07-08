// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int change(int amount, int[] coins) {
//         int ans=recur(amount,coins,0);
//         return ans;
        
//     }
//     public int recur(int amount,int[] coins, int pos)
//     {
//         if(amount==0)
//             return 1;
//         if(amount<0 || pos==coins.length)
//             return 0;
//         int check1=recur(amount-coins[pos],coins,pos);
//         int check2=recur(amount,coins,pos+1);
//         return check1+check2;
        
        
        
        int m=coins.length;
        int n=amount;
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=m;i++)
            dp[i][0]=1;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        return dp[m][n];
    }
}

// Time Complexity :O(m)
// Space Complexity :O(3*m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int minCost(int[][] costs) {
        
        int m=costs.length;
        int[][] dp=new int[m][3];
        dp[m-1][0]=costs[m-1][0];
        dp[m-1][1]=costs[m-1][1];
        dp[m-1][2]=costs[m-1][2];
        for(int i=m-2;i>=0;i--){
            dp[i][0]=costs[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i+1][0],dp[i+1][1]);
        }
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}