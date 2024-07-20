//Brute force

 class Solution {
    public int change(int amount, int[] coins) {
        return count(0, amount, coins);
    }
    
    private int count(int i, int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (i >= coins.length || amount < 0) {
            return 0;
        }
        int withI = count(i, amount - coins[i], coins);
        int withoutI = count(i+1, amount, coins);
        return withI + withoutI;
    }
}


//Improved with Dynamic Programming
//time = O(n*m), n is amount and m is number of coins
//Space = O(n)
class Solution {
    public int change(int amount, int[] coins) {                          
        int[] dp = new int[amount+1];                                     
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}

