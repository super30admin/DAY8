// Time Complexity: O(mn) where m = amount, n = no of coins
// Space Complexity: O(m+1) where m = amount

class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;

        for(int coin : coins) {
            for(int i=1; i<combinations.length; i++) {
                if(i >= coin) {
                    combinations[i] += combinations[i - coin];
                }
            }
        }

        return combinations[amount];
    }
}