package Day9;

public class CoinChange2Rec {

    public int change(int amount, int[] coins){
        if(coins == null) return 0;
        return helper(amount, coins,0);
    }

    private int helper(int amount, int[] coins, int i){

        //Base case
        if(amount == 0) return 1;

        if(amount < 0 || i == coins.length) return 0;

        //Logic
        //Choose
        int case1 = helper(amount-coins[i], coins, i);

        //not choose
        int case2 = helper(amount, coins, i+1);

        return case1+case2;
    }

    public static void main(String args[]){
        CoinChange2Rec ob = new CoinChange2Rec();

        int[] nums = new int[]{1,2,5};

        System.out.println("The number of combinations of denominations to achieve target amount: "+ ob.change(5,nums));
    }
}
