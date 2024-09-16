// Time Complexity : 2^nm
//Space Complexity : doubt
//Did this code successfully run on Leetcode : Yes but Time limit exceeded when submitted
class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        
        if(coins.length == 0 && amount == 0) return 1;
        if(coins.length == 0 || coins == null) return 0;
        
        return helper(coins, amount, 0);
         
    }
    
    private int helper(int[] coins, int amount, int index){

        // Logic + Base 
        // when ever amount becomes 0 return 1 
        if(amount == 0) {
            
           return 1;
        }
        if(amount < 0 || index == coins.length) return 0 ;
        
        
            
        // dont choose 
        int case1 = helper(coins, amount, index + 1);
        
        // choose
        int case2 = helper(coins, amount - coins[index], index );
        
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        
        return case1 + case2;
        
     
    }
}