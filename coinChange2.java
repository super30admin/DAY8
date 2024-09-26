    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/coin-change-2/
    Time Complexity for operators : o(m*n)
    Extra Space Complexity for operators : o(m*n) .. 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Followed the choose and don't choose approach as suggested in image. And found the repatative sub problem.
        # Optimized approach: . 
                              
            # 1. Form the two-d matrix. colum will be for amount values from 0 to amount and row will be for coins.
              2. First row and colum will be 0 as we cannot form the sum with the given value with 0 weights and vice-versa
                 (we can get 1 capacity with the available weights).
              3. Starting from first row and column, we will find the total no of ways of Choose and don't choose. If we don't choose that means we will
                 get the minimum ways from previous array +.
              4. If we choose the coin, then we will select the rest of the weights from (previous row -  value of coinc). The sum of (point no  3,point no 4)
                 will be the value of current position
              5. At the end, we will return the last element that tell us the required o/p
    */  

    public class coinChange2{
    public static void main(String args[]) {
                int coins[]= new int[] {1,2,5};
                int amount  = 5;
                System.out.println(coinChangeProblem(coins,amount));
            }
            
            
        public static int coinChangeProblem(int coins[],int amount) {
                
                    
            if((coins==null ||coins.length==0) && amount == 0)
                return 1;
            
            if((coins==null ||coins.length==0) && amount != 0)
                return 0;
            
            int dp[][] = new int[coins.length+1][amount+1];
            
            for(int i=1;i<amount+1;i++){
                dp[0][i] = 0;
            }
            
            for(int i=0;i<coins.length+1;i++){
                dp[i][0] = 1;
            }
            
            for(int i=1;i<=coins.length;i++){
                for(int j=1;j<=amount;j++){
                    if(j<coins[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    }
                }
            }
            
            return dp[coins.length][amount];
        }
}