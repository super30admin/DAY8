// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// approach
// 1) create 2d array and initiate dp[i][0] = 1
// 2) loop through dp and copy previous row values untill current coin value is greater than amount
// 3) when less, add previous row and current row column less than coins[i-1]];
public class CoinChangeII {
	
	public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        int m = dp.length; int n = dp[0].length;
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<m;i++){
            for(int j= 1; j< n;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m-1][n-1];
    }

	public static void main(String[] args) {
		CoinChangeII obj = new CoinChangeII();
		int[] coins = {1, 2, 5};
		int amount = 5;
		int res = obj.change(amount, coins);
		System.out.println(res);
	}

}
