//Time O(nxm)
//Space O(n)
//Leetcode run : yes
//Issue seen: none

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> dp(amount+1, 0);
        
        dp[0] = 1;
        for(int j=0; j<coins.size(); j++) {
            for(int i=1; i <=amount; i ++) {
            
                if(i >= coins[j]) {
                    //include case
                    dp[i] = dp[i] + dp[i-coins[j]];
                } else {
                    //exclude
                     dp[i] = dp[i];
              }
            } 
        }
        return dp[amount];
    }
};
