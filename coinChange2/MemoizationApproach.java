package coinChange2;

// Time Complexity : O(m*amount) n is the size of the input coins array
// Space Complexity : O(m*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MemoizationApproach {

    int [][] memo;

    public static void main(String[] args)
    {
        int amount = 5;
        int[] coins = {1, 2, 5};

//                int amount = 3;
//                int[] coins = {2};

//        int amount = 10;
//        int[] coins = {10};

        MemoizationApproach obj = new MemoizationApproach();
        System.out.println(obj.change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        this.memo = new int[coins.length][amount+1];
        //fill the memo arr with -1s
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                memo[i][j] = -1;
            }
        }
        return helper(coins, 0, amount);
    }
    private int helper(int [] coins, int idx, int amount){
        // base
        if(amount < 0 || idx == coins.length) return 0;
        if(amount == 0) return 1;
        if(memo[idx][amount] != -1) return memo[idx][amount];
        //logic
        // choose
        int case1 = helper(coins, idx, amount - coins[idx]);
        // dont choose;
        int case2 = helper(coins, idx+1, amount);
        memo[idx][amount] = case1 + case2;
        return  memo[idx][amount];

    }
}
