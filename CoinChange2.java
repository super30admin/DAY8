/**
 * 
 */

/**
 * @author aupadhye
 *
 */
//Space complexity would be O(n^2) and time complexity would be O(n^2)
public class CoinChange2 {

	/**
	 * @param args
	 */
    public static int change(int amount, int[] coins) {
        
        if(coins.length ==0 && amount==0) {return 1;}//If coin and amount is zero return since we can make amount zero by not selecting anycoins.
        if(coins.length==0 && amount!=0){return 0;}//Else if amount is not zero and coins are zero return zero since there are no coins.
    
        int[][]dp = new int[coins.length+1][amount+1];
        
           dp[0][0] = 1; //First row will be 1 since we can make zero amount by selecting zero
        
        for(int i=0; i<coins.length+1; i++){
             dp[i][0] = 1;//Since zero is also included if we have choice of not choosing the denominations.
            }
        
        for(int i=1;i<dp.length;i++){
         
            for(int j=1;j<dp[0].length;j++){
                
                if(j>=coins[i-1]){dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];} //If amount is less than coins[i] look at the above entry
                //If it is greater than look at the above entry and also the entry of the amount after the coin is selected that is j-i.
                else{dp[i][j] = dp[i-1][j];}
                
            }
            
        }
        return dp[coins.length][amount];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int amount = 5;
		int[] coins = new int[] {1,2,5};
		int types = change(amount,coins);
		System.out.println(types);
		
	}

}
