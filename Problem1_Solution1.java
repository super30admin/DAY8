/*
Time Complexity -> O(2^N)
Space complexity -> O(1)
*/

class Problem1_Solution1 {
    public int change(int amount, int[] coins) {

        if (coins == null || coins.length == 0) {
            return 0;
        }
        return recurse(amount, coins, 0);
    }

    private int recurse(int amount, int[] coins, int index) {

        // Base
        if (index == coins.length || amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }

        // Case 1 not to pick the coin
        int case1 = recurse(amount, coins, index + 1);

        // Case 2 to pick that element
        int case2 = recurse(amount - coins[index], coins, index);

        return case1 + case2;

    }

}