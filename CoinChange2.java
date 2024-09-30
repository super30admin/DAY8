// At each iteration in the dynamic programming, we will be storing the numbr of valid combinations and based on those we will be returning the maximum number of combinations that can be formed.

// Time complexity: O(n*m) n is number of coins and m is the amount that is required.
//Space complexity: O(m)
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        /*helper(0,amount, coins);
        return count;
        
    }
    private void helper(int index, int amount, int[] coins){
        //base case
        if(amount == 0 ) { 
            count++; 
            return;}
        if(index>=coins.length || amount < 0){
            return;
        }
        
        //choices
        helper(index+1, amount, coins);
        helper(index, amount - coins[index], coins); */
    
        if(coins == null || coins.length == 0) return 0;

        int[] tracker = new int[amount+1];
        tracker[0] = 1;
        for(int i =1; i<=coins.length; i++){
            for(int j=0; j<amount+1; j++){
                if(j>=coins[i-1]){
                    tracker[j] = tracker[j] + tracker[j - coins[i-1]];
                }
            }
        }
        return tracker[amount];
    
    
    }
    
}
