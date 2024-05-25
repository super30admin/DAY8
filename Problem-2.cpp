// Time Complexity : O(n^2)=> Traversing for the whole dp array and filling solution in each sub problem
// Space Complexity : O(n^2) since we're using dp array 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int dp[coins.size()+1][amount+1];
        
        // Fill first column
        for(int i=0;i<coins.size()+1;i++)
            dp[i][0] = 1;

        // Fill first row
        for(int j=1;j<=amount;j++)
            dp[0][j] = 0;

        for(int i=1;i<=coins.size();i++)
        {
            for(int j=1;j<=amount;j++)
            {   
                if(j-coins[i-1]<0)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {       
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.size()][amount];
    }
};