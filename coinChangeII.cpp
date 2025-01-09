// Time Complexity :O(n2) (n raise to power 2)
// Space Complexity :O(n) (using 2D dp array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*Precomputing intermediate ways to make intermediate sum and last row and column gives answer
Also done it using recursion and gives TLE due to repeated computations*/
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n= coins.size();
        if(n==0){
            return 0;
        }
        //making dp array
        vector<vector<uint64_t>> dp;  //to take care of integer overflow(this has larger positive range )
        //rows resized to size n+1
        dp.resize(n+1);
        //columns resized to size amount+1
        for(int i=0; i<n+1; i++){
            dp[i].resize(amount+1);
        }
        //initialize first row to 0 except first column
        for(int j=0; j<amount+1; j++){
            dp[0][j]=0;
        }
        //filing up first column as 1
        for(int i=0; i<n+1; i++){
            dp[i][0]=1;
        }
       

        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++){
                if(j < coins[i-1]){  // coin value is more than amount(represented by j)
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
};