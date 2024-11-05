// Time Complexity : O(m*n)
// Space Complexity :   O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//approach: created a dp matrix to count the number of possible ways.

// Your code here along with comments explaining your approach


public class coinchange2 {
    class Solution {
        public int change(int amount, int[] coins) {
            int m=coins.length;
            int n=amount;
            int [][] arr=new int[m+1][n+1];
            int i,j;
            arr[0][0]=1;
            for(i=1;i<=m;i++)
            {
                for(j=0;j<=n;j++)
                {
                    if(j<coins[i-1])
                        arr[i][j]=arr[i-1][j];
                    else
                        arr[i][j]=arr[i-1][j]+arr[i][j-coins[i-1]];
                }
            }
            return arr[m][n];
        }
    }
}
