//The Bruteforce approach (recursive solution) would take time complexit of O(2^n) where is the number of coins and the space complexity is O(1)
class Solution {
  public int change(int amount, int[] coins) {
    return helperFn(amount,coins, 0);
  }

  //Bruteforce Approach
  private int helperFn(int amount, int[] coins, int index){
    //If we have reached the amount to zero on recursion we return 1 as a possbile way
    if(amount == 0)
      return 1;
    //If we have reached the amount to be less than zero on recursion we return 0 as it is not a possbile way
    if(amount < 0 || index == coins.length)
      return 0;
    //When we choose the coin we reduce the amount based on coin denomination
    int case1 = helperFn(amount-coins[index],coins,index);
    // case when we are not choosing the coin we increase the index
    int case2 = helperFn(amount,coins,index+1);
    //we return the
    return case1+case2;
  }
}

// This Optimal Solution takes about O(nm + m) complexity where n is the number of coins + 1 and m is amount + 1.
//The space complexity of this problem is O(nm)
class Solution {
  public int change(int amount, int[] coins) {
    if(coins.length == 0)
      return 0;
    else{
      int coinRow = coins.length + 1;
      int amountColumn = amount + 1;
      int [][]dp = new int[coinRow][amountColumn];//Having an extra row to 0 for coins and amount
      //Filling the first row with min value
      for(int i = 1;i<coinRow;i++){
        dp[i][0] = 1;
      }
      for(int i=1;i<coinRow;i++){
        for(int j=1;j<amountColumn;j++){
          if(j < coins[i-1]){
            //copying the previous row elements if amount is less than coin denomination
            dp[i][j] = dp[i-1][j];
          }
          else{
            dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
          }
        }
      }
      return dp[coinRow-1][amountColumn-1];
    }
  }

}