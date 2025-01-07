// Time Complexity : O (coins.length * amount)
// Space Complexity : O (amount)
// Did this code successfully run on Leetcode : Yes

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        // dp array
        int[] amounts = new int[amount + 1];
        amounts[0] = 1; // F(0) = 1 - there is always one way to create amount 0
        // for each c in coins
        //     for each a in amounts
        //         F(a) = (F(a) + F(a-c)) (where a-c > 0)
        // note that the index in amounts is the amount 'a' while the value amounts[i] is the number of coins
        for(int c: coins) {
            for(int i = 1; i <= amount; i++) {
                if(i - c >= 0) {
                    amounts[i] = amounts[i] + amounts[i - c];
                }
            }
        }
        // return last index of amounts
        return amounts[amount];
    }
}
