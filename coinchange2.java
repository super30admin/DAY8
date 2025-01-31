// Time Complexity : O(mn) where m is no. of different denominations
// and n is the total amount.
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int [] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                // denomination of coin > amount
                if(coins[i-1] <= j){
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];
    }

    //Test Case 1: amount = 5, coins = [1,2,5]
    //Test Case 2: amount = 3, coins = [2]
    //Test Case 3: amount = 10, coins = [10]
    public static void main(String args[]){
        Solution obj = new Solution();
        int[] coins1= new int[] {1, 2, 5};
        System.out.println(obj.change(5, coins1));
        int[] coins2= new int[] {2};
        System.out.println(obj.change(3, coins2));
        int[] coins3= new int[] {10};
        System.out.println(obj.change(10, coins3));
    }
}

