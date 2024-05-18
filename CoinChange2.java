/**
Recusrsive approach where we finnd all combinations.
TC - 2^(m+n) where n is no. of coins, m is the amount
SC - O(m+n)


DP- Tabulation approach

TC- O(m*n)
SC - O(m*n)
 */

 class Solution {

    public int change(int amount, int[] coins) {
        
        //return helper(coins,amount,0);

        //Recusive approach Tabulation
        int m = coins.length;
        int n = amount;
        int[][] mat = new int[m+1][n+1];

        mat[0][0] = 1;

        for(int i = 1; i<=m; i++){
            for(int j =0;j<=n ; j++){
                if(j<coins[i-1]){
                    mat[i][j] = mat[i-1][j];
                } else {
                    mat[i][j] = mat[i-1][j] + mat[i][j-coins[i-1]];
                }
            }
        }
        return mat[m][n];
 
    }
    private int helper(int[] coins, int amount, int i){


        // base
        if(amount == 0){
            return 1;
        }
        if(amount <0 || i>= coins.length){
            return 0;
        }
        //logic
        int take = helper(coins, amount - coins[i], i);

        int nottake = helper(coins, amount, i+1);

        return take + nottake;
    }
}