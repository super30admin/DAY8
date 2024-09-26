//Space Complexity: O(NM), where n is number of coins and m is amount.
//Time Complexity: O(NM), where n is the length of the array.
//Executed successfully on leetcode.


class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int dp[coins.size()+1][amount+1];
        for(int i=0; i<coins.size()+1; i++){
             for(int j = 0; j<amount+1; j++){
                  dp[i][j] = 0;
             }
        }
        for(int i=0; i<coins.size()+1; i++){
            dp[i][0] = 1;
        }
        for(int i =1; i<coins.size()+1; i++){
            for(int j = 1; j<amount+1; j++){
                if(j<coins.at(i-1)){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins.at(i-1)];
                }
            }
        }
        return dp[coins.size()][amount];
    }
};