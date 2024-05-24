class CoinChange2 {
    public int change(int amount, int[] coins) {
        //unbounded knapsack problem + Subset sum dp problem
        //TC - O(m*n)
        //SC - O(n)

        if(coins == null || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount+1];

        dp[0] = 1;

        for(int coin : coins) {
            for(int j =coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j-coin];
            }
        }

        return dp[amount];
    }
}