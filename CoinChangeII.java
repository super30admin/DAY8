import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeII {
    //TC: O(m*n)
    // m = coins.length
    // n = amount
    // SC: O(m*n)
    public int change5(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        int[][] dp;
        if (amount == 0)
            return 1;
        if (coins.length == 0)
            return 0;
        dp = new int[coins.length][amount + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return changeFrom(amount, coins, 0, dp);
    }

    private int changeFrom(int amount, int[] coins, int currentIndex, int[][] dp) {
        if (amount == 0)
            return 1;

        if (amount < 0 || currentIndex == coins.length)
            return 0;

        if (dp[currentIndex][amount] != -1)
            return dp[currentIndex][amount];

        // Recursive call after selecting the coin at the currentIndex
        int sum1 = changeFrom(amount - coins[currentIndex], coins, currentIndex, dp);

        // Recursive call after excluding the coin at the currentIndex
        int sum2 = changeFrom(amount, coins, currentIndex + 1, dp);

        dp[currentIndex][amount] = sum1 + sum2;
        return dp[currentIndex][amount];
    }


    public int change3(int amount, int[] coins) {
        Map<String, Integer> cache = new HashMap<>();
        return  coinChangeHelper(coins, 0, amount, cache);
    }

    int coinChangeHelper(int[] coins, int start, int amount, Map<String, Integer> cache){
        if(amount == 0){
            return 1;
        }

        String key = amount + "," + start;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int ways = 0;
        for(int i = start; i < coins.length; i++){
            if(amount - coins[i] >= 0)
                ways += coinChangeHelper(coins, i, amount - coins[i], cache);
        }

        cache.put(key, ways);
        return ways;
    }
    public static void main(String[] strs) {
        int ans = new CoinChangeII().change(5, new int[]{1, 2, 5});
        System.out.println(ans);
    }
}
