public class Solution
{
    public int Change(int amount, int[] coins)
    {
        if (amount == 0)
        {
            return 1;
        }

        int[][] dp = new int[coins.Length + 1][];
        for (int i = 0; i <= coins.Length; i++)
        {
            dp[i] = new int[amount + 1];
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.Length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j < coins[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }

        return dp[coins.Length][amount];
    }

    // public int Recurse(int[] coins, int amount, int index){
    //     //base
    //     if(index == coins.Length || amount < 0){
    //         return 0;
    //     }

    //     if(amount == 0){
    //         return 1;
    //     }
    //     //logic
    //     //pick the coin
    //     int case1 = Recurse(coins, amount - coins[index], index);

    //     //do not pick the coin
    //     int case2 = Recurse(coins, amount, index + 1);

    //     return case1 + case2;
    // }
}