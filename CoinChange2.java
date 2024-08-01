// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(j >= coins[i-1]){
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 5;
        System.out.println("Number of ways " + amount1 + " can be made using coins1 is "
                + change(amount1, coins1));
        int[] coins2 = {1,2,5,10};
        int amount2 = 78;
        System.out.println("Number of ways " + amount2 + " can be made using coins2 is "
                + change(amount2, coins2));
    }
}