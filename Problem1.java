// Time Complexity : O(m*n) -> for dp solution
// Space Complexity : O(m*n) -> for dp solution
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No
public class Problem1 {
    //its different than coin change that there we're finding min coins here we're finding no of ways that add up to that amount
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        //Approach1 : GO greedy -> greedy will fail because what if coins = [1,2,5] and amount = 6
        //Approach2 : Recursive(Exhaustive) -> here we'll make our decision on 2 choice either choose / not choose the coin denoted by 0 and 1. and we'll get TLE with this.
        //return helperForRecursive(coins,amount,0);

        //Approach3 : Go with DP.
        return helperForDp(coins, amount);
    }

    private int helperForDp(int[]coins, int amount){
        //Approach3: dp which includes overlapping sub problem.
        int[][]dp = new int[coins.length+1][amount+1];

        //fill the first column with 1 as for every coin we've 1 way i.e donot choose the coin for 0 amount.
        for(int i = 0;i<coins.length+1;i++){
            dp[i][0] = 1;
        }
        for(int i =1;i<coins.length+1;i++){
            for(int j =1;j<amount+1;j++){
                if(coins[i-1]>j){//if the amount is less than the current coint we're not gonna choose that coin and look up right above
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //if the amount is = > coin  then min between if we choose or if we don't choose.
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                    //why +1 because in that case we're choosing 1 coin and what is [j-coins[i-1]] => current amount - coin back (coin arrays has 3 coin start from 0 index but our generated i has +1 value so we're going -1 to find the actual coin).
                }
            }
        }
        return dp[coins.length][amount];
    }

    private int helperForRecursive(int[] coins, int amount, int coinIndex){
        //base
        if(coinIndex > coins.length-1 || amount < 0){
            return 0;
        }

        if(amount == 0){
            return 1;
        }

        //logic
        //0 -> donot pick the coin.
        int case1 = helperForRecursive(coins,amount,coinIndex+1);

        //1-> pick the coin.
        int case2 =  helperForRecursive(coins,amount-coins[coinIndex],coinIndex);

        return case1 + case2;
    }
}
