// Time Complexity :O(m*n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class Problem1 {
    public int change(int amount, int[] coins) {
            int m= coins.length;
            int n= amount;

            int[] dp= new int[n+1];
            dp[0]=1;

            for(int i=1; i<=m; i++){
                for(int j=0; j<=n; j++){
                    if(j<coins[i-1]){
                        dp[j]=dp[j];
                    }else{
                        dp[j]=dp[j] + dp[j-coins[i-1]];
                    }
                }
            }

            return dp[n];
    }

    public static void main(String args[]) {
        Problem1 problem1 = new Problem1();
        int[] coins={1,2,5};
        int amount=11;
        System.out.println("Output "+problem1.change(amount, coins));

    }
}
