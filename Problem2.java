public class Problem2 {
    public int change(int amount, int[] coins) {
        return ccSpaceOptimized(coins,amount);
    }

    //Time Complexity : O(2 raised to (n+m)
    int recurHelper(int[] coins,int amount,int index){

        //base condition
        if(amount == 0){
            return 1;
        }
        if(index == coins.length || amount <0){
            return 0;
        }

        //do not choose
        int case0 =  recurHelper(coins,amount,index+1);

        //choose
        int case1 =  recurHelper(coins,amount-coins[index],index);

        return case0+case1;

    }

    //Time Compleity O(M*N)
    //Space Compleity O(M*N)
    int coinChangeDP(int[] coins,int amount){
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 1;

        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){

                //when we are not choosing
                int case0 = dp[i-1][j];
                int case1 = 0;
                //we can choose only if amount is greater than the available amount
                if(j>=coins[i-1]){
                    case1 = dp[i][j-coins[i-1]];
                }

                dp[i][j] = case0+case1;
            }
        }

        return dp[m][n];
    }

    //Time Compleity O(M*N)
    //Space Compleity O(N)
    int ccSpaceOptimized(int[] coins,int amount){
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){

                //when we are not choosing
                int case0 = dp[j];
                int case1 = 0;
                //we can choose only if amount is greater than the available amount
                if(j>=coins[i-1]){
                    case1 = dp[j-coins[i-1]];
                }

                dp[j] = case0+case1;
            }
        }

        return dp[n];
    }
}
