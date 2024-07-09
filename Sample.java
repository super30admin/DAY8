// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//coin change11
//exhaustive approch 2^m*n time and space complexity
class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, 0, amount);

    }
    private int helper(int[] coins, int idx,int amount){
        //base
        if(amount < 0 || idx == coins.length) return 0;
        if(amount == 0) return 1;

        //logic
        //choose
        int case1 = helper(coins,idx,amount-coins[idx]);
        //donot choose
        int case2 = helper(coins,idx+1,amount);
        return case1+case2;

    }

}
//2D array
//M*N time and space complexity
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];

        for (int i=1; i<= m; i++){
            dp[i][0]=1;
        }
        for(int i = 1; i<= m; i++){
            for(int j=1; j <= n; j++){
                //till coin denomination is greater than amouny we have no choose case only.
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}

//paint house
class Solution {
    int [][] memo;
    public int minCost(int[][] costs) {
        this.memo = new int[costs.length][3];
        int costsR = helper(costs, 0, 0);
        int costsB = helper(costs, 0, 1);
        int costsG = helper(costs, 0, 2);
        return Math.min(costsR, Math.min(costsB, costsG));
    }
    private int helper(int[][] costs,int idx,int c){
        // base
        if(idx == costs.length) return 0;
        // logic
        if(memo[idx][c] != 0) return memo[idx][c];
        if(c == 0){
            memo[idx][c] = costs[idx][0]  +
                    Math.min(helper(costs, idx+1, 1),  helper(costs, idx + 1, 2));
        }
        if(c == 1){
            memo[idx][c] = costs[idx][1] +
                    Math.min(helper(costs, idx+1, 0),  helper(costs, idx + 1, 2));
        }
        if(c == 2){
            memo[idx][c] = costs[idx][2] +
                    Math.min(helper(costs, idx+1, 0),  helper(costs, idx + 1, 1));
        }
        return memo[idx][c];
    }
}
