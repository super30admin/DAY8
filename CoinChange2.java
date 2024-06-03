class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) {
            return 0;
        }
        // return recurse(coins, amount, 0);
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    private int recurse(int[] coins, int amount, int index) {
        // base
        if(amount < 0 || index == coins.length) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }

        // logic
        // 0 or do not pick the coin case
        int case1 = recurse(coins, amount, index + 1);
        // 1 or pick the coin case
        int case2 = recurse(coins, amount - coins[index], index);
        return case1 + case2;
    }
}
