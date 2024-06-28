public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

//        for(int j=0; j<=n; j++) {
//            dp[0][j] = 0; //dummy row insertion because at 0th denomination, there are 0 ways to make any amount.
//        }
//
//        for(int i=0; i<=m; i++) {
//            dp[i][0] = 1; //manual insertion because at 0th column,
//            //as anyway case1 is always the same value as above value and with 0th denomination, we can make 0 in 1 way.
//        }

        dp[0] = 1;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) { //O(m*n) T.C
                //case1 - if current amount is lesser than denomination, just chose value from above as 0th case
//                if(j < coins[i-1]) {
//                    dp[j] = dp[j];
//                }

                //case2 - if current amount can be made with given denomination, add the value from above
                //and the value at current denomination places before in the same row.
                if(j >= coins[i-1]){
                    dp[j] = dp[j] + dp[j-coins[i-1]]; //O(n) S.C
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
