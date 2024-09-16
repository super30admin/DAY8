//Time Complexity = Exponential
//Space Complexity = O(N)
//Where N is the size of the vector coins. This space complexity is due to the recursive stack memory used during recursion.
class Solution {
public:
    int helper(vector <int> coins, int amount, int index, int ways)
    {
        if(index==coins.size() || amount<0)
            return 0;
        if(amount==0)
            return 1;
        int case0 = helper(coins, amount, index+1, ways);
        int case1 = helper(coins, amount-coins[index], index, ways);
        return case0+case1;
    }
    int change(int amount, vector<int>& coins) {
        return helper(coins, amount, 0, 0);
    }
};


//Time Complexity = O(M*N)
//Space Complexity = O(M*N)
//Where M is the size of the vector coins and N is the amount.
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        long dp[coins.size()+1][amount+1],i,j;
        for(i=0;i<=coins.size();i++)
            dp[i][0] = 1;
        for(i=0;i<=amount;i++)
            dp[0][i] = 0;
        for(i=1;i<=coins.size();i++)
            for(j=1;j<=amount;j++)
            {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];              //Here i am adding the number of ways when that particular coin is not choosen and i got the final amount with the number of ways when that particular coin is choosen and i got my final amount.
            }
        return dp[coins.size()][amount];
    }
};
