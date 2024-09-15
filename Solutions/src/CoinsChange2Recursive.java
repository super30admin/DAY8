// Time Complexity :O(m*2^n)
// Space Complexity :O(m+n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No
class CoinsChange2Recursive {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return -1;
        }

        return helper(coins,amount,0);
    }

    public int helper(int[] coins, int amount, int index){


        //Base
        if(amount == 0) return 1;
        if(amount<0 || index>=coins.length) return 0;


        //Case1 Choose

        int case1 = helper(coins, amount-coins[index],index);


        //Case2 Not Choose

        int case2 = helper(coins, amount, index+1);

        return case1+case2;
    }
}